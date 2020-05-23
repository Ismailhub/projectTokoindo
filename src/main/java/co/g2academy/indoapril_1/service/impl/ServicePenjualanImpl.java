package co.g2academy.indoapril_1.service.impl;

import co.g2academy.indoapril_1.model.*;
import co.g2academy.indoapril_1.repository.*;
import co.g2academy.indoapril_1.request.RequestIdPenjualan;
import co.g2academy.indoapril_1.request.RequestTanggal;
import co.g2academy.indoapril_1.response.ResponseDataSales;
import co.g2academy.indoapril_1.response.ResponseKonfirmasiPembayaran;
import co.g2academy.indoapril_1.response.ResponsePenjualan;
import co.g2academy.indoapril_1.response.ResponseTracking;
import co.g2academy.indoapril_1.response.loginresponse.BaseResponse;
import co.g2academy.indoapril_1.service.ServicePenjualan;
import lombok.AllArgsConstructor;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import java.sql.Blob;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;


@Service
@AllArgsConstructor
@Repository("ServicePenjualan")
public class ServicePenjualanImpl implements ServicePenjualan {

    private RepositoryProduct repositoryProduct;

    private RepositoryPenjualanDetail repositoryDetail;

    private RepositoryPenjualan repositoryPenjualan;

    private RepositoryTracking repositoryTracking;

    private RepositoryRefundStatus repositoryRefundStatus;

    private RepositoryRefund repositoryRefund;


    /*
     *
     * @Untuk Menampilkan Data Penjualan atau Order
     *
     */
    public List<ResponsePenjualan> getOrderByTgl( RequestTanggal request ){

        Sort sort = Sort.by("idPenjualan");

        return repositoryDetail.findAllByPenjualanTanggalPenjualanBetween( request.getTgl(), request.getTglAkhir(), sort )
                .stream()
                .map(this::toResponseOrderSimpel)
                .collect( Collectors.toList() );

    }



    /*
     *
     * @Fungsi Untuk Menampilkan Data Sales
     *
     */
    public List<ResponseDataSales> getDataSales(RequestTanggal request){

        Sort sort = Sort.by("idPenjualan");

        List<ResponseDataSales> resultDataSales = repositoryPenjualan
                .findAllByTanggalPenjualanBetween( request.getTgl(), request.getTglAkhir(), sort )
                .stream()
                .map(this::toResponseDataSalesSimpel)
                .collect(Collectors.toList());

        List<ModelPenjualanDetail> tempPenjualanDetail = repositoryDetail
                .findAllByPenjualanTanggalPenjualanBetween(
                        request.getTgl(),
                        request.getTglAkhir(),
                        sort
                );

        String idPenjualan = new String();

        int subKeuntungan = 0;

        try {

                idPenjualan = tempPenjualanDetail.get(0).getIdPenjualan();

                subKeuntungan = tempPenjualanDetail.get(0).getQtyPenjualan() * tempPenjualanDetail.get(0).getProducts().getHargaBeli();

        }catch ( Exception e ){

                return null;

        }

        int noUrut = 0;

        try {

                for ( int i = 0; i < tempPenjualanDetail.size(); i++ ){

                        if ( idPenjualan.equals(tempPenjualanDetail.get(i+1).getIdPenjualan()) ){

                                subKeuntungan += tempPenjualanDetail.get(i+1).getQtyPenjualan() * tempPenjualanDetail.get(i+1).getProducts().getHargaBeli();

                        }else {

                                resultDataSales.get(noUrut).setKeuntungan( subKeuntungan );

                                noUrut++;

                                idPenjualan = tempPenjualanDetail.get(i+1).getIdPenjualan();

                                subKeuntungan = tempPenjualanDetail.get(i+1).getQtyPenjualan() * tempPenjualanDetail.get(i+1).getProducts().getHargaBeli();

                        }
                }

        }catch ( Exception e ){

                resultDataSales.get(noUrut).setKeuntungan( subKeuntungan );
        }

        return resultDataSales;

    }



