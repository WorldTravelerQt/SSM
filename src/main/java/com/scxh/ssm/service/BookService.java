package com.scxh.ssm.service;

import com.scxh.ssm.pojo.Book;

import java.util.List;

/**
 * @Author: 乔童
 * @Description: 书籍业务层接口
 * @Date: 2019/11/29 10:27
 * @Version: 1.0
 */
public interface BookService {
    /**
     * 添加图书
     */
    Integer addBook(Book book);

    /**
     * 修改图书
     */
    Integer updateBook(Book book);

    /**
     * 删除图书
     */
    Integer deleteBook(int bookId);

    /**
     * 按书名查询
     */
    List<Book> findBookByBookName(String bookName);

    /**
     * 按书ID查询
     */
    Book findBookByBookId(int bookId);

    /**
     * 搜索智能提示
     */
    List<Book> searchTips(String bookName);

    /**
     * 查询全部
     */
    List<Book> findAll();
}
