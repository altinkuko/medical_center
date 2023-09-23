package com.example.medical_center.exceptions;

public class GenericExceptions extends RuntimeException{
    private Integer status;

    GenericExceptions(String message, Integer status){
        super(message);
        this.status = status;
    }
    public static GenericExceptions idNotNull(){
        return new GenericExceptions("Id is not null", 400);
    }

    public static GenericExceptions idIsNull(){
        return new GenericExceptions("Id is null", 400);
    }

    public static GenericExceptions notFound(Object id){
        return new GenericExceptions(String.format("Record with id %s does not exist", id), 404);
    }
    public static GenericExceptions usernameExists(String username){
        String message = String.format("Record with username %s exists", username);
        return new GenericExceptions(message, 400);
    }

    public static GenericExceptions timeIsWrong() {
        return new GenericExceptions("Please select another time", 400);
    }

    public Integer getStatus() {
        return status;
    }
}
