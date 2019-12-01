package springMVC.controller;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.ui.*;
import org.springframework.web.bind.annotation.*;

import springMVC.model.*;

@Controller
@RequestMapping("/books")
public class BookController {
   @Autowired
   private BookRepository service;

   @RequestMapping("list")
   public String bookList(ModelMap model) {      
      model.addAttribute("booklist",service.getBooks());
      return "booklist";
   }

   @RequestMapping("detail")
   public String bookDetail(@RequestParam("isbn") String isbn,
         ModelMap model) {
      model.addAttribute("book",service.getBook(isbn));
      return "bookdetail";
   }
}
