package co.g2academy.indoapril_1.controller;

import co.g2academy.indoapril_1.request.RequestBarangKeluar;
import co.g2academy.indoapril_1.request.RequestBarangMasuk;
import co.g2academy.indoapril_1.response.ResponseBarangKeluar;
import co.g2academy.indoapril_1.response.ResponseBarangMasuk;
import co.g2academy.indoapril_1.service.ServiceBarangKeluar;
import co.g2academy.indoapril_1.service.ServiceBarangMasuk;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api_3")
public class BarangKeluarControler {
    @Autowired
    ServiceBarangKeluar service;

    //Menampilkan Seluruh Data
    @GetMapping("/BarangKeluar")
    public List<ResponseBarangKeluar> getBarangKeluar(){
        return service.getBarangKeluarList();
    }

    //Menambah Data Barang Keluar
    @PostMapping(value = "/InputBarangKeluar", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseBarangKeluar postBarangMasuk(@RequestBody RequestBarangKeluar request){
        return service.create(request);}
}
