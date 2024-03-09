package programacionweb.springback.models.db.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import programacionweb.springback.models.db.entities.PartidaDeUsuario;

@RepositoryRestResource
public interface PartidaDeUsuarioRepository extends JpaRepository<PartidaDeUsuario, Long> {

     @Query("SELECT p FROM PartidaDeUsuario p WHERE p.id_partida.id_partida = ?1")
     List<PartidaDeUsuario> findByPartidaId(Long id);

     //List<PartidaDeUsuario> findByUsuarioUsername(String username);
}
