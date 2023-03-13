package org.example.controller;

import at.favre.lib.crypto.bcrypt.BCrypt;
import org.example.entity.User;
import org.example.service.inter.UserServiceInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ResetController {
    @Autowired
    UserServiceInter userService;
    private static BCrypt.Verifyer verifyer = BCrypt.verifyer();

    @RequestMapping(method = {RequestMethod.GET}, value="/reset")
    public String reset(){
        return "reset";
    }

    @RequestMapping(method = {RequestMethod.POST}, value="/reset")
    public String reset(
            @RequestParam(value="email") String email,
            @RequestParam(value="password") String password,
            @RequestParam(value="new1Password") String new1Password,
            @RequestParam(value="new2Password") String new2Password
    ) {
        User user = userService.findByEmail(email);

        if (user == null) {
            throw new IllegalArgumentException("Istifadeci tapilmadi");
        }

        BCrypt.Result rs = verifyer.verify(password.toCharArray(), user.getPassword().toCharArray());
        if (!rs.verified) {
            throw new IllegalArgumentException("Parol yanlishdir");
        }

        int userId = userService.findIdByEmail(email);

        if (!new1Password.equals(new2Password)) {
            throw new IllegalArgumentException("Yeni parollar eynileshmir");
        }
        User u = new User(userId, new2Password);
        userService.updatePassword(u);
//        userDao.updatePassword(u);
//        ModelAndView mv = new ModelAndView("reset");
        return "users";
//        response.sendRedirect("users");
    }
}
