package project.booklist.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import project.booklist.entity.PersonEntity;
import project.booklist.service.PersonService;

@RestController
@RequestMapping("/api/")
public class PersonController {

    private PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping("person")
    public PersonEntity createPerson(@RequestBody PersonEntity personEntity) {
        return personService.createPerson(personEntity);
    }

    @GetMapping("person/{id}")
    public PersonEntity getPerson(@PathVariable int id) {
        return personService.getPerson(id);
    }

    @PutMapping("person/{id}")
    public PersonEntity updatePerson(@RequestBody PersonEntity personEntity, @PathVariable int id) {
        return personService.updatePerson(personEntity, id);
    }

    @DeleteMapping("person/{id}")
    public String deletePerson(@PathVariable int id) {
        personService.DeletePerson(id);

        return "Person " + id + " has been deleted!";
    }

}
