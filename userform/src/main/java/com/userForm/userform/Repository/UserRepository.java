package com.userForm.userform.Repository;

import com.userForm.userform.Model.UserModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<UserModel, Long> {
        UserModel findByUsernameAndPassword(String username, String password);
        UserModel findByUsername(String username);

}
