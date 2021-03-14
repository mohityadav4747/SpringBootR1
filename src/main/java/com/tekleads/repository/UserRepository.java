
  package com.tekleads.repository;
  
  import org.springframework.data.jpa.repository.JpaRepository;
  
  import com.tekleads.model.User;
  
  public interface UserRepository extends JpaRepository<User, Integer>{
  
 }
