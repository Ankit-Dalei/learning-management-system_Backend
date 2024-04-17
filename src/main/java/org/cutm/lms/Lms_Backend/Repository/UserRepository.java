package org.cutm.lms.Lms_Backend.Repository;

import org.cutm.lms.Lms_Backend.Entity.User;
import org.cutm.lms.Lms_Backend.Service.UserService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface UserRepository extends JpaRepository<User, Long>{
    @Query("SELECT u FROM User u WHERE u.UserEmail = :useremail AND u.UserPasswd = :password")
    User findByUserEmailAndPassword(@Param("useremail") String useremail, @Param("password") String password);



}