package tr.com.obss.bookportalserverside.controller;

import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tr.com.obss.bookportalserverside.entity.Author;
import tr.com.obss.bookportalserverside.entity.Book;
import tr.com.obss.bookportalserverside.entity.Role;
import tr.com.obss.bookportalserverside.entity.User;
import tr.com.obss.bookportalserverside.model.AuthorDTO;
import tr.com.obss.bookportalserverside.model.BookDTO;
import tr.com.obss.bookportalserverside.model.RoleDTO;
import tr.com.obss.bookportalserverside.model.UserDTO;
import tr.com.obss.bookportalserverside.service.AuthorService;
import tr.com.obss.bookportalserverside.service.BookService;
import tr.com.obss.bookportalserverside.service.RoleService;
import tr.com.obss.bookportalserverside.service.UserService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @Autowired
    private AuthorService authorService;

    @Autowired
    private BookService bookService;

    //  Role Operations

    @PostMapping("/add-role")
    public ResponseEntity<Role> addRole(@Valid @RequestBody RoleDTO roleDTO){
        return new ResponseEntity<>(roleService.addRole(roleDTO), HttpStatus.OK);
    }

    @DeleteMapping("/delete-role")
    public ResponseEntity<String> deleteRole(@RequestParam Long id){
        roleService.deleteRole(id);
        return new ResponseEntity<>("Role Has Deleted!", HttpStatus.OK);
    }

    @PostMapping("/update-role")
    public ResponseEntity<Role> updateRole(@RequestBody JsonNode requestBody){
        return new ResponseEntity<>(roleService.updateRole(requestBody.get("id").asLong(),requestBody.get("name").asText()), HttpStatus.OK);
    }

    //  User Operations

    @PostMapping("/add-user")
    public ResponseEntity<User> addUser(@Valid @RequestBody UserDTO userDTO){
        return new ResponseEntity<>(userService.addUser(userDTO), HttpStatus.OK);
    }

    @DeleteMapping("/delete-user")
    public ResponseEntity<String> deleteUser(@RequestParam Long id){
        userService.deleteUser(id);
        return new ResponseEntity<>("User Has Deleted!", HttpStatus.OK);
    }

    @PostMapping("/update-user")
    public ResponseEntity<User> updateUser(@RequestBody JsonNode requestBody){
        return new ResponseEntity<>(userService.updateUser(requestBody.get("id").asLong(),requestBody.get("name").asText(),requestBody.get("password").asText(),requestBody.get("roleID").asText()), HttpStatus.OK);
    }

    //  Author Operations

    @PostMapping("/add-author")
    public ResponseEntity<Author> addAuthor(@Valid @RequestBody AuthorDTO authorDTO){
        return new ResponseEntity<>(authorService.addAuthor(authorDTO), HttpStatus.OK);
    }

    @DeleteMapping("/delete-author")
    public ResponseEntity<String> deleteAuthor(@RequestParam Long id){
        authorService.deleteAuthor(id);
        return new ResponseEntity<>("Author Has Deleted!", HttpStatus.OK);
    }

    @PostMapping("/update-author")
    public ResponseEntity<Author> updateAuthor(@RequestBody JsonNode requestBody){
        return new ResponseEntity<>(authorService.updateAuthor(requestBody.get("id").asLong(),requestBody.get("name").asText()), HttpStatus.OK);
    }

    @GetMapping("/get-authors")
    public ResponseEntity<List<Author>> getAllAuthorsByName(@RequestParam String name){
        return new ResponseEntity<>(authorService.getAllAuthors(name), HttpStatus.OK);
    }

    //  Book Operations

    @PostMapping("/add-book")
    public ResponseEntity<Book> addBook(@Valid @RequestBody BookDTO bookDTO){
        return new ResponseEntity<>(bookService.addBook(bookDTO), HttpStatus.OK);
    }

    @DeleteMapping("/delete-book")
    public ResponseEntity<String> deleteBook(@RequestParam Long id){
        bookService.deleteBook(id);
        return new ResponseEntity<>("Book Has Deleted!", HttpStatus.OK);
    }

    @PostMapping("/update-book")
    public ResponseEntity<Book> updateBook(@RequestBody JsonNode requestBody){
        return new ResponseEntity<>(bookService.updateBook(requestBody.get("id").asLong(),requestBody.get("name").asText(),requestBody.get("authorsID").asText()), HttpStatus.OK);
    }





}
