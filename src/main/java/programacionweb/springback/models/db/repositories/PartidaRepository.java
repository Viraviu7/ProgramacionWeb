package programacionweb.springback.models.db.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import programacionweb.springback.models.db.entities.Partida;

@RepositoryRestResource
public interface PartidaRepository extends JpaRepository<Partida, Long> {
}
