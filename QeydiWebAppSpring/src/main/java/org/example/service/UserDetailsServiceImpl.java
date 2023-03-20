//package org.example.service;
//
//import org.example.dao.UserRepository;
//import org.example.entity.Role;
//import org.example.entity.User;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.User.UserBuilder;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//import java.util.ArrayList;
//import java.util.Set;
//
//import static org.springframework.security.core.userdetails.User.withUsername;
//@Service("userDetailsService")
//public class UserDetailsServiceImpl implements UserDetailsService {
//
//    @Autowired
//    private UserRepository userRepo;
//    @Override
//    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
//        User user = userRepo.findByEmail(email);
//        System.out.println("loadUserTeref");
//        if(user !=null){
//            System.out.println("loadUserTeref");
//
//            UserBuilder builder = withUsername(email);
//            System.out.println("loadUserTeref");
//
//            builder.disabled(false);
//            System.out.println("loadUserTeref");
//
//            builder.password(user.getPassword());
//            System.out.println("loadUserTeref");
//
//
//            String[] authoritiesArr = new String[]{ "ADMIN", "USER", "ROLE_USER"};
////            ArrayList<String> auts = new ArrayList<String>();
////            Set<Role> roles = user.getRole();
////
////        for (Role role : roles) {
////            auts.add(role.getRole());
////        }
////            builder.authorities((GrantedAuthority) auts);
////            String[] authoritiesArr = new String[]{user.getRole().toString()};
////            System.out.println("loadUserTeref");
////            System.out.println(authoritiesArr);
////            String[] authoritiesArr = new String[]{user.getRole().toString()};
//            builder.authorities(authoritiesArr);
////            System.out.println(user.getRole());
//            return builder.build();
//        }else{
//            throw new UsernameNotFoundException("User not found...");
//        }
//    }
//}
