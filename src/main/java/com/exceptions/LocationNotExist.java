package com.exceptions;

public class LocationNotExist extends RuntimeException{
    public LocationNotExist(String mess){
        super(mess);
    }
}

