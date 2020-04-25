package co.g2academy.indoapril_1.repository;

import co.g2academy.indoapril_1.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<UserModel, Integer> {
    List<UserModel> findAll();
    UserModel getOneByUsername(String username);
}
