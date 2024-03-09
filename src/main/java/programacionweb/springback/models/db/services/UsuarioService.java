package programacionweb.springback.models.db.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import programacionweb.springback.models.db.entities.Usuario;
import programacionweb.springback.models.db.repositories.UsuarioRepository;

import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<Usuario> obtenerTodosLosUsuarios() {
        return usuarioRepository.findAll();
    }

    public void registrarUsuario(Usuario usuario) {
        usuarioRepository.save(usuario);
    }

    public void borrarUsuario(Usuario usuario) {
        usuarioRepository.delete(usuario);
    }

    public void borrarUsuarioPorId(Long id) {
        usuarioRepository.deleteById(id);
    }

    public Usuario obtenerUsuarioPorId(Long id) {
        return usuarioRepository.findById(id).orElse(null);
    }

    public void actualizarUsuario(Usuario usuario) {
        usuarioRepository.save(usuario);
    }

    public void borrarTodosLosUsuarios() {
        usuarioRepository.deleteAll();
    }

    public boolean existeId(Long id) {
        return usuarioRepository.existsById(id);
    }

 
    // public Usuario obtenerPorUsername(String username) {
    //     return usuarioRepository.findByUsername(username);
    // }


}
