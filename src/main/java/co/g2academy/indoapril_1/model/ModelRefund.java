package co.g2academy.indoapril_1.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tb_refund")
@Entity
public class ModelRefund implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer idRefund;
    private Integer idRefundStatus;
    private String noRekening;
    private String namaBank;
    private Date tanggalRefund;
    private String statusRefundSelesai;

    public void setTransferSelesai(String transferSelesai) {

        this.transferSelesai = transferSelesai;

    }

    private String transferSelesai;

}