package com.domain;



import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Message" )
public class Message implements Serializable {
   @Id
   @GeneratedValue(strategy=GenerationType.IDENTITY)
   @Column(name = "Id")
   private int id;

   @Column(name = "Content")
   private String content;

   public Message() {
   }

   public Message(String content) {
      this.content = content;
   }

   public int getId() {
      return id;
   }

   public void setId(int id) {
      this.id = id;
   }

   public String getContent() {
      return content;
   }

   public void setContent(String content) {
      this.content = content;
   }

   @Override
   public String toString() {
      final StringBuilder sb = new StringBuilder("Message{");
      sb.append("id=").append(id);
      sb.append(", content='").append(content).append('\'');
      sb.append('}');
      return sb.toString();
   }
}
