package co.g2academy.indoapril_1.repository;

import co.g2academy.indoapril_1.model.ModelPenjualan;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositoryPenjualan extends JpaRepository<ModelPenjualan, Integer> {

//    List<ModelPenjualan> findByUserModelUsername( String username );
//    @Transactional
//    @Query(value = "SELECT a.id_order, a.qty_total, a.id_user, a.tgl_order, c.nama_barang, b.qty_detail, d.alamat_penempatan FROM tb_order a INNER JOIN tb_order_detail b USING(id_order) INNER JOIN tb_barang c USING(id_barang) INNER JOIN user d USING(id_user) WHERE a.tgl_order = :tgl GROUP BY(b.no)", nativeQuery = true)
//    List<ModelPenjualan> getOrderByTgl(@Param("tgl") String tgl);

}
