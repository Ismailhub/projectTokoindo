package co.g2academy.indoapril_1.repository;

import co.g2academy.indoapril_1.model.ModelOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

public interface RepositoryOrder extends JpaRepository<ModelOrder, Integer> {

//    List<ModelOrder> findByUserModelUsername( String username );
//    @Transactional
//    @Query(value = "SELECT a.id_order, a.qty_total, a.id_user, a.tgl_order, c.nama_barang, b.qty_detail, d.alamat_penempatan FROM tb_order a INNER JOIN tb_order_detail b USING(id_order) INNER JOIN tb_barang c USING(id_barang) INNER JOIN user d USING(id_user) WHERE a.tgl_order = :tgl GROUP BY(b.no)", nativeQuery = true)
//    List<ModelOrder> getOrderByTgl(@Param("tgl") String tgl);
}
