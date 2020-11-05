package tr.com.obss.bookportalserverside.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Book extends EntityBase{

    private String name;

    @ManyToMany
    @JoinColumn(name = "author_id", referencedColumnName = "id")
    @JsonManagedReference
    private Set<Author> authors;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(Set<Author> authors) {
        this.authors = authors;
    }
}
