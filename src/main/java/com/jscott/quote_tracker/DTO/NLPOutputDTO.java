package com.jscott.quote_tracker.DTO;

public class NLPOutputDTO {
    public String[] tokens;
    public String[] tags;

    public NLPOutputDTO() {
    }

    public NLPOutputDTO(String[] tokens, String[] tags) {
        this.tokens = tokens;
        this.tags = tags;
    }

    public String[] getTokens() {
        return tokens;
    }

    public void setTokens(String[] tokens) {
        this.tokens = tokens;
    }

    public String[] getTags() {
        return tags;
    }

    public void setTags(String[] tags) {
        this.tags = tags;
    }

    @Override
    public String toString() {
        return "NLPOutputDTO{" +
                "tokens=" + tokens +
                ", tags='" + tags +
                '}';
    }
}
