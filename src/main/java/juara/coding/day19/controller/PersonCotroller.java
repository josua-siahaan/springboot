package juara.coding.day19.controller;

import jakarta.validation.Valid;
import juara.coding.day19.dto.PersonDTO;
import juara.coding.day19.model.Person;
import juara.coding.day19.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
public class PersonCotroller {

    @Autowired
    private PersonService userService;

    @PostMapping("/create")
    public Person create(@Valid @RequestBody PersonDTO personDTO){
        Person user = new Person();
        user.setUsername(personDTO.getUsername());
        user.setPassword(personDTO.getPassword());
        return userService.create(user);
    }

    @PostMapping("/login")
    public String login(@Valid @RequestBody PersonDTO personDTO){

        return userService.login(personDTO);
    }

}
