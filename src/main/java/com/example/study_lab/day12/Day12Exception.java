package com.example.study_lab.day12;

// Runtime예외를 상속받아. Unchecked Exception으로 만듦.
public class Day12Exception extends RuntimeException{
    public Day12Exception(String message){
        super(message);
    }
}
