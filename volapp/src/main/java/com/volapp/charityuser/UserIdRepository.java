package com.volapp.charityuser;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserIdRepository extends JpaRepository<User, String>{
    User findById(Long id);
    
}