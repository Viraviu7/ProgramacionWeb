package programacionweb.springback.models.db.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import programacionweb.springback.models.db.entities.PartidaDeUsuario;

@RepositoryRestResource
public interface PartidaDeUsuarioRepository extends JpaRepository<PartidaDeUsuario, Long> {

    List<PartidaDeUsuario> findByUsuarioUsername(String username);
}
