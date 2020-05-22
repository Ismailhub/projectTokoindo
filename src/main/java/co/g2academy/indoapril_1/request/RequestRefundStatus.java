package co.g2academy.indoapril_1.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RequestRefundStatus {

    private String idPenjualan;
    private String statusRefundDisetujui;

    public String getIdPenjualan() {
        return idPenjualan;
    }

    public String getStatusRefundDisetujui() {

        return statusRefundDisetujui;

    }

}
