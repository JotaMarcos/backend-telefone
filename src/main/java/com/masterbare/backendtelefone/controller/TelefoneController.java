package com.masterbare.backendtelefone.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.masterbare.backendtelefone.model.Telefone;
import com.masterbare.backendtelefone.services.TelefoneService;

@RestController
@RequestMapping("/api/telefones")
public class TelefoneController {

    @Autowired
    private TelefoneService telefoneService;

    @GetMapping
    public List<Telefone> obterTodos() {
        return telefoneService.obterTodos();
    }

    @GetMapping("/{id}")
    public Optional<Telefone> obterPorId(@PathVariable Long id) {
        return telefoneService.obterPorId(id);
    }

    @PostMapping
    public Telefone adicionar(@RequestBody Telefone telefone) {
        return telefoneService.adicionar(telefone);
    }

    @DeleteMapping("/{id}")
    public String deletar(@PathVariable Long id) {
        telefoneService.deletar(id);
        return "Telefone com id:" + id + " foi deletado com sucesso!";
    }
    
    @PutMapping("/{id}")
    public Telefone atualizar(@RequestBody Telefone telefone, @PathVariable long id) {

        return telefoneService.atualizar(id, telefone);
    }
}
