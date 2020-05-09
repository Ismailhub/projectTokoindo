
package co.g2academy.indoapril_1.controller;

import co.g2academy.indoapril_1.request.RequestInventoryReport;
import co.g2academy.indoapril_1.response.loginresponse.BaseResponse;
import co.g2academy.indoapril_1.service.ServiceInventoryReport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("report")
public class InventoryReportController {

    @Autowired
    ServiceInventoryReport service;

    //melihat inventory report
    @PostMapping(
            value = "/getInventoryReport",
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<BaseResponse> getReport( @RequestBody RequestInventoryReport request ){

        BaseResponse baseResponse = new BaseResponse(HttpStatus.OK, "OK", service.getInventoryReportBy( request ), "Inventory Report");

        return new ResponseEntity<>( baseResponse,HttpStatus.OK );

    }

}
