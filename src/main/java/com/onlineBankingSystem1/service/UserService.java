package com.onlineBankingSystem1.service;

import java.util.List;
import java.util.Set;

import com.onlineBankingSystem1.domain.User;
import com.onlineBankingSystem1.domain.security.UserRole;

public interface UserService {
	User findByUsername(String username);

    User findByEmail(String email);

    boolean checkUserExists(String username, String email);

    boolean checkUsernameExists(String username);

    boolean checkEmailExists(String email);
    
    void save (User user);
    User createUser(User user, Set<UserRole> userRoles);
  User saveUser (User user); 
    
    //<User> findUserList();

  //  void enableUser (String username);

    //void disableUser (String username);
}
