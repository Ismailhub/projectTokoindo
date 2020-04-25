package co.g2academy.indoapril_1.controller;

import co.g2academy.indoapril_1.request.RequestSupplier;
import co.g2academy.indoapril_1.response.ResponseSupplier;
import co.g2academy.indoapril_1.response.ResponseSupplierAndBarang;
import co.g2academy.indoapril_1.service.ServiceSupplier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.util.List;

@RestController
@RequestMapping("supplier")
public class SupplierController {
    @Autowired
    ServiceSupplier service;

    // untuk menampilkan semua supplier
    @GetMapping("/getSuppliers")
    public List<ResponseSupplier> getSuppliers(){ return service.getSupplierList();}

    @GetMapping("/getSuppliersAndBarang")
    public List<ResponseSupplierAndBarang> getSuppliersAndBarang(){return service.getSupplierAndBarangList();}

    @PostMapping(value = "/setSupplier", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseSupplier setSupplier(@RequestBody RequestSupplier request){
        return service.create(request);
    }

}
