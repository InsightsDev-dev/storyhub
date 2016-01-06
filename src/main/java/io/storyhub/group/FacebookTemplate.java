package io.storyhub.group;

import io.storyhub.security.UserSession;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author chanwook
 */
public class FacebookTemplate {

    private static final String FACEBOOK_API_URI = "https://graph.facebook.com/v2.5/";
    private static final String ACCESS_TOKEN_PARAM = "access_token={accessToken}";

    public static final String URL_FB_GET_GROUP_LIST = FACEBOOK_API_URI + "{userId}/groups?" + ACCESS_TOKEN_PARAM;
    public static final String URL_FB_GET_GROUP = FACEBOOK_API_URI + "{groupId}?" + ACCESS_TOKEN_PARAM;
    public static final String URL_FB_GET_FEED_OF_GROUP = FACEBOOK_API_URI + "{groupId}/feed?" + ACCESS_TOKEN_PARAM;

    private final RestTemplate restTemplate;
    private final UserSession userSession;

    public FacebookTemplate(UserSession userSession) {
        this.userSession = userSession;
        this.restTemplate = new RestTemplate();
    }

    /**
     * https://developers.facebook.com/docs/graph-api/reference/user/groups/
     *
     * @return
     */
    public List<FacebookGroup> groupList() {
        Map<String, String> args = new HashMap<>();
        args.put("userId", userSession.getUserId());
        args.put("accessToken", userSession.getAccessToken());

        FacebookGroupData data = restTemplate.getForObject(URL_FB_GET_GROUP_LIST, FacebookGroupData.class, args);
        return data.getData();
    }

    /**
     * https://developers.facebook.com/docs/graph-api/reference/v2.5/group
     *
     * @param groupId
     * @return
     */
    public FacebookGroup group(String groupId) {

        return null;
    }


}
