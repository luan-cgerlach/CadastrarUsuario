package com.example.cadastrousuario.controller;

import com.example.cadastrousuario.entity.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.cadastrousuario.service.ServiceUsuario;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class ControllerCadastroUsuario {

    @Autowired
    ServiceUsuario serviceUsuario;

    @PostMapping("/cadastrar")
    public Usuario cadastrarUsuario(@RequestBody Usuario usuario){
        return serviceUsuario.cadastrarUsuario(usuario);
    }

    @GetMapping ("/usuario/{id}")
    public Usuario buscaPorId(@PathVariable int id){
        return serviceUsuario.buscaPorId(id);
    }

    @GetMapping ("usuarios")
    public List<Usuario> listaDeUsuarios(){
        return serviceUsuario.listaDeUsuarios();
    }

    @PutMapping("atualizar/{id}")
    public Usuario atualizarUsuario(@PathVariable int id, @RequestBody Usuario usuarioAtualizado){
        return serviceUsuario.atualizarUsuario(id, usuarioAtualizado);
    }

}
