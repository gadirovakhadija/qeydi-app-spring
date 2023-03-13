package org.example.controller;

import at.favre.lib.crypto.bcrypt.BCrypt;
import org.example.entity.User;
import org.example.form.UserForm;
import org.example.service.inter.UserServiceInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class RegistrationController {

    @RequestMapping(method = {RequestMethod.GET}, value="/registration")
    public String registr(){
        return "registration";
    }
    @Autowired
    UserServiceInter userService;
    private static BCrypt.Verifyer verifyer = BCrypt.verifyer();
    @RequestMapping(method = {RequestMethod.POST}, value="/registration")
    public String registration(
//                                     @RequestParam(value="email") String email,
//                                     @RequestParam(value="password") String password,
//                                     @RequestParam(value="name") String name,
//                                     @RequestParam(value="surname") String surname,
//                                     @RequestParam(value="university") String university,
//                                     @RequestParam(value="experience") String experience,
//                                     @RequestParam(value="code") String code,
//                                     @RequestParam(value="age") Integer age
//                                     @RequestParam(value="point") Integer point,
//                                     @RequestParam(value="teachway") String teachway,
//                                     @RequestParam(value="subject") String subject,
//                                     @RequestParam(value="cost") Double cost
    @ModelAttribute("registrationModel") UserForm u
    ) {
        User user = userService.findByEmail(u.getEmail());
        System.out.println(user);
        if (user == null) {
            throw new IllegalArgumentException("Istifadeci tapilmadi");
        }

        BCrypt.Result rs = verifyer.verify(u.getPassword().toCharArray(), user.getPassword().toCharArray());
        if (!rs.verified) {
            throw new IllegalArgumentException("Parol yanlishdir");
        }
        int userId = userService.findIdByEmail(u.getEmail());
        System.out.println(userId);

        User us = new User(userId, u.getName(), u.getSurname(),
                u.getAge(), u.getUniversity(), u.getPoint(), u.getExperience(),
                u.getTeachwayId(), u.getSubjectId(), u.getCode(), u.getCost());

        userService.updateUser(us);
        return "redirect:/users";
    }
//    @ModelAttribute("registrationModel")
//    public UserForm getEmptyUserForm(){
//        return new UserForm(1, null,null,null,null);
//    }
}