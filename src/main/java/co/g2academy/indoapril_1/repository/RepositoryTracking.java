package co.g2academy.indoapril_1.repository;

import co.g2academy.indoapril_1.model.ModelTracking;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface RepositoryTracking extends JpaRepository<ModelTracking, Integer> {

    boolean existsByIdPenjualanAndStatus( String idPenjualan, String status );

    List<ModelTracking> findByIdPenjualan( String idPenjualan );

}