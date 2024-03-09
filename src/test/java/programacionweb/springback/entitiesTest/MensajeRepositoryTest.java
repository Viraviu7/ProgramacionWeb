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
import programacionweb.springback.models.db.entities.Usuario;
import programacionweb.springback.models.db.repositories.MensajeRepository;

public class MensajeRepositoryTest {

    @Autowired
    MensajeRepository mensajeRepository;


    @Autowired
    public MensajeRepositoryTest(MensajeRepository mensajeRepository) {
        this.mensajeRepository = mensajeRepository;
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

        mensajeRepository.deleteAll();

    }
    @Test
    void givenAnMensaje_whenSave_thenMensajewithId(){
        //given
        Mensaje mensaje = Mensaje.builder()
                .creador_email(user)
                .destinatario_email(user2)
                .created_at(Timestamp.valueOf(LocalDateTime.now()))
                .contenido("Esto es un contenido.")
                .build();
        //when
        Mensaje partidaSaved = mensajeRepository.save(mensaje);
        //then
        assertNotNull(partidaSaved);

    }
    @Test
    @DisplayName("dado un conjunto de usuarios al buscarlo todos obtenemos la lista de los usuarios en la base de datos")
    void shouldGetAllMensajes(){
        //GIVEN
        Mensaje mensaje = Mensaje.builder()
                .creador_email(user)
                .destinatario_email(user2)
                .created_at(Timestamp.valueOf(LocalDateTime.now()))
                .contenido("Esto es un contenido.")
                .build();
                mensajeRepository.save(mensaje);

        Mensaje mensaje2 = Mensaje.builder()
                .creador_email(user2)
                .destinatario_email(user)
                .created_at(Timestamp.valueOf(LocalDateTime.now()))
                .contenido("Esto es un segundo contenido.")
                .build();
        mensajeRepository.save(mensaje2);
        mensajeRepository.flush();
        //WHEN
        List<Mensaje> mensajes = mensajeRepository.findAll();

        //THEN
        assertEquals(2, mensajes.size());
    }
    @Test
    void givenMensajes_whenBuscarPorUsername_thenObtienesUnaListaDeMensajes(){
        Mensaje mensaje = Mensaje.builder()
                .creador_email(user)
                .destinatario_email(user2)
                .created_at(Timestamp.valueOf(LocalDateTime.now()))
                .contenido("Esto es un contenido.")
                .build();
        mensajeRepository.save(mensaje);

        List<Mensaje> mensajes = mensajeRepository.findByUsername("julianpizarro");

        assertTrue(mensajes.size()>0);
    }

}
