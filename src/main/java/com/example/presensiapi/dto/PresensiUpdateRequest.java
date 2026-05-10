package com.example.presensiapi.dto;

@SuppressWarnings("unused")
public class PresensiUpdateRequest {
    private String status;
    private String jamPresensi;

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public String getJamPresensi() { return jamPresensi; }
    public void setJamPresensi(String jamPresensi) { this.jamPresensi = jamPresensi; }
}
