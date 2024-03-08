package programacionweb.springback.models.db.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import programacionweb.springback.models.db.entities.Sugerencia;
import programacionweb.springback.models.db.repositories.SugerenciaRepository;

import java.util.List;

@Service
public class SugerenciaService {

    @Autowired
    private SugerenciaRepository sugerenciaRepository;

    public List<Sugerencia> obtenerTodasLasSugerencias() {
        return sugerenciaRepository.findAll();
    }

    public Sugerencia crearSugerencia(Sugerencia sugerencia) {
        return sugerenciaRepository.save(sugerencia);
    }

    public void actualizarSugerencia(Sugerencia sugerencia) {
        sugerenciaRepository.save(sugerencia);
    }

    public void borrarSugerencia(Sugerencia sugerencia) {
        sugerenciaRepository.delete(sugerencia);
    }

    public void borrarTodasLasSugerencias() {
        sugerenciaRepository.deleteAll();
    }

    public void borrarSugerenciaPorId(Long id) {
        sugerenciaRepository.deleteById(id);
    }

    public Sugerencia obtenerSugerenciaPorId(Long id) {
        return sugerenciaRepository.findById(id).orElse(null);
    }

    public boolean existeId(Long id) {
        return sugerenciaRepository.existsById(id);
    }

    @Query("SELECT s FROM Sugerencia s WHERE s.username = ?1")
    public Sugerencia obtenerPorUsername(String username) {
        return sugerenciaRepository.findByUsername(username);
    }

}
