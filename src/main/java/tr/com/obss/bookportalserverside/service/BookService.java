package tr.com.obss.bookportalserverside.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tr.com.obss.bookportalserverside.entity.Author;
import tr.com.obss.bookportalserverside.entity.Book;
import tr.com.obss.bookportalserverside.model.AuthorDTO;
import tr.com.obss.bookportalserverside.model.BookDTO;
import tr.com.obss.bookportalserverside.repository.AuthorRepository;
import tr.com.obss.bookportalserverside.repository.BookRepository;

import java.util.HashSet;
import java.util.Set;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private AuthorRepository authorRepository;

    public Book addBook(BookDTO bookDTO){
        Book book = new Book();
        book.setName(bookDTO.getName());
        Set authorSet = new HashSet();
        for (String author : bookDTO.getAuthors().split(",")){
            authorSet.add(authorRepository.findById(Long.parseLong(author)).get());
        }
        book.setAuthors(authorSet);
        return bookRepository.save(book);
    }

    public void deleteBook(Long id){
        bookRepository.deleteById(id);
    }

    public Book updateBook(Long id, String name, String authorsID){
        Book book = bookRepository.findById(id).get();
        book.setName(name);
        Set authorSet = new HashSet();
        for (String author : authorsID.split(",")){
            authorSet.add(authorRepository.findById(Long.parseLong(author)).get());
        }
        book.setAuthors(authorSet);
        return bookRepository.save(book);
    }


}
