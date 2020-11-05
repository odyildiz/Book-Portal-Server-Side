package tr.com.obss.bookportalserverside.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
public class Role extends EntityBase {
    @Column(unique = true)
    private String name;

    @ManyToMany
    @JoinColumn(name = "role_id", referencedColumnName = "id")
    @JsonBackReference
    private Set<User> users;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }
}
