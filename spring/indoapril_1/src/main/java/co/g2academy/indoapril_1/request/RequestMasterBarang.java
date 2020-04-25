package co.g2academy.indoapril_1.request;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RequestMasterBarang {
    private int Id_Barang;
    private String Nama_Barang;
    private String Nama_Suplier;
    private String Status;
}
