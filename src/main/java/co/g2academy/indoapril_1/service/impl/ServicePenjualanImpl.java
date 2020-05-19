package co.g2academy.indoapril_1.service.impl;

import co.g2academy.indoapril_1.model.ModelPenjualan;
import co.g2academy.indoapril_1.model.ModelPenjualanDetail;
import co.g2academy.indoapril_1.repository.RepositoryProduct;
import co.g2academy.indoapril_1.repository.RepositoryPenjualan;
import co.g2academy.indoapril_1.repository.RepositoryPenjualanDetail;
import co.g2academy.indoapril_1.request.RequestPenjualan;
import co.g2academy.indoapril_1.request.RequestSetStatusPembayaran;
import co.g2academy.indoapril_1.request.RequestTanggal;
import co.g2academy.indoapril_1.response.ResponseDataSales;
import co.g2academy.indoapril_1.response.ResponseKonfirmasiPembayaran;
import co.g2academy.indoapril_1.response.ResponsePenjualan;
import co.g2academy.indoapril_1.service.ServicePenjualan;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Repository("ServicePenjualan")
public class ServicePenjualanImpl implements ServicePenjualan {

    private RepositoryProduct repositoryProduct;

    private RepositoryPenjualanDetail repositoryDetail;

    private RepositoryPenjualan repositoryPenjualan;

    //menampilkan order by tgl
    public List<ResponsePenjualan> getOrderByTgl( RequestTanggal request ){

        Sort sort = Sort.by("idPenjualan");

        return repositoryDetail.findAllByPenjualanTanggalPenjualanBetween( request.getTgl(), request.getTglAkhir(), sort )
                .stream()
                .map(this::toResponseOrderSimpel)
                .collect( Collectors.toList() );

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

    public List<ResponseDataSales> getDataSales(RequestTanggal request){

        Sort sort = Sort.by("idPenjualan");

        List<ResponseDataSales> resultDataSales = repositoryPenjualan
                .findAllByTanggalPenjualanBetween( request.getTgl(), request.getTglAkhir(), sort )
                .stream()
                .map(this::toResponseDataSalesSimpel)
                .collect(Collectors.toList());

        List<ModelPenjualanDetail> tempPenjualanDetail = repositoryDetail
                .findAllByPenjualanTanggalPenjualanBetween( request.getTgl(), request.getTglAkhir(), sort);

        String idPenjualan = new String();

        int subKeuntungan = 0;

        try {

            idPenjualan = tempPenjualanDetail.get(0).getIdPenjualan();

            subKeuntungan = tempPenjualanDetail.get(0).getQtyPenjualan() * tempPenjualanDetail.get(0).getProducts().getHargaBeli();

        }catch (Exception e){

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

        }catch (Exception e){

            resultDataSales.get(noUrut).setKeuntungan( subKeuntungan );
        }

        return resultDataSales;
    }

    private ResponseDataSales toResponseDataSalesSimpel( ModelPenjualan entity ){

        return new ResponseDataSales(
                entity.getIdPenjualan(),
                entity.getIdCustomer(),
                entity.getTotalBayar(),
                0
        );
    }

    public List<ResponseKonfirmasiPembayaran> getStatusBayar(){

        return repositoryPenjualan
                .findAllByMetodePembayaranAndStatusPembayaranAndGambarBuktiTransferNotNull("transfer","belum")
                .stream()
                .map(this::toResponseKonfirmasiPembayaranSimpel)
                .collect(Collectors.toList());

    }

    private ResponseKonfirmasiPembayaran toResponseKonfirmasiPembayaranSimpel( ModelPenjualan entity ){

        return new ResponseKonfirmasiPembayaran(
                entity.getIdPenjualan(),
                entity.getTotalPenjualan(),
                entity.getTotalBayar(),
                entity.getAlamatTujuan(),
                entity.getMetodePembayaran(),
                entity.getTanggalPenjualan(),
                entity.getIdCustomer(),
                entity.getGambarBuktiTransfer()
        );

    }

    public void setStatusPembayaran( RequestSetStatusPembayaran request ){

        ModelPenjualan dataPenjualan ;

        switch (request.getMetodePembayaran()){

            case "transfer":
                dataPenjualan = repositoryPenjualan.findByIdPenjualanAndGambarBuktiTransferNotNull(request.getIdPenjualan());
                dataPenjualan.setStatusPembayaran("sudah");
                repositoryPenjualan.save(dataPenjualan);
                break;
            case "indopay":
                dataPenjualan = repositoryPenjualan.findByIdPenjualan(request.getIdPenjualan());
                dataPenjualan.setStatusPembayaran("sudah");
                repositoryPenjualan.save(dataPenjualan);
                break;

        }

    }

}