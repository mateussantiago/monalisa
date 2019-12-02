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
        analisarPunicaoParaAplicar(postagem);
    }

    public void analisarPunicaoParaAplicar(Postagem postagem){
        List<Denuncia> denunciasConteudoImproprio = denunciaRepository.buscarDenunciasPorTipo(postagem.getIdPostagem(),
                                                                                        "Conteúdo impróprio");

        List<Denuncia> denunciasForaConteudo = denunciaRepository.buscarDenunciasPorTipo(postagem.getIdPostagem(),
                                                                                    "Postagem fora do conteúdo");

        if (!denunciasConteudoImproprio.isEmpty()){
            if (denunciasConteudoImproprio.size() >= 2){
                denunciasConteudoImproprio.get(0).getPostagem().getUsuarioAutor().setAtivo(false);

                for (Denuncia denuncia : denunciasConteudoImproprio){
                    denuncia.setProcessada(true);
                }
            }
        }

        if (!denunciasForaConteudo.isEmpty()){
            if (denunciasForaConteudo.size() >= 5){
                denunciasConteudoImproprio.get(0).getPostagem().setAtivo(false);
            }

            for (Denuncia denuncia : denunciasForaConteudo){
                denuncia.setProcessada(true);
            }
        }

        List<Denuncia> todasDenuncias = new ArrayList<>(denunciasConteudoImproprio);
        todasDenuncias.addAll(denunciasForaConteudo);

        denunciaRepository.saveAll(todasDenuncias);
    }
}
