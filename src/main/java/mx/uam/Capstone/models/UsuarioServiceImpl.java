package mx.uam.Capstone.models;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    // Create o Save operation
    @Override
    public Usuario saveUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    // Read operation
    @Override
    public List<Usuario> fetchUsuarioList() {
        return (List<Usuario>) usuarioRepository.findAll();
    }

    @Override
    public Usuario updateUsuario(Usuario usuario, Long UsuarioId) {
        return null;
    }

    // Delete operation
    @Override
    public void borrarUsuarioPorId(Integer UsuarioId) {
        usuarioRepository.deleteById(UsuarioId);
    }
}
