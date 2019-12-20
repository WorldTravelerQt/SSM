package com.scxh.ssm.service.impl;

import com.scxh.ssm.dao.BookMapper;
import com.scxh.ssm.pojo.Book;
import com.scxh.ssm.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: 乔童
 * @Description:
 * @Date: 2019/11/29 11:08
 * @Version: 1.0
 */
@Service("bookService")
public class BookServiceImpl implements BookService {
    @Autowired
    private BookMapper bookMapper;
    @Override
    public Integer addBook(Book book) {
        return bookMapper.addBook(book);
    }

    @Override
    public Integer updateBook(Book book) {
        return bookMapper.updateBook(book);
    }

    @Override
    public Integer deleteBook(int bookId) {
        return bookMapper.deleteBook(bookId);
    }

    @Override
    public List<Book> findBookByBookName(String bookName) {
        return bookMapper.findBookByBookName(bookName);
    }

    @Override
    public Book findBookByBookId(int bookId) {
        return bookMapper.findBookByBookId(bookId);
    }

    @Override
    public List<Book> searchTips(String bookName) {
        return bookMapper.searchTips(bookName);
    }

    @Override
    public List<Book> findAll() {
        return bookMapper.findAll();
    }
}
