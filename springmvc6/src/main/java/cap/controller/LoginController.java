package cap.controller;


import cap.model.Admin;
import cap.service.AdminService;
import cap.util.PageBean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;

@Controller
@RequestMapping("/")
public class LoginController {

    @Resource
    private AdminService adminService;

    @RequestMapping(value = "login", method = RequestMethod.GET)
    public String login() {
        return "login";
    }

    @RequestMapping(value = "login", method = RequestMethod.POST)
    public @ResponseBody Admin login(@RequestBody Admin admin) {
        return adminService.login(admin);
    }

}
