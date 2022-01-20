package com.ssmp.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ssmp.dao.BookMapper;
import com.ssmp.pojo.Book;
import com.ssmp.service.IBookService;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author sheep
 */
@Service
public class BookServiceImpl extends ServiceImpl<BookMapper, Book> implements IBookService {
    private BookMapper bookMapper;
    @Autowired
    public void setBookMapper(BookMapper bookMapper) {
        this.bookMapper = bookMapper;
    }

//    @Override
//    public IPage<Book> getPage(int currentPage, int pageSize) {
//        Page<Book> page = new Page<>(currentPage,pageSize);
//        return bookMapper.selectPage(page,null);
//    }

    @Override
    public IPage<Book> getPage(int currentPage, int pageSize, Book book) {
        IPage<Book> page = new Page<Book>(currentPage,pageSize);
        LambdaQueryWrapper<Book> lqw = new LambdaQueryWrapper<Book>();
        lqw.like(Strings.isNotEmpty(book.getName()),Book::getName,book.getName());
        lqw.like(Strings.isNotEmpty(book.getType()),Book::getType,book.getType());
        lqw.like(Strings.isNotEmpty(book.getDescription()),Book::getDescription,book.getDescription());
        return bookMapper.selectPage(page,lqw);
    }
}
