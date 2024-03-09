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

import java.sql.Date;
import java.sql.Time;

@Entity
@Data
@Table(name = "partidas")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Partida {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_partida;

    @ManyToOne
    @JoinColumn(referencedColumnName = "email", nullable = false)
    private Usuario creadorEmail;

    @Column(nullable = false, length = 100)
    private String deporte;

    @Column(nullable = false, length = 100)
    private String ciudad;

    @Column(nullable = false, length = 100)
    private String provincia;

    @Column(nullable = false)
    private Date fecha;

    @Column(nullable = false)
    private Time horaComienzo;

    @Column(nullable = false)
    private Time horaFinal;

    @Column(nullable = false)
    private Integer participantes;

    @Column(nullable = false)
    private Integer suplentes;

    @Column(nullable = false, length = 100)
    private String comentarios;
    
}
