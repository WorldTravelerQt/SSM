package com.scxh.ssm.controller;

import com.scxh.ssm.pojo.Book;
import com.scxh.ssm.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @Author: 乔童
 * @Description: 书籍控制器
 * @Date: 2019/11/29 10:26
 * @Version: 1.0
 */
@RequestMapping("/books")
@Controller
public class BooksController {
    @Autowired
    @Qualifier(value = "bookService")
    private BookService bookService;
    /**
     * 查询所有图书
     */
    @RequestMapping("/all")
    public String findAll(Model model)
    {
        List<Book> all = bookService.findAll();
        System.err.println("查询所有图书->"+all);
        model.addAttribute("books",all);
        return "main";
    }

    @RequestMapping("/searchByName")
    public String findBookByName(String bookName,Model model)
    {
        if(!bookName.trim().isEmpty()) {
            bookName="%"+bookName+"%";
            System.err.println("图书查询->" + bookName);
            List<Book> books = bookService.findBookByBookName(bookName);
            model.addAttribute("books", books);
        }
        return "main";
    }

    /**
     * 添加图书
     */
    @RequestMapping("/toAddPager")
    public String toAddPager()
    {
        System.err.println("添加图书...");
        return "add";
    }
    @RequestMapping("/add")
    public String add(Book book)
    {
        System.err.println("添加图书->"+book);
        bookService.addBook(book);
        return "redirect:/books/all";
    }

    /**
     * 修改图书
     */
    @RequestMapping("/toUpdatePager")
    public String toUpdatePager(int bookId,Model model)
    {
        Book book = bookService.findBookByBookId(bookId);
        System.err.println("修改图书->"+book);
        model.addAttribute("book",book);
        return "update";
    }
    @RequestMapping("/update")
    public String update(Book book)
    {
        System.err.println(book);
        bookService.updateBook(book);
        return "redirect:/books/all";
    }

    /**
     * 删除图书
     */
    @RequestMapping("/delete")
    public String delete(int bookId)
    {
        System.out.println("删除图书,编号->"+bookId);
        bookService.deleteBook(bookId);
        return "redirect:/books/all";
    }

    /**
     * 智能搜索提示
     */
    @ResponseBody
    @RequestMapping("/searchTips")
    public List<Book> search(String bookName)
    {
        if(bookName.trim().isEmpty())
        {
            return null;
        }
        bookName="%"+bookName+"%";
        List<Book> books = bookService.searchTips(bookName);
        System.out.println(books);
        return books;
    }
}
