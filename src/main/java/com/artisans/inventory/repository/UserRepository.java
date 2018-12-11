/**
 * 
 */
package com.artisans.inventory.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.artisans.inventory.model.User;

/**
 * @author Jacob
 *
 */
public interface UserRepository extends JpaRepository<User, Integer> {

}
