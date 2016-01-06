package io.storyhub.group;

import io.storyhub.security.UserSession;
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

        if (logger.isDebugEnabled()) {
            logger.debug("Group list for " + userSession.getUserId());
        }

        FacebookTemplate facebookTemplate = new FacebookTemplate(userSession);
        List<FacebookGroup> groupList = facebookTemplate.groupList();

        model.addAttribute(groupList);

        return "groupList";
    }

    @RequestMapping("/group/{groupId}")
    public String postListInGroup(@PathVariable String groupId,
                                  UserSession userSession, ModelMap model) {

        final FacebookTemplate facebookTemplate = new FacebookTemplate(userSession);
        // 현재 화면에서는 group 정보는 필요없고 바로 feed만 가져와도 된다.
//        FacebookGroup group = facebookTemplate.group(groupId);
        List<Post> postList = facebookTemplate.feedOfGroup(groupId);

        return "postList";
    }

}
