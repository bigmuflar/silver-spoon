package com.jscott.quote_tracker.RestControllers;

import com.jscott.quote_tracker.DTO.QuoteDTO;
import com.jscott.quote_tracker.Services.QuoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class QuoteController {

    @Autowired
    QuoteService quoteService;

    public QuoteController(QuoteService quoteService) {
        this.quoteService = quoteService;
    }

    @GetMapping(value = "/quotes", produces = "application/json")
    public ResponseEntity<List<QuoteDTO>> getAllQuotes() {

        List<QuoteDTO> allQuotes = quoteService.getAllQuotes();
        return new ResponseEntity<List<QuoteDTO>>(allQuotes, HttpStatus.OK);
    }
}
