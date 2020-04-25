package co.g2academy.indoapril_1.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.awt.print.Book;
import java.io.Serializable;
import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tb_master_barang")
@Entity
@EntityListeners(AuditingEntityListener.class)
public class ModelMasterBarang implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int Id_Barang;       //    @Column(name = "id_barang")
    private String Nama_Barang;  //    @Column(name = "nama_barang")
    private String Nama_Suplier; //    @Column(name = "nama_supplier")
    private String Status;

}
