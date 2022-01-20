package com.ssmp.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.ssmp.controller.utils.R;
import com.ssmp.pojo.Book;
import com.ssmp.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
 * @author sheep
 */
@RestController
@RequestMapping("/books")
public class BookController {
    private IBookService bookService;

    @Autowired
    public void setBookService(IBookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public R getAll() {
        return new R(true, bookService.list());
    }

    @PostMapping
    public R save(@RequestBody Book book) {
        Boolean flag = bookService.save(book);
        return new R(flag,flag?"添加成功":"添加失败");
    }

    @PutMapping
    public R update(@RequestBody Book book) {
        Boolean flag = bookService.updateById(book);
        return new R(flag,flag?"修改成功":"修改失败");
    }

    @DeleteMapping("{id}")
    public R delete(@PathVariable Integer id) {
        Boolean flag = bookService.removeById(id);
        return new R(flag,flag?"删除成功":"删除失败");
    }

    @GetMapping("{id}")
    public R getById(@PathVariable Integer id) {
        return new R(true, bookService.getById(id));
    }

    @GetMapping("{currentPage}/{pageSize}")
    public R getPage(@PathVariable int currentPage, @PathVariable int pageSize, Book book) {
        IPage<Book> page = bookService.getPage(currentPage, pageSize,book);
        if (page.getPages() < currentPage){
            page = bookService.getPage((int)page.getPages(), pageSize,book);
        }
        return new R(true, page);
    }
}
