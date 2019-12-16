package br.com.monalisa.service;

import br.com.monalisa.dto.DenunciaDTO;
import br.com.monalisa.model.Denuncia;
import br.com.monalisa.model.Postagem;
import br.com.monalisa.model.User;
import br.com.monalisa.repository.DenunciaRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class DenunciaService {
    @Autowired
    private DenunciaRepository denunciaRepository;

    @Autowired
    private UserService userService;

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
        User usuario = userService.findById(idUsuario);

        if (usuario == null){
            throw new RuntimeException("Não existe usuário ativo nessa sessão");
        }

        Postagem postagem = postagemService.buscarPorId(denunciaDTO.getIdPostagem());

        if (postagem == null){
            throw new RuntimeException("Não existe postagem com o ID informado");
        }

        Denuncia denuncia = new Denuncia();
        denuncia.setAtivo(true);
        denuncia.setMotivacao(denunciaDTO.getMotivacao());
        denuncia = salvar(denuncia);

        User usuarioDenunciado = postagem.getUsuarioAutor();
        Long denunciasUsuario = denunciaRepository.contarDenuncias(usuarioDenunciado.getIdUser());

        if(denunciasUsuario > 10){
            usuarioDenunciado.setAtivo(false);
        }

        return denuncia;
    }
}
