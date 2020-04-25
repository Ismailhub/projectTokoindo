package co.g2academy.indoapril_1.controller;

import co.g2academy.indoapril_1.request.RequestBarangMasuk;
import co.g2academy.indoapril_1.response.ResponseBarangMasuk;
import co.g2academy.indoapril_1.service.ServiceBarangMasuk;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api_1")
public class BarangMasukController {
    @Autowired
    ServiceBarangMasuk service;

    //Menampilkan Seluruh Data
    @GetMapping("/BarangMasuk")
    public List<ResponseBarangMasuk> getBarangMasuk(){
        return service.getBarangMasukList();
    }

    //Menambah Data Barang Masuk
    @PostMapping(value = "/TambahBarangMasuk", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseBarangMasuk postBarangMasuk(@RequestBody RequestBarangMasuk request){
        return service.create(request);}


}
