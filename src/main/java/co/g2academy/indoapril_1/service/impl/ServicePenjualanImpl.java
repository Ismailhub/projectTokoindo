package co.g2academy.indoapril_1.service.impl;

import co.g2academy.indoapril_1.model.ModelPenjualanDetail;
import co.g2academy.indoapril_1.repository.RepositoryProduct;
import co.g2academy.indoapril_1.repository.RepositoryPenjualan;
import co.g2academy.indoapril_1.repository.RepositoryPenjualanDetail;
import co.g2academy.indoapril_1.request.RequestPenjualan;
import co.g2academy.indoapril_1.request.RequestPenjualanTgl;
import co.g2academy.indoapril_1.response.ResponseOrder;
import co.g2academy.indoapril_1.service.ServicePenjualan;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
@AllArgsConstructor
@Repository("ServicePenjualan")
public class ServicePenjualanImpl implements ServicePenjualan {

    private RepositoryProduct repositoryProduct;

    private RepositoryPenjualanDetail repositoryDetail;

    private RepositoryPenjualan repositoryPenjualan;

    //Menambah Data order
    @Override
    @Transactional
    public String create( List<RequestPenjualan> request ){

//        Integer total_qty = 0 ;
//
//        Integer id_customer = 0;
//
//        String id_order = UUID.randomUUID().toString();
//
//        String tgl_order = getTanggal();
//
//        for ( RequestPenjualan data : request ){
//
//            ModelPenjualanDetail entityDetail = toEntityDetail( id_order, data );
//
//            repositoryDetail.save( entityDetail );
//
//            repositoryProduct.decreaseByOrder(
//                    data.getQty(),
//                    data.getId_Barang()
//            );
//
//            id_customer = data.getId();
//
//            total_qty += data.getQty();
//
//        }
//
//        ModelPenjualan entityOrder = toEntityOrder(
//                id_order,
//                total_qty,
//                tgl_order,
//                id_customer
//        );
//
//        repositoryPenjualan.save( entityOrder );

        return "Order Berhasil";
    }

//    private ModelPenjualanDetail toEntityDetail (
//            String id_order,
//            RequestPenjualan respon
//    ){
//        return ModelPenjualanDetail
//                .builder()
//                .Id_Order( id_order )
//                .idBarang( respon.getId_Barang() )
//                .Qty_Detail( respon.getQty_Detail() )
//                .build();
//    }
//
//    private ModelPenjualan toEntityOrder (
//            String id_order,
//            Integer qty_total,
//            String tgl_order,
//            Integer id_user
//    ){
//        return ModelPenjualan
//                .builder()
//                .Id_Order( id_order )
//                .Qty_Total( qty_total )
//                .Tgl_Order( tgl_order )
//                .Id_User( id_user )
//                .build();
//    }

    private String getTanggal() {

        DateFormat dateFormat = new SimpleDateFormat( "yyyy-MM-dd" );

        Date date = new Date();

        return dateFormat.format(date);
    }

    //menampilkan order by tgl
    public List<ResponseOrder> getOrderByTgl( RequestPenjualanTgl request ){

        return null;
//        return repositoryDetail.findAll()
//                .stream()
//                .map(this::toResponseOrderSimpel)
//                .collect( Collectors.toList() );
    }

    private ResponseOrder toResponseOrderSimpel( ModelPenjualanDetail entity ){

        return null;
//        return new ResponseOrder(
//                entity.getOrder().getId_Order(),
//                entity.getOrder().getTgl_Order(),
//                entity.getBarang().getNama_Barang(),
//                entity.getQty_Detail(),
//                entity.getOrder().getUser().getAlamat_Penempatan()
//        );
    }

}