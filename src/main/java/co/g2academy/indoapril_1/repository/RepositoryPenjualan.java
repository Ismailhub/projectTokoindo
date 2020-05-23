package co.g2academy.indoapril_1.repository;

import co.g2academy.indoapril_1.model.ModelPenjualan;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Date;
import java.util.List;

public interface RepositoryPenjualan extends JpaRepository<ModelPenjualan, String> {

    List<ModelPenjualan> findAllByTanggalPenjualanBetween(Date tanggal, Date tglAkhir, Sort sort);

    List<ModelPenjualan> findAllByMetodePembayaranAndStatusPembayaranAndGambarBuktiTransferNotNull(String metodePembayaran, String statusPembayaran);

    ModelPenjualan findByIdPenjualanAndGambarBuktiTransferNotNull(String idPenjualan);

}
