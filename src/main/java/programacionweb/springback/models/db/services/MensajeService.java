package programacionweb.springback.models.db.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import programacionweb.springback.models.db.entities.Mensaje;
import programacionweb.springback.models.db.repositories.MensajeRepository;

import java.util.List;

@Service
public class MensajeService {

    @Autowired
    private MensajeRepository mensajeRepository;

    public List<Mensaje> obtenerTodosLosMensajes() {
        return mensajeRepository.findAll();
    }

    public void guardar(Mensaje mensaje) {
        mensajeRepository.save(mensaje);
    }

    public void borrar(Mensaje mensaje) {
        mensajeRepository.delete(mensaje);
    }

    public void borrarTodosLosMensajes() {
        mensajeRepository.deleteAll();
    }

    public void borrarPorId(Long id) {
        mensajeRepository.deleteById(id);
    }

    public Mensaje obtenerPorId(Long id) {
        return mensajeRepository.findById(id).orElse(null);
    }

    @Query("SELECT m FROM Mensaje m WHERE m.username = ?1")
    public List<Mensaje> obtenerMensajesPorUsername(String username) {
        return mensajeRepository.findByUsername(username);
    }
}
