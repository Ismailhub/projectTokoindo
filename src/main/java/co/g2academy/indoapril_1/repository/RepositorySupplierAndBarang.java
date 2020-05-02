
package co.g2academy.indoapril_1.repository;

import co.g2academy.indoapril_1.model.ModelSupplairAndBarang;
import co.g2academy.indoapril_1.model.SupplierModel;
import co.g2academy.indoapril_1.response.ResponseSupplierAndBarang;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

public interface RepositorySupplierAndBarang extends JpaRepository<ModelSupplairAndBarang, Integer> {

    @Transactional
    @Query(value = "SELECT a.id_supplier, a.nama_supplier, a.alamat_supplier," +
            " a.telepon_supplier, b.id_barang, b.nama_barang," +
            " b.qty_min_stock, b.qty_stock, b.satuan, b.harga_barang" +
            " FROM tb_supplier a" +
            " INNER JOIN tb_barang b" +
            " USING(id_supplier)", nativeQuery = true)
    List<ModelSupplairAndBarang> getSupplierAndBarangList();

}