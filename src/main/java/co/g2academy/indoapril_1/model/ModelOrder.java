package co.g2academy.indoapril_1.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tb_order")
@Entity
@EntityListeners(AuditingEntityListener.class)
public class ModelOrder implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int no;
    private String Id_Order;
    private Integer Qty_Total;
    private String Tgl_Order;
    private Integer Id_User;

}