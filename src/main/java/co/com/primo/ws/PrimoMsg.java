/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.primo.ws;

/**
 *
 * @author OvalleGA
 */
public class PrimoMsg {
    private Object message_object;
    private boolean succes;
    private String response;
    
    public Object getMessage_object() {
        return message_object;
    }

    public void setMessage_object(Object message_object) {
        this.message_object = message_object;
    }

    public boolean isSucces() {
        return succes;
    }

    public void setSucces(boolean succes) {
        this.succes = succes;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }
    
    
}
