package co.g2academy.indoapril_1.repository;

import co.g2academy.indoapril_1.model.ModelAdmin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositoryAdmin extends JpaRepository<ModelAdmin, Integer> {

    ModelAdmin getOneByEmail( String email );

    boolean existsByEmail(String email);

    boolean existsByToken(String token);

}
