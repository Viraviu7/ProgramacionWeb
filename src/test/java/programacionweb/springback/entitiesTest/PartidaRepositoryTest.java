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

import programacionweb.springback.models.db.entities.Partida;
import programacionweb.springback.models.db.entities.Usuario;
import programacionweb.springback.models.db.repositories.PartidaRepository;
import programacionweb.springback.models.db.repositories.UsuarioRepository;

public class PartidaRepositoryTest {

    @Autowired
    PartidaRepository partidaRepository;


    @Autowired
    public PartidaRepositoryTest(PartidaRepository partidaRepository) {
        this.partidaRepository = partidaRepository;
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


    @BeforeEach
    void setUp() {

        partidaRepository.deleteAll();

    }
    @Test
    void givenAnPartida_whenSave_thenPartidawithId(){
        //given
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
        //when
        Partida partidaSaved = partidaRepository.save(partida);
        //then
        assertNotNull(partidaSaved);

    }
    @Test
    @DisplayName("dado un conjunto de usuarios al buscarlo todos obtenemos la lista de los usuarios en la base de datos")
    void shouldGetAllPartidas(){
        //GIVEN
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
        partidaRepository.save(partida);

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
        partidaRepository.save(partida2);
        partidaRepository.flush();
        //WHEN
        List<Partida> partidas = partidaRepository.findAll();

        //THEN
        assertEquals(2, partidas.size());
    }
    @Test
    void givenPartidas_whenBuscarPorUsername_thenObtienesUnaListaDePartidas(){
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
        partidaRepository.save(partida);

        List<Partida> partidas = partidaRepository.findByUsername("julianpizarro");

        assertTrue(partidas.size()>0);
    }

}
