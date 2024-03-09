package programacionweb.springback.entitiesTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import programacionweb.springback.models.db.entities.Mensaje;
import programacionweb.springback.models.db.entities.Partida;
import programacionweb.springback.models.db.entities.PartidaDeUsuario;
import programacionweb.springback.models.db.entities.Usuario;
import programacionweb.springback.models.db.repositories.PartidaDeUsuarioRepository;

public class PartidaDeUsuarioRepositoryTest {

    @Autowired
    PartidaDeUsuarioRepository partidaDeUsuarioRepository;


    @Autowired
    public PartidaDeUsuarioRepositoryTest(PartidaDeUsuarioRepository partidaDeUsuarioRepository) {
        this.partidaDeUsuarioRepository = partidaDeUsuarioRepository;
    }

    Usuario user = Usuario.builder()
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

    Usuario user2 = Usuario.builder()
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
    
    Partida partida = Partida.builder()
            .creadorEmail(user)
            .deporte("Futbol")
            .ciudad("Ciudad1")
            .provincia("Provincia1")
            .fecha(Date.valueOf(LocalDate.now()))
            .horaComienzo(Time.valueOf(LocalTime.now()))
            .horaFinal(Time.valueOf(LocalTime.now()))
            .participantes(4)
            .suplentes(5)
            .comentarios("Esto es un comentario.")
            .build();

    Partida partida2 = Partida.builder()
            .creadorEmail(user2)
            .deporte("Tenis")
            .ciudad("Ciudad2")
            .provincia("Provincia2")
            .fecha(Date.valueOf(LocalDate.now()))
            .horaComienzo(Time.valueOf(LocalTime.now()))
            .horaFinal(Time.valueOf(LocalTime.now()))
            .participantes(4)
            .suplentes(5)
            .comentarios("Esto es un segundo comentario.")
            .build();    



    @BeforeEach
    void setUp() {

        partidaDeUsuarioRepository.deleteAll();

    }
    @Test
    void givenAnMensaje_whenSave_thenMensajewithId(){
        //given
        PartidaDeUsuario partidaDeUsuario = PartidaDeUsuario.builder()
                .id_partida(partida)
                .id_usuario(user2)
                .build();
        //when
        PartidaDeUsuario partidaSaved = partidaDeUsuarioRepository.save(partidaDeUsuario);
        //then
        assertNotNull(partidaSaved);

    }
    @Test
    @DisplayName("dado un conjunto de usuarios al buscarlo todos obtenemos la lista de los usuarios en la base de datos")
    void shouldGetAllMensajes(){
        //GIVEN
        PartidaDeUsuario partidaDeUsuario = PartidaDeUsuario.builder()
                .id_partida(partida)
                .id_usuario(user2)
                .build();
        partidaDeUsuarioRepository.save(partidaDeUsuario);

        PartidaDeUsuario partidaDeUsuario2 = PartidaDeUsuario.builder()
                .id_partida(partida2)
                .id_usuario(user)
                .build();
        partidaDeUsuarioRepository.save(partidaDeUsuario2);

        partidaDeUsuarioRepository.flush();
        //WHEN
        List<PartidaDeUsuario> partidasDeUsuarios = partidaDeUsuarioRepository.findAll();

        //THEN
        assertEquals(2, partidasDeUsuarios.size());
    }
    @Test
    void givenMensajes_whenBuscarPorUsername_thenObtienesUnaListaDeMensajes(){
        PartidaDeUsuario partidaDeUsuario = PartidaDeUsuario.builder()
                .id_partida(partida)
                .id_usuario(user2)
                .build();
        partidaDeUsuarioRepository.save(partidaDeUsuario);

        List<PartidaDeUsuario> partidasDeUsuarios = partidaDeUsuarioRepository.findByPartidaId(2L);

        assertTrue(partidasDeUsuarios.size()>0);
    }

}
