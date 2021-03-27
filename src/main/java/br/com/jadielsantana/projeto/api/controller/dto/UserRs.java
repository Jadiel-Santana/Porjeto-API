package br.com.jadielsantana.projeto.api.controller.dto;

import br.com.jadielsantana.projeto.api.model.User;

public class UserRs {
    private Long id;
    private String nome;
    private String senha;

    public static UserRs converter(User u) {
        var user = new UserRs();
        user.setId(u.getId());
        user.setNome(u.getNome());
        user.setSenha(u.getSenha());
        return user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}