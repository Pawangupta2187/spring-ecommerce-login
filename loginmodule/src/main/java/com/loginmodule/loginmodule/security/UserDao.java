package com.loginmodule.loginmodule.security;

import com.loginmodule.loginmodule.entities.users.User;
import com.loginmodule.loginmodule.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class UserDao {

    @Autowired
    UserRepository userRepository;

    AppUser loadUserByUserEmail(String useremail) {
        List<User> userslist = userRepository.findUserByemailId(useremail);
        if(userslist.size()>0)
        {
            User user=userslist.get(0);
            return new AppUser(user.getEmailId(), user.getPassword(), user.getRoles().stream().map(role->new GrantAuthorityImplementation(role.getAuthority())).collect(Collectors.toList()),user.getIsActive(),user.getIsDelete(),user.isAccountNonLocked());
        }
        else
            throw new RuntimeException("Invalid EmailId");

    }
}
