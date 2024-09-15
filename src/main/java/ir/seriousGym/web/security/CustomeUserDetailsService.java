package ir.seriousGym.web.security;

import java.util.stream.Collectors;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import ir.seriousGym.web.model.UserEntity;
import ir.seriousGym.web.repository.UserRepo;

public class CustomeUserDetailsService implements UserDetailsService{
    private final UserRepo userRepo;
    

    public CustomeUserDetailsService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity user = userRepo.findFirstByUsername(username);
        if(user != null){
            // Spring Security provides a default implementation of the UserDetails interface called User.
            // This class is often used to create user objects that are authenticated by Spring Security.
            User authUser = new User(
                user.getEmail(),
                user.getPassword(),
                user.getRoles().stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList())
            );
             /**
                 * SimpleGrantedAuthority is a simple implementation of the GrantedAuthority interface in Spring Security. 
                 *  It is used to represent user roles or permissions in a straightforward manner.
            */
            return authUser;
        }else{
            throw new UsernameNotFoundException("Invalid Username or password(No Such User found in First Try in form of LIMIT 1)");
        }
    }
    
}
