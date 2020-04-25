package co.g2academy.indoapril_1.repository;

import co.g2academy.indoapril_1.model.ModelBarangMasuk;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RepositoryBarangMasuk extends JpaRepository<ModelBarangMasuk, Integer> {

//    @Query(value = "SELECT * FROM ModelMasterBarang ORDER BY id",
//           countQuery = "SELECT count (*) FROM ModelMasterBarang",
//           nativeQuery = true)
    List<ModelBarangMasuk>findAll();


}
