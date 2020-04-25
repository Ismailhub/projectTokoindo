
package co.g2academy.indoapril_1.repository;

import co.g2academy.indoapril_1.model.ModelOrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositoryOrderDetail extends JpaRepository<ModelOrderDetail, Integer> {

}