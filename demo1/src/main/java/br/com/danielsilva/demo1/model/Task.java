package br.com.danielsilva.demo1.model;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "TB_TASK")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "Nome" , nullable = false , length = 50)
    private String nome;

    @Column(name = "completa", nullable = false)
    private boolean completed;

    @Column(name = "Descricao" , nullable = false , length = 50)
    private String description;

    @Column(name = "Prioridade" , nullable = false )
    private boolean prioridade;
}
