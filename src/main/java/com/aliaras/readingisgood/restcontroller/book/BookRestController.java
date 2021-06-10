package com.aliaras.readingisgood.restcontroller.book;

import com.aliaras.readingisgood.app.aspect.ReadingIsGoodLogger;
import com.aliaras.readingisgood.model.book.BookEntity;
import com.aliaras.readingisgood.service.book.IBookService;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Log4j2
@RestController
@RequestMapping(value = "/book")
public class BookRestController {

    private final IBookService iBookService;

    public BookRestController(IBookService iBookService) {
        this.iBookService = iBookService;
    }

    @ReadingIsGoodLogger
    @PostMapping(value = "/save")
    public ResponseEntity<BookEntity> save(@RequestBody BookEntity bookEntity) {
        return new ResponseEntity<>(iBookService.save(bookEntity), HttpStatus.OK);
    }

    @ReadingIsGoodLogger
    @PostMapping(value = "/update")
    public ResponseEntity<BookEntity> update(@RequestBody BookEntity bookEntity) {
        return save(bookEntity);
    }

    @ReadingIsGoodLogger
    @DeleteMapping(value = "/delete")
    public ResponseEntity<BookEntity> delete(@RequestBody BookEntity bookEntity) {
        try {
            iBookService.delete(bookEntity);
            return new ResponseEntity<>(HttpStatus.OK);

        } catch (Exception e) {
            log.error(e.getMessage());
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
    }
}
