package maryjaneslastdance.sigecap.repo;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import maryjaneslastdance.sigecap.model.Rol;

@DataJpaTest
@Transactional
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class RolRepositoryTest {

	@Autowired
	RolRepository repo;
	
	@Test
	@Rollback
	void testSave() {
		Rol r = new Rol("ROL_DE_PRUEBA");
		r.setId(0);
		Rol recibido = repo.save(r);
		assertThat(recibido.getId()).isGreaterThan(0);
	}

	@Test
	@Rollback
	void testFindById() {
		Rol recibido = repo.findById(1).orElse(null); //ID 1 = Administrador
		assertNotNull(recibido);
	}

	@Test
	@Rollback
	void testFindAll() {
		List<Rol> roles = (List<Rol>) repo.findAll();
		assertThat(roles.size()).isEqualTo(3);
	}

	@Test
	@Rollback
	void testDelete() {
		Rol recibido = repo.findById(1).orElse(null); //ID 1 = Administrador
		if(recibido==null)
			fail("No existen datos en la base de datos.");
		repo.deleteById(1);
		recibido = repo.findById(1).orElse(null);
		assertNull(recibido);
	}

}
