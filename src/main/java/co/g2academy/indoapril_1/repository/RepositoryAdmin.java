package co.g2academy.indoapril_1.repository;

import co.g2academy.indoapril_1.model.ModelAdmin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositoryAdmin extends JpaRepository<ModelAdmin, Integer> {

    ModelAdmin getOneByEmail( String email );

    boolean existsByEmail(String email);

    boolean existsByToken(String token);

//    @Query("SELECT new co.g2academy.indoapril_1.response.UserOrderDto(b.id_order, a.alamat_penempatan)" +
//            " FROM ModelAdmin a INNER JOIN a.order b")
//    List<UserOrderDto> innerJoin();

}
