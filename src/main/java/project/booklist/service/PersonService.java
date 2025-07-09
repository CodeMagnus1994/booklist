package project.booklist.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.booklist.entity.ListEntity;
import project.booklist.entity.PersonEntity;
import project.booklist.repository.ListRepository;
import project.booklist.repository.PersonRepository;

@Service
public class PersonService {

    private PersonRepository personRepository;
    private ListRepository listRepository;

    @Autowired
    public PersonService(PersonRepository personRepository, ListRepository listRepository) {
        this.personRepository = personRepository;
        this.listRepository = listRepository;
    }

    public PersonEntity createPerson(PersonEntity personEntity) {
        return personRepository.save(personEntity);
    }

    public PersonEntity getPerson(int id) {
        return personRepository.findById(id).get();
    }

    public PersonEntity updatePerson(PersonEntity personEntity, int id) {

        PersonEntity person = personRepository.findById(id).get();

        ListEntity associatedList = listRepository.findById(personEntity.getListEntity().getId())
                .orElseThrow(() -> new RuntimeException("List not found"));

        if(personEntity.getId() != 0) {
            person.setId(personEntity.getId());
        }

        if(personEntity.getUsername() != null) {
            person.setUsername(personEntity.getUsername());
        }

        if(personEntity.getPassword() != null) {
            person.setPassword(personEntity.getPassword());
        }

        if(associatedList.getId() != 0){
            associatedList.setId(associatedList.getId());
        }
        if(associatedList.getBookEntityList() != null){
            associatedList.setBookEntityList(associatedList.getBookEntityList());
        }
        person.setListEntity(associatedList);

        return personRepository.save(person);
    }

    public void DeletePerson(int id) {
        personRepository.deleteById(id);
    }

}
