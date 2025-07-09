package project.booklist.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.booklist.entity.BookEntity;
import project.booklist.repository.BookRepository;

@Service
public class BookService {

    private BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository){
        this.bookRepository = bookRepository;
    }

    public BookEntity createBook(BookEntity bookEntity) {
        return bookRepository.save(bookEntity);
    }

    public BookEntity getBook(int id) {
        return bookRepository.findById(id).get();
    }

    public BookEntity updateBook(BookEntity bookEntity, int id) {

        BookEntity book = bookRepository.findById(id).get();

        if(bookEntity.getId() != 0) {
            book.setId(bookEntity.getId());
        }

        if(bookEntity.getTitle() != null){
            book.setTitle(bookEntity.getTitle());
        }

        if(bookEntity.getAuthor() != null){
            book.setAuthor(bookEntity.getAuthor());
        }

        return bookRepository.save(book);
    }

    public void deleteBook(int id) {
        bookRepository.deleteById(id);
    }

}
