package com.ssmp;

import com.ssmp.dao.BookMapper;
import com.ssmp.pojo.Book;
import com.ssmp.service.IBookService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class ApplicationTests {
    @Autowired
    private BookMapper bookMapper;

    @Autowired
    private IBookService bookService;

    @Test
    void contextLoads() {
        List<Book> list = bookService.list();
        for (Book book : list) {
            System.out.println(book);
        }
    }

}
