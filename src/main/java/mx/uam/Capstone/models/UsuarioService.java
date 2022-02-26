package mx.uam.Capstone.models;

import java.util.List;

//Operaciones CRUD

public interface UsuarioService {

    // Create (o Save) operation
    Usuario saveUsuario(Usuario usuario);

    // Read operation
    List<Usuario> fetchUsuarioList();

    // Update operation
    Usuario updateUsuario(Usuario usuario, Long UsuarioId);

    // Delete operation
    void borrarUsuarioPorId(Integer UsuarioId);


}
