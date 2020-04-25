package co.g2academy.indoapril_1.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ResponseSupplierAndBarang {
    private int Id_Supplier;
    private String Nama_Supplier;
    private String Alamat_Supplier;
    private String Telepon_Supplier;
    private Integer Id_Barang;
    private String Nama_Barang;
    private Integer Qty_Min_Stock;
    private Integer Qty_Stock;
    private String Satuan;
    private Integer Harga_Barang;
}
