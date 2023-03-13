package org.example.controller;

import org.example.form.UserForm;
import org.example.service.inter.UserServiceInter;
import org.example.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class UserController {
@Autowired
     private UserServiceInter userService;


//@RequestMapping(method= RequestMethod.GET,value = "/users")
//    public ModelAndView users(
//            @RequestParam(value="name",required = false) String name,
//            @RequestParam(value="surname", required = false) String surname,
//            @RequestParam(value = "email",required = false) String email,
//            @RequestParam(value = "password",required = false) String password){
//    List<User> user = userService.getAll(name,surname, email,password);
//    ModelAndView mv = new ModelAndView("users");
//
//    mv.addObject("users",user);
//    return mv;
//}
@RequestMapping(method = {RequestMethod.POST}, value="/users")
public String users(
//        @ModelAttribute("registrationModel") UserForm u
){
//    List<User> user = userService.getAll(u.getName(),u.getSurname(),u.getEmail(),u.getPassword());

    return "reset";
}
    @RequestMapping(method = {RequestMethod.GET}, value="/users")//users?name=Sarkhan
    public ModelAndView usersGet(
            @ModelAttribute("registrationModel") UserForm u
    ){

        List<User> user = userService.getAll(u.getName(),u.getSurname(),u.getEmail(),u.getPassword());
        ModelAndView mv = new ModelAndView("users");
        mv.addObject("users",user);

        return mv;

    }
//    @PostMapping("/users")
//@RequestMapping(method = {RequestMethod.GET}, value="/users")
//    public String users(){
//      return "users";
//    }

//    @RequestMapping(method = {RequestMethod.GET}, value="/index")//users?name=Sarkhan
//    public String loginPost(){
//        return "index";
//    }
//    @RequestMapping(value="/test",method=RequestMethod.POST)
//    public String test(){
//    return "test";
//    }
//public ModelAndView user(
////        @Valid
//@ModelAttribute("user") UserForm u) {
//    ModelAndView mv = new ModelAndView("users");
//    List<User> user = userService.getAll(u.getName(),u.getSurname(),u.getEmail(),u.getPassword());
//    mv.addObject("users",user);
//
//    return mv;
//}
//    @ModelAttribute("user")
//    public UserForm getEmptyUserForm(){
//        return new UserForm(1,null, null,null,null);
//    }
}
