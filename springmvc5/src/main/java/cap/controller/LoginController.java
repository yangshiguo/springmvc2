package cap.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
@SessionAttributes("u")
public class LoginController {

    @RequestMapping(value = "login",method = RequestMethod.GET)
    public String login() {
        return "login";
    }

    @RequestMapping(value = "login",method = RequestMethod.POST)
    public ModelAndView login(@RequestParam("username") String username,@RequestParam("password") String password){
        ModelAndView modelAndView = new ModelAndView();
            if("admin".equals(username) && "admin".equals(password)) {
                modelAndView.addObject("u",username);
                modelAndView.setViewName("redirect:/user/list");
            }else {
                modelAndView.addObject("errMsg","密码错误");
            modelAndView.setViewName("login");
        }
        return modelAndView;
    }

    @RequestMapping(value="user/list",method = RequestMethod.GET)
    public String test() {
        return "user/list";
    }
}