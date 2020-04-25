package co.g2academy.indoapril_1.repository;

import co.g2academy.indoapril_1.model.ModelBarangMasuk;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RepositoryBarangMasuk extends JpaRepository<ModelBarangMasuk, Integer> {
    List<ModelBarangMasuk> findAll();
//    ModelMasterBarang getOneByIdBarang(Integer IdBarang);
//    ModelMasterBarang getOneByIdSuplier(Integer IdSuplier);

}
