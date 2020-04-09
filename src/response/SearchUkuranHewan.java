/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package response;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import model.UkuranHewanModel;

/**
 *
 * @author Smith
 */
public class SearchUkuranHewan {
    @SerializedName("error")
    boolean error;
    @SerializedName("message")
    UkuranHewanModel UkuranHewan;

    public SearchUkuranHewan() {
    }

    public SearchUkuranHewan(boolean error, UkuranHewanModel listUkuranHewan) {
        this.error = error;
        this.UkuranHewan = listUkuranHewan;
    }

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    public UkuranHewanModel getUkuranHewan() {
        return UkuranHewan;
    }

    public void setUkuranHewan(UkuranHewanModel listUkuranHewan) {
        this.UkuranHewan = listUkuranHewan;
    }
    
    
}
