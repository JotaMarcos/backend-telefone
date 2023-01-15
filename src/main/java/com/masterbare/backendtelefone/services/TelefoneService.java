package com.masterbare.backendtelefone.services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.masterbare.backendtelefone.model.Telefone;
import com.masterbare.backendtelefone.repository.TelefoneRepository;

@Service
public class TelefoneService {

    @Autowired
    private TelefoneRepository telefoneRepository;
    
    /**
     * Método para retornar uma lista de telefones
     * @return Lista dos telefones
     */
    public List<Telefone> obterTodos() {
        // Colocar regra aqui caso tenha ...
        return telefoneRepository.obterTodos();
    }

    /**
     * Método que retorna o telefone encontrado pelo seu id.
     * @param id do telefone que será localizado. 
     * @return Retorna um telefone caso seja encontrado.
     */
    public Optional<Telefone> obterPorId(Long id) {
        return telefoneRepository.obterPorId(id);
    }

     /**
     * Método para adicionar telefone na lista.
     * @param telefone que será adicionado.
     * @return Retorna o telefone que foi adicionado na lista.
     */
    public Telefone adicionar(Telefone telefone) {
        // Poderia ter alguma regra de negócio para validar o telefone.
        return telefoneRepository.adicionar(telefone);
    }

    /**
     * Método para deletar o telefone por id.
     * @param id do telefone a ser deletado.
     */
    public void deletar(Long id) {
        // Aqui poderia ter alguma lógica de validação.
        telefoneRepository.deletar(id);
    }

    /**
     * Método para atualizar o telefone na lista.
     * @param telefone que será atualizado.
     * @param id do telefone.
     * @return Retorna o telefone após atualizar a lista.
     */
    public Telefone atualizar(Long id, Telefone telefone) {
       
        // Ter alguma validação no ID.
        telefone.setId(id);

        return telefoneRepository.atualizar(telefone);
    }

}
