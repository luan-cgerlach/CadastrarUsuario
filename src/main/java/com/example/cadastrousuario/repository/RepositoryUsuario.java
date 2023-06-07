package com.example.cadastrousuario.repository;

import com.example.cadastrousuario.entity.Usuario;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class RepositoryUsuario {

    List<Usuario> usuarios = new ArrayList<>();
    Usuario u1 = new Usuario(1,"Luan", "luan@gmail.com","luan123");

    public Usuario cadastrarUsuario(Usuario usuario){
        usuarios.add(usuario);
        return usuario;
    }

    public Usuario buscaPorId(int id){
        return usuarios.stream()
                .filter(usuario -> usuario.getId()==id)
                .findFirst().get();
    }

    public Usuario deletarUsuario(Usuario usuario){
        usuarios.remove(usuario);
        return usuario;
    }

    public List<Usuario> listaDeUsuarios(){
        return usuarios;
    }
}
