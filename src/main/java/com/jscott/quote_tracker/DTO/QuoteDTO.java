package com.jscott.quote_tracker.DTO;

import com.jscott.quote_tracker.Entities.Quote;

public class QuoteDTO {

    public NLPCountDTO nlpCount;
    public int quoteId;
    public String quote;
    public String author;
    public String book;

    public QuoteDTO() {
    }

    public QuoteDTO(Quote quoteEntity) {
        this.quoteId = quoteEntity.getQuoteId();
        this.quote = quoteEntity.getQuote();
        this.author = quoteEntity.getAuthor();
        this.book = quoteEntity.getBook();
    }

    public int getQuoteId() {
        return quoteId;
    }

    public void setQuoteId(int quoteId) {
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

    public NLPCountDTO getNlpCount() {
        return nlpCount;
    }

    public void setNlpCount(NLPCountDTO nlpCount) {
        this.nlpCount = nlpCount;
    }


    @Override
    public String toString() {
        return "QuoteDTO{" +
                "quoteId=" + quoteId +
                ", quote='" + quote + '\'' +
                ", author='" + author + '\'' +
                ", book='" + book + '\'' +
                ", nlpCount='" + nlpCount +
                '}';
    }
}
