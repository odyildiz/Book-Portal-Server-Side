package tr.com.obss.bookportalserverside.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tr.com.obss.bookportalserverside.entity.Role;
import tr.com.obss.bookportalserverside.entity.User;
import tr.com.obss.bookportalserverside.model.MyUserDetails;
import tr.com.obss.bookportalserverside.model.UserDTO;
import tr.com.obss.bookportalserverside.repository.RoleRepository;
import tr.com.obss.bookportalserverside.repository.UserRepository;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder encoder;

    @Bean
    public PasswordEncoder encoder() {return new BCryptPasswordEncoder();}

    @Transactional
    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        Optional<User> byUserName = userRepository.findUserByUserName(userName);
        if (byUserName.isPresent()){
            return new MyUserDetails(byUserName.get());
        }
        throw new UsernameNotFoundException("User does not exist!");
    }

    public User addUser(UserDTO userDTO){
        User user = new User();
        user.setUserName(userDTO.getUsername());
        user.setPassword(encoder.encode(userDTO.getPassword()));
        user.setRoles(Stream.of(roleRepository.findByName("ROLE_USER")).collect(Collectors.toSet()));
        return userRepository.save(user);
    }

    public void deleteUser(Long id){
        userRepository.deleteById(id);
    }

    public User updateUser(Long id, String name, String password, String roleID){
        User user = userRepository.findById(id).get();
        user.setUserName(name);
        user.setPassword(password);
        Set roleSet = new HashSet();
        for (String role : roleID.split(",")){
            roleSet.add(roleRepository.findById(Long.parseLong(role)).get());
        }
        user.setRoles(roleSet);
        return userRepository.save(user);
    }

    public void addToReadList(Long userId, Long bookId){
        userRepository.addBookToReadList(userId, bookId);
    }

    public void deleteFromReadList(Long userId, Long bookId){
        userRepository.deleteBookFromReadList(userId, bookId);
    }

    public String getReadList(Long userId){
        return userRepository.getReadList(userId);
    }

    public void addToFavoriteList(Long userId, Long bookId){
        userRepository.addBookToFavoriteList(userId, bookId);
    }

    public void deleteFromFavoriteList(Long userId, Long bookId){
        userRepository.deleteBookFromFavoriteList(userId, bookId);
    }

    public String getFavoriteList(Long userId){
        return userRepository.getFavoriteList(userId);
    }
}
