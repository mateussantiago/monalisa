package br.com.framework.service;

import br.com.framework.model.Denuncia;
import br.com.framework.utils.Punicao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PunicaoService {

    @Autowired
    protected   DenunciaService denunciaService;

    protected List<Punicao> listaPunicoesDisponiveis;

    public void talvezPunir(Long idPostagem){
        List<Denuncia> denunciasDaPostagem = denunciaService.recuperarDenunciasPorIdPostagem(idPostagem);

        for(Punicao punicao : listaPunicoesDisponiveis){
            punicao.talvezPunir(denunciasDaPostagem);
        }
    }
}
