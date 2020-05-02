//package co.g2academy.indoapril_1.repository;
//
//public interface RepositoryInventoryReport {
//}

package co.g2academy.indoapril_1.repository;

import co.g2academy.indoapril_1.model.ModelInventoryReport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


public interface RepositoryInventoryReport extends JpaRepository<ModelInventoryReport, Integer> {

    @Transactional
    @Query(value = "SELECT a.id_barang_masuk, a.nomor_surat_jalan, a.tanggal_pemesanan, a.id_barang," +
            " b.nama_barang, a.tanggal_masuk, a.qtt_barang_masuk," +
            " c.qty_detail, b.qty_stock, b.qty_min_stock, d.tgl_order" +
            " FROM tb_barang_masuk a" +
            " LEFT JOIN tb_barang b" +
            " ON a.id_barang = b.id_barang" +
            " LEFT JOIN tb_order_detail c" +
            " ON b.id_barang = c.id_barang" +
            " LEFT JOIN tb_order d" +
            " ON c.id_order = d.id_order" +
            " ORDER BY(a.id_barang)",
            nativeQuery = true)
    List<ModelInventoryReport> getInventoryReport();

}

//    SELECT a.id_barang, b.nama_barang, a.tanggal_masuk, sum(a.qtt_barang_masuk) masuk, sum(c.qty_detail) keluar, b.qty_stock, b.qty_min_stock, d.tgl_order
//        FROM tb_barang_masuk a
//        LEFT JOIN tb_barang b ON a.id_barang = b.id_barang
//        LEFT JOIN tb_order_detail c ON b.id_barang = c.id_barang
//        LEFT JOIN tb_order d ON c.id_order = d.id_order
//        GROUP BY(b.id_barang)