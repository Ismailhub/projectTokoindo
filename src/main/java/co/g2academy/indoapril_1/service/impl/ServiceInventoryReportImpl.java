package co.g2academy.indoapril_1.service.impl;

import co.g2academy.indoapril_1.model.*;
import co.g2academy.indoapril_1.repository.*;
import co.g2academy.indoapril_1.request.RequestInventoryReport;
import co.g2academy.indoapril_1.request.RequestTanggal;
import co.g2academy.indoapril_1.response.ResponseInventoryReport;
import co.g2academy.indoapril_1.service.ServiceInventoryReport;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import java.util.*;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Repository("ServiceInventoryReport")
public class ServiceInventoryReportImpl implements ServiceInventoryReport {

    @Autowired
    RepositoryProduct repositoryProduct;

    @Autowired
    RepositoryProductMasuk repostiryProductMasuk;

    @Autowired
    RepositoryPenjualanDetail repositoryPenjualanDetail;

    public List<ResponseInventoryReport>getInventoryReportBy( RequestTanggal request ){

        List<ResponseInventoryReport> resultProduct = repositoryProduct.findAllByOrderByIdProduct()
                .stream()
                .map(this::toResponseInventoryReportSimpel)
                .collect(Collectors.toList());

//        List<ModelProductMasuk> tempBarangMasuk = repostiryProductMasuk.findAll(Sort.by(Sort.Direction.ASC,"IdProduct"));

        Sort sort = Sort.by("idProduct");

        List<ModelProductMasuk> tempProductMasuk = repostiryProductMasuk.findAllByTanggalMasukBetween(request.getTgl(), request.getTglAkhir(), sort);

        System.out.println(tempProductMasuk);

        List<ModelPenjualanDetail> tempOrderDetail = repositoryPenjualanDetail.findAllByPenjualanTanggalPenjualanBetween(request.getTgl(), request.getTglAkhir(), sort);

        int noProductMasuk = 0;

        int noProductKeluar = 0;

        Integer totalProductMasuk = 0;

        Integer totalProductKeluar = 0;


        try {

            totalProductMasuk = tempProductMasuk.get(0).getQtyMasuk();

            totalProductKeluar = tempOrderDetail.get(0).getQtyPenjualan();

        }catch (Exception e){

            System.out.println(" salah satu data ada yg kosong "+e);

        }

        HashMap<Integer,Integer> listTotalMasuk = new HashMap<>();

        HashMap<Integer,Integer> listTotalKeluar = new HashMap<>();

        boolean lastIdProductMasuk = true;

        boolean lastIdProductKluar = true;

        System.out.println("sampe 1");

        for( int i = 0; i < tempProductMasuk.size() || i < tempOrderDetail.size() ; i++ ){

            // untuk list total masuk
            try {

                if ( resultProduct.get(noProductMasuk).getIdProduct() == tempProductMasuk.get( i+1 ).getIdProduct() ){

                    totalProductMasuk += tempProductMasuk.get( i+1 ).getQtyMasuk();

                }else {

                    listTotalMasuk.put( resultProduct.get(noProductMasuk).getIdProduct(), totalProductMasuk );

                    noProductMasuk++;

                    totalProductMasuk = tempProductMasuk.get( i+1 ).getQtyMasuk();

                }

            }catch (Exception e){

                if ( lastIdProductMasuk ){

                    listTotalMasuk.put( resultProduct.get(noProductMasuk).getIdProduct(), totalProductMasuk );

                    lastIdProductMasuk = false;
                }

                noProductMasuk++;
            }

            // untuk list total keluar
            try {

                if ( resultProduct.get(noProductKeluar).getIdProduct() == tempOrderDetail.get( i+1 ).getIdProduct() ){

                    totalProductKeluar += tempOrderDetail.get( i+1 ).getQtyPenjualan();

                }else {

                    listTotalKeluar.put( resultProduct.get(noProductKeluar).getIdProduct(), totalProductKeluar );

                    noProductKeluar++;

                    totalProductKeluar = tempOrderDetail.get(i+1).getQtyPenjualan();

                }

            }catch ( Exception e ){

                if ( lastIdProductKluar ){

                    listTotalKeluar.put(resultProduct.get(noProductKeluar).getIdProduct(),totalProductKeluar);

                    lastIdProductKluar = false;

                }

                noProductKeluar++;

            }

        }

        System.out.println("sampe 2");

        for ( int k = 0; k < resultProduct.size(); k++ ){

            int idProduct = resultProduct.get(k).getIdProduct();

            if( listTotalKeluar.get( idProduct ) != null ){

                resultProduct.get(k).setQtyPenjualan( listTotalKeluar.get( idProduct ) );

            }

            if( listTotalMasuk.get( idProduct ) != null){

                resultProduct.get(k).setQtyProductMasuk( listTotalMasuk.get(idProduct) );

            }

        }

        System.out.println("sampe 3");

        return resultProduct;

    }

    private ResponseInventoryReport toResponseInventoryReportSimpel( ModelProduct entity ){

        return new ResponseInventoryReport(
                entity.getIdProduct(),
                entity.getNamaProduct(),
                0,
                entity.getQtyStock(),
                0,
                entity.getQtyMinStock()
        );

    }

}