package tr.com.obss.bookportalserverside.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import tr.com.obss.bookportalserverside.entity.User;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    @Override
    <S extends User> S save(S s);

    @Override
    void deleteById(Long aLong);

    @Override
    Optional<User> findById(Long aLong);

    Optional<User> findUserByUserName(String userName);

    @Modifying
    @Transactional
    @Query(value = "insert into read_list (user_id, book_id) values(:userId, :bookId) ", nativeQuery = true)
    void addBookToReadList(@Param("userId") Long userId, @Param("bookId") Long bookId);

    @Modifying
    @Transactional
    @Query(value = "delete from read_list where user_id = :userId and book_id = :bookId ", nativeQuery = true)
    void deleteBookFromReadList(@Param("userId") Long userId, @Param("bookId") Long bookId);

    @Query(value = "select * from read_list where user_id = :userId ", nativeQuery = true)
    String getReadList(@Param("userId") Long userId);

    @Modifying
    @Transactional
    @Query(value = "insert into favorite_list (user_id, book_id) values(:userId, :bookId) ", nativeQuery = true)
    void addBookToFavoriteList(@Param("userId") Long userId,@Param("bookId") Long bookId);

    @Modifying
    @Transactional
    @Query(value = "delete from favorite_list where user_id = :userId and book_id = :bookId ", nativeQuery = true)
    void deleteBookFromFavoriteList(@Param("userId") Long userId, @Param("bookId") Long bookId);

    @Query(value = "select * from favorite_list where user_id = :userId ", nativeQuery = true)
    String getFavoriteList(@Param("userId") Long userId);
}
