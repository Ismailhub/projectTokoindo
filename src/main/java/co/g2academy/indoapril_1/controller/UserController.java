package co.g2academy.indoapril_1.controller;

import co.g2academy.indoapril_1.request.loginrequest.LoginRequest;
import co.g2academy.indoapril_1.response.loginresponse.BaseResponse;
import co.g2academy.indoapril_1.response.loginresponse.UserResponse;
import co.g2academy.indoapril_1.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("users")
public class UserController {
    @Autowired
    UserService service;

    //POST LOGIN
    @PostMapping(value = "/", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BaseResponse> postLogin(@RequestBody LoginRequest request){
        BaseResponse baseResponse=service.loginByUsername(request);
        return new ResponseEntity<>(baseResponse, baseResponse.getCode());
    }
}
