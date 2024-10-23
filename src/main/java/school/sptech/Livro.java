package school.sptech;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Livro {
    private String titulo;
    private String autor;
    private LocalDate dataPublicacao;
    private List<Avaliacao> avaliacoes = new ArrayList<Avaliacao>();

    public Livro() {
    }

    public Livro(String titulo, String autor, LocalDate dataPublicacao) {
        this.titulo = titulo;
        this.autor = autor;
        this.dataPublicacao = dataPublicacao;
        this.avaliacoes = avaliacoes;

    }


    public void adicionarAvaliacao(String descricao, Double qtdEstrelas) {
        if (descricao != null && qtdEstrelas != null) {
            if (!descricao.isBlank() && qtdEstrelas >= 0 && qtdEstrelas <= 5) {
                Avaliacao novaAvaliacao = new Avaliacao(descricao, qtdEstrelas);
                avaliacoes.add(novaAvaliacao);
            }
        }
    }


public Double calcularMediaAvaliacoes() {
    Double mediaAvaliacoes = 0.0;

    if (avaliacoes.isEmpty())
        return mediaAvaliacoes;

    for (Avaliacao avaliacao : avaliacoes) {
        mediaAvaliacoes += avaliacao.getQtdEstrelas();
    }

    return mediaAvaliacoes / avaliacoes.size();
}

public String getTitulo() {
    return titulo;
}

public void setTitulo(String titulo) {
    this.titulo = titulo;
}

public String getAutor() {
    return autor;
}

public void setAutor(String autor) {
    this.autor = autor;
}

public LocalDate getDataPublicacao() {
    return dataPublicacao;
}

public void setDataPublicacao(LocalDate dataPublicacao) {
    this.dataPublicacao = dataPublicacao;
}

public List<Avaliacao> getAvaliacoes() {
    return avaliacoes;
}

public void setAvaliacoes(List<Avaliacao> avaliacoes) {
    this.avaliacoes = avaliacoes;
}

@Override
public String toString() {
    return "Livro{" +
            "titulo='" + titulo + '\'' +
            ", autor='" + autor + '\'' +
            ", dataPublicacao=" + dataPublicacao +
            ", avaliacoes=" + avaliacoes +
            '}';
}
}
