package programacionweb.springback.models.db.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import programacionweb.springback.models.db.entities.Partida;

@RepositoryRestResource
public interface PartidaRepository extends JpaRepository<Partida, Long> {

    
    @Query("SELECT p FROM Partida p WHERE p.creadorEmail.username = ?1")
    List<Partida> findByUsername(String username);

    // //List<Usuario> findByNombreAndApellido(String nombre, String apellido);
    
    // @Query("SELECT u FROM Usuario u WHERE u.nombre = ?1 AND u.apellido = ?2")
    // List<Usuario> buscarPorNombreYApellido(String nombre, String apellido);
    // //List<Usuario> findByUsernameOrEmail(String username, String email);

    // //List<Usuario> findByNombreLike(String nombre);
    // @Query("Select u from Usuario u where u.nombre like %?1")
    // List<Usuario> buscarPorNombre(String nombre);
}
