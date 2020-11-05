package tr.com.obss.bookportalserverside.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Author extends EntityBase {

    private String name;

    @ManyToMany(cascade = CascadeType.MERGE)
    @JoinColumn(name = "book_id", referencedColumnName = "id")
    @JsonBackReference
    private Set<Book> books;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Book> getBook() {
        return books;
    }

    public void setBook(Set<Book> books) {
        this.books = books;
    }
}

