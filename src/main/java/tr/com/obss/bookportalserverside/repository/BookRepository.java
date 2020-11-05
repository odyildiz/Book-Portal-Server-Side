package tr.com.obss.bookportalserverside.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import tr.com.obss.bookportalserverside.entity.Book;

import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository<Book,Long> {
    @Override
    <S extends Book> S save(S s);

    @Override
    Optional<Book> findById(Long aLong);

    @Override
    void deleteById(Long aLong);
}
