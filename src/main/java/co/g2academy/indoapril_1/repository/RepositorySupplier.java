package co.g2academy.indoapril_1.repository;

import co.g2academy.indoapril_1.model.ModelSupplairAndBarang;
import co.g2academy.indoapril_1.model.SupplierModel;
import co.g2academy.indoapril_1.response.ResponseSupplierAndBarang;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface RepositorySupplier extends JpaRepository<SupplierModel, Integer> {

    List<SupplierModel> findAll();

//    @Query("SELECT new co.g2academy.indoapril_1.response.RepositorySupplierAndBarang(a.Nama_Supplier, b.Nama_Barang) FROM SupplierModel a JOIN a.ModelBarang b")
//    List<ResponseSupplierAndBarang> getSupplierAndBarangList();

}
