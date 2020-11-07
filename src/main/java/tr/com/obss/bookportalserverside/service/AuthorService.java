package tr.com.obss.bookportalserverside.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tr.com.obss.bookportalserverside.entity.Author;
import tr.com.obss.bookportalserverside.model.AuthorDTO;
import tr.com.obss.bookportalserverside.repository.AuthorRepository;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorService {

    @Autowired
    private AuthorRepository authorRepository;

    public Author addAuthor(AuthorDTO authorDTO){
        Author author = new Author();
        author.setName(authorDTO.getName());
        return authorRepository.save(author);
    }

    public void deleteAuthor(Long id){
        authorRepository.deleteById(id);
    }

    public Author updateAuthor(Long id, String name){
        Optional<Author> author = authorRepository.findById(id);

        if (author.isPresent()){
            author.get().setName(name);
            return authorRepository.save(author.get());
        }

        throw new IllegalArgumentException("Couldn't find specified author");
    }

    public List<Author> getAllAuthors(String name){
        String newName = '%' + name + "%";
        Optional<List<Author>> authors = authorRepository.findAllByNameIsLike(newName);

        if (authors.isPresent()){
            return authors.get();
        }
        throw new IllegalArgumentException("Couldn't find specified author");
    }

}
