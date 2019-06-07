package springboot.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import springboot.demo.service.UserService;

// spring security protege y habilito la seguridad y creo el mecanismo de acceso

@Configuration
@EnableWebSecurity
public class SecurityConfig  extends WebSecurityConfigurerAdapter {


    @Autowired
    private UserService userDetailService;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Bean
    public BCryptPasswordEncoder passwordEncoder(){ //bean para poder declarar y tener una instancia de ambistos singleton  en el core de spring
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        return bCryptPasswordEncoder;

    }

    protected  void configure(AuthenticationManagerBuilder auth) throws  Exception{

        auth.userDetailsService(userDetailService).passwordEncoder(bCryptPasswordEncoder);
    }


protected  void configure(HttpSecurity htpp) throws Exception{ //cualquier peticion que entra tiene que estar autentificado
    htpp.authorizeRequests()
                .anyRequest()
                .authenticated()
                .and()
                .httpBasic();


}



}
