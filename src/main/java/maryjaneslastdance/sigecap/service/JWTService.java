package maryjaneslastdance.sigecap.service;

import java.nio.charset.StandardCharsets;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import maryjaneslastdance.sigecap.model.Usuario;

@Service
public class JWTService {

	private final SecretKey APP_SECRET_KEY;
	
	public final int HORAS_DURACION_JWT = 3;
	
	public JWTService(@Value("${APP_SECRET}") String secretKey) {
        APP_SECRET_KEY = Keys.hmacShaKeyFor(secretKey.getBytes(StandardCharsets.UTF_8));
    }
	public String generarToken(Usuario usuario, int duracion) {
		Map<String, Object> claims = new HashMap<>();
		return Jwts.builder()
				.claims()
				.add(claims)
				.subject(usuario.getEmail())
				.issuedAt(new Date(System.currentTimeMillis()))
				.expiration(new Date(System.currentTimeMillis() + 3600000 + HORAS_DURACION_JWT))
				.and()
				.signWith(APP_SECRET_KEY)
				.compact();
	}
	
	public String generarToken(Usuario usuario) {
		return generarToken(usuario, 3);
	}
	public String extractUserName(String token) {
		try{
			return extractClaim(token, Claims::getSubject);
		}catch (Exception e){
			return null;
		}
    }

    private <T> T extractClaim(String token, Function<Claims, T> claimResolver) {
		try{
			final Claims claims = extractAllClaims(token);
			return claimResolver.apply(claims);
		} catch (Exception e) {
			return null;
		}
    }

    private Claims extractAllClaims(String token) {
		try{
			var parser = Jwts.parser()
					.verifyWith(APP_SECRET_KEY)
					.build();
			return parser.parseSignedClaims(token).getPayload();
		} catch (Exception e) {
			return null;
		}
    }

    public boolean validarToken(String token, UserDetails userDetails) {
    	boolean v = false;
        try {
        	final String userName = extractUserName(token);
            v = (userName.equals(userDetails.getUsername()) && !isTokenExpired(token));
        }catch(Exception e) {
        	v = false;
        }
        return v;
    }

    private boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }

    private Date extractExpiration(String token) {
        return extractClaim(token, Claims::getExpiration);
    }
}
