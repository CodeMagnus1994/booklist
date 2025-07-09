package project.booklist.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import project.booklist.entity.ListEntity;
import project.booklist.service.ListService;

@RestController
@RequestMapping("/api/")
public class ListController {

    private ListService listService;

    @Autowired
    public ListController(ListService listService) {
        this.listService = listService;
    }

    @PostMapping("list")
    public ListEntity createList(@RequestBody ListEntity listEntity) {
        return listService.createList(listEntity);
    }

    @GetMapping("list/{id}")
    public ListEntity getList(@PathVariable int id) {
        return listService.getList(id);
    }

    @PutMapping("list/{id}")
    public ListEntity updateList(@RequestBody ListEntity listEntity, @PathVariable int id) {
        return listService.updateList(listEntity, id);
    }

}
