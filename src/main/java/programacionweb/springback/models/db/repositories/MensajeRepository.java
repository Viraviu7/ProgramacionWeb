package programacionweb.springback.models.db.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import programacionweb.springback.models.db.entities.Mensaje;

@RepositoryRestResource
public interface MensajeRepository extends JpaRepository<Mensaje, Long> {

    List<Mensaje> findByUsername(String username);
}

