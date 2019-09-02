package br.com.monalisa.config;

import br.com.monalisa.model.Usuario;
import br.com.monalisa.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class AutenticacaoProvider implements AuthenticationProvider {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UsuarioService usuarioService;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String email = authentication.getName();
        String senha = authentication.getCredentials().toString();
        Usuario usuario = usuarioService.findByEmail(email);

        if (usuario != null) {
            Boolean senhaCorreta = passwordEncoder.matches(senha, usuario.getSenha());

            if (senhaCorreta) {
                return new UsernamePasswordAuthenticationToken(email, usuario.getSenha());
            }
        }

        throw new UsernameNotFoundException("Login e/ou Senha inválidos");
    }

    @Override
    public boolean supports(Class<?> autenticacao) {
        return autenticacao.equals(UsernamePasswordAuthenticationToken.class);
    }
}
