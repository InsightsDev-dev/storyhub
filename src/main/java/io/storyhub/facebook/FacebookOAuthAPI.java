package io.storyhub.facebook;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

/**
 * @author chanwook
 */
public class FacebookOAuthAPI {

    public static final String URL_PREFIX = "https://graph.facebook.com/oauth/";
    private final RestTemplate restTemplate = new RestTemplate();

    public String getAccessToken(String appId, String appSecret, String code) {

        final Map<String, String> args = new HashMap<>();
        args.put("appId", appId);
        args.put("appSecret", appSecret);
        args.put("code", code);

        final ResponseEntity<String> responseEntity = restTemplate.getForEntity(URL_PREFIX +
                "access_token?client_id={appId}&client_secret={appSecret}&code={code}", String.class, args);
        return responseEntity.getBody();
    }
}
