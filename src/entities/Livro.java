package entities;

public class Livro {
	private String nomeLivro, autor; 
	private StringBuffer conteudo;
	private int anoPublicacao, qtePalavras;
	
	public Livro() {
		
	}

	public Livro(String nomeLivro, String autor, StringBuffer conteudo, int anoPublicacao, int qtePalavras) {
		super();
		this.nomeLivro = nomeLivro;
		this.autor = autor;
		this.conteudo = conteudo;
		this.anoPublicacao = anoPublicacao;
		this.qtePalavras = qtePalavras;
	}

	@Override
	public String toString() {
		return "Livro [nomeLivro=" + nomeLivro + ", autor=" + autor + ", anoPublicacao=" + anoPublicacao
				+ ", qtePalavras=" + qtePalavras + "]";
	}
}
