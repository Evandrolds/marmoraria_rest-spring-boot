package com.evandro.marmoraria.resources;

import com.evandro.marmoraria.entities.Produto;
import com.evandro.marmoraria.services.ProdutoService;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 *
 * @author Evandro
 */
@RestController
@RequestMapping({"/produtos"})
public class ProdutoController {

    private final ProdutoService service;

    public ProdutoController(ProdutoService service) {
        this.service = service;
    }

    //O Controller é a classe responsável por expor cada URI que estará disponível na API Marmoraria.
    @GetMapping
    public List<Produto> findAllProdutos() {
        return service.findAllProdutos();
    }

    @GetMapping(path = {"/{id}"})
    public ResponseEntity<Produto> getProdutoById(@PathVariable Integer id) {
        return service.findProdutosById(id)
                .map(p -> ResponseEntity.ok().body(p))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/inserir")
    public Produto insertProduto(@RequestBody Produto prod) {
        
        
        return service.saveProdutos(prod);

    }

    @PutMapping(path = "/{id}")
    public ResponseEntity updateProdutosById(@PathVariable("id") Integer id, @RequestBody Produto produto) {

        return service.findProdutosById(id).map(prod -> {
            prod.setDescricao(produto.getDescricao());
            prod.setNome(produto.getNome());
            Produto atualizado = service.saveProdutos(prod);
            return ResponseEntity.ok().body(atualizado);
        }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping(path = {"/{id}"})
    public ResponseEntity deleteById(@PathVariable Integer id) {
        return service.findProdutosById(id).map(prod -> {
            service.deleteProdutosById(id);
            return ResponseEntity.ok().build();
        }).orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/quantidade")
    public Long countProdutos() {
        return service.countProduto();
    }
    @GetMapping("/existe/{id}")
    public Boolean existeProduto(@PathVariable("id") Integer id){
        return service.existsProdutosById(id);
    }
}
