package br.com.monalisa.config;

import br.com.monalisa.model.Usuario;
import br.com.monalisa.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class AutenticacaoProvider implements AuthenticationProvider {

    @Autowired
    private UsuarioService usuarioService;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String login = authentication.getName();
        String senha = authentication.getCredentials().toString();
        Usuario usuario = usuarioService.findByLoginAndPassword(login, senha);

        if (usuario != null) {
            return new UsernamePasswordAuthenticationToken(login, senha);
        }

        throw new UsernameNotFoundException("Login e/ou Senha inválidos");

    }

    @Override
    public boolean supports(Class<?> autenticacao) {
        return autenticacao.equals(UsernamePasswordAuthenticationToken.class);
    }
}
