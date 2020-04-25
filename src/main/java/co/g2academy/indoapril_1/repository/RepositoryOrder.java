package co.g2academy.indoapril_1.repository;

import co.g2academy.indoapril_1.model.ModelOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositoryOrder extends JpaRepository<ModelOrder, Integer> {

}
