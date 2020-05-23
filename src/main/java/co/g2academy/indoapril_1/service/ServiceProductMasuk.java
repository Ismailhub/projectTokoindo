package co.g2academy.indoapril_1.service;

import co.g2academy.indoapril_1.request.RequestProductMasuk;
import co.g2academy.indoapril_1.response.ResponseProductMasuk;
import java.util.List;

public interface ServiceProductMasuk {

    List<ResponseProductMasuk> getProductMasukList();

    void create( List<RequestProductMasuk> request );

    boolean findNamaProduct( String namaProduct );

}