package programacionweb.springback.models.db.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Data
@Table(name = "partidas_de_usuarios")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PartidaDeUsuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(referencedColumnName = "id_partida")
    private Partida id_partida;

    @ManyToOne
    @JoinColumn(referencedColumnName = "id_usuario")
    private Usuario id_usuario;
}