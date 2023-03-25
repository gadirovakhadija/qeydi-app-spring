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
//        if(user !=null){
//            UserBuilder builder = withUsername(email);
//            builder.disabled(false);
//            builder.password(user.getPassword());
//            String[] authoritiesArr = new String[]{ "ADMIN", "USER", "ROLE_USER"};
//            builder.authorities(authoritiesArr);
//            return builder.build();
//        }else{
//            throw new UsernameNotFoundException("User not found...");
//        }
//    }
//}
