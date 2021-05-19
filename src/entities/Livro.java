package entities;

import java.util.List;

public class Livro {
	private String nomeLivro, autor; 
	private List<String> conteudo;
	private int anoPublicacao, qtePalavras;
	
	public Livro() {
		
	}

	public Livro(String nomeLivro, String autor, List<String> conteudo, int anoPublicacao, int qtePalavras) {
		super();
		this.nomeLivro = nomeLivro;
		this.autor = autor;
		this.conteudo = conteudo;
		this.anoPublicacao = anoPublicacao;
		this.qtePalavras = qtePalavras;
	}

	@Override
	public String toString() {
		return "Livro: "+nomeLivro+""
				+ "\n"
				+ "Autor: "+autor+""
						+ " | Ano de lançamento: "+anoPublicacao+""
								+ " | Possui "+qtePalavras+" palavras";
	}

	public List<String> getConteudo() {
		return conteudo;
	}

	public String getNomeLivro() {
		return nomeLivro;
	}

	public String getAutor() {
		return autor;
	}

	public int getAnoPublicacao() {
		return anoPublicacao;
	}

	public int getQtePalavras() {
		return qtePalavras;
	}
}
