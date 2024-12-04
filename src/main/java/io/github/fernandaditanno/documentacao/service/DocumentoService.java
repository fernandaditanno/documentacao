package io.github.fernandaditanno.documentacao.service;

import io.github.fernandaditanno.documentacao.domain.entity.Documento;
import io.github.fernandaditanno.documentacao.domain.enuns.Fase;
import io.github.fernandaditanno.documentacao.domain.repository.DocumentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DocumentoService {

    @Autowired
    private DocumentoRepository documentoRepository;

    public Documento salvar(Documento documento) {
        if (!this.verificarSeExisteDocumento(documento.getSigla(), documento.getFase())){
            return this.documentoRepository.save(documento);
        }else {
            new Exception("Já possui um documento com essa sigla e fase cadastrados.");
            return null;
        }
    }

    public void excluir(Documento documento) {
        this.documentoRepository.delete(documento);
    }

    public List<Documento> listar() {
        return this.documentoRepository.findAll();
    }

    public Documento buscarPorId(Long id) {
        return this.documentoRepository.findById(id).orElse(null);
    }

    public Boolean verificarSeExisteDocumento(String sigla, Fase fase){
        List<Documento> lista = this.documentoRepository.existeDocumentoComSiglaEFase(sigla, fase);
        if (lista.isEmpty()){
            return false;
        }else {
            return true;
        }
    }

    public Documento AtualizarFaseDoDocumento(Documento documento){
        List<Documento> lista = this.documentoRepository.buscarDocumentoPorSigla(documento.getSigla());
        List<Documento> listaAux = this.documentoRepository.existeDocumentoComSiglaEFase(documento.getSigla(), Fase.VIGENTE);
        if (listaAux.isEmpty()){
            Documento docEditar = this.documentoRepository.findById(documento.getId().longValue()).orElse(null);
            if (docEditar != null){
                docEditar.setFase(Fase.VIGENTE);
            }
        }else {
            Documento docEditar = this.documentoRepository.findById(documento.getId().longValue()).orElse(null);
            listaAux.forEach(d -> {
                int versao = Integer.parseInt(d.getVersao());
                int versaoMaisUm = versao + 1;
                if (docEditar != null){
                    docEditar.setFase(Fase.VIGENTE);
                    docEditar.setVersao(String.valueOf(versaoMaisUm));
                }
               if(d.getFase() == Fase.VIGENTE){

                   d.setFase(Fase.OBSOLETO);
                   this.documentoRepository.save(d);
               }
            });
        }
        return this.documentoRepository.findById(documento.getId().longValue()).orElse(null);
    }
}
