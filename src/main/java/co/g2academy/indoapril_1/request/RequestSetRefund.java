package co.g2academy.indoapril_1.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RequestSetRefund {

    private Integer idRefundStatus;

    public Integer getIdRefundStatus() {

        return idRefundStatus;

    }

}
