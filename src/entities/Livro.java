package entities;

import java.util.List;

public class Livro implements Comparable<Livro> {
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + anoPublicacao;
		result = prime * result + ((autor == null) ? 0 : autor.hashCode());
		result = prime * result + ((conteudo == null) ? 0 : conteudo.hashCode());
		result = prime * result + ((nomeLivro == null) ? 0 : nomeLivro.hashCode());
		result = prime * result + qtePalavras;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Livro other = (Livro) obj;
		if (anoPublicacao != other.anoPublicacao)
			return false;
		if (autor == null) {
			if (other.autor != null)
				return false;
		} else if (!autor.equals(other.autor))
			return false;
		if (conteudo == null) {
			if (other.conteudo != null)
				return false;
		} else if (!conteudo.equals(other.conteudo))
			return false;
		if (nomeLivro == null) {
			if (other.nomeLivro != null)
				return false;
		} else if (!nomeLivro.equals(other.nomeLivro))
			return false;
		if (qtePalavras != other.qtePalavras)
			return false;
		return true;
	}

	@Override
	public int compareTo(Livro o) {
		return qtePalavras;
	}
	
	
}
