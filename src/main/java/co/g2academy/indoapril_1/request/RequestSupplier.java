package co.g2academy.indoapril_1.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RequestSupplier {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int Id_Supplier;
    private String Nama_Supplier;
    private String Alamat_Supplier;
    private String Kota_Supplier;
    private String Provinsi_Supplier;
    private String Telepon_Supplier;
    private String Status;

}
