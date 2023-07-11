package br.com.streming.Streaming.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import br.com.streming.Streaming.domain.Usuario;
@Repository
public interface UsuarioRepository extends JpaRepository<Usuario,Long> {

    @Query("SELECT u FROM Usuario u WHERE u.email = :email")
    UserDetails encontrarPorEmail( String email);
    
    boolean existsByEmail(String email);
}
