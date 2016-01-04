package io.storyhub.group;

import io.storyhub.security.UserSessionHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

/**
 * @author chanwook
 */
@Controller
public class GroupController {

    private final Logger logger = LoggerFactory.getLogger(GroupController.class);

    @RequestMapping("/group/list")
    public String list(ModelMap model, HttpSession session) {
        final UserSessionHandler userSession = new UserSessionHandler(session);

        if (logger.isDebugEnabled()) {
            logger.debug("Group list for " + userSession.getUserId());
        }

        return "groupList";
    }

}
