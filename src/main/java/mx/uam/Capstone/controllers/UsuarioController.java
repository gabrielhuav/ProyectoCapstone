package mx.uam.Capstone.controllers;


import mx.uam.Capstone.models.Usuario;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UsuarioController {

    @RequestMapping(value = "usuario")
    public Usuario getUsuario() {
        Usuario usuario = new Usuario();
        usuario.setNombreUsuario("amaury");
        usuario.setEmail("amauryy2@gmail.com");
        return usuario;
    }

}
