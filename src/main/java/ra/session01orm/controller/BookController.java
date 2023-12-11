package ra.session01orm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import ra.session01orm.model.Author;
import ra.session01orm.model.Book;
import ra.session01orm.repository.IAuthorRepository;
import ra.session01orm.repository.IBookRepository;

import java.util.*;

@Controller
@RequestMapping("/book")
public class BookController {
    @Autowired
    private IBookRepository bookRepository;
    @Autowired
    private IAuthorRepository authorRepository;
    @RequestMapping("/add")
    public String add(){
               Book book= new Book(null,"dế mèn",null,new ArrayList<>());
        Book book1=      new Book(null,"dế choắt",null,new ArrayList<>());
        Book book2=    new Book(null,"Sóng",null,new ArrayList<>());
        Author author1= new Author(null,"Tô Hoài",null,new ArrayList<>());
        Author author2= new Author(null,"Ngô Tất Tố",null,new ArrayList<>());
      //thm tác giả cho sách 1
        book1.getAuthors().add(author1);
        book1.getAuthors().add(author2);
        // thêm tác giả cho sách 2

        book2.getAuthors().add(author1);
//        thêm mới tác giả
        authorRepository.save(author1);
        authorRepository.save(author2);

        // th mới sách
        bookRepository.save(book1);
        bookRepository.save(book2);

        return "home";
    }
    @RequestMapping("/list")
    public  String list(){
        List<Book> list = bookRepository.findAll();
        List<Author> list1 = authorRepository.findAll();


        return "home";
    }
}
