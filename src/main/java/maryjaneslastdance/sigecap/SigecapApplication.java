package maryjaneslastdance.sigecap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.crypto.KeyGenerator;
import java.security.NoSuchAlgorithmException;

@SpringBootApplication
public class SigecapApplication {

	public static void main(String[] args) throws NoSuchAlgorithmException {
		SpringApplication.run(SigecapApplication.class, args);
	}
}
