
package co.g2academy.indoapril_1.response;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Data
@Builder
@NoArgsConstructor
public class ResponseInventoryReport {

    @Id
    private int Id_Barang;
    private String Nama_Barang;
    private Date Tanggal_Masuk;
    private Integer Qtt_Barang_Masuk;
    private Integer Qty_Stock;
    private Integer Qty_Detail; //sebagai barang keluar
    private Integer Qty_Min_Stock;
    private Date Tgl_Order;

    public ResponseInventoryReport(
            int id_Barang,
            String nama_Barang,
            Date tanggal_Masuk,
            Integer qtt_Barang_Masuk,
            Integer qty_Detail,
            Integer qty_Stock,
            Integer qty_Min_Stock,
            Date tgl_Order
    ) {
        this.Id_Barang = id_Barang;
        this.Nama_Barang = nama_Barang;
        this.Tanggal_Masuk = tanggal_Masuk;
        this.Qtt_Barang_Masuk = qtt_Barang_Masuk;
        this.Qty_Detail = qty_Detail;
        this.Qty_Stock = qty_Stock;
        this.Qty_Min_Stock = qty_Min_Stock;
        this.Tgl_Order = tgl_Order;
    }

    public int getId_Barang() {

        return this.Id_Barang;
    }

    public Integer getQty_Detail() {

        if(this.Qty_Detail != null){

            return this.Qty_Detail;

        }else {

            return 0;

        }
    }

    public Integer getQtt_Barang_Masuk() {

        return this.Qtt_Barang_Masuk;

    }

    public Integer getQty_Stock() {

        return this.Qty_Stock;

    }

    public String getNama_Barang() {

        return this.Nama_Barang;

    }

    public Integer getQty_Min_Stock() {

        return this.Qty_Min_Stock;

    }

    public Date getTgl_Order() {

        if( this.Tgl_Order != null){

            return this.Tgl_Order;

        }else {

            Date date = new Date();

            return date;

        }
    }

    public Date getTanggal_Masuk() {

        return this.Tanggal_Masuk;

    }

}