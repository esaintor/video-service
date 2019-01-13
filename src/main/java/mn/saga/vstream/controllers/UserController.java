package mn.saga.vstream.controllers;

import mn.saga.vstream.models.CurrentUser;
import mn.saga.vstream.repos.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequestMapping("api")
public class UserController {

    @Autowired
    UserRepository userRepository;

    @GetMapping("me")
    public ResponseEntity<?> me(Principal principal) {
        CurrentUser user = new CurrentUser();

        OAuth2Authentication authentication = (OAuth2Authentication) principal;
        OAuth2AuthenticationDetails details = (OAuth2AuthenticationDetails) authentication.getDetails();

        if (details instanceof OAuth2AuthenticationDetails) {
            user.setToken(details.getTokenValue());
            user.setEmail(userRepository.findByUsername(principal.getName()).get().getEmail());
            user.setUsername(userRepository.findByUsername(principal.getName()).get().getUsername());
        }

        return ResponseEntity.ok(user);
    }
}
