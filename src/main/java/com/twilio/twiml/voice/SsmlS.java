/**
 * This code was generated by
 * \ / _    _  _|   _  _
 *  | (_)\/(_)(_|\/| |(/_  v1.0.0
 *       /       /
 */

package com.twilio.twiml.voice;

import com.twilio.twiml.TwiML;

/**
 * TwiML wrapper for {@code <S>}
 */
public class SsmlS extends TwiML {
    private final String words;

    /**
     * For XML Serialization/Deserialization
     */
    private SsmlS() {
        this(new Builder((String) null));
    }

    /**
     * Create a new {@code <SsmlS>} element
     */
    private SsmlS(Builder b) {
        super("s", b);
        this.words = b.words;
    }

    /**
     * The body of the TwiML element
     * 
     * @return Element body as a string if present else null
     */
    protected String getElementBody() {
        return this.getWords() == null ? null : this.getWords();
    }

    /**
     * Words to speak
     * 
     * @return Words to speak
     */
    public String getWords() {
        return words;
    }

    /**
     * Create a new {@code <S>} element
     */
    public static class Builder extends TwiML.Builder<Builder> {
        private String words;

        /**
         * Create a {@code <S>} with words
         */
        public Builder(String words) {
            this.words = words;
        }

        /**
         * Create and return resulting {@code <S>} element
         */
        public SsmlS build() {
            return new SsmlS(this);
        }
    }
}