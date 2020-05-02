
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
public class RequestOrderTgl {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int No;
    private String Tgl;

    public String getTgl() {
        return this.Tgl;
    }
}
