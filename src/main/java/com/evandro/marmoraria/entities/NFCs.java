package com.evandro.marmoraria.entities;


import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import lombok.*;

/**
 *
 * @author Evandro
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tbl_Nota_Fiscal")
public class NFCs {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String serie;
    private String razaoSocial;
    @OneToMany(mappedBy = "notaFiscal")
    private List<Produto> produtos = new ArrayList<>();
    private String cnpj;
    private Integer quantidade;
    private Double valor;

    
}
