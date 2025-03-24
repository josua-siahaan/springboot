package juara.coding.day19.service;

import jakarta.transaction.Transactional;
import juara.coding.day19.dto.PersonDTO;
import juara.coding.day19.model.Person;
import juara.coding.day19.repos.PersonRepo;
import juara.coding.day19.security.BcryptImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class PersonService extends BcryptImpl {

    @Autowired
    private PersonRepo userRepo;

    public Person create(Person user){
        user.setPassword(hash(user.getUsername()+user.getPassword()));
        return userRepo.save(user);
    }
    public String login(PersonDTO personDTO){
        String usernameInput = personDTO.getUsername();
        String passwordInput = personDTO.getPassword();
        Person user = userRepo.findByUsernameContains(usernameInput);
        if (verifyHash(usernameInput+passwordInput, user.getPassword())){
            return "true";
        }
        else {
            return "false";
        }
    }
}
