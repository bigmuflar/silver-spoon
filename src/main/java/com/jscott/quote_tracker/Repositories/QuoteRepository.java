package com.jscott.quote_tracker.Repositories;

import com.jscott.quote_tracker.Entities.Quote;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import java.util.Optional;

@RepositoryRestResource
public interface QuoteRepository extends CrudRepository<Quote, Integer> {
    Optional<Quote> findQuoteByQuoteId(Integer quoteId);
}
