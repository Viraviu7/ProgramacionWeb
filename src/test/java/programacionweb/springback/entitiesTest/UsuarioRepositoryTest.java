package programacionweb.springback.entitiesTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import programacionweb.springback.models.db.entities.Usuario;
import programacionweb.springback.models.db.repositories.UsuarioRepository;

@SpringBootTest
public class UsuarioRepositoryTest {

    @Autowired
    UsuarioRepository usuarioRepository;


    @Autowired
    public UsuarioRepositoryTest(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }
/* 
    void initMockUsuarios(){
        Usuario usuario = Usuario.builder()
                .nombre("Julian")
                .apellidos("Pizarro")
                .username("julianpizarro")
                .password("123")
                .build();
        usuarioRepository.save(usuario);

        Usuario usuario2 = Usuario.builder().nombre("Jose")
                .apellidos("Pertuz")
                .username("josepertuz")
                .password("123")
                .build();
        usuarioRepository.save(usuario2);
        usuarioRepository.flush();
    }
*/
    @BeforeEach
    void setUp() {

        usuarioRepository.deleteAll();

    }
    @Test
    void givenAnUser_whenSave_thenUserwithId(){
        //given
        Usuario usuario = Usuario.builder()
                .nombre("Julian")
                .apellidos("Pizarro")
                .username("julianpizarro")
                .password("123")
                .email("")
                .edad(0)
                .rep_password("")
                .enabled(true)
                .created_at(Timestamp.valueOf(LocalDateTime.now()))
                .build();
        //when
        Usuario userSaved = usuarioRepository.save(usuario);
        //then
        assertNotNull(userSaved);

    }
    @Test
    @DisplayName("dado un conjunto de usuarios al buscarlo todos obtenemos la lista de los usuarios en la base de datos")
    void shouldGetAllUsers(){
        //GIVEN
        Usuario usuario = Usuario.builder()
                .nombre("Julian")
                .apellidos("Pizarro")
                .username("julianpizarro")
                .password("123")
                .email("b")
                .edad(0)
                .rep_password("123")
                .enabled(true)
                .created_at(Timestamp.valueOf(LocalDateTime.now()))
                .build();
        usuarioRepository.save(usuario);

        Usuario usuario2 = Usuario.builder()
                .nombre("Andres")
                .apellidos("perez")
                .username("and3sperez")
                .password("123")
                .email("a")
                .edad(0)
                .rep_password("123")
                .enabled(true)
                .created_at(Timestamp.valueOf(LocalDateTime.now()))
                .build();
        usuarioRepository.save(usuario2);
        usuarioRepository.flush();
        //WHEN
        List<Usuario> usuarios = usuarioRepository.findAll();

        //THEN
        assertEquals(2,usuarios.size());
    }
    @Test
    void givenUsuarios_whenBuscarPorNombreyApellido_thenObtienesUnaListaDeUsuarios(){
        Usuario usuario = Usuario.builder()
                .nombre("Julian")
                .apellidos("Pizarro")
                .username("julianpizarro")
                .password("123")
                .email("b")
                .edad(0)
                .rep_password("123")
                .enabled(true)
                .created_at(Timestamp.valueOf(LocalDateTime.now()))
                .build();
        usuarioRepository.save(usuario);

        List<Usuario> usuarios = usuarioRepository.buscarPorNombreYApellidos("Julian", "Pizarro");

        //assertEquals(1, usuarios.size());
        assertTrue(usuarios.size()>0);
        assertTrue(usuarios.get(0).getNombre().equals("Julian"));
    }

}
