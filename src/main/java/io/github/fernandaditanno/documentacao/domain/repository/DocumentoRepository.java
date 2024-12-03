package io.github.fernandaditanno.documentacao.domain.repository;

import io.github.fernandaditanno.documentacao.domain.entity.Documento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface DocumentoRepository extends JpaRepository<Documento, Long> {

    @Query("select dc from Documento dc where dc.titulo == :nome")
    public Documento findDocumentoByNome(String nome);

    
}
