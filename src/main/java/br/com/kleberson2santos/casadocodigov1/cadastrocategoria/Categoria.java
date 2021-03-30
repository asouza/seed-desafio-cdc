package br.com.kleberson2santos.casadocodigov1.cadastrocategoria;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Entity
public class Categoria {

    @Deprecated
    Categoria(){
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private @NotBlank String nome;

    public Categoria(@NotBlank String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "Categoria{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                '}';
    }
}
