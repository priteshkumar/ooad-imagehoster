package ImageHoster.service;

import ImageHoster.model.User;

public interface UserService {

	void registerUser(User newUser);

	User login(User user);

}