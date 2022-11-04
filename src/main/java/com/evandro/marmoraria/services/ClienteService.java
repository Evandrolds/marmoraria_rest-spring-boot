package com.evandro.marmoraria.services;

import com.evandro.marmoraria.entities.Cliente;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import com.evandro.marmoraria.repositories.ClienteRepositoty;

/**
 *
 * @author Evandro
 */
@Service
public class ClienteService {

    //Autowired
    public final ClienteRepositoty repository;

    /*
      Aqui no meu exemplo não estou usando a anotação @Autowired 
      pois não é mais considerado uma boa prática para injeção de dependência de atributos obrigatórios. 
      Desde a versão 4 do Spring a prática recomendada é o uso de injeção de dependência por construtor 
     
     */
    public ClienteService(ClienteRepositoty repository) {
        this.repository = repository;
    }
    
    public Cliente saveCliente(Cliente obj){
        return repository.save(obj);
    }
  
    public List<Cliente> findAllClientes(){
        return repository.findAll();
    }
    public Optional<Cliente> findClienteById(Integer id){
        return repository.findById(id);
    }
    public void deletClienteById(Integer id){
        repository.deleteById(id);
    }
    public Long countCliente(){
        return repository.count();
    }
    
}
