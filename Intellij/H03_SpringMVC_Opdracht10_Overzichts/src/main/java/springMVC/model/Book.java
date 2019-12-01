package springMVC.model;

import java.io.*;

public class Book implements Serializable {
   private String isbn;
   private String title;
   private String author;
   private int price;

   public Book(String isbn, String title, String author, int price) {
      this.isbn = isbn;
      this.title = title;
      this.author = author;
      this.price = price;
   }

   public String getIsbn() {
      return isbn;
   }

   public String getTitle() {
      return title;
   }

   public String getAuthor() {
      return author;
   }

   public int getPrice() {
      return price;
   }

   public String toString() {
      return isbn + " " + title + " " + author + " " + price;
   }
}
