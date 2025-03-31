package com.tranquyet.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Comment {

    private String author;
    private String message;
    private String timestamp;

    public Comment(String author, String message, String timestamp) {
        this.author = author;
        this.message = message;
        this.timestamp = timestamp;
    }
    @Override
    public String toString() {
        return "Comment{" +
                "author='" + author + '\'' +
                ", message='" + message + '\'' +
                ", timestamp='" + timestamp + '\'' +
                '}';
    }
}
