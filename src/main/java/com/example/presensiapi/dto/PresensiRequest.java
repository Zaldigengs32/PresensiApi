package com.example.presensiapi.dto;

@SuppressWarnings("unused")
public class PresensiRequest {
    private String kodeMk;
    private String course;
    private String date;
    private String jamPresensi;
    private Integer pertemuanKe;
    private String status;
    private String nimMhs;
    private String ruangan;
    private String dosenPengampu;

    public String getKodeMk() { return kodeMk; }
    public void setKodeMk(String kodeMk) { this.kodeMk = kodeMk; }

    public String getCourse() { return course; }
    public void setCourse(String course) { this.course = course; }

    public String getDate() { return date; }
    public void setDate(String date) { this.date = date; }

    public String getJamPresensi() { return jamPresensi; }
    public void setJamPresensi(String jamPresensi) { this.jamPresensi = jamPresensi; }

    public Integer getPertemuanKe() { return pertemuanKe; }
    public void setPertemuanKe(Integer pertemuanKe) { this.pertemuanKe = pertemuanKe; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public String getNimMhs() { return nimMhs; }
    public void setNimMhs(String nimMhs) { this.nimMhs = nimMhs; }

    public String getRuangan() { return ruangan; }
    public void setRuangan(String ruangan) { this.ruangan = ruangan; }

    public String getDosenPengampu() { return dosenPengampu; }
    public void setDosenPengampu(String dosenPengampu) { this.dosenPengampu = dosenPengampu; }
}
