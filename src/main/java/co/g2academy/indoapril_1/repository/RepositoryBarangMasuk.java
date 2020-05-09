package co.g2academy.indoapril_1.repository;

import co.g2academy.indoapril_1.model.ModelBarangMasuk;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RepositoryBarangMasuk extends JpaRepository<ModelBarangMasuk, Integer> {

    List<ModelBarangMasuk> findAllByOrderByIdBarang();

//    @Query(value = "SELECT * FROM tb_barang_masuk WHERE (tanggal_masuk BETWEEN :tglMulai AND :tglAkhir) ORDER BY(id_barang)",nativeQuery = true)
//    List<ModelBarangMasuk> getReportBarangMasuk(@Param("tglMulai") String tglMulai, @Param("tglAkhir") String tglAkhir);

}
