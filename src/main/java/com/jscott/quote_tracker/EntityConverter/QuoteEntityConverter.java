package com.jscott.quote_tracker.EntityConverter;

import com.jscott.quote_tracker.DTO.QuoteDTO;
import com.jscott.quote_tracker.Entities.Quote;
import org.springframework.stereotype.Service;

@Service
public class QuoteEntityConverter implements EntityConverter<Quote, QuoteDTO> {

    @Override
    public QuoteDTO convertToDTO(Quote quoteEntity) {
        QuoteDTO quoteDTO = new QuoteDTO();
        quoteDTO.quote = quoteEntity.getQuote();
        quoteDTO.quoteId = quoteEntity.getQuoteId();

        return quoteDTO;
    }

    @Override
    public Quote convertToEntity(QuoteDTO quoteDTO) {

        Quote quoteEntity = new Quote();

        quoteEntity.setQuote(quoteDTO.quote);
        quoteEntity.setAuthor(quoteDTO.author);
        return quoteEntity;
    }
}
