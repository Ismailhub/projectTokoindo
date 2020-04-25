package co.g2academy.indoapril_1.controller;

import co.g2academy.indoapril_1.request.RequestOrder;
import co.g2academy.indoapril_1.response.ResponseOrder;
import co.g2academy.indoapril_1.service.ServiceOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api_1")
public class OrderController {
    @Autowired
    ServiceOrder service;

    //Menambah Data Barang Masuk
    @PostMapping(value = "/InputOrder", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseOrder postBarangMasuk(@RequestBody List<RequestOrder> request){
        return service.create(request);
    }

}
