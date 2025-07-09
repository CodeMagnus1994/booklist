package project.booklist.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="list")
public class ListEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    int id;

    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinTable(
            name="book_list_relation",
            joinColumns = @JoinColumn(name="list_id"),
            inverseJoinColumns = @JoinColumn(name="book_id")
    )
    List<BookEntity> bookEntityList;

    public ListEntity(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<BookEntity> getBookEntityList() {
        return bookEntityList;
    }

    public void setBookEntityList(List<BookEntity> bookEntityList) {
        this.bookEntityList = bookEntityList;
    }
}
