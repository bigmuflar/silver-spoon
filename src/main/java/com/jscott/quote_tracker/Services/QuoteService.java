package com.jscott.quote_tracker.Services;

import com.jscott.quote_tracker.DTO.NLPCountDTO;
import com.jscott.quote_tracker.DTO.NLPOutputDTO;
import com.jscott.quote_tracker.DTO.QuoteDTO;
import com.jscott.quote_tracker.Entities.Quote;
import com.jscott.quote_tracker.EntityConverter.QuoteEntityConverter;
import com.jscott.quote_tracker.Repositories.QuoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import opennlp.tools.postag.POSModel;
import opennlp.tools.postag.POSTaggerME;
import opennlp.tools.sentdetect.SentenceDetectorME;
import opennlp.tools.sentdetect.SentenceModel;
import opennlp.tools.tokenize.Tokenizer;
import opennlp.tools.tokenize.TokenizerME;
import opennlp.tools.tokenize.TokenizerModel;
import opennlp.tools.util.Span;

import javax.transaction.Transactional;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

// TODO: Seperate openNLP functions into new openNLP class.

@Service
public class QuoteService {

    @Autowired
    QuoteRepository quoteRepository;

    @Autowired
    QuoteEntityConverter quoteEntityConverter;

    @Transactional
    public List<QuoteDTO> getAllQuotes() {

        Iterable<Quote> all = quoteRepository.findAll();
        List<QuoteDTO> dtos = new ArrayList<>();
        for (Quote quote : all) {
            QuoteDTO temp = new QuoteDTO();
            temp.quoteId = quote.getQuoteId();
            temp.quote = quote.getQuote();
            temp.author = quote.getAuthor();
            temp.book = quote.getBook();
            temp.nlpCount = this.getNlpCount(temp.quote);
            dtos.add(temp);
        }
        return dtos;
    }

    public NLPCountDTO getNlpCount(String quote) {
        NLPCountDTO nlpCount = new NLPCountDTO();
        NLPOutputDTO nlpOutput = getNlpTagsTokens(quote);
        nlpCount.nouns = getCountFromArray(nlpOutput.tags, "NN");
        nlpCount.periods = getCountFromArray(nlpOutput.tags, ".");
        nlpCount.verbs = getCountFromArray(nlpOutput.tags, "VB");
        nlpCount.that = getCountFromArray(nlpOutput.tokens, "that");
        nlpCount.they = getCountFromArray(nlpOutput.tokens, "they");
        nlpCount.thing = getCountFromArray(nlpOutput.tokens, "thing");
        nlpCount.you = getCountFromArray(nlpOutput.tokens, "you");
        nlpCount.oddSentenceOut = removeSentences(quote, getSentencesAndPosDetection(quote));
        return nlpCount;
    }

    public static NLPOutputDTO getNlpTagsTokens(String quote) {
        InputStream tokenModelIn = null;
        InputStream posModelIn = null;
        NLPOutputDTO dataOut = new NLPOutputDTO();
         
        try {
            String sentence = quote;
            // tokenize the sentence
            tokenModelIn = new FileInputStream("./openNLP_models/en-token.bin");
            TokenizerModel tokenModel = new TokenizerModel(tokenModelIn);
            Tokenizer tokenizer = new TokenizerME(tokenModel);
            String tokens[] = tokenizer.tokenize(sentence);
 
            // Parts-Of-Speech Tagging
            // reading parts-of-speech model to a stream 
            posModelIn = new FileInputStream("./openNLP_models/en-pos-maxent.bin");
            // loading the parts-of-speech model from stream
            POSModel posModel = new POSModel(posModelIn);
            // initializing the parts-of-speech tagger with model 
            POSTaggerME posTagger = new POSTaggerME(posModel);
            // Tagger tagging the tokens
            String tags[] = posTagger.tag(tokens);
            dataOut = new NLPOutputDTO(tokens, tags);
        }
        catch (IOException e) {
            // Model loading failed, handle the error
            e.printStackTrace();
        }
        finally {
            if (tokenModelIn != null) {
                try {
                    tokenModelIn.close();
                }
                catch (IOException e) {
                }
            }
            if (posModelIn != null) {
                try {
                    posModelIn.close();
                }
                catch (IOException e) {
                }
            }
        }
        return dataOut;
    }

    public static Span[] getSentencesAndPosDetection(String quote) {
        InputStream inputStream =  null;
        Span[] spansOut = null;

        try {
            String sen = quote; 
            //Loading a sentence model 
            inputStream = new FileInputStream("./openNLP_models/en-sent.bin"); 
            SentenceModel model = new SentenceModel(inputStream); 
            
            //Instantiating the SentenceDetectorME class 
            SentenceDetectorME detector = new SentenceDetectorME(model);  
            
            //Detecting the position of the sentences in the paragraph  
            Span[] spans = detector.sentPosDetect(sen);

            //Setting the value to return
            spansOut = spans;
        }
        catch (IOException e) {
            // Model loading failed, handle the error
            e.printStackTrace();
        }
        finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                }
                catch (IOException e) {
                }
            }
        }

        return spansOut;
    }

    public static Integer getCountFromArray(String[] array, String value) {
        int count = 0, i = 0;
        for (i = 0; i < array.length; i++) {
            if (array[i].toLowerCase().contains(value.toLowerCase())) {
                count++;
            }
        }
        return count;
    }

    public static String removeSentences(String quote, Span[] spans) {
        StringBuffer clippedQuoteArray = new StringBuffer();
        for (int i = 0; i < spans.length; i++) {
            // Skip 3rd and 5th sentences, - 1 given array count starts at 0.
            if (i == 2 || i == 4) {
                continue;
            }
            clippedQuoteArray.append(quote.substring(spans[i].getStart(), spans[i].getEnd()) + " ");
        }
        return clippedQuoteArray.toString();
    }
}