package io.storyhub.group;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author chanwook
 */
@Controller
public class GroupController {

    @RequestMapping("/group/list")
    public String list(ModelMap model) {

        return "groupList";
    }

}
