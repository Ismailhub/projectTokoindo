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
@Table(name = "tb_refund_status")
@Entity
public class ModelRefundStatus implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer idRefundStatus;
    private String idPenjualan;
    private String statusRefundDiajukan;
    private String alasanRefund;
    private String statusRefundDisetujui;
    private Integer idCustomer;


    public void setStatusRefundDisetujui(String statusRefundDisetujui) {

        this.statusRefundDisetujui = statusRefundDisetujui;

    }

}