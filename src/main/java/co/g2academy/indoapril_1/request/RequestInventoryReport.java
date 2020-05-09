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
public class RequestInventoryReport {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int No;
    private String TglMulai;
    private String TglAkhir;

    public String getTglMulai() {
        return this.TglMulai;
    }

    public String getTglAkhir() {
        return this.TglAkhir;
    }
}
