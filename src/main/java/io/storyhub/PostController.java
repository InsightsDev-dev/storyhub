package io.storyhub;

import io.chanwook.facebook.FacebookGraphAPI;
import io.chanwook.facebook.UserSession;
import io.chanwook.facebook.model.Post;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author chanwook
 */
@Controller
public class PostController {

    @RequestMapping("/post/{postId}")
    public String viewPost(@PathVariable String postId, UserSession userSession, ModelMap model) {

        final FacebookGraphAPI graphAPI = new FacebookGraphAPI(userSession);
        Post post = graphAPI.getPost(postId);

        model.put("post", post);
        return "post";
    }
}
