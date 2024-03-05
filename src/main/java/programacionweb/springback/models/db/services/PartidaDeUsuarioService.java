package programacionweb.springback.models.db.services;

import org.springframework.beans.factory.annotation.Autowired;
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
}
