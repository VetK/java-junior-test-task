package com.exceptions;

public class LocationAlreadyExist extends RuntimeException{
    public LocationAlreadyExist(String mess){
        super(mess);
    }
}
