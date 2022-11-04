package com.evandro.marmoraria.entities;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import lombok.*;

/**
 *
 * @author Evandro
 */
@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor

@Table(name = "tbl_Produto")
public class Produto implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codigo;
    @Column(nullable = false, length = 25)
    private String nome;
    @Column(nullable = false, length = 60)
    private String descricao;
    private Double valor;
    
    @ManyToOne
    @JoinColumn(name = "Nota_do_Produto")
    private NFCs notaFiscal;
    
    @ManyToMany
    @JoinTable(name = "tb_Pedidos_Produtos",
            joinColumns = @JoinColumn(name = "produto_id"),
            inverseJoinColumns = @JoinColumn(name = "pedido_id"))
    private List<Pedido> pedidos = new ArrayList<>();

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

}
