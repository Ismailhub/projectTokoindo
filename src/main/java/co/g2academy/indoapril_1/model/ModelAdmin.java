package co.g2academy.indoapril_1.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tb_admin")
@Entity
public class ModelAdmin implements Serializable {

    @Id //ganti2 kalo ada erorr kan ada 2 tuh Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer idAdmin;
    private String namaAdmin;
    private String email;
    private String password;
    private String telephon;
    private String status;
    private String token;

}

//    @OneToMany(mappedBy = "user")
//    private List<ModelPenjualan> order;