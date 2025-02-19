package com.getarrays.employeemanager.exception;

//public class UserNotFoundException extends @org.jetbrains.annotations.NotNull X {
//    public UserNotFoundException(String s, Object p1, String s1) {
//    }
//}


public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(String message) {
        super(message);
    }
}