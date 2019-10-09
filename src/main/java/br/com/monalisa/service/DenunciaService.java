package br.com.monalisa.service;

import br.com.monalisa.dto.DenunciaDTO;
import br.com.monalisa.model.Denuncia;
import br.com.monalisa.model.Postagem;
import br.com.monalisa.model.Usuario;
import br.com.monalisa.repository.DenunciaRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class DenunciaService {
    @Autowired
    private DenunciaRepository denunciaRepository;

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private PostagemService postagemService;

    public List<Denuncia> buscarTodos() {
        return denunciaRepository.buscarTodos();
    }

    public Denuncia buscarPorId(Long id) {
        return denunciaRepository.buscarPorId(id);
    }

    public Denuncia salvar(Denuncia denuncia) {
        return denunciaRepository.save(denuncia);
    }

    public Denuncia denunciarPostagem(Long idUsuario, DenunciaDTO denunciaDTO){
        Usuario usuario = usuarioService.buscarPorId(idUsuario);

        if (usuario == null){
            throw new RuntimeException("Não existe usuário ativo nessa sessão");
        }

        Postagem postagem = postagemService.buscarPorId(denunciaDTO.getIdPostagem());

        if (postagem == null){
            throw new RuntimeException("Não existe postagem com o ID informado");
        }

        Denuncia denuncia = new Denuncia();
        denuncia.setAtivo(true);
        denuncia.setIdPostagem(denunciaDTO.getIdPostagem());
        denuncia.setIdUsuario(idUsuario);
        denuncia.setMotivacao(denunciaDTO.getMotivacao());
        denuncia = salvar(denuncia);

        Usuario usuarioDenunciado = postagem.getUsuarioAutor();
        Long denunciasUsuario = denunciaRepository.contarDenuncias(usuarioDenunciado.getIdUsuario());

        if(denunciasUsuario > 10){
            usuarioDenunciado.setAtivo(false);
        }

        return denuncia;
    }
}
