package programacionweb.springback.models.db.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import programacionweb.springback.models.db.entities.Partida;
import programacionweb.springback.models.db.repositories.PartidaRepository;

import java.util.List;

@Service
public class PartidaService {

    @Autowired
    private PartidaRepository partidaRepository;

    public List<Partida> obtenerTodasLasPartidas() {
        return partidaRepository.findAll();
    }

    public Partida crearPartida(Partida partida) {
        return partidaRepository.save(partida);
    }

    public Partida actualizarPartida(Partida partida) {
        return partidaRepository.save(partida);
    }

    public void borrarTodasLasPartidas() {
        partidaRepository.deleteAll();
    }

    public void borrarPartida(Partida partida) {
        partidaRepository.delete(partida);
    }

    public void borrarPartidaPorId(Long id) {
        partidaRepository.deleteById(id);
    }

    public Partida obtenerPartidaPorId(Long id) {
        return partidaRepository.findById(id).orElse(null);
    }

    public boolean existeId(Long id) {
        return partidaRepository.existsById(id);
    }

    @Query("SELECT p FROM Partida p WHERE p.username = ?1")
    public Partida obtenerPartidaPorUsername(String username) {
        return partidaRepository.findByUsername(username);
    }
}
