/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package response;

import com.google.gson.annotations.SerializedName;

/**
 *
 * @author Smith
 */
public class PostUpdateDelete {
    @SerializedName("error")
    boolean error;
    @SerializedName("message")
    String message;

    public PostUpdateDelete() {
    }

    public PostUpdateDelete(boolean error, String message) {
        this.error = error;
        this.message = message;
    }

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    
    
    
}
