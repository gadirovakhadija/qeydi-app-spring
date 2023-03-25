package org.example.service;

import org.example.MyUserDetails;
import org.example.dao.UserRepository;
import org.example.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsServiceImpl  implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {
        User user = userRepository.findByEmail(username);

        if (user == null) {
            throw new UsernameNotFoundException("Could not find user");
        }

        return new MyUserDetails(user);
    }

}
