package edu.keepaneye.app2;

public abstract class AbstractFactory {
    abstract Bread getBread(String bread);
    abstract Filling getFilling(String filling);
}

