package com.domain;



import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Note" )
public class Message implements Serializable {
   @Id
   @GeneratedValue(strategy=GenerationType.IDENTITY)
   @Column(name = "Id")
   private int id;

   @Column(name = "Message")
   private String message;

   public Message() {
   }

   public Message(String message) {
      this.message = message;
   }

   public int getId() {
      return id;
   }

   public Message setId(int id) {
      this.id = id;
      return this;
   }

   public String getMessage() {
      return message;
   }

   public Message setMessage(String message) {
      this.message = message;
      return this;
   }

   @Override
   public String toString() {
      return "Message{" +
              "id=" + id +
              ", message='" + message + '\'' +
              '}';
   }
}
