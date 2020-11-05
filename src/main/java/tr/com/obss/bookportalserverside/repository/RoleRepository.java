package tr.com.obss.bookportalserverside.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tr.com.obss.bookportalserverside.entity.Role;

import java.util.List;
import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role,Long> {

    @Override
    <S extends Role> S save(S s);

    @Override
    void deleteById(Long aLong);

    Role findByName(String name);

    @Override
    List<Role> findAll();

    @Override
    Optional<Role> findById(Long aLong);
}
