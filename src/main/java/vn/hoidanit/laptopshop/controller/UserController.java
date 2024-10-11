package vn.hoidanit.laptopshop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import vn.hoidanit.laptopshop.domain.User;
import vn.hoidanit.laptopshop.service.UserService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping("/")
    public String getHomePage(Model model) {
        String test = this.userService.handlHello();
        model.addAttribute("eric", test);
        model.addAttribute("buihobac", "from bac dep trai");
        return "hello";
    }

    @RequestMapping("/admin/user")
    public String getUserPage(Model model) {
        String test = this.userService.handlHello();
        model.addAttribute("newUser", new User());
        model.addAttribute("buihobac", "from bac dep trai");

        return "admin/user/create";
    }

    @RequestMapping(value = "/admin/user/create", method = RequestMethod.POST)
    public String createUserPage(Model model, @ModelAttribute("newUser") User hoidanit) {
        String test = this.userService.handlHello();
        System.out.println("run here" + hoidanit);

        return "hello";
    }

}
