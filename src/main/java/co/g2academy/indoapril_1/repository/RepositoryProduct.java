package co.g2academy.indoapril_1.repository;

import co.g2academy.indoapril_1.model.ModelProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface RepositoryProduct extends JpaRepository<ModelProduct, Integer> {

    ModelProduct findByIdProduct( Integer id );

    List<ModelProduct> findAllByOrderByIdProduct();

    ModelProduct findByNamaProduct( String nama );

    boolean existsByNamaProduct( String nama );

}
