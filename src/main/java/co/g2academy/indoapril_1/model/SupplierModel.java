package co.g2academy.indoapril_1.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tb_supplier")
@Entity
public class SupplierModel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int Id_Supplier;
    private String Nama_Supplier;
    private String Alamat_Supplier;
    private String Telepon_Supplier;

}