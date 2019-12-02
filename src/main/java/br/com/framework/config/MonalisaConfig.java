package br.com.framework.config;

import br.com.framework.utils.BuscadorConteudo;
import br.com.framework.utils.ComparadorPostagem;
import br.com.framework.utils.Punicao;
import br.com.monalisa.utils.BuscadorMonalisa;
import br.com.monalisa.utils.ComparadorPostagemMonalisa;
import br.com.monalisa.utils.PunicaoMonalisa;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MonalisaConfig {
    @Bean
    public BuscadorConteudo buscadorConteudo(){
        return new BuscadorMonalisa();
    }

    @Bean
    public ComparadorPostagem comparadorPostagem(){
        return new ComparadorPostagemMonalisa();
    }

    @Bean
    public Punicao punicao(){
        return new PunicaoMonalisa();
    }

}
