package ke.com.mtugo.services;

import ke.com.mtugo.dtos.MpesaAccessToken;
import okhttp3.Response;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Map;

public interface MpesaService {
   MpesaAccessToken getAuthorizationToken();
    Response makeMpesaPayment(Map<String, Object> paymentRequestDto) throws URISyntaxException, IOException;
}
