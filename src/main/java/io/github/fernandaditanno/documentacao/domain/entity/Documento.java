package io.github.fernandaditanno.documentacao.domain.entity;

import io.github.fernandaditanno.documentacao.domain.enuns.Fase;
import jakarta.persistence.*;
import lombok.*;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "Documento")
@Data
@Setter
@Getter
public class Documento {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(unique = true, nullable = false)
    private Integer id;

    @Column(nullable = false)
    @NotEmpty
    private String titulo;

    @Column(nullable = false)
    @NotEmpty
    private String descricao;

    @Column(nullable = false)
    @NotEmpty
    private String versao;

    @Column(nullable = false)
    @NotEmpty
    private String sigla;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    @NotEmpty
    private Fase fase;
}
