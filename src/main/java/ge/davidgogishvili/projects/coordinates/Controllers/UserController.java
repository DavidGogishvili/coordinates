package ge.davidgogishvili.projects.coordinates.Controllers;

import ge.davidgogishvili.projects.coordinates.Entities.User;
import ge.davidgogishvili.projects.coordinates.Models.UserCreateModel;
import ge.davidgogishvili.projects.coordinates.Services.UserService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/Users")
public class UserController {


    private final UserService userService;

    @PostMapping("/createUser/{id}/create")
    public User createUser(@PathVariable Integer id, @RequestBody UserCreateModel userCreateModel) {

        return userService.createUser(id, userCreateModel);
    }

}
