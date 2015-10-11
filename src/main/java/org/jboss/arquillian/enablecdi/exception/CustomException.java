package org.jboss.arquillian.enablecdi.exception;

/**
 * Created by pestano on 11/10/15.
 */
public class CustomException extends RuntimeException {


    public CustomException(){

    }

    public CustomException(String msg){
        super(msg);
    }
}
