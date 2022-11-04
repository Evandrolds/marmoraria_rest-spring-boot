package com.evandro.marmoraria.entities;

import com.evandro.marmoraria.entities.enumeracao.StatusDoPedido;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import lombok.NoArgsConstructor;

/**
 *
 * @author Evandro
 */
@Entity
@NoArgsConstructor
@Table(name = "tbl_Pedido")

public final class Pedido implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private LocalDateTime dataDoPedido;
    private Integer statusDoPedido;
    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;
    @JsonIgnore
    @ManyToMany(mappedBy = "pedidos")
    private List<Produto> produtos = new ArrayList<>();

    public List<Produto> getProdutos() {
        return produtos;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Pedido(Integer id, LocalDateTime dataDoPedido, StatusDoPedido statusDoPedido, Cliente cliente) {
        this.id = id;
        this.dataDoPedido = dataDoPedido;
        this.cliente = cliente;
        setStatusDoPedido(statusDoPedido);

    }

    public Integer getId() {
        return id;
    }

    public LocalDateTime getDataDoPedido() {
        return dataDoPedido;
    }

    public void setDataDoPedido(LocalDateTime dataDoPedido) {
        this.dataDoPedido = dataDoPedido;
    }

    public StatusDoPedido getStatusDoPedido() {
        //Pegando o metodo estatico que foi criado lá da Enum e passando o getStatus no paramentro do metodo
        return StatusDoPedido.getStatusDoPedido(statusDoPedido);
    }

    public void setStatusDoPedido(StatusDoPedido statusDoPedido) {
        if (statusDoPedido != null) {
            //Pegando o status pelo código lá da Enum
            this.statusDoPedido = statusDoPedido.getCodigo();
        }
    }

}
