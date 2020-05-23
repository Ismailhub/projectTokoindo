package co.g2academy.indoapril_1.repository;

import co.g2academy.indoapril_1.model.ModelSupplier;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositorySupplier extends JpaRepository<ModelSupplier, Integer> {

    boolean existsByNamaSupplierAndAlamatSupplierAndTelepon( String nama, String alamat, String telepon );

    boolean existsByIdSupplier( Integer idSupplier );

}