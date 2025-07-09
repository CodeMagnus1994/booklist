package project.booklist.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.booklist.entity.PersonEntity;
import project.booklist.repository.PersonRepository;

@Service
public class PersonService {

    private PersonRepository personRepository;

    @Autowired
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public PersonEntity createPerson(PersonEntity personEntity) {
        return personRepository.save(personEntity);
    }

    public PersonEntity getPerson(int id) {
        return personRepository.findById(id).get();
    }

    public PersonEntity updatePerson(PersonEntity personEntity, int id) {

        PersonEntity person = personRepository.findById(id).get();

        if(personEntity.getId() != 0) {
            person.setId(personEntity.getId());
        }

        if(personEntity.getUsername() != null) {
            person.setUsername(personEntity.getUsername());
        }

        if(personEntity.getPassword() != null) {
            person.setPassword(personEntity.getPassword());
        }

        return personRepository.save(person);
    }

    public void DeletePerson(int id) {
        personRepository.deleteById(id);
    }

}
