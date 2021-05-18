package app;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Livro;

public class Application {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		Locale.setDefault(Locale.US);
		
		//creation of arrays - one for the books, another to store the inital data of each book
		List<Livro> biblioteca = new ArrayList<Livro>();
		List<String> dataBook = new ArrayList<String>();
		
		//working with files
		File directoryPath = new File("C:\\Users\\Pichau\\Documents\\UTF\\Estrutura de dados\\Trabalho FinalED\\biblioteca");
		File filesList[] = directoryPath.listFiles();
		
		for (File file : filesList) {

			sc = new Scanner(file);
			String input;
			StringBuffer sb = new StringBuffer();
			String p = "";
			
			//attributing the first line of each file into a string
			String f = sc.nextLine();
			for (int i = 0; i < f.length(); i++) {
				//verifies if the character is a letter, digit or white space
				while(Character.isLetter(f.charAt(i)) || Character.isWhitespace(f.charAt(i)) || Character.isDigit(f.charAt(i))) {
					 p += f.charAt(i); //if it is, creates a string 
					 i++;
					 
					 //break the code to avoid execeptions
					 if(i == f.length()) {
						 break;
					 } 
				}
				dataBook.add(p); //add the word made into a list of data
				p=""; //restart the string
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
			String word = sc.next();
			count++;
		}

		sc.close();

		return count;
	}
	
	//method to add the content of a book into a StringBuffer
	public static StringBuffer content(File file) throws FileNotFoundException {
		Scanner sc = new Scanner(System.in);
		StringBuffer sb = new StringBuffer();
		String input;
		
		sc = new Scanner(file);
		
		while (sc.hasNextLine()) { 
			 input = sc.nextLine();
			 sb.append(input+" ");  
		}
		
		return sb;
	}

}
