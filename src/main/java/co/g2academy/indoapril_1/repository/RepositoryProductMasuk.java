package co.g2academy.indoapril_1.repository;

import co.g2academy.indoapril_1.model.ModelProductMasuk;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RepositoryProductMasuk extends JpaRepository<ModelProductMasuk, Integer> {

    List<ModelProductMasuk> findAllByOrderByIdProduct();

//    @Query(value = "SELECT * FROM tb_barang_masuk WHERE (tanggal_masuk BETWEEN :tglMulai AND :tglAkhir) ORDER BY(id_barang)",nativeQuery = true)
//    List<ModelProductMasuk> getReportBarangMasuk(@Param("tglMulai") String tglMulai, @Param("tglAkhir") String tglAkhir);

}
