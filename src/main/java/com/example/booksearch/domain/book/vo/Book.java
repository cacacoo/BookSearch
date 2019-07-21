package com.example.booksearch.domain.book.vo;

import com.google.gson.annotations.SerializedName;
import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Getter
@Builder
public class Book {

    private String title;

    private String thumbnail;

    private String isbn;

    private String contents;

    private List<String> authors;

    private String publisher;

    @SerializedName("datetime")
    private Date publicationDate;

    private BigDecimal price;

    @SerializedName("sale_price")
    private BigDecimal salePrice;

}
