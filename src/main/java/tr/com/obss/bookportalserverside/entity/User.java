package tr.com.obss.bookportalserverside.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
public class User extends EntityBase{
    @Column(unique = true)
    private String userName;

    private String password;

    @ManyToMany(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @JoinColumn(name = "role_id", referencedColumnName = "id")
    @JsonManagedReference
    private Set<Role> roles;

    @ManyToMany
    @JoinTable(name = "READ_LIST",
            joinColumns = {@JoinColumn(name = "USER_ID", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "BOOK_ID", referencedColumnName = "id")})
    @JsonManagedReference
    private Set<Book> readList;

    @ManyToMany
    @JoinTable(name = "FAVORITE_LIST",
            joinColumns = {@JoinColumn(name = "USER_ID", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "BOOK_ID", referencedColumnName = "id")})
    @JsonManagedReference
    private Set<Book> favoriteList;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
}
