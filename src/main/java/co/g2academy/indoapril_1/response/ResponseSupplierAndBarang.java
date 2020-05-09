package co.g2academy.indoapril_1.response;

import lombok.*;

import javax.persistence.Id;

@Data
@Builder
@NoArgsConstructor

public class ResponseSupplierAndBarang {

    @Id
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

    public ResponseSupplierAndBarang(
            int id_Supplier,
            String nama_Supplier,
            String alamat_Supplier,
            String telepon_Supplier,
            Integer id_Barang,
            String nama_Barang,
            Integer qty_Min_Stock,
            Integer qty_Stock,
            String satuan,
            Integer harga_Barang
    ) {
        this.Id_Supplier = id_Supplier;
        this.Nama_Supplier = nama_Supplier;
        this.Alamat_Supplier = alamat_Supplier;
        this.Telepon_Supplier = telepon_Supplier;
        this.Id_Barang = id_Barang;
        this.Nama_Barang = nama_Barang;
        this.Qty_Min_Stock = qty_Min_Stock;
        this.Qty_Stock = qty_Stock;
        this.Satuan = satuan;
        this.Harga_Barang = harga_Barang;
    }

}
