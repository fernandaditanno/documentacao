package io.github.fernandaditanno.documentacao.domain.repository;

import io.github.fernandaditanno.documentacao.domain.entity.Documento;
import io.github.fernandaditanno.documentacao.domain.enuns.Fase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Documentos extends JpaRepository<Documento, Long> {

    @Query ("select d from Documento d where d.fase = :fase and d.sigla = :sigla")
    List<Documento> existeDocumentoComSiglaEFase(String sigla, Fase fase);

    @Query ("select d from Documento d where d.sigla = :sigla")
    List<Documento> buscarDocumentoPorSigla(String sigla);


}
