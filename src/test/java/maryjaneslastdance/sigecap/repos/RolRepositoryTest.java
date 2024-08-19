package maryjaneslastdance.sigecap.repos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import maryjaneslastdance.sigecap.model.Rol;
import maryjaneslastdance.sigecap.repo.RolRepository;

import static org.assertj.core.api.Assertions.assertThat;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;


@ExtendWith(SpringExtension.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class RolRepositoryTest {
	
	@Autowired
	private RolRepository rolRepo;
	
	@Test
	public void crearYBuscarRoles() {
		Rol r1 = new Rol("Admin");
		
		rolRepo.save(r1);
		
		Rol rol = rolRepo.findById(r1.getId()).orElse(null);
		assertThat(rol.getId()).isEqualTo(r1.getId());
	}
}
