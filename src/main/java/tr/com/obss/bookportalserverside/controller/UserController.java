package tr.com.obss.bookportalserverside.controller;

import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tr.com.obss.bookportalserverside.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    // Read List

    @PostMapping("/add-to-read-list")
    public ResponseEntity<String> addToReadList(@RequestBody JsonNode requestBody){
        userService.addToReadList(requestBody.get("userId").asLong(),requestBody.get("bookId").asLong());
        return new ResponseEntity<>("Book has added to ReadList!", HttpStatus.OK);
    }

    @DeleteMapping("/delete-from-read-list")
    public ResponseEntity<String> deleteFromReadList(@RequestBody JsonNode requestBody){
        userService.deleteFromReadList(requestBody.get("userId").asLong(),requestBody.get("bookId").asLong());
        return new ResponseEntity<>("Book has removed from ReadList!", HttpStatus.OK);
    }

    @GetMapping("/get-books-from-read-list")
    public ResponseEntity<String> getReadList(@RequestParam Long userId){
        return new ResponseEntity<>(userService.getReadList(userId), HttpStatus.OK);
    }

    // Favorite List

    @PostMapping("/add-to-favorite-list")
    public ResponseEntity<String> addToFavoriteList(@RequestBody JsonNode requestBody){
        userService.addToFavoriteList(requestBody.get("userId").asLong(),requestBody.get("bookId").asLong());
        return new ResponseEntity<>("Book has added to FavoriteList!", HttpStatus.OK);
    }

    @DeleteMapping("/delete-from-favorite-list")
    public ResponseEntity<String> deleteFromFavoriteList(@RequestBody JsonNode requestBody){
        userService.deleteFromFavoriteList(requestBody.get("userId").asLong(),requestBody.get("bookId").asLong());
        return new ResponseEntity<>("Book has removed from FavoriteList!", HttpStatus.OK);
    }

    @GetMapping("/get-books-from-favorite-list")
    public ResponseEntity<String> getFavoriteList(@RequestParam Long userId){
        return new ResponseEntity<>(userService.getFavoriteList(userId), HttpStatus.OK);
    }

}
