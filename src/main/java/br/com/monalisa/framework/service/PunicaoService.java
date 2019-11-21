package br.com.monalisa.framework.service;

import br.com.monalisa.framework.model.Denuncia;
import br.com.monalisa.framework.utils.Punicao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PunicaoService {

    @Autowired
    DenunciaService denunciaService;

    List<Punicao> listaPunicoesDisponiveis;

    public void talvezPunir(Long idPostagem){
        List<Denuncia> denunciasDaPostagem = denunciaService.recuperarDenunciasPorIdPostagem(idPostagem);

        for(Punicao punicao : listaPunicoesDisponiveis){
            punicao.talvezPunir(denunciasDaPostagem);
            // essa passagem é por referencia? as denunciasDaPostagem
            // precisam ser modificadas para processadas caso utilizadas
        }
    }
}
