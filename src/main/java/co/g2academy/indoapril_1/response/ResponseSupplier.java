package co.g2academy.indoapril_1.response;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Builder
@NoArgsConstructor
public class ResponseSupplier {

    @Id
    private int Id_Supplier;
    private String Nama_Supplier;
    private String Alamat_Supplier;
    private String Telepon_Supplier;

    public ResponseSupplier (
            int id_supplier,
            String nama_supplier,
            String alamat_supplier,
            String telepon_supplier
    ){
        this.Id_Supplier = id_supplier;
        this.Nama_Supplier = nama_supplier;
        this.Alamat_Supplier = alamat_supplier;
        this.Telepon_Supplier = telepon_supplier;
    }
}
