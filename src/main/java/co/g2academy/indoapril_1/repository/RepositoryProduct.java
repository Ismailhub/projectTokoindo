package co.g2academy.indoapril_1.repository;

import co.g2academy.indoapril_1.model.ModelProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface RepositoryProduct extends JpaRepository<ModelProduct, Integer> {

    ModelProduct findByIdProduct( Integer id );

//    @Query(value = "SELECT * FROM tb_barang WHERE id_barang = :idBarang", nativeQuery = true)
//    ModelProduct findBarangById(@Param("idBarang") Integer idBarang );
//
//    @Transactional
//    @Modifying(clearAutomatically = true)
//    @Query(value = "UPDATE tb_barang SET qty_stock = qty_stock - :qtyOrder WHERE id_barang = :idBarang", nativeQuery = true)
//    void decreaseByOrder( @Param("qtyOrder") Integer qtyOrder, @Param("idBarang") Integer idBarang );
//
//    @Transactional
//    @Modifying(clearAutomatically = true)
//    @Query(value = "UPDATE tb_barang SET qty_stock = qty_stock + :qtyMasuk WHERE id_barang = :idBarang", nativeQuery = true)
//    void addByBarangMasuk( @Param("qtyMasuk") Integer qtyMasuk, @Param("idBarang") Integer idBarang );
//
//    @Query(value = "SELECT * FROM tb_barang ORDER BY(id_barang) ",nativeQuery = true)
//    List<ModelProduct> getReportBarang(@Param("tglMulai") String tglMulai, @Param("tglAkhir") String tglAkhir );
}
