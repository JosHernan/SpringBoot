package springboot.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import springboot.demo.repo.IUsuarioRepo;
import springboot.demo.model.Usuario;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService implements UserDetailsService {

    //implementamos el userDeatailsService de Spring

    @Autowired
    private IUsuarioRepo repo;//inyectamos de donde vamos aobtener la informacion de la base de datos

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException { // aqui lo buscamos por nombre de usuario
        Usuario us=repo.findByNombre(username); // me retorna un usuario
        List<GrantedAuthority> roles=new ArrayList<>();//creamos una lista de roles
        roles.add(new SimpleGrantedAuthority("ADMIN"));//para despues pasarselo

        UserDetails userDetails=new User(us.getNombre(),us.getClave(),roles); // aqui estamos pasando a user de spring el nombre, clave y roles
        return userDetails;
    }


}
