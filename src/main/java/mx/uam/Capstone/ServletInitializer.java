package mx.uam.Capstone;

import mx.uam.Capstone.controllers.BDController;
import mx.uam.Capstone.models.Usuario;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

public class ServletInitializer extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(CapstoneApplication.class);
	}

}
