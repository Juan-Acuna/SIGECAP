package maryjaneslastdance.sigecap.service;

import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import maryjaneslastdance.sigecap.model.Sesion;
import maryjaneslastdance.sigecap.model.Usuario;

@Service
public class JWTService {

	private SecretKey APP_SECRET_KEY;
	
	public JWTService() {
		try {
			KeyGenerator kg = KeyGenerator.getInstance("HmacSHA256");
			APP_SECRET_KEY = Keys.hmacShaKeyFor(kg.generateKey().getEncoded());
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
	}
	
	public Sesion generarToken(Usuario usuario, int duracion) {
		Map<String, Object> claims = new HashMap<>();
		claims.put("rol", usuario.getRol().getNombre());
		String token = Jwts.builder()
				.claims()
				.add(claims)
				.subject(usuario.getEmail())
				.issuedAt(new Date(System.currentTimeMillis()))
				.expiration(new Date(System.currentTimeMillis() + 60000 * duracion))
				.and()
				.signWith(APP_SECRET_KEY)
				.compact();
		return new Sesion(usuario, token);
	}
	
	public Sesion generarToken(Usuario usuario) {
		return generarToken(usuario, 30);
	}
	public String extractUserName(String token) {
        return extractClaim(token, Claims::getSubject);
    }

    private <T> T extractClaim(String token, Function<Claims, T> claimResolver) {
        final Claims claims = extractAllClaims(token);
        return claimResolver.apply(claims);
    }

    private Claims extractAllClaims(String token) {
        return Jwts.parser()
                .verifyWith(APP_SECRET_KEY)
                .build()
                .parseSignedClaims(token)
                .getPayload();
    }

    public boolean validarToken(String token, UserDetails userDetails) {
        final String userName = extractUserName(token);
        return (userName.equals(userDetails.getUsername()) && !isTokenExpired(token));
    }

    private boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }

    private Date extractExpiration(String token) {
        return extractClaim(token, Claims::getExpiration);
    }
}
