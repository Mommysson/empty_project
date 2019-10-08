package ru.bellintegrator.practice.dto;

public class ResultMessage {
    String result;

    public ResultMessage(String result) {
        this.result = result;
    }
    @Override
    public String toString(){
        return "{result:" + result + "}";
    }
}
