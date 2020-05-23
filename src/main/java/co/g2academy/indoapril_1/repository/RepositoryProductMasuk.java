package co.g2academy.indoapril_1.repository;

import co.g2academy.indoapril_1.model.ModelProductMasuk;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Date;
import java.util.List;

public interface RepositoryProductMasuk extends JpaRepository<ModelProductMasuk, Integer> {

    List<ModelProductMasuk> findAllByOrderByIdProduct();

    List<ModelProductMasuk> findAllByTanggalMasukBetween( Date tanggalMulai, Date tanggalAkhir, Sort sort );

}