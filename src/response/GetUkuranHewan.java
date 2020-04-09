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
public class GetUkuranHewan {
    @SerializedName("error")
    boolean error;
    @SerializedName("message")
    List<UkuranHewanModel> listUkuranHewan;

    public GetUkuranHewan() {
    }

    public GetUkuranHewan(boolean error, List<UkuranHewanModel> listUkuranHewan) {
        this.error = error;
        this.listUkuranHewan = listUkuranHewan;
    }

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    public List<UkuranHewanModel> getListUkuranHewan() {
        return listUkuranHewan;
    }

    public void setListUkuranHewan(List<UkuranHewanModel> listUkuranHewan) {
        this.listUkuranHewan = listUkuranHewan;
    }

    
    
}
