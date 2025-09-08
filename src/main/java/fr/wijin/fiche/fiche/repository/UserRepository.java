package fr.wijin.fiche.fiche.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.wijin.fiche.fiche.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    
    	/**
	 * Get a user by username
	 * @param username the username
	 * @return the user
	 */
	User findByUsername(String username);
	
	/**
	 * Get a user by username and password
	 * @param username the username
	 * @param password the password
	 * @return the user
	 */
	User findByUsernameAndPassword(String username, String password);
}
