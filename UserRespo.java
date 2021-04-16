package org.abdul.project.resposittory;

import org.abdul.project.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRespo extends JpaRepository<User, Integer> {

	User findByEmailId(String emailId);

	User findByEmailIdAndPassword(String emailId, String password);

}
