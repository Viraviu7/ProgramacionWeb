package programacionweb.springback.models.db.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import java.sql.Timestamp;

@Entity
@Data
@Table(name = "mensajes")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Mensaje {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_mensaje;

    @ManyToOne
    @JoinColumn(referencedColumnName = "email", nullable = false)
    private Usuario creador_email;

    @ManyToOne
    @JoinColumn(referencedColumnName = "email", nullable = false)
    private Usuario destinatario_email;

    @Column(nullable = false)
    private Timestamp created_at;

    @Column(columnDefinition = "TEXT")
    private String contenido;

}