    /*
     *
     * @Fungsi Untuk Menampilkan Order Yang Sudah Mengirim Bukti Transfer Pembayaran
     *
     */
    public List<ResponseKonfirmasiPembayaran> getStatusBayar(){

        return repositoryPenjualan
                .findAllByMetodePembayaranAndStatusPembayaranAndGambarBuktiTransferNotNull("transfer","belum")
                .stream()
                .map(this::toResponseKonfirmasiPembayaranSimpel)
                .collect(Collectors.toList());

    }

    private ResponseKonfirmasiPembayaran toResponseKonfirmasiPembayaranSimpel( ModelPenjualan entity ){

        String imageBase64 = new String();

        try {

            imageBase64 = "data:image/png;base64, "+toBase64(entity.getGambarBuktiTransfer());

        }catch (Exception e){

            System.out.println(e);

        }

        return new ResponseKonfirmasiPembayaran(
                entity.getIdPenjualan(),
                entity.getTotalPenjualan(),
                entity.getTotalBayar(),
                entity.getAlamatTujuan(),
                entity.getMetodePembayaran(),
                entity.getTanggalPenjualan(),
                entity.getIdCustomer(),
                imageBase64
        );

    }


    /*
     *
     * @Fungsi Konfrimasi Pembayaran Sudah Diterima
     *
     */
    public boolean setStatusTransaksi( RequestIdPenjualan request ){

        ModelPenjualan dataPenjualan = repositoryPenjualan
                .findByIdPenjualanAndGambarBuktiTransferNotNull( request.getIdPenjualan() );

        if ( dataPenjualan == null ){

              return false;

        }

        String statusPembayaran = dataPenjualan.getStatusPembayaran();

        String statusTracking = new String();

        switch (statusPembayaran){

            case "belum":

                List<ModelPenjualanDetail> dataPenjualanDetail = repositoryDetail.findAllByIdPenjualan( request.getIdPenjualan() );

                for ( ModelPenjualanDetail data : dataPenjualanDetail ){

                        ModelProduct dataProduct = repositoryProduct.findByIdProduct( data.getIdProduct() );

                        dataProduct.reduceQtyStock( data.getQtyPenjualan() );

                        repositoryProduct.save( dataProduct );

                        statusTracking = "Pembayaran Dikonfirmasi";

                        dataPenjualan.setStatusTracking("2");

                }

                dataPenjualan.setStatusPembayaran("sudah");

                break;

            case "sudah":

                String curentStatusTrackingPenjualan = dataPenjualan.getStatusTracking();

                switch ( curentStatusTrackingPenjualan ){

                    // case 1 menunggu pembayaran digenerate ketika pembuatan penjualan

                    // case 2 pembayaran dikonfimasi digenenrate ketika status pembayaran diset sudah

                    case "2":

                            statusTracking = "Sedang Diproses";

                            dataPenjualan.setStatusTracking("3");

                            break;

                    case "3":

                            statusTracking = "Sedang Dikirim Ke Alamat Tujuan";

                            dataPenjualan.setStatusTracking("4");

                            break;

                    case "4":

                            System.out.println("Batas Set sudah Max");

                            return true;

                    // case 4 sudah diterima digenerate oleh customer

                    default:

                            System.out.println("hanya sampai set 4");
                }

                break;

            default:

                    System.out.println(" kondisi tidak dikenali ");

        }

        repositoryPenjualan.save( dataPenjualan );

        // 'Menunggu Pembayaran','Pembayaran Dikonfirmasi','Sedang Diproses','Sedang Dikirim Ke Alamat Tujuan','Sudah Diterima'
        ModelTracking dataTracking = generateEntityTracking( request.getIdPenjualan(), statusTracking );

        repositoryTracking.save(dataTracking);

        return true;

    }


    private ModelTracking generateEntityTracking(String idPenjualan, String status){

        Date nowDate = new Date();

        try {

            nowDate = getTanggal();

        }catch (Exception e){

            System.out.println(e);

        }

        return ModelTracking
                .builder()
                .no( null )
                .status( status )
                .tanggal( nowDate )
                .idPenjualan( idPenjualan )
                .build();

    }



