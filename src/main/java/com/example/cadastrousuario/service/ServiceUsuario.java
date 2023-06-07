package com.example.cadastrousuario.service;

import com.example.cadastrousuario.entity.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.cadastrousuario.repository.RepositoryUsuario;

import java.util.List;

@Service    
public class ServiceUsuario {

    @Autowired
    RepositoryUsuario repositoryUsuario;

    public Usuario cadastrarUsuario(Usuario usuario){
        for (Usuario u : repositoryUsuario.listaDeUsuarios()) {
            if (u.getEmail().equals(usuario.getEmail())) {
                return null;
            }
        }
        return repositoryUsuario.cadastrarUsuario(usuario);
    }

    public Usuario atualizarUsuario(int id, Usuario usuarioAtualizado){
        Usuario usuarioDesatualizado = repositoryUsuario.buscaPorId(id);
        if(usuarioDesatualizado==null){
            return null;
        }else{
            usuarioAtualizado.setId(id);
            repositoryUsuario.deletarUsuario(usuarioDesatualizado);
            repositoryUsuario.cadastrarUsuario(usuarioAtualizado);
            return usuarioAtualizado;
        }
    }

    public Usuario buscaPorId(int id){
        return repositoryUsuario.buscaPorId(id);
    }

    public List<Usuario> listaDeUsuarios(){
        return repositoryUsuario.listaDeUsuarios();
    }
}
