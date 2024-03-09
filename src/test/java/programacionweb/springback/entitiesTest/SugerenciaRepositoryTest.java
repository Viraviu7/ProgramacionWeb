package programacionweb.springback.entitiesTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import programacionweb.springback.models.db.entities.Sugerencia;
import programacionweb.springback.models.db.entities.Usuario;
import programacionweb.springback.models.db.repositories.SugerenciaRepository;

@SpringBootTest
@ExtendWith(SpringExtension.class)
public class SugerenciaRepositoryTest {

    @Autowired
    SugerenciaRepository sugerenciaRepository;

    @Autowired
    public SugerenciaRepositoryTest(SugerenciaRepository sugerenciaRepository) {
        this.sugerenciaRepository = sugerenciaRepository;
    }

    Usuario user = Usuario.builder()
        .nombre("Julian")
        .apellidos("Pizarro")
        .username("julianpizarro")
        .password("123")
        .email("b@example.com")
        .edad(0)
        .rep_password("123")
        .enabled(true)
        .created_at(Timestamp.valueOf(LocalDateTime.now()))
        .build();

    Usuario user2 = Usuario.builder()
        .nombre("Andres")
        .apellidos("perez")
        .username("and3sperez")
        .password("123")
        .email("a@example.com")
        .edad(0)
        .rep_password("123")
        .enabled(true)
        .created_at(Timestamp.valueOf(LocalDateTime.now()))
        .build();    

    @BeforeEach
    void setUp() {

        sugerenciaRepository.deleteAll();

    }
    @Test
    void givenAnSugerencia_whenSave_thenSugerenciawithId(){
        //given
        Sugerencia sugerencia = Sugerencia.builder()
                .descripcion("Hola, esto es una descripcion.")
                .created_at(Timestamp.valueOf(LocalDateTime.now()))
                .id_usuario(user)
                .build();
        //when
        Sugerencia sugerenciaSaved = sugerenciaRepository.save(sugerencia);
        //then
        assertNotNull(sugerenciaSaved);

    }
    @Test
    @DisplayName("dado un conjunto de usuarios al buscarlo todos obtenemos la lista de los usuarios en la base de datos")
    void shouldGetAllSugerencias(){
        //GIVEN
        Sugerencia sugerencia = Sugerencia.builder()
                .descripcion("Hola, esto es una descripcion.")
                .created_at(Timestamp.valueOf(LocalDateTime.now()))
                .id_usuario(user)
                .build();
        sugerenciaRepository.save(sugerencia);

        Sugerencia sugerencia2 = Sugerencia.builder()
                .descripcion("Hola, esto es una segunda descripcion.")
                .created_at(Timestamp.valueOf(LocalDateTime.now()))
                .id_usuario(user2)
                .build();
        sugerenciaRepository.save(sugerencia2);
        sugerenciaRepository.flush();
        //WHEN
        List<Sugerencia> sugerencias = sugerenciaRepository.findAll();

        //THEN
        assertEquals(2, sugerencias.size());
    }
    @Test
    void givenSugerencias_whenBuscarPorUsername_thenObtienesUnaListaDeSugerencias(){
        Sugerencia sugerencia = Sugerencia.builder()
                .descripcion("Hola, esto es una descripcion.")
                .created_at(Timestamp.valueOf(LocalDateTime.now()))
                .id_usuario(user)
                .build();
        sugerenciaRepository.save(sugerencia);

        List<Sugerencia> sugerencias = sugerenciaRepository.findByUsername("julianpizarro");

        //assertEquals(1, usuarios.size());
        assertTrue(sugerencias.size()>0);
        //assertTrue(usuarios.get(0).getNombre().equals("Julian"));
    }
}
