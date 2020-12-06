package ar.com.degedev.trazar_covid.repository;

import ar.com.degedev.trazar_covid.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    User findByUserName(String userName);

}
