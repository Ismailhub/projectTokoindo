package co.g2academy.indoapril_1.service.impl;
import co.g2academy.indoapril_1.model.*;
import co.g2academy.indoapril_1.repository.*;
import co.g2academy.indoapril_1.request.RequestInventoryReport;
import co.g2academy.indoapril_1.response.ResponseInventoryReport;
import co.g2academy.indoapril_1.service.ServiceInventoryReport;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Repository("ServiceInventoryReport")
public class ServiceInventoryReportImpl implements ServiceInventoryReport {

    @Autowired
    RepositoryBarang repositoryBarang;

    @Autowired
    RepositoryBarangMasuk repostiryBarangMasuk;

    @Autowired
    RepositoryOrderDetail repositoryOrderDetail;

    public List<ResponseInventoryReport>getInventoryReportBy( RequestInventoryReport request ){

        List<ResponseInventoryReport> resultBarang = repositoryBarang.findAll()
                .stream()
                .map(this::toResponseInventoryReportSimpel)
                .collect(Collectors.toList());

//        List<ModelBarangMasuk> tempBarangMasuk = repostiryBarangMasuk.findAll(Sort.by(Sort.Direction.ASC,"IdBarang"));

        List<ModelBarangMasuk> tempBarangMasuk = repostiryBarangMasuk.findAllByOrderByIdBarang();

        List<ModelOrderDetail> tempOrderDetail = repositoryOrderDetail.findAllByOrderByIdBarang();

        int idBarangMasuk = tempBarangMasuk.get(0).getIdBarang();

        int idBarangKeluar = tempOrderDetail.get(0).getIdBarang();

        Integer totalBarangMasuk = tempBarangMasuk.get(0).getQtt_Barang_Masuk();

        Integer totalBarangKeluar = tempOrderDetail.get(0).getQty_Detail();

        HashMap<Integer,Integer> listTotalMasuk = new HashMap<>();

        HashMap<Integer,Integer> listTotalKeluar = new HashMap<>();

        boolean lastIdBarangMasuk = true;

        boolean lastIdBarangKluar = true;

        for( int i = 0; i < tempBarangMasuk.size() || i < tempOrderDetail.size() ; i++ ){

            // untuk list total masuk
            try {

                if ( idBarangMasuk == tempBarangMasuk.get( i+1 ).getIdBarang() ){

                    totalBarangMasuk += tempBarangMasuk.get( i+1 ).getQtt_Barang_Masuk();

                }else {

                    listTotalMasuk.put( idBarangMasuk, totalBarangMasuk );

                    idBarangMasuk++;

                    totalBarangMasuk = tempBarangMasuk.get( i+1 ).getQtt_Barang_Masuk();

                }

            }catch (Exception e){

                if ( lastIdBarangMasuk ){

                    listTotalMasuk.put( idBarangMasuk, totalBarangMasuk );

                    lastIdBarangMasuk = false;
                }

                idBarangMasuk++;
            }

            // untuk list total keluar
            try {

                if ( idBarangKeluar == tempOrderDetail.get( i+1 ).getIdBarang() ){

                    totalBarangKeluar += tempOrderDetail.get( i+1 ).getQty_Detail();

                }else {

                    listTotalKeluar.put( idBarangKeluar, totalBarangKeluar );

                    idBarangKeluar++;

                    totalBarangKeluar = tempOrderDetail.get(i+1).getQty_Detail();

                }

            }catch ( Exception e ){

                if ( lastIdBarangKluar ){

                    listTotalKeluar.put(idBarangKeluar,totalBarangKeluar);

                    lastIdBarangKluar = false;

                }

                idBarangKeluar++;
            }

        }

        for (int k = 0; k < resultBarang.size(); k++){

            int idBarang = resultBarang.get(k).getId_Barang();

            if( listTotalKeluar.get( idBarang ) != null ){

                resultBarang.get(k).setQty_Detail( listTotalKeluar.get( idBarang ) );
            }

            if( listTotalMasuk.get( idBarang ) != null){

                resultBarang.get(k).setQtt_Barang_Masuk( listTotalMasuk.get(idBarang) );
            }

        }

        return resultBarang;
    }

    private ResponseInventoryReport toResponseInventoryReportSimpel( ModelBarang entity ){

        return new ResponseInventoryReport(
                entity.getIdBarang(),
                entity.getNama_Barang(),
                0,
                0,
                entity.getQty_Stock(),
                entity.getQty_Min_Stock()
        );
    }

}
