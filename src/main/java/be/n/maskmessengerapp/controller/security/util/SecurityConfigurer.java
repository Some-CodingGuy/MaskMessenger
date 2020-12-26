package be.n.maskmessengerapp.controller.security.util;

import be.n.maskmessengerapp.controller.security.service.MyUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


// This annotation tells Spring Security that this is the configuration class for the "web security".
// Spring Security uses WebSecurityConfigurerAdapter to know what to do, but with this annotation,
//      any overriden method described here, will be executed instead of the original.
@EnableWebSecurity
public class SecurityConfigurer extends WebSecurityConfigurerAdapter {

    @Autowired
    private MyUserDetailsService myUserDetailsService;

    /**
     * This method will validate the the user credentials, and throw an exception if the user is not allowed.
     * @param auth
     * @throws Exception
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(myUserDetailsService);
    }
}
