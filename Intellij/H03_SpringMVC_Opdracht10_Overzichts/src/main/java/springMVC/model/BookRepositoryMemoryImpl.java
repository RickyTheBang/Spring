package springMVC.model;

import java.io.*;
import java.util.*;
import javax.annotation.*;
import org.springframework.stereotype.*;

@Service
public class BookRepositoryMemoryImpl implements Serializable, BookRepository {   
   private Map<String,Book> map = new HashMap<String,Book>();
      
   @PostConstruct
   public void init(){
      Book b1 = new Book("0545139708","Harry Potter and the Deathly Hallows","J.K. Rowling",15);
      map.put(b1.getIsbn(),b1);
      Book b2 = new Book("0385504225","The Lost Symbol","Dan Brown",18);
      map.put(b2.getIsbn(),b2);
      Book b3 = new Book("015603297X","Foucault's Pendulum","Umberto Ecco",12);
      map.put(b3.getIsbn(),b3);      
   }
   
   public List<Book> getBooks() {
      return new ArrayList<Book>(map.values());
   }
   
   public Book getBook(String isbn) {
      return map.get(isbn);
   }   
}
