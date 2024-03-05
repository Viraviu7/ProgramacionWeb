package programacionweb.springback.models.db.services;

import org.springframework.beans.factory.annotation.Autowired;
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
}
