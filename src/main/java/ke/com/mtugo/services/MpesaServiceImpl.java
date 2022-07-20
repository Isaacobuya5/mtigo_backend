package ke.com.mtugo.services;

import ke.com.mtugo.dtos.MpesaAccessToken;
import okhttp3.MediaType;
import org.json.JSONObject;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import okhttp3.*;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Base64;
import java.util.Map;


@Service
public class MpesaServiceImpl implements MpesaService {

    public MpesaAccessToken getAuthorizationToken() {
        String uri = "https://sandbox.safaricom.co.ke/oauth/v1/generate?grant_type=client_credentials";
        HttpHeaders headers = new HttpHeaders();
        String basicCredentials = "cFJZcjZ6anEwaThMMXp6d1FETUxwWkIzeVBDa2hNc2M6UmYyMkJmWm9nMHFRR2xWOQ==";
        headers.add("Authorization", "Basic " + basicCredentials);
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<MpesaAccessToken> response = restTemplate.exchange(
                uri,
                HttpMethod.GET,
                new HttpEntity<>("parameters", headers),
                MpesaAccessToken.class
        );

        return response.getBody();
    }

    @Override
    public Response makeMpesaPayment(Map<String, Object> mpesaPaymentDetails) throws URISyntaxException, IOException {
        // generate timestamp
        ZoneId zoneId = ZoneId.of("Africa/Nairobi");
        Timestamp timestamp = Timestamp.valueOf(LocalDateTime.now(zoneId));
        String generatedTimeStamp = new SimpleDateFormat("yyyyMMddHHmmss").format(timestamp);
        // generate password
        String businessShortCode = "174379";
        String passwordString = businessShortCode + "bfb279f9aa9bdbcf158e97dd71a467cd2e0c893059b10f78e6b72ada1ed2c919" + generatedTimeStamp;
        String password = Base64.getEncoder().encodeToString(passwordString.getBytes(StandardCharsets.UTF_8));
        OkHttpClient client = new OkHttpClient().newBuilder().build();
        MediaType mediaType = MediaType.parse("application/json");
        JSONObject jsonBody = new JSONObject(mpesaPaymentDetails);
        jsonBody.put("Timestamp", generatedTimeStamp);
        jsonBody.put("Password", password);
        jsonBody.put("PartyA", "254705407602");
        jsonBody.put("PhoneNumber", "254705407602");
        RequestBody body = RequestBody.create(jsonBody.toString(), mediaType);
        Request request = new Request.Builder()
                .url("https://sandbox.safaricom.co.ke/mpesa/stkpush/v1/processrequest")
                .method("POST", body)
                .addHeader("Content-Type", "application/json")
                .addHeader("Authorization", "Bearer lFPgYAMAATlWbmfT098cjYSGGGxj")
                .build();
        Response response = client.newCall(request).execute();
        System.out.println(response.body().string());
        // map to get the response
        return response;
        //return response;
    }
}
