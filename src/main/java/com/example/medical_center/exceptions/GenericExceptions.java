package com.example.medical_center.exceptions;

public class GenericExceptions extends RuntimeException{

    GenericExceptions(String message){
        super(message);
    }
    public static GenericExceptions idNotNull(){
        return new GenericExceptions("Id is not null");
    }

    public static GenericExceptions idIsNull(){
        return new GenericExceptions("Id is null");
    }

    public static GenericExceptions notFound(Object id){
        return new GenericExceptions(String.format("Record with %s does not exist", id));
    }

}
