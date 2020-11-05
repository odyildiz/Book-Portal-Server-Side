package tr.com.obss.bookportalserverside.model;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import tr.com.obss.bookportalserverside.entity.User;

import java.util.Collection;
import java.util.Collections;
import java.util.stream.Collectors;

public class MyUserDetails implements UserDetails {

    private User user;

    public MyUserDetails(User user){
        this.setUser(user);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return getUser() != null ?
                getUser().getRoles().stream().map(t ->
                        new SimpleGrantedAuthority(t.getName()))
                        .collect(Collectors.toList()) :
                Collections.emptyList();
    }

    @Override
    public String getPassword() {
        return getUser().getPassword();
    }

    @Override
    public String getUsername() {
        return getUser().getUserName();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
