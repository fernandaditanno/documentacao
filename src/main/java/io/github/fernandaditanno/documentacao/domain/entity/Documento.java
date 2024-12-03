package io.github.fernandaditanno.documentacao.domain.entity;

import io.github.fernandaditanno.documentacao.domain.enuns.Fase;
import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
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
