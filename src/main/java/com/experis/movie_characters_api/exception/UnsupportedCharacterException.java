package com.experis.movie_characters_api.exception;

public class UnsupportedCharacterException extends RuntimeException{
    public UnsupportedCharacterException(String message) {
        super(message);
    }
}
