package com.freechat.flashchatnewfirebase;

/**
 * Created by mahe on 22-Oct-17.
 */

public class InstantMessage {
    private  String message;
    private  String author;

    public InstantMessage (String message, String author) {
        this.message = message;
        this.author = author;
    }

    public InstantMessage () {
    }

    public String getMessage () {
        return message;
    }

    public String getAuthor () {
        return author;
    }
}
