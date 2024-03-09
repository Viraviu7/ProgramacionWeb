package programacionweb.springback.models.db.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import programacionweb.springback.models.db.entities.Sugerencia;

@RepositoryRestResource
public interface SugerenciaRepository extends JpaRepository<Sugerencia, Long> {

    @Query("SELECT s FROM Sugerencia s WHERE s.id_usuario.username = ?1")
    List<Sugerencia> findByUsername(String username);
}
