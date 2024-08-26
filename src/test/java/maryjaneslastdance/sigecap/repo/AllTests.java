package maryjaneslastdance.sigecap.repo;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectClasses({ RolRepositoryTest.class, UsuarioRepositoryTest.class })
public class AllTests {

}
