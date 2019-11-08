package com.repository;

import com.domain.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.RepositoryDefinition;

import java.util.List;


@RepositoryDefinition(domainClass = Message.class,idClass = Integer.class)
public interface MessageRepository extends JpaRepository<Message,Integer> {

     default Message getMessageById(int id){
        return findById(id).orElse(null);
    }

     default  void updateMessage(Message b){
        save(b);
    }

    default List<Message>   getALLMessages(){ return findAll ();}



}