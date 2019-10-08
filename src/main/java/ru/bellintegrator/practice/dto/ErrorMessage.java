package ru.bellintegrator.practice.dto;

public class ErrorMessage {
    String error;

    public ErrorMessage(String error) {
        this.error = error;
    }
    @Override
    public String toString(){
        return "{error:" + error + "}";
    }
}
