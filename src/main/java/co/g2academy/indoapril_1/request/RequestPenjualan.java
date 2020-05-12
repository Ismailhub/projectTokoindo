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
public class RequestPenjualan {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int No;
    private Integer Id_User;
    private Integer Id_Barang;
    private Integer Qty_Detail;

    public int getId(){
        return this.Id_User;
    }

    public int getQty(){
        return this.Qty_Detail;
    }

}
