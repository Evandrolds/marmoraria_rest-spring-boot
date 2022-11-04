
package com.evandro.marmoraria.entities;

import jakarta.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.*;
import lombok.*;

/**
 *
 * @author Evandro
 */
@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tbl_Cliente")
public class Cliente implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String cliente;
    private String cpf;
    private String telefone;
    private String email;
    private LocalDate nascimento;
    
    
    @OneToMany(mappedBy = "cliente")
    private List<Pedido> predidos = new ArrayList<>();

    public void setNome(String cliente) {
        this.cliente = cliente;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Cliente other = (Cliente) obj;
        return Objects.equals(this.id, other.id);
    }
    
}
