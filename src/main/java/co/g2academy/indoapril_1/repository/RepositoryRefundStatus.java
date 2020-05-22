package co.g2academy.indoapril_1.repository;

import co.g2academy.indoapril_1.model.ModelRefundStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RepositoryRefundStatus extends JpaRepository<ModelRefundStatus,Integer> {

    List<ModelRefundStatus> findAllByStatusRefundDisetujui(String status);

    ModelRefundStatus findByIdPenjualan(String idPenjualan);
}
