package ke.com.mtugo.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import ke.com.mtugo.dtos.MpesaAccessToken;
import ke.com.mtugo.dtos.MpesaPaymentRequestDto;
import ke.com.mtugo.dtos.MpesaPaymentResponseDto;
import ke.com.mtugo.services.MpesaService;
import okhttp3.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestClientException;

import java.io.IOException;
import java.util.Map;

@RestController
@RequestMapping("api/v1")
public class MpesaController {

    @Autowired
    MpesaService mpesaService;


    @CrossOrigin("*")
    @GetMapping("/mpesa-access_token")
    public MpesaAccessToken getMpesaAuthorizationToken() {
        MpesaAccessToken accessToken = mpesaService.getAuthorizationToken();
        return accessToken;
    }

    @CrossOrigin("*")
    @PostMapping("/mpesa-make_payments")
    public Response makeMpesaPayment(@RequestBody Map<String, Object> mpesaPaymentDetails) throws RestClientException, JsonProcessingException {
        try {
            return mpesaService.makeMpesaPayment(mpesaPaymentDetails);
        } catch(Exception ex) {
            return null;
        }
    }

}
