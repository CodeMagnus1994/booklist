package project.booklist.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project.booklist.entity.ListEntity;

@Repository
public interface ListRepository extends JpaRepository<ListEntity, Integer> {
}
