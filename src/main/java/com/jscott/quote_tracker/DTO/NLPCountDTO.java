package com.jscott.quote_tracker.DTO;

public class NLPCountDTO {
    public int nouns;
    public int verbs;
    public int periods;
    public int you;
    public int that;
    public int thing;
    public int they;
    public String oddSentenceOut;

    public NLPCountDTO() {
    }

    public int getNouns() {
        return nouns;
    }

    public void setNouns(int nouns) {
        this.nouns = nouns;
    }

    public int getVerbs() {
        return verbs;
    }

    public void setVerbs(int verbs) {
        this.verbs = verbs;
    }

    public int getPeriods() {
        return periods;
    }

    public void setPeriods(int periods) {
        this.periods = periods;
    }

    public int getYou() {
        return you;
    }

    public void setYou(int you) {
        this.you = you;
    }

    public int getThat() {
        return that;
    }

    public void setThat(int that) {
        this.that = that;
    }

    public int getThing() {
        return thing;
    }

    public void setThing(int thing) {
        this.thing = thing;
    }

    public int getThey() {
        return they;
    }

    public void setThey(int they) {
        this.they = they;
    }

    public String getOddSentenceOut() {
        return oddSentenceOut;
    }

    public void setOddSentenceOut(String oddSentenceOut) {
        this.oddSentenceOut = oddSentenceOut;
    }

    @Override
    public String toString() {
        return "NLPCountDTO{" +
                "nouns=" + nouns +
                ", verbs='" + verbs + '\'' +
                ", periods='" + periods + '\'' +
                ", you='" + you + '\'' +
                ", that='" + that + '\'' +
                ", thing='" + thing + '\'' +
                ", they='" + they + '\'' +
                ", oddSentenceOut='" + oddSentenceOut +
                '}';
    }
}
