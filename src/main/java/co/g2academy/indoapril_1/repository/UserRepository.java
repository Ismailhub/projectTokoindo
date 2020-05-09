package co.g2academy.indoapril_1.repository;

import co.g2academy.indoapril_1.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserModel, Integer> {

    UserModel getOneByUsername( String username );

//    @Query("SELECT new co.g2academy.indoapril_1.response.UserOrderDto(b.id_order, a.alamat_penempatan)" +
//            " FROM UserModel a INNER JOIN a.order b")
//    List<UserOrderDto> innerJoin();

}