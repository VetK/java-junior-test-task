package com.exceptions;

public class RouteNotExist extends RuntimeException{
    public RouteNotExist(String mess){
        super(mess);
    }
}