package br.com.monalisa.controller;

import br.com.monalisa.dto.UsuarioDTO;
import br.com.monalisa.exception.EntidadeNaoEncontradaException;
import br.com.monalisa.exception.NovoUsuarioComEmailExistenteException;
import br.com.monalisa.exception.NovoUsuarioComLoginEmUsoException;
import br.com.monalisa.exception.UsuarioComCampoNaoInformadoException;
import br.com.monalisa.model.User;
import br.com.monalisa.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity registrarUsuario(@RequestBody UsuarioDTO usuarioDTO) {
        try {
            User usuario = userService.registerUser(usuarioDTO);

            return ResponseEntity.status(HttpStatus.CREATED).headers(new HttpHeaders()).body(usuario);

        } catch (UsuarioComCampoNaoInformadoException e) {
            e.printStackTrace();

            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE, e.getMessage(), e.getCause());

        } catch (NovoUsuarioComEmailExistenteException e) {
            e.printStackTrace();

            throw new ResponseStatusException(HttpStatus.BAD_REQUEST    , e.getMessage(), e.getCause());

        } catch (NovoUsuarioComLoginEmUsoException e) {
            e.printStackTrace();

            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage(), e.getCause());
        }
    }

    @RequestMapping(value = "/{idUsuario}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity usuarioPorId(@PathVariable("idUsuario") Long idUsuario) {
        try {
            User usuario = userService.findById(idUsuario);

            return ResponseEntity.status(HttpStatus.OK).headers(new HttpHeaders()).body(usuario);

        } catch (EntidadeNaoEncontradaException e) {
            e.printStackTrace();

            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage(), e.getCause());
        }
    }
}
