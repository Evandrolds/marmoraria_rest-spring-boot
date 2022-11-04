package com.evandro.marmoraria.resources;

import com.evandro.marmoraria.entities.Cliente;
import com.evandro.marmoraria.services.ClienteService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 *
 * @author Evandro
 */
@RestController
@RequestMapping({"/funcionarios"})
public class ClienteController {

    @Autowired
    private ClienteService service;

    @GetMapping
    public List<Cliente> findAllClientes() {
        return service.findAllClientes();
    }

    @PostMapping
    public Cliente saveCliente(@RequestBody Cliente obj) {
        return service.saveCliente(obj);
    }

    @GetMapping(path = {"/{id}"})
    public ResponseEntity<Cliente> findClienteById(@PathVariable Integer id) {
        return service.findClienteById(id)
                .map(f -> ResponseEntity.ok().body(f))
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping(path = {"/{id}"})
    public ResponseEntity<?> deleteClienteById(@PathVariable Integer id) {
        return service.findClienteById(id)
                .map(x -> {
                    service.deletClienteById(id);

                    return ResponseEntity.ok().build();
                }).orElse(ResponseEntity.notFound().build());
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Cliente> updateClienteById(@PathVariable("id") Integer id, @RequestBody Cliente cliente) {
        return service.findClienteById(id).map(func -> {
            func.setEmail(cliente.getEmail());
            func.setTelefone(cliente.getTelefone());
            Cliente atualizado = service.saveCliente(func);
            return ResponseEntity.ok().body(atualizado);
        }).orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/quantidade")
    public Long conutCliente() {
        return service.countCliente();
    }
}
