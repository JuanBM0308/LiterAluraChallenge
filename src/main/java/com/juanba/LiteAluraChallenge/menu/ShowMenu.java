package com.juanba.LiteAluraChallenge.menu;

import com.juanba.LiteAluraChallenge.entity.Book;
import com.juanba.LiteAluraChallenge.entity.Person;
import com.juanba.LiteAluraChallenge.fetch.FetchApiGutendex;
import com.juanba.LiteAluraChallenge.repository.BookRepository;
import com.juanba.LiteAluraChallenge.repository.PersonRepository;
import com.juanba.LiteAluraChallenge.service.ConvertData;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ShowMenu {
    private Scanner scanner = new Scanner(System.in);
    private FetchApiGutendex fetchApiGutendex = new FetchApiGutendex();
    private final String API_URL = "https://gutendex.com/books";
    private ConvertData convertData = new ConvertData();
    private List<Book> books = new ArrayList<>();

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private PersonRepository personRepository;

    public void show() {
        var option = -1;
        while (option != 0) {
            var menu = """
                    1 - Buscar libros\s
                    2 - Buscar autores
                    3 - Mostrar libros por idioma
                    4 - Bucar autores a partir de fechas
                    5 - Listar libros en base de datos
                    6 - Listar autores en base de datos
                                 \s
                    0 - Salir
                   \s""";
            System.out.println(menu);
            option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    System.out.println(findBook());
                    break;
                case 2:
                    System.out.println(findAuthor());
                    break;
                case 3:
                    System.out.println(findByLanguage());
                    break;
                case 4:
                    System.out.println(findAuthorByYear());
                    break;
                case 5:
                    System.out.println(getBooks());
                    break;
                case 6:
                    System.out.println(getPeople());
                    break;

                case 0:
                    System.out.println("Cerrando la aplicación...");
                    break;
                default:
                    System.out.println("Opción inválida");
            }
        }

    }

    private Book findBook() {
        System.out.println("Digite el nombre del libro a buscar:");
        var findBook = scanner.nextLine();

        var json = fetchApiGutendex.fetchData(API_URL + "?search=" + findBook.replace(" ", "%20"));
        System.out.println(json);

        Book book = convertData.getData(json, Book.class);

        bookRepository.save(book);
        personRepository.save(book.authors());
        return book;
    }

    private Person findAuthor() {
        System.out.println("Digite el autor a buscar:");
        var authorName = scanner.nextLine();

        return personRepository.findByName(authorName);
    }

    private List<Book> findByLanguage() {
        System.out.println("Digite el idioma a buscar:");
        var language = scanner.nextLine();

        List<Book> bookList = bookRepository.findAll().stream()
                .filter(book -> book.languages().contains(language))
                .collect(Collectors.toList());

        return bookList;
    }

    private List<Person> findAuthorByYear() {
        System.out.println("Digite el año de inicio:");
        var startYear = scanner.nextLong();

        System.out.println("Digite el año de fin:");
        var endYear = scanner.nextLong();

        return personRepository.findAuthorsLivedWithinYearRange(startYear, endYear);
    }

    private List<Book> getBooks() {
        return bookRepository.findAll();
    }

    private List<Person> getPeople() {
        return personRepository.findAll();
    }
}
