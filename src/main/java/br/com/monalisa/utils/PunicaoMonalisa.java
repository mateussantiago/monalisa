package br.com.monalisa.utils;

import br.com.framework.model.Denuncia;
import br.com.framework.model.Postagem;
import br.com.framework.repository.DenunciaRepository;
import br.com.framework.utils.Punicao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PunicaoMonalisa implements Punicao {
    @Autowired
    private DenunciaRepository denunciaRepository;

    @Override
    public void punir(Postagem postagem) {
        punirForaConteudo( postagem );
        punirConteudoImproprio( postagem );
    }

    private void punirForaConteudo(Postagem postagem){
        List<Denuncia> denunciasForaConteudo = denunciaRepository.buscarDenunciasPorTipo(postagem.getIdPostagem(),
                                                                                    "Postagem fora do conteúdo");

        if (!denunciasForaConteudo.isEmpty()){
            if (denunciasForaConteudo.size() >= 5){
                postagem.setAtivo(false);

                for (Denuncia denuncia : denunciasForaConteudo){
                    denuncia.setProcessada(true);
                }
            }
        }

        denunciaRepository.saveAll( denunciasForaConteudo );
    }

    private void punirConteudoImproprio(Postagem postagem){
        List<Denuncia> denunciasConteudoImproprio = denunciaRepository.buscarDenunciasPorTipo(postagem.getIdPostagem(),
                "Conteúdo impróprio");

        if (!denunciasConteudoImproprio.isEmpty()){
            if (denunciasConteudoImproprio.size() >= 2){
                denunciasConteudoImproprio.get(0).getPostagem().getUsuarioAutor().setAtivo(false);

                for (Denuncia denuncia : denunciasConteudoImproprio){
                    denuncia.setProcessada(true);
                }
            }
        }

        denunciaRepository.saveAll( denunciasConteudoImproprio );
    }
}
