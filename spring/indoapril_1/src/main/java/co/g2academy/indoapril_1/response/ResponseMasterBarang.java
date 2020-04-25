package co.g2academy.indoapril_1.response;


import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
public class ResponseMasterBarang {
    private int Id_Barang;
    private String Nama_Barang;
    private String Nama_Suplier;
    private String Status;

    public ResponseMasterBarang(int id_barang,
                                String nama_barang,
                                String nama_Suplier,
                                String status){
        this.Id_Barang = id_barang;
        this.Nama_Barang = nama_barang;
        this.Nama_Suplier = nama_Suplier;
        this.Status = status;
    }
}
