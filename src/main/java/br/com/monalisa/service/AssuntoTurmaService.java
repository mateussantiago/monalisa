package br.com.monalisa.service;

import br.com.monalisa.dto.SugestaoAssuntoDTO;
import br.com.monalisa.model.Assunto;
import br.com.monalisa.model.AssuntoTurma;
import br.com.monalisa.model.Turma;
import br.com.monalisa.model.Usuario;
import br.com.monalisa.repository.AssuntoTurmaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AssuntoTurmaService {
    @Autowired
    private AssuntoTurmaRepository assuntoTurmaRepository;

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private AssuntoService assuntoService;

    @Autowired
    private AssuntoTurmaService assuntoTurmaService;

    @Autowired
    private TurmaService turmaService;

    public List<AssuntoTurma> buscarTodos() {
        return assuntoTurmaRepository.buscarTodos();
    }

    public AssuntoTurma buscarPorId(Long id) {
        return assuntoTurmaRepository.buscarPorId(id);
    }

    public AssuntoTurma salvar(AssuntoTurma assuntoTurma) {
        return assuntoTurmaRepository.save(assuntoTurma);
    }

    public AssuntoTurma buscarPorIdAssuntoEIdTurma(Long assunto, Long turma){
        return assuntoTurmaRepository.buscarPorAssuntoETurma(assunto, turma);
    }

    public List<AssuntoTurma> buscarPorIdTurma(Long idTurma) {
        return assuntoTurmaRepository.buscarPorIdTurma(idTurma);
    }

    public List<AssuntoTurma> buscaPorIdUsuario(Long idUsuario) {
        return assuntoTurmaRepository.buscaPorIdUsuario(idUsuario);
    }
    public AssuntoTurma sugerirAssunto(SugestaoAssuntoDTO sugestaoAssuntoDTO, Long idUsuario){

        Usuario usuario = usuarioService.buscarPorId(idUsuario);

        if (usuario == null){
            throw new RuntimeException("Não existe usuário ativo nessa sessão");
        }

        String nome_assunto = sugestaoAssuntoDTO.getNome_assunto();
        String descricao_assunto = sugestaoAssuntoDTO.getDescricao_assunto();
        String justificativa_sugestao = sugestaoAssuntoDTO.getJustificativa_sugestao();
        Long idTurma = sugestaoAssuntoDTO.getIdTurma();

        Turma turma = turmaService.buscarPorId(idTurma);
        if (turma == null){
            throw new RuntimeException("Não existe turma com o ID passado");
        }

        Assunto assunto = assuntoService.buscarAssuntoPorNomeExato(nome_assunto);

        // assunto nao foi cirado ainda
        if(assunto == null){
            assunto = new Assunto();
            assunto.setAtivo(false);
            assunto.setDescricao(descricao_assunto);
            assunto.setNome(nome_assunto);

            assunto = assuntoService.salvar(assunto);
        }

        AssuntoTurma assuntoTurma = assuntoTurmaService.buscarPorIdAssuntoEIdTurma(assunto.getIdAssunto(), idTurma);

        // vinculo nao foi criado ainda
        if(assuntoTurma == null){
            assuntoTurma = new AssuntoTurma();
            assuntoTurma.setAssunto(assunto);
            assuntoTurma.setAtivo(false);
            assuntoTurma.setTurma(turma);
        }

        return assuntoTurmaService.salvar(assuntoTurma);

    }


}
