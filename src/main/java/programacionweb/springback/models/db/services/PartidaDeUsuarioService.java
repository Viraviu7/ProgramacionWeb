package programacionweb.springback.models.db.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import programacionweb.springback.models.db.entities.PartidaDeUsuario;
import programacionweb.springback.models.db.repositories.PartidaDeUsuarioRepository;

import java.util.List;

@Service
public class PartidaDeUsuarioService {

    @Autowired
    private PartidaDeUsuarioRepository partidaDeUsuarioRepository;

    public List<PartidaDeUsuario> obtenerTodosLasPartidasDeUnUsuario() {
        return partidaDeUsuarioRepository.findAll();
    }

    public void insertarPartidaDeUsuario(PartidaDeUsuario partidaDeUsuario) {
        partidaDeUsuarioRepository.save(partidaDeUsuario);
    }

    public void borrarPartidaDeUsuario(PartidaDeUsuario partidaDeUsuario) {
        partidaDeUsuarioRepository.delete(partidaDeUsuario);
    }

    public void borrarTodosLasPartidasDeUnUsuario() {
        partidaDeUsuarioRepository.deleteAll();
    }

    public void borrarPartidaDeUsuarioPorId(Long id) {
        partidaDeUsuarioRepository.deleteById(id);
    }

    public PartidaDeUsuario obtenerPartidaDeUsuarioPorId(Long id) {
        return partidaDeUsuarioRepository.findById(id).orElse(null);
    }

    @Query("SELECT p FROM PartidaDeUsuario p WHERE p.usuario.username = ?1")
    public List<PartidaDeUsuario> obtenerPartidasDeUsuarioPorUsername(String username) {
        return partidaDeUsuarioRepository.findByUsuarioUsername(username);
    }
}
