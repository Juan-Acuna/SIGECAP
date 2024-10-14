package maryjaneslastdance.sigecap.repo;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import maryjaneslastdance.sigecap.model.Usuario;


@DataJpaTest
@Transactional
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class UsuarioRepositoryTest {

	@Autowired
	UsuarioRepository repo;
	
	@Test
	@Rollback
	void testFindByEmail() {
		Usuario u = repo.findByEmail("tadeo@fake.com");
		assertNotNull(u);
	}
	
	@Test
	@Rollback
	void testFindById() {
		Usuario u = repo.findById(1).orElse(null);
		assertNotNull(u);
	}

	@Test
	@Rollback
	void testDeleteById() {
		repo.deleteById(1);
		Usuario u = repo.findById(1).orElse(null);
		assertNull(u);
	}

}
