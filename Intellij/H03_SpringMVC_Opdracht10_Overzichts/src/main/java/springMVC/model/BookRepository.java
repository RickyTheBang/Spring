package springMVC.model;

import java.util.*;

public interface BookRepository {
   public abstract List<Book> getBooks();
   public abstract Book getBook(String isbn);
}