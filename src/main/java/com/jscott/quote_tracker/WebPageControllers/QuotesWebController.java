package com.jscott.quote_tracker.WebPageControllers;

import com.jscott.quote_tracker.Repositories.QuoteRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class QuotesWebController {

    private final QuoteRepository quoteRepository;

    public QuotesWebController(QuoteRepository quoteRepository) {
        this.quoteRepository = quoteRepository;
    }

    @GetMapping("/quotes")
    public ModelAndView quotesPage() {
        ModelAndView modelAndView = new ModelAndView("quotes");

        return modelAndView;
    }
}
