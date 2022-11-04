package com.evandro.marmoraria.services;

import com.evandro.marmoraria.entities.Produto;
import java.util.Optional;
import org.springframework.stereotype.Service;
import java.util.List;
import com.evandro.marmoraria.repositories.ProdutoRepository;

/**
 *
 * @author Evandro
 */
@Service
public class ProdutoService {

    private final ProdutoRepository repository;

    public ProdutoService(ProdutoRepository repository) {
        this.repository = repository;
    }

    public Produto saveProdutos(Produto prod) {
        return repository.save(prod);
    }

    public List<Produto> findAllProdutos() {

        return repository.findAll();
    }

    public Optional<Produto> findProdutosById(Integer id) {

        return repository.findById(id);
    }

    public boolean existsProdutosById(Integer id) {
        return repository.existsById(id);
    }

    public Long countProduto() {

        return repository.count();
    }

    public void deleteProdutosById(Integer id) {
        repository.deleteById(id);
    }

    public Produto updateProdutosById(Produto id) {

        repository.findById(id.getCodigo());
        return repository.save(id);

    }

}
