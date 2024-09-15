package ir.seriousGym.web.security;


import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;


public class SecurityUtil {
    public static String getUserBySession(){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        // checking if the user is logged in / if its logged in then
        if(!(auth instanceof AnonymousAuthenticationToken)){
            String currentUsername = auth.getName();
            return currentUsername;
        }
        // if the user is not authenticated
        return null;
    }
}
