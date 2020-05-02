package co.g2academy.indoapril_1.service.impl;
import co.g2academy.indoapril_1.model.ModelInventoryReport;
import co.g2academy.indoapril_1.repository.*;
import co.g2academy.indoapril_1.request.RequestInventoryReport;
import co.g2academy.indoapril_1.response.ResponseInventoryReport;
import co.g2academy.indoapril_1.service.ServiceInventoryReport;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Repository("ServiceInventoryReport")
public class ServiceInventoryReportImpl implements ServiceInventoryReport {

    RepositoryInventoryReport repository;

    public List<ResponseInventoryReport>getInventoryReportBy( RequestInventoryReport request ){

        List<ResponseInventoryReport> tempResponseReport = repository.getInventoryReport()
                .stream()
                .map(this::toResponseInventoryReportSimpel)
                .collect(Collectors.toList());

        List<ResponseInventoryReport> resultResponseReport = new ArrayList<ResponseInventoryReport>();

        int totalBarangMasuk = tempResponseReport.get(0).getQtt_Barang_Masuk();

        int totalBarangKeluar = 0;

            for( int i = 0; i < tempResponseReport.size(); i++ ){

                try {

                    if ( tempResponseReport.get(i).getId_Barang() == tempResponseReport.get(i+1).getId_Barang() ){

                        totalBarangMasuk += tempResponseReport.get(i+1).getQtt_Barang_Masuk();

                        totalBarangKeluar += tempResponseReport.get(i+1).getQty_Detail();

                    }else {

                        ResponseInventoryReport tempReportInvReport = new ResponseInventoryReport(
                                tempResponseReport.get(i).getId_Barang(),
                                tempResponseReport.get(i).getNama_Barang(),
                                tempResponseReport.get(i).getTanggal_Masuk(),
                                totalBarangMasuk,
                                totalBarangKeluar,
                                tempResponseReport.get(i).getQty_Stock(),
                                tempResponseReport.get(i).getQty_Min_Stock(),
                                tempResponseReport.get(i).getTgl_Order()

                        );

                        resultResponseReport.add( tempReportInvReport );

                        totalBarangMasuk = tempResponseReport.get(i+1).getQtt_Barang_Masuk();

                        totalBarangKeluar = 0;

                    }

                }catch (Exception e){

                    ResponseInventoryReport tempReportInvReport = new ResponseInventoryReport(
                            tempResponseReport.get(i).getId_Barang(),
                            tempResponseReport.get(i).getNama_Barang(),
                            tempResponseReport.get(i).getTanggal_Masuk(),
                            totalBarangMasuk,
                            totalBarangKeluar,
                            tempResponseReport.get(i).getQty_Stock(),
                            tempResponseReport.get(i).getQty_Min_Stock(),
                            tempResponseReport.get(i).getTgl_Order()

                    );

                    resultResponseReport.add(tempReportInvReport);
                }

            }

        return resultResponseReport;

    }

    private ResponseInventoryReport toResponseInventoryReportSimpel( ModelInventoryReport entity ){

        return new ResponseInventoryReport(
                entity.getId_Barang(),
                entity.getNama_Barang(),
                entity.getTanggal_Masuk(),
                entity.getQtt_Barang_Masuk(),
                entity.getQty_Detail(),
                entity.getQty_Stock(),
                entity.getQty_Min_Stock(),
                entity.getTgl_Order()
        );
    }

}
