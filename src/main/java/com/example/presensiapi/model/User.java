package com.example.presensiapi.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
@SuppressWarnings("unused")
public class User {
    @Id
    private String mhsNim;
    private String password;
    private String mhsName;
    private String prodi;

    public String getMhsNim() {
        return mhsNim;
    }

    public void setMhsNim(String mhsNim) {
        this.mhsNim = mhsNim;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMhsName() {
        return mhsName;
    }

    public void setMhsName(String mhsName) {
        this.mhsName = mhsName;
    }

    public String getProdi() {
        return prodi;
    }

    public void setProdi(String prodi) {
        this.prodi = prodi;
    }
}
