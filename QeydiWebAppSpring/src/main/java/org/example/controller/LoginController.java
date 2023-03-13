package org.example.controller;

import at.favre.lib.crypto.bcrypt.BCrypt;
import org.example.entity.User;
import org.example.form.UserForm;
import org.example.service.inter.UserServiceInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

//import static org.example.service.impl.UserServiceImpl.verifyer;



@Controller
public class LoginController {

    private static BCrypt.Verifyer verifyer = BCrypt.verifyer();
    @Autowired
    UserServiceInter userService;

    @RequestMapping(method = {RequestMethod.GET}, value="/login")
    public String login(){
        return "login";
    }
    @RequestMapping(method = {RequestMethod.POST}, value="/sign-in")
    public ModelAndView signIn(
            @RequestParam(value="email") String email,
            @RequestParam(value="password") String password){
        User user = userService.findByEmail(email);

        if (user == null) {
            throw new IllegalArgumentException("Istifadeci tapilmadi");
        }

        BCrypt.Result rs = verifyer.verify(password.toCharArray(), user.getPassword().toCharArray());
        if (!rs.verified) {
            throw new IllegalArgumentException("Parol yanlishdir");
        }

        ModelAndView mv = new ModelAndView("users");
        mv.addObject("loggedInUser",user);
        return mv;
    }

    @RequestMapping(method = {RequestMethod.POST}, value="/sign-up")
    public ModelAndView signUp(
            @ModelAttribute("signupModel") UserForm u
    ){
        System.out.println(u.getSurname());
        int userId = 0;
        User user = new User(userId,u.getName(), u.getSurname(), u.getEmail(), u.getPassword());
        userService.addUser(user);
        System.out.println(user);
        System.out.println(user.getName());

        ModelAndView mv = new ModelAndView("redirect:/users");
        mv.addObject("loggedInUser",u);
        return mv;
    }
}
