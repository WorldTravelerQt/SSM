package com.scxh.ssm.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: 乔童
 * @Description: 书籍实体类
 * @Date: 2019/11/29 10:24
 * @Version: 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book {
    private Integer bookId;
    private String bookName;
    private Integer bookCounts;
    private String detail;
}
