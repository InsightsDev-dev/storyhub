package io.storyhub.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

/**
 * @author chanwook
 */
@Controller
public class LoginController {

    private final Logger logger = LoggerFactory.getLogger(LoginController.class);

    @RequestMapping("/login")
    public String viewPage() {
        return "login";
    }

    @RequestMapping("/auth/fb")
    public String authenticationByFacebook(@RequestParam String accessToken,
                                           @RequestParam String userId,
                                           HttpSession session) {

        loggingToUserInfo(accessToken, userId);

        //TODO 일단 session에 저장해 group list를 가지고 오는 기능을 구현 한 후에 userdetails로 변경
        new UserSession(session).createUserSession(accessToken, userId);

        return "redirect:/group/list";
    }

    private void loggingToUserInfo(@RequestParam String accessToken, @RequestParam String userId) {
        if (logger.isInfoEnabled()) {
            StringBuilder sb = new StringBuilder();
            sb.append("=== Authentication By Facebook ===");
            sb.append("\n+AccessToken=");
            sb.append(accessToken);
            sb.append("\n+UserId=");
            sb.append(userId);

            logger.info(sb.toString());
        }
    }

}
