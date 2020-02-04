/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
 
public class JAXBSerializationExample2 {
	
	private static final String BOOKS_XML_FILE = "books.xml";
 
	public static void main(String[] args) throws JAXBException, IOException {
		
		JAXBContext context = JAXBContext.newInstance(Books.class);
		Marshaller marshaller = context.createMarshaller();
		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		
		// Llenamos los alumnos
		Books alumnes = ompleAlumnes();
		
		// Mostramos el documento XML generado
		System.out.println(" ");
		marshaller.marshal(alumnes, System.out);
		
		FileOutputStream fos = new FileOutputStream(BOOKS_XML_FILE);
		
		// Guardamos el objeto serializado en un documento XML
		marshaller.marshal(alumnes, fos);
		fos.close();
		
		Unmarshaller unmarshaller = context.createUnmarshaller();
		
		// Deserializamos a partir de un documento XML 
		Books alumnesAux = (Books) unmarshaller.unmarshal(new File(BOOKS_XML_FILE));
		System.out.println(" ");
		System.out.println("MOSTRANDO FICHERO XML........................");
		System.out.println(" ");
		
		// Mostramos el objeto java obtenido
		marshaller.marshal(alumnesAux, System.out);
		
	}
	
	private static Books ompleAlumnes() {
		
		Scanner teclado = new Scanner(System.in);
		
		boolean continuar = true;
		int j = 0;
		String[] autorBook = new String[999];
		String[] titleBook = new String[999];
		String[] genreBook = new String[999];
		String[] priceBook = new String[999];
		String[] publishDateBook = new String[999];
		String[] descriptionBook = new String[999];
		
		while (continuar) {
			
			// Pedimos la información del libro
			System.out.println(" ");
			System.out.println("Autor del libro: ");
			String autor = teclado.nextLine();
			System.out.println("Título del libro: ");
			String title = teclado.nextLine();
			System.out.println("Género del libro: ");
			String genre = teclado.nextLine();
			System.out.println("Precio del libro: ");
			String price = teclado.nextLine();
			System.out.println("Fecha de publicación del libro: ");
			String publishDate = teclado.nextLine();
			System.out.println("Descripción del libro: ");
			String description = teclado.nextLine();
			
			autorBook[j] = autor;
			titleBook[j] = title;
			genreBook[j] = genre;
			priceBook[j] = price;
			publishDateBook[j] = publishDate;
			descriptionBook[j] = description;
			
			System.out.println(" ");
			System.out.println("¿Quieres continuar introduciendo libros? (s/n)");
			String masLibro = teclado.nextLine();
			
			j++;
			continuar = (masLibro.equalsIgnoreCase("s")) ? true : false;
		}
		
		Book[] arrayLibros = new Book[j];
		
		for (int i = 0; i < arrayLibros.length; i++) {

			arrayLibros[i] = new Book();

			arrayLibros[i].setAuthor(autorBook[i]);
			arrayLibros[i].setTitle(titleBook[i]);
			arrayLibros[i].setGenre(genreBook[i]);
			arrayLibros[i].setPrice(priceBook[i]);
			arrayLibros[i].setPublishDate(publishDateBook[i]);
			arrayLibros[i].setDescription(descriptionBook[i]);
		}

		Books books = new Books();
		books.setBooks(arrayLibros);
		
		return books;
	}
}