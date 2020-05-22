package co.g2academy.indoapril_1.repository;

import co.g2academy.indoapril_1.model.ModelRefund;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface RepositoryRefund extends JpaRepository<ModelRefund,Integer> {

    List<ModelRefund> findAllByTransferSelesaiAndNoRekeningNotNull(String statusTransfer);

    ModelRefund findByIdRefundStatusAndNoRekeningNotNull(Integer idRefundStatus);

}
