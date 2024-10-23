package school.sptech;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Biblioteca {
    private String nome;
    private List<Livro> livros = new ArrayList<Livro>();

    public Biblioteca() {
    }

    public Biblioteca(String nome, List<Livro> livros) {
        this.nome = nome;
        this.livros = livros;
        this.livros = livros;
    }

    public void adicionarLivro(Livro livro) {
        if (livro != null &&
                livro.getTitulo() != null &&
                !livro.getTitulo().isBlank() &&
                livro.getAutor() != null &&
                !livro.getAutor().isBlank() &&
                livro.getDataPublicacao() != null
        ) {
            livros.add(livro);
        }
    }

    public void removerLivroPorTitulo(String titulo) {
        livros.removeIf(livro -> livro.getTitulo().equalsIgnoreCase(titulo));
    }

    public Livro buscarLivroPorTitulo(String titulo) {
        return livros.stream()
                .filter(livro -> livro.getTitulo().equalsIgnoreCase(titulo))
                .findFirst()
                .orElse(null);
    }

    public Integer contarLivros() {
        return this.livros.size();
    }

    public List<Livro> obterLivrosAteAno(Integer ano) {
        return livros.stream()
                .filter(livro -> livro.getDataPublicacao().getYear() <= ano)
                .toList();
    }

    public List<Livro> retornarTopCincoLivros() {
        return livros.stream()
                .sorted(Comparator.comparingDouble(Livro::calcularMediaAvaliacoes).reversed())
                .limit(5)
                .toList();
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "Biblioteca{" +
                "livros=" + livros +
                ", nome='" + nome + '\'' +
                '}';
    }
}
