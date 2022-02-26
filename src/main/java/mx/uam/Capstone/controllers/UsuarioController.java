package mx.uam.Capstone.controllers;


import mx.uam.Capstone.models.Usuario;
import mx.uam.Capstone.models.UsuarioRepository;
import mx.uam.Capstone.models.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

import java.util.ArrayList;
import java.util.List;

//@RequestMapping("/appWEB/")
@RestController
public class UsuarioController {

    @Autowired private UsuarioService usuarioService;

    // Create o Save operation
    @PostMapping("/aber")
    public Usuario saveUsuario(@Valid @RequestBody Usuario usuario) {
        usuario.setNombreUsuario("Probando guardar esto en la BD");
        return usuarioService.saveUsuario(usuario);
    }

    // Read operation
    @GetMapping("/aber1")
    public List<Usuario> fetchUsuarioList()
    {
        return usuarioService.fetchUsuarioList();
    }

/*
    @GetMapping("/departments")
    public List <Usuario> leert()  {
        return usuarioRepository.findAll();
    }*/

    //Consultar los usuarios de la lista con CRUD https://www.bezkoder.com/spring-boot-jpa-crud-rest-api/
    @GetMapping("/usuarios")
    public ResponseEntity <List<Usuario>> getAllUsuarios() {
        List<Usuario> usuarios = new ArrayList<Usuario>();
        usuarios.add(new Usuario("Solovino"));
        return new ResponseEntity<>(usuarios, HttpStatus.OK);
    }

    @PostMapping("/usuarios1")
    public Usuario  createEmployee(@RequestBody Usuario usuario) {
        return usuarioService.saveUsuario(usuario);
    }

    @RequestMapping(value = "usuario")
    public Usuario getUsuario1() {
        Usuario usuario = new Usuario();
        usuario.setNombreUsuario("amaury");
        usuario.setEmail("amauryy2@gmail.com");
        return usuario;
    }

}
