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
import java.util.Map.Entry;
import java.util.NavigableMap;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

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
		
		
		/*
		for(Livro l : biblioteca) {
			System.out.println(l);
			System.out.println("-----------------------------------------------------");
		}
		
		
		
		for(Livro l : biblioteca){
			System.out.println("Nome do livro: "+l.getNomeLivro()+"\n Quantidade de palavras: "+l.getQtePalavras()+" | Quantidade de palavras distintas: "+distintos(l));
			System.out.println("-----------------------------------------------");
		}
		
		
		
		System.out.println("Total de palavras distintas da biblioteca: "+distintosBiblioteca(biblioteca));
		
		
		String palavra = "anyone"
		for(Livro l : biblioteca){
		System.out.println("A palavra "+palavra+" apareceu "+frequencia(biblioteca, "anyone")+" vezes no livro "+l.getNomeLivro());
		}
		
		;
		
		
		String palavra = "anyone";
			for(Livro l : biblioteca){
			System.out.println("A palavra "+palavra+" apareceu "+frequencia(l, "anyone")+" vezes no livro "+l.getNomeLivro());	
			System.out.println("A palavra "+palavra+" apareceu "+frequenciaBiblioteca(biblioteca, palavra)+" vezes em toda a biblioteca");	
		}
		*/
		
		for(Livro l : biblioteca) {
			System.out.print("Palavra mais frequente no livro "+l.getNomeLivro()+" :");
			maisFrequente(l);
		}
		
		
		
		
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
			sc.next();
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
	
	public static int distintos(Livro l) {
			Set<String> distintos = new HashSet<String>(l.getConteudo());
			return distintos.size();
	}
	
	public static int distintosBiblioteca(List<Livro> biblioteca) {
		List<String> conteudo = new ArrayList<String>();
		
		for(Livro l : biblioteca) {
			conteudo.addAll(l.getConteudo());
		}
		Set<String> distintos = new HashSet<String>(conteudo);
		
		return distintos.size();
	}
	
	public static Integer frequencia(Livro l, String palavra) {
		Integer freq = 0;
		
			Map<String, Integer> frequencia = new HashMap<String, Integer>();
			for(String s : l.getConteudo()) {
				Integer count = frequencia.get(s);
				
				if(count == null) {
					frequencia.put(s, 1);
				}else {
					frequencia.put(s, count + 1);
				}
			}
			
			freq = frequencia.get(palavra);
		
		return freq;
		
	} 
	
	public static Integer frequenciaBiblioteca(List<Livro> biblioteca, String palavra) {
		Integer countBiblio = 0;
		
			Map<String, Integer> frequencia = new HashMap<String, Integer>();
			
			for(Livro l : biblioteca) {
				for(String s : l.getConteudo()) {
					Integer count = frequencia.get(s);
					
					if(count == null) {
						frequencia.put(s, 1);
					}else {
						frequencia.put(s, count + 1);
					}
				}
				countBiblio += frequencia.get(palavra);
			}
			
		
		return countBiblio;
		
	} 
	

	
	public static void maisFrequente(Livro livro) {
		Map<String, Integer> distintos = new HashMap<String, Integer>();
		
		
			for(String palavra : livro.getConteudo()) {
				Integer count = distintos.get(palavra);
				
				if(count == null) {
					distintos.put(palavra, 1);
				}else {
					distintos.put(palavra, count + 1);
				}
			}	
		
		
		NavigableMap<Integer, Set<String>> contadorInvertido = new TreeMap<Integer, Set<String>>();

		
		Set<String> distintosII;
		
		for (Entry<String, Integer> entry : distintos.entrySet()) {
			if(!contadorInvertido.containsKey(entry.getValue())) {
				contadorInvertido.put(entry.getValue(), null);
			}
			
			if(contadorInvertido.get(entry.getValue()) == null) {
				distintosII = new HashSet<String>();
				distintosII.add(entry.getKey());
				contadorInvertido.put(entry.getValue(), distintosII);
			}else {
				contadorInvertido.get(entry.getValue()).add(entry.getKey());
			}
			
			
			
		}
		System.out.print(contadorInvertido.lastEntry()+"\n");
		
	}
}
