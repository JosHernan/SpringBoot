package springboot.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import springboot.demo.model.Persona;

public interface IPersonaRepo extends JpaRepository<Persona,Integer> {


}
