package tr.com.obss.bookportalserverside.repository;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tr.com.obss.bookportalserverside.entity.Author;

import java.util.List;
import java.util.Optional;

@Repository
public interface AuthorRepository extends JpaRepository<Author,Long> {

    @Override
    <S extends Author> S save(S s);

    @Override
    void deleteById(Long aLong);

    @Override
    Optional<Author> findById(Long aLong);

    Optional<List<Author>> findAllByNameIsLike(String name);
}
