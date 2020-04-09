/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import com.google.gson.annotations.SerializedName;

/**
 *
 * @author Smith
 */
public class UkuranHewanModel {
    @SerializedName("id_ukuran_hewan")
    int id_ukuran_hewan;
    @SerializedName("nama")
    String nama;
    @SerializedName("created_at")
    String created_at;
    @SerializedName("created_by")
    String created_by;
    @SerializedName("modified_at")
    String modified_at;
    @SerializedName("modified_by")
    String modified_by;
    @SerializedName("delete_at")
    String delete_at;
    @SerializedName("delete_by")
    String delete_by;
    @SerializedName("aktif")
    String aktif;
   
    public UkuranHewanModel(){}

    public UkuranHewanModel(int id_ukuran_hewan, String nama, String created_at, String created_by, String modified_at, String modified_by, String delete_at, String delete_by, String aktif) {
        this.id_ukuran_hewan = id_ukuran_hewan;
        this.nama = nama;
        this.created_at = created_at;
        this.created_by = created_by;
        this.modified_at = modified_at;
        this.modified_by = modified_by;
        this.delete_at = delete_at;
        this.delete_by = delete_by;
        this.aktif = aktif;
    }

    public int getId_ukuran_hewan() {
        return id_ukuran_hewan;
    }

    public void setId_ukuran_hewan(int id_ukuran_hewan) {
        this.id_ukuran_hewan = id_ukuran_hewan;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getCreated_by() {
        return created_by;
    }

    public void setCreated_by(String created_by) {
        this.created_by = created_by;
    }

    public String getModified_at() {
        return modified_at;
    }

    public void setModified_at(String modified_at) {
        this.modified_at = modified_at;
    }

    public String getModified_by() {
        return modified_by;
    }

    public void setModified_by(String modified_by) {
        this.modified_by = modified_by;
    }

    public String getDelete_at() {
        return delete_at;
    }

    public void setDelete_at(String delete_at) {
        this.delete_at = delete_at;
    }

    public String getDelete_by() {
        return delete_by;
    }

    public void setDelete_by(String delete_by) {
        this.delete_by = delete_by;
    }

    public String getAktif() {
        return aktif;
    }

    public void setAktif(String aktif) {
        this.aktif = aktif;
    }
    
    
}
