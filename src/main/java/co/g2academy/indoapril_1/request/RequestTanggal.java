package co.g2academy.indoapril_1.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RequestTanggal {

    private Date tgl;
    private Date tglAkhir;


    public Date getTgl() {
        return this.tgl;
    }

    public Date getTglAkhir(){

        return this.tglAkhir;
    }

}