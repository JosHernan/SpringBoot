package springboot.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;
import springboot.demo.model.Usuario;
import springboot.demo.repo.IUsuarioRepo;
import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

    @Autowired
    private IUsuarioRepo repo;

    @Autowired
    private BCryptPasswordEncoder encoder;
    @Test
    public void crearUsuarioTest() {

        Usuario us=new Usuario();
        us.setId(2);
        us.setNombre("spring");
        us.setClave(encoder.encode("145"));//creamos el encoder para eencriptar los datos de password
       Usuario retorno= repo.save(us);
       assertTrue(retorno.getClave().equalsIgnoreCase(us.getClave()));//prueba test
    }

}
