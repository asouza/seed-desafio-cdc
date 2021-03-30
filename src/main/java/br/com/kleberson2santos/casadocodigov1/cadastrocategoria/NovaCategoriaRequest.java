package br.com.kleberson2santos.casadocodigov1.cadastrocategoria;

import javax.validation.constraints.NotBlank;

public class NovaCategoriaRequest {
    @Deprecated
    NovaCategoriaRequest(){}

    @NotBlank
    private String nome;

    public NovaCategoriaRequest(@NotBlank String nome) {
        super();
        this.nome = nome;
    }

    public String getNome() {
        return this.nome;
    }
}
