package io.storyhub.facebook;

import io.storyhub.facebook.model.*;
import io.storyhub.security.UserSession;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author chanwook
 */
public class FacebookGraphAPI {

    private static final String FACEBOOK_API_URI = "https://graph.facebook.com/v2.5/";
    private static final String ACCESS_TOKEN_PARAM = "access_token={accessToken}";

    public static final String URL_GET_GROUP_LIST = FACEBOOK_API_URI + "{userId}/groups?" + ACCESS_TOKEN_PARAM;
    public static final String URL_GET_FEED_OF_GROUP = FACEBOOK_API_URI + "{groupId}/feed?" + ACCESS_TOKEN_PARAM;
    public static final String URL_GET_POST = FACEBOOK_API_URI + "{postId}?" + ACCESS_TOKEN_PARAM;

    private final RestTemplate restTemplate;

    private final UserSession userSession;

    public FacebookGraphAPI(UserSession userSession) {
        this.userSession = userSession;
        this.restTemplate = new RestTemplate();
    }

    /**
     * https://developers.facebook.com/docs/graph-api/reference/user/groups/
     *
     * @return
     */
    public List<Group> groupList() {
        Map<String, String> args = new HashMap<>();
        args.put("userId", userSession.getUserId());
        args.put("accessToken", userSession.getAccessToken());

        GroupList data = restTemplate.getForObject(URL_GET_GROUP_LIST, GroupList.class, args);
        return data.getData();
    }

    /**
     * https://developers.facebook.com/docs/graph-api/reference/v2.5/group
     *
     * @param groupId
     * @return
     */
    public Group group(String groupId) {

        return null;
    }

    /**
     * https://developers.facebook.com/docs/graph-api/reference/v2.5/group/feed
     *
     * @param groupId
     * @return
     */
    public List<Post> feedOfGroup(String groupId) {
        Map<String, String> args = new HashMap<>();
        args.put("accessToken", userSession.getAccessToken());
        args.put("groupId", groupId);

        ResponseEntity<Feed> response =
                restTemplate.getForEntity(URL_GET_FEED_OF_GROUP, Feed.class, args);
        return response.getBody().getPostList();
    }

    /**
     * https://developers.facebook.com/docs/graph-api/reference/v2.5/post
     *
     * @param postId
     * @return
     */
    public Post getPost(String postId) {
        final HashMap<String, String> args = new HashMap<>();
        args.put("postId", postId);
        args.put("accessToken", userSession.getAccessToken());

        final ResponseEntity<Post> response = restTemplate.getForEntity(URL_GET_POST, Post.class, args);
        return response.getBody();
    }
}
