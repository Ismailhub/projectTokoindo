package com.example.indoapril.controler;

import com.example.indoapril.model.ModelBarangMasuk;
import com.example.indoapril.service.BarangMasukService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RequestMapping("api/indoapril")
@RestController
public class ControlerBarangMasuk {

    @Autowired
    BarangMasukService service;

    @GetMapping("/barang_mask")
    public List<ModelBarangMasuk> list() {
        return service.listAll();
    }

    @GetMapping("/products/{id}")
    public ResponseEntity<ModelBarangMasuk> get(@PathVariable Integer id_barang_masuk) {
        try {
            ModelBarangMasuk product = service.get(id_barang_masuk);
            return new ResponseEntity<ModelBarangMasuk>(product, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<ModelBarangMasuk>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/input_masuk")
    public void add(@RequestBody ModelBarangMasuk tb_barang_masuk) {
        service.save(tb_barang_masuk);
    }
}
