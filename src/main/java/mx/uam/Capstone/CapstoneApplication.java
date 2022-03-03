package mx.uam.Capstone;

import mx.uam.Capstone.controllers.BDController;
import mx.uam.Capstone.models.Usuario;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.security.NoSuchAlgorithmException;

@SpringBootApplication
public class CapstoneApplication {

	public static void main(String[] args) {
		SpringApplication.run(CapstoneApplication.class, args);
		/*System.out.println("esto es lo primero que voy a hacr");
		BDController bd = new BDController();
		Usuario usuario1 = new Usuario("amaury");
		bd.registraUsuario(usuario1);*/
	}

}
