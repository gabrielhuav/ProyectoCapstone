package mx.uam.Capstone.controllers;


import mx.uam.Capstone.models.Usuario;
import mx.uam.Capstone.models.UsuarioRepository;
import mx.uam.Capstone.models.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//@RequestMapping("/appWEB/")
@Controller
public class UsuarioController {

    @Autowired private UsuarioService usuarioService;

    @RequestMapping(value = "/getAll", method = RequestMethod.GET, headers = "Accept=application/json")
    public String getPerson(Model model) {
        List<Usuario> listOfPersons = usuarioService.fetchUsuarioList();
        model.addAttribute("person", new Usuario());
        model.addAttribute("listOfPersons", listOfPersons);
        return "PersonDetails";
    }


    @PostMapping()
    public Usuario saveUsuario(@Valid @RequestBody Usuario usuario) {
        usuario.setNombreUsuario("Probando guardar esto en la BD");
        BDController bd = new BDController();
        Usuario usuario1 = new Usuario("amaury1111");
        bd.registraUsuario(usuario1);

        return usuarioService.saveUsuario(usuario1);
    }

    // Read operation
    @GetMapping("/aber")
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
