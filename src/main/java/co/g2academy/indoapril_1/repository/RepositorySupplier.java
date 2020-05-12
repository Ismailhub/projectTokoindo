package co.g2academy.indoapril_1.repository;

import co.g2academy.indoapril_1.model.ModelSupplier;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RepositorySupplier extends JpaRepository<ModelSupplier, Integer> {

    List<ModelSupplier> findAll();

//    @Query("SELECT new co.g2academy.indoapril_1.response.RepositorySupplierAndBarang(a.Nama_Supplier, b.Nama_Barang) FROM ModelSupplier a JOIN a.ModelProduct b")
//    List<ResponseSupplierAndBarang> getSupplierAndBarangList();

}