    /*
     *
     * @Fungsi Menampilkan Hisotry Tracking
     *
     */
    public BaseResponse getTracking( String idPenjualan ){

        System.out.println(idPenjualan);

        List<ResponseTracking> resultTracking = repositoryTracking
                .findByIdPenjualan(idPenjualan)
                .stream()
                .map( this::toTrackingResponseSimpel )
                .collect(Collectors.toList());

        System.out.println(resultTracking);

        return new  BaseResponse (
                HttpStatus.OK,
                "200",
                resultTracking,
                "Data History Pesanan"
                );

    }



    /*
     *
     * @Fungsi Menampilkan Pengajuan Refund
     *
     */
    public List<ModelRefundStatus> getRefundStatus(){

        return repositoryRefundStatus.findAllByStatusRefundDisetujui("menunggu");

    }



    /*
     *
     * @Fungsi Konfirmasi Refund Disetujui atau Tidak
     *
     */
    public ModelRefundStatus setRefundStatus( String idPenjualan, String isDisetujui ){

        ModelRefundStatus dataRefundStatus = repositoryRefundStatus.findByIdPenjualan( idPenjualan );

        dataRefundStatus.setStatusRefundDisetujui( isDisetujui );

        repositoryRefundStatus.save( dataRefundStatus );

        return dataRefundStatus;

    }



    /*
     *
     * @Fungsi Menampilkan Refund Yang Sudah Disetujui dan Menunggu Pengembalian Uang
     *
     */
    public List<ModelRefund> getRefund(){

        return repositoryRefund.findAllByTransferSelesaiAndNoRekeningNotNull("belum");

    }



    /*
     *
     * @Fungsi Konfirmasi Uang Refund Sudah Ditransfer Ke Rekening Customer
     *
     */
    public ModelRefund setRefund( Integer idRefundStatus ){

        ModelRefund dataRefund = repositoryRefund.findByIdRefundStatusAndNoRekeningNotNull( idRefundStatus );

        dataRefund.setTransferSelesai("sudah");

        repositoryRefund.save(dataRefund);

        return dataRefund;

    }


    /*
     *
     * @Fungsi - Fungsi Untuk Helper
     *
     */

    private ResponseTracking toTrackingResponseSimpel(ModelTracking entity ){

        return new ResponseTracking(
                entity.getPenjualan().getIdPenjualan(),
                entity.getPenjualan().getTotalBayar(),
                entity.getPenjualan().getAlamatTujuan(),
                entity.getPenjualan().getMetodePembayaran(),
                entity.getStatus(),
                entity.getTanggal()
        );

    }

    private String toBase64( Blob imageBlob ) throws SQLException {

        if ( imageBlob != null ){

            try {

                int blobLength = (int) imageBlob.length();

                byte[] byteImage = imageBlob.getBytes(1, blobLength);

                return Base64.encodeBase64String(byteImage);

            }catch (Exception e){

                System.out.println(e);

            }

        }

        return null;

    }

    private Date getTanggal() throws ParseException {

        DateFormat dateFormat = new SimpleDateFormat( "yyyy-MM-dd" );

        Date tempDate = new Date();

        String sDate = dateFormat.format(tempDate);

        return new SimpleDateFormat( "yyyy-MM-dd" ).parse(sDate);

    }

    private ResponsePenjualan toResponseOrderSimpel(ModelPenjualanDetail entity ){

        Integer subKeuntungan = entity.getSubTotal() - ( entity.getProducts().getHargaBeli() * entity.getQtyPenjualan() );

        return new ResponsePenjualan(
                entity.getIdPenjualan(),
                entity.getPenjualan().getTotalBayar(),
                entity.getPenjualan().getStatusPembayaran(),
                entity.getPenjualan().getTanggalPenjualan(),
                entity.getPenjualan().getIdCustomer(),
                entity.getProducts().getNamaProduct(),
                entity.getQtyPenjualan(),
                entity.getSubTotal(),
                subKeuntungan
        );

    }

    private ResponseDataSales toResponseDataSalesSimpel( ModelPenjualan entity ){

        return new ResponseDataSales(
                entity.getIdPenjualan(),
                entity.getIdCustomer(),
                entity.getTotalBayar(),
                0
        );
    }
}