package io.storyhub;

import io.chanwook.facebook.FacebookGraphAPI;
import io.chanwook.facebook.UserSession;
import io.chanwook.facebook.model.Group;
import io.chanwook.facebook.model.Post;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @author chanwook
 */
@Controller
public class GroupController {

    private final Logger logger = LoggerFactory.getLogger(GroupController.class);

    @RequestMapping("/group/list")
    public String list(ModelMap model, UserSession userSession) {

        FacebookGraphAPI facebookGraphAPI = new FacebookGraphAPI(userSession);
        List<Group> groupList = facebookGraphAPI.groupList();

        if (logger.isDebugEnabled()) {
            logger.debug("Group list for " + userSession.getUserId() + ", size is " + groupList.size());
        }

        model.put("groupList", groupList);

        return "groupList";
    }

    @RequestMapping("/group/{groupId}")
    public String postListInGroup(@PathVariable String groupId,
                                  UserSession userSession, ModelMap model) {

        final FacebookGraphAPI facebookGraphAPI = new FacebookGraphAPI(userSession);
        // 현재 화면에서는 group 정보는 필요없고 바로 feed만 가져와도 된다.
//        FacebookGroup group = facebookTemplate.group(groupId);
        List<Post> feed = facebookGraphAPI.feedOfGroup(groupId);

        if (logger.isDebugEnabled()) {
            logger.debug("Group feed for " + groupId + ", feed size is " + feed.size());
        }

        model.put("feed", feed);
        return "postList";
    }

}
