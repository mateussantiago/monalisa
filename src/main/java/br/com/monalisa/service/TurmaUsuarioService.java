package br.com.monalisa.service;

import br.com.monalisa.model.Turma;
import br.com.monalisa.model.TurmaUsuario;
import br.com.monalisa.model.Usuario;
import br.com.monalisa.repository.TurmaUsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Service
public class TurmaUsuarioService {

    @Autowired
    private TurmaUsuarioRepository turmaUsuarioRepository;

    public TurmaUsuario save(TurmaUsuario turmaUsuario) {
        turmaUsuario.setDataInicio(new Date());
        turmaUsuario.setAtivo(true);

        return turmaUsuarioRepository.save(turmaUsuario);
    }


    public List<TurmaUsuario> findAll() {
        return turmaUsuarioRepository.findAll();
    }

    public Optional<TurmaUsuario> findOne(Long id) {
        return turmaUsuarioRepository.findById(id);
    }

    public TurmaUsuario followTurma(Usuario usuario, Turma turma){
        TurmaUsuario turmaUsuario = new TurmaUsuario();

        turmaUsuario.setUsuario(usuario);
        turmaUsuario.setTurma(turma);

        return save(turmaUsuario);
    }

    public TurmaUsuario unfollowTurma(Usuario usuario, Turma turma){
        boolean achouTurma = false;

        TurmaUsuario turmaUsuario = new TurmaUsuario();
        for (Iterator<TurmaUsuario> it = usuario.getTurmas().iterator(); it.hasNext(); ) {
            turmaUsuario = it.next();
            if (turmaUsuario.getTurma().getIdTurma().equals(turma.getIdTurma())) {
                if(turmaUsuario.isAtivo()){
                    turmaUsuario.setAtivo(false);
                    achouTurma = true;
                    break;
                } else{
                    throw new RuntimeException("Usuário já está desvinculado da turma");
                }
            }
        }

        if(!achouTurma){
            throw new RuntimeException("Usuário não está cadastrado nessa turma");
        }

        return save(turmaUsuario);
    }
}
