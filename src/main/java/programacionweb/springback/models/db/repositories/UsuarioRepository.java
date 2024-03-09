package programacionweb.springback.models.db.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import programacionweb.springback.models.db.entities.Usuario;

@RepositoryRestResource
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {


    //List<Usuario> findByNombreContainingIgnoreCase(String nombre);

    // @Query("SELECT u FROM Usuario u WHERE u.username = ?1")
    // Usuario findByUsername(String username);


    @Query("SELECT u FROM Usuario u WHERE u.nombre = nombre AND u.apellidos = apellidos")
    List<Usuario> buscarPorNombreYApellidos(String nombre, String apellidos);

    // @Query("SELECT u FROM Usuario u WHERE u.username = ?1 OR u.email = ?2")
    // List<Usuario> findByUsernameOrEmail(String username, String email);

    // //List<Usuario> findByNombreLike(String nombre);

    // @Query("Select u from Usuario u where u.nombre like %?1")
    // List<Usuario> buscarPorNombre(String criterio);
}
