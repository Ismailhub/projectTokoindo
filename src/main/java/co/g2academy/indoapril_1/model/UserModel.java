package co.g2academy.indoapril_1.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "user")
@Entity
@EntityListeners(AuditingEntityListener.class)
public class UserModel implements Serializable {
    @Id //ganti2 kalo ada erorr kan ada 2 tuh Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id_user")
    private int id_User;
    private String nama_User;
    private String username;
    private String password;
    private String alamat_Penempatan;
    private String telephon_User;
    private String status;
    private String token;

//    @OneToMany(
//            mappedBy = "user",
//            cascade = CascadeType.ALL,
//            fetch = FetchType.LAZY,
//            orphanRemoval = true
//    )
//    private List<ModelOrder> order = new ArrayList<ModelOrder>();

    // setter and getter
}