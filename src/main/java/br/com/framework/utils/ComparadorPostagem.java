package br.com.framework.utils;

import br.com.framework.model.Postagem;
import org.springframework.stereotype.Component;

import java.util.Comparator;

@Component
public interface ComparadorPostagem extends Comparator<Postagem> {
}
