package app;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import entities.Livro;

public class Application {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		Locale.setDefault(Locale.US);
		StringBuilder sb = new StringBuilder();
	
		//creation of arrays - one for the books, another to store the inital data of each book
		List<Livro> biblioteca = new ArrayList<Livro>();
		List<String> dataBook = new ArrayList<String>();
	
		//working with files
		File directoryPath = new File("C:\\Users\\Pichau\\Documents\\UTF\\Estrutura de dados\\Trabalho FinalED\\livros");
		File filesList[] = directoryPath.listFiles();
		
		for (File file : filesList) {
			sc = new Scanner(file);
			
			//attributing the first line of each file into a string
			String f = sc.nextLine();
			for (int i = 0; i < f.length(); i++) {
				//verifies if the character is a letter, digit or white space
				while(Character.isLetter(f.charAt(i)) || Character.isWhitespace(f.charAt(i)) || Character.isDigit(f.charAt(i))) {
					 sb.append(f.charAt(i)); //if it is, creates a string 
					 i++;
					 
					 //break the code to avoid exceptions
					 if(i == f.length()) {
						 break;
					 } 
				}
				dataBook.add(sb.toString()); //add the word made into a list of data
				sb.delete(0, sb.length()); //restart the string
			}
			
			//creates 3 variables, the first ones to add in the book object
			String nameBook = dataBook.get(0);
			String authorBook = dataBook.get(1);
			int releaseDate = Integer.parseInt(dataBook.get(2));
			
			//create a new book object, and add it to a list
			biblioteca.add(new Livro(nameBook, authorBook, content(file), releaseDate, countWords(file)));
			
			//clear the list of data for the next string
			dataBook.clear();
		}
		
		for(Livro l : biblioteca) {
			System.out.println(l);
			System.out.println("-----------------------------------------------------");
		}
		
		/*
		distintos(biblioteca);
		
		
		distintosBiblioteca(biblioteca);
		
		frequencia(biblioteca, "anyone");
		*/
		
		sc.close();
	}
	
	//method to count the words of each file
	public static int countWords(File file) throws FileNotFoundException {
		Scanner sc = new Scanner(System.in);
		int count = 0;

		sc = new Scanner(file);

		while (sc.hasNextLine()) {
			if(sc.hasNext() == false) {
				break;
			}
			String word = sc.next();
			count++;
		}

		sc.close();

		return count;
	}
	
	//method to add the content of a book into a StringBuffer
	public static List<String> content(File file) throws FileNotFoundException {
		Scanner sc = new Scanner(System.in);
		String input;
		List<String> conteudo = new ArrayList<String>();
		
		sc = new Scanner(file);
		
		while (sc.hasNextLine()) { 
			if(sc.hasNext() == false) {
				break;
			}
			 input = sc.next();
			 conteudo.add(input);  
		}
		
		return conteudo;
	}
	
	public static void distintos(List<Livro> biblioteca) {
		for(Livro l : biblioteca) {
			Set<String> distintos = new HashSet<String>(l.getConteudo());
			System.out.println("Nome do livro: "+l.getNomeLivro()+"\n Quantidade de palavras: "+l.getQtePalavras()+" | Quantidade de palavras distintas: "+distintos.size());
			System.out.println("-----------------------------------------------");
		}
	}
	
	public static void distintosBiblioteca(List<Livro> biblioteca) {
		List<String> conteudo = new ArrayList<String>();
		
		for(Livro l : biblioteca) {
			conteudo.addAll(l.getConteudo());
		}
		Set<String> distintos = new HashSet<String>(conteudo);
		System.out.println("Total de palavras distintas da biblioteca: "+distintos.size());
	}
	
	public static void frequencia(List<Livro> biblioteca, String palavra) {
		Integer countBiblio = 0;
		for(Livro l : biblioteca) {
			Map<String, Integer> frequencia = new HashMap<String, Integer>();
			for(String s : l.getConteudo()) {
				Integer count = frequencia.get(s);
				
				if(count == null) {
					frequencia.put(s, 1);
				}else {
					frequencia.put(s, count + 1);
				}
			}
			countBiblio+=frequencia.get(palavra);
			
			System.out.println("A palavra "+palavra+" apareceu "+frequencia.get(palavra)+" vezes no livro "+l.getNomeLivro());
			System.out.println("-------------------------------------");
		}
		
		System.out.println("A palavra "+palavra+" apareceu "+countBiblio+" vezes na Biblioteca");
	}
}
