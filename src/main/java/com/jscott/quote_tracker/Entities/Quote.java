package com.jscott.quote_tracker.Entities;

import com.jscott.quote_tracker.DTO.QuoteDTO;
import javax.persistence.*;

@Entity
@Table(name = "quote_data")
public class Quote {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "quote_id")
    Integer quoteId;

    @Column(name = "quote", nullable = false)
    String quote;

    @Column(name = "author")
    String author;

    @Column(name = "book")
    String book;

    public Quote() {
    }

    public Quote(QuoteDTO quoteDTO) {
        this.quote = quoteDTO.quote;
        this.author = quoteDTO.author;
        this.book = quoteDTO.book;
    }

    public Integer getQuoteId() {
        return quoteId;
    }

    public void setQuoteId(Integer quoteId) {
        this.quoteId = quoteId;
    }

    public String getQuote() {
        return quote;
    }

    public void setQuote(String quote) {
        this.quote = quote;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getBook() {
        return book;
    }

    public void setBook(String book) {
        this.book = book;
    }

    @Override
    public String toString() {
        return "Quote{" +
                "quoteId=" + quoteId +
                ", quote='" + quote + '\'' +
                ", author='" + author + '\'' +
                ", book=" + book +
                '}';
    }
}
