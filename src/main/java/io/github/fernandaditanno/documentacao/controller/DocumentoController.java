package io.github.fernandaditanno.documentacao.controller;

import io.github.fernandaditanno.documentacao.domain.entity.Documento;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/Documento")
public class DocumentoController {

    @PostMapping
    public Documento salvar (@RequestBody Documento documento) {
        return documento;
    }
    @GetMapping
    public List<Documento> Listar(){
        return null;
    }

    @GetMapping("/{id}")
    public Documento buscarPorId(@PathVariable Integer id){
        return null;
    }

    @DeleteMapping("/{id}")
    public void excluir(@PathVariable Integer id){
    }

    @PutMapping("/{id}")
    public Documento atualizar(@RequestBody Documento documento){
        return null;
    }
}
