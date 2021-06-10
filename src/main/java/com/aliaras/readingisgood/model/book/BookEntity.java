package com.aliaras.readingisgood.model.book;

import com.aliaras.readingisgood.model.base.BaseEntity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookEntity extends BaseEntity {
    private Long bookId;
    private int isbn;
    private String title;
    private String summary;
    private String categoryId;
    private int numberOfPage;
    private String country;
    private Double price;
    private String publisher;
    private String author;
    private String language;
    private int stock;
}
