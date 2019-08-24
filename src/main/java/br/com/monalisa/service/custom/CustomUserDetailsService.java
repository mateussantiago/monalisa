package br.com.monalisa.service.custom;

import br.com.monalisa.model.Usuario;
import br.com.monalisa.model.UsuarioDetails;
import br.com.monalisa.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Usuario usuario = usuarioRepository.findByLogin(s);

        if (usuario != null) {
            return new UsuarioDetails(usuario);
        }

        throw new UsernameNotFoundException("Usuario não encontrado");
    }
}
