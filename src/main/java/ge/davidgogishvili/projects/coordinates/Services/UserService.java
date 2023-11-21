package ge.davidgogishvili.projects.coordinates.Services;

import ge.davidgogishvili.projects.coordinates.Entities.User;
import ge.davidgogishvili.projects.coordinates.Models.UserCreateModel;

public interface UserService {


    User createUser (Integer id, UserCreateModel userCreateModel);
}
