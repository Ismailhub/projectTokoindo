package co.g2academy.indoapril_1.repository;

import co.g2academy.indoapril_1.model.ModelBarangKeluar;
import co.g2academy.indoapril_1.model.ModelBarangMasuk;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RepositoryBarangKeluar extends JpaRepository<ModelBarangKeluar, Integer> {
    List<ModelBarangKeluar> findAll();
}
