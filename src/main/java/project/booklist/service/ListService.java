package project.booklist.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.booklist.entity.BookEntity;
import project.booklist.entity.ListEntity;
import project.booklist.repository.ListRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class ListService {

    private ListRepository listRepository;
    @Autowired
    public ListService(ListRepository listRepository) {
        this.listRepository = listRepository;
    }

    public ListEntity createList(ListEntity listEntity) {
        return listRepository.save(listEntity);
    }

    public ListEntity getList(int id) {
        return listRepository.findById(id).get();
    }

    public ListEntity updateList(ListEntity listEntity, int id) {

        ListEntity list = listRepository.findById(id).get();

        List<BookEntity> bookEntityList = new ArrayList<>();

        if(listEntity.getBookEntityList() != null) {
            bookEntityList.addAll(list.getBookEntityList());
            bookEntityList.addAll(listEntity.getBookEntityList());
            list.setBookEntityList(bookEntityList);
        }

        if(listEntity.getId() != 0){
            list.setId(listEntity.getId());
        }

        return listRepository.save(list);
    }


}
