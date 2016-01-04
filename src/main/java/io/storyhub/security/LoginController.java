package io.storyhub.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

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
    public String authenticationByFacebook() {
        logger.info("=== Authentication By Facebook ===");

        return "redirect:/group/list";
    }

}
