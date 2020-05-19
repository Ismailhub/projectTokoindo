package co.g2academy.indoapril_1.response;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
public class ResponseDataSales {

    private String idPenjualan;
    private Integer idCustomer;
    private Integer totalBayar;
    private Integer keuntungan;

    public ResponseDataSales(
            String idPenjualan,
            Integer idCustomer,
            Integer totalBayar,
            Integer keuntungan
    ) {
        this.idPenjualan = idPenjualan;
        this.idCustomer = idCustomer;
        this.totalBayar = totalBayar;
        this.keuntungan = keuntungan;
    }


    public void setKeuntungan( Integer keuntungan ) {

        this.keuntungan = keuntungan;

    }

}