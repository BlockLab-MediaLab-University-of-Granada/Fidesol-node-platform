package com.fidesol.bcp.domain.repository.mysql;

import com.fidesol.bcp.domain.model.mysql.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
	User findOneByToken(String token);

    /**
     * This query insert a new entry in users table.

     * @param String, String, int
     */
	@Transactional
	@Modifying
	@Query(value = "INSERT INTO `users` (`username`, `password`, `token`) VALUES (?1, ?2, ?3)", nativeQuery = true)
    void add(String name, String password, int token);

    /**
     * This query obtains the password of a given username.

     * @param String
     */
	@Query(value = "SELECT password from users WHERE username=?1", nativeQuery = true)
	String login(String name);

    /**
     * This query obtains the token of a given username.

     * @param String
     */
	@Query(value = "SELECT token from users WHERE username=?1", nativeQuery = true)
    int getToken(String name);

    /**
     * This query obtains the rol of a given username.

     * @param String
     */
	@Query(value = "SELECT rol from users WHERE username=?1", nativeQuery = true)
	int getRol(String name);

    /**
     * This query changes the given user's rol to 2 (admin).

     * @param String
     */
	@Transactional
	@Modifying
	@Query(value = "UPDATE `bcp`.`users` SET `rol` = '2' WHERE (`username` = ?1)", nativeQuery = true)
	void upgrade(String username);
}
