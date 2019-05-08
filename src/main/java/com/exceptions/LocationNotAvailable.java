package com.exceptions;

public class LocationNotAvailable extends RuntimeException{
    public LocationNotAvailable(String mess){
        super(mess);
    }
}

