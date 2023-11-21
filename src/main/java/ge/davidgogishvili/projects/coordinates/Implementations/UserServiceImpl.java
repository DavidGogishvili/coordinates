package ge.davidgogishvili.projects.coordinates.Implementations;

import ge.davidgogishvili.projects.coordinates.Entities.User;
import ge.davidgogishvili.projects.coordinates.Models.UserCreateModel;
import ge.davidgogishvili.projects.coordinates.Repositories.UserRepo;
import ge.davidgogishvili.projects.coordinates.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepo userRepo;

    @Autowired
    public UserServiceImpl(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public User createUser(Integer id, UserCreateModel userCreateModel) {
        var user = new User();
        user.setEmail(userCreateModel.email());
        user.setPassword(userCreateModel.password());
        user.setUsername(userCreateModel.username());
        user.setName(userCreateModel.name());
        user.setLastName(userCreateModel.lastName());
        userRepo.save(user);
        return user;
    }
}
