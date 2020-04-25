
package co.g2academy.indoapril_1.repository;

import co.g2academy.indoapril_1.model.ModelBarang;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;


public interface RepositoryBarang extends JpaRepository<ModelBarang, Integer> {

    @Transactional
    @Modifying(clearAutomatically = true)
    @Query(value = "UPDATE tb_barang set qty_stock = qty_stock - :qtyOrder WHERE id_barang =:idBarang", nativeQuery = true)
    void decreaseByOrder(@Param("qtyOrder") Integer qtyOrder, @Param("idBarang") Integer idBarang);

    @Transactional
    @Modifying(clearAutomatically = true)
    @Query(value = "UPDATE tb_barang set qty_stock = qty_stock + :qtyMasuk WHERE id_barang =:idBarang", nativeQuery = true)
    void addByBarangMasuk(@Param("qtyMasuk") Integer qtyMasuk, @Param("idBarang") Integer idBarang);

}
