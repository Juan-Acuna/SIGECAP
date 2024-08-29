package maryjaneslastdance.sigecap.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.transaction.annotation.Transactional;

import maryjaneslastdance.sigecap.model.Sesion;
import maryjaneslastdance.sigecap.model.Usuario;
import maryjaneslastdance.sigecap.model.UsuarioDetails;

@DataJpaTest
@Transactional
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class UsuarioServiceTest {
	
	@Autowired
	UsuarioService service;

	@Test
	void testVerificarUsuario() {
		Usuario u = new Usuario();
		u.setEmail("francisco@fake.com");
		u.setPwd("francisco123");
		Sesion s = service.verificarUsuario(u);
		assertNotNull(s);
	}

	@Test
	void testListarUsuarios() {
		List<Usuario> usuarios = service.listarUsuarios();
		assertEquals(7,usuarios.size(), "Deben haber 7 usuarios registrados");
	}

	@Test
	void testGetUsuario() {
		Usuario u = service.getUsuario("francisco@fake.com");
		assertNotNull(u);
	}

	@Test
	void testGetPerfilUsuario() {
		Usuario u = new Usuario();
		u.setEmail("francisco@fake.com");
		UsuarioDetails d = new UsuarioDetails(u);
		Usuario recibido = service.getPerfilUsuario(d);
		assertNotNull(recibido);
	}
}
