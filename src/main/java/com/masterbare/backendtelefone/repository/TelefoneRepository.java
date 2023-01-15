package com.masterbare.backendtelefone.repository;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;
import com.masterbare.backendtelefone.model.Telefone;

@Repository
public class TelefoneRepository {
    
    // Simulando um banco de dados em memória
    private List<Telefone> telefones = new ArrayList<Telefone>();
    private Long ultimoId = 0L;

    /**
     * Método para retornar uma lista de telefones
     * @return Lista dos telefones
     */
    public List<Telefone> obterTodos() {
        return telefones;
    }

    /**
     * Método que retorna o produto encontrado pelo seu id.
     * @param id do telefone que será localizado. 
     * @return Retorna um telefone caso seja encontrado.
     */
    public Optional<Telefone> obterPorId(Long id) {
        return telefones
                .stream()
                .filter(telefone -> telefone.getId() == id)
                .findFirst();
    }

    /**
     * Método para adicionar produto na lista.
     * @param telefone que será adicionado.
     * @return Retorna o telefone que foi adicionado na lista.
     */
    public Telefone adicionar(Telefone telefone) {
       
        ultimoId++;

        telefone.setId(ultimoId);
        telefones.add(telefone);

        return telefone;
    }

    /**
     * Método para deletar o telefone por id.
     * @param id do telefone a ser deletado.
     */
    public void deletar(Long id) {
        telefones.removeIf(telefone -> telefone.getId() == id);
    }

    /**
     * Método para atualizar o telefone na lista.
     * @param telefone que será atualizado.
     * @return Retorna o telefone após atualizar a lista.
     */
    public Telefone atualizar(Telefone telefone) {
        // Encontrar o telefone na lista
        Optional<Telefone> telefoneEncontrado = obterPorId(telefone.getId());

        if(telefoneEncontrado.isEmpty()){
            throw new InputMismatchException("telefone não encontrado");
        } 

        // Eu tenho que remover o telefone antigo da lista
        deletar(telefone.getId());
        // Depois adicionar o telefone atualizado na lista.
        telefones.add(telefone);

        return telefone;

    }

}
