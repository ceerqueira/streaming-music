package br.com.streming.Streaming.infra.segurity;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Date;
import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;

import br.com.streming.Streaming.domain.Usuario;

@Service
public class TokenService {



    public String gerarToken(Usuario usuario) {
        try {
            var algoritmo = Algorithm.HMAC256("secreta");
            return JWT.create()
                    .withIssuer("striming_api")
                    .withSubject(usuario.getEmail())
                    .withExpiresAt(Date.from(dataExpiracao()))
                    .sign(algoritmo);
        } catch (JWTCreationException exception) {
            throw new RuntimeException("erro ao gerrar token jwt", exception);
        }
    }

    public String getSubject(String tokenJWT) {

        try {
            var algoritmo = Algorithm.HMAC256("secreta");
            return JWT.require((Algorithm) algoritmo)
                    .withIssuer("striming_api")
                    .build()
                    .verify(tokenJWT)
                    .getSubject();
        } catch (JWTVerificationException exception) {
            throw new RuntimeException("Token JWT inválido ou expirado!");
        }
    }

    private Instant dataExpiracao() {
        return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-03:00"));
    }
}
