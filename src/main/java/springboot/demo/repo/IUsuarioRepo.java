package springboot.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import springboot.demo.model.Usuario;

public interface IUsuarioRepo extends JpaRepository<Usuario,Integer> {

    // buscar por nombre
     Usuario findByNombre(String nombre); // esto es igual a SELECT * FROM usuario where nombre



}
