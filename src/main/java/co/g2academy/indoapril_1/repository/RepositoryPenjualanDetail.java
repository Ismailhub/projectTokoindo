package co.g2academy.indoapril_1.repository;

import co.g2academy.indoapril_1.model.ModelPenjualanDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface RepositoryPenjualanDetail extends JpaRepository<ModelPenjualanDetail, Integer> {

//    @Transactional
//    @Query(value = "SELECT a.no, a.id_barang, a.id_order, b.tgl_order," +
//            " c.nama_barang, a.qty_detail, d.alamat_penempatan" +
//            " FROM tb_order_detail a" +
//            " INNER JOIN tb_order b" +
//            " USING(id_order)" +
//            " INNER JOIN tb_barang c" +
//            " USING(id_barang)" +
//            " INNER JOIN user d" +
//            " USING(id_user)" +
//            " WHERE b.tgl_order = :tgl", nativeQuery = true)
//    List<ModelPenjualanDetail> getOrderByTgl(@Param("tgl") String tgl );

//    @Query(value = "SELECT * FROM tb_order_detail INNER JOIN tb_order b USING(id_order) WHERE (b.tgl_order BETWEEN :tglMulai AND :tglAkhir) ORDER BY(id_barang)",nativeQuery = true)
//    List<ModelPenjualanDetail> getReportOrderDetail(@Param("tglMulai") String tglMulai, @Param("tglAkhir") String tglAkhir);

    List<ModelPenjualanDetail> findAllByOrderByIdProduct();
}