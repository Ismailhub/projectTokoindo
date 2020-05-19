package co.g2academy.indoapril_1.repository;

import co.g2academy.indoapril_1.model.ModelPenjualanDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.domain.Sort;

import java.util.Date;
import java.util.List;

public interface RepositoryPenjualanDetail extends JpaRepository<ModelPenjualanDetail, Integer> {

     List<ModelPenjualanDetail> findAllByOrderByIdProduct();

    List<ModelPenjualanDetail> findAllByPenjualanTanggalPenjualanBetween( Date tanggal, Date tglAkhir, Sort sort);

}