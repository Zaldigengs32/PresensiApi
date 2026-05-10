package com.example.presensiapi.model;

import jakarta.persistence.*;

@Entity
@Table(name = "mahasiswa")
public class Mahasiswa {
    @Id
    @Column(name = "nim_mhs")
    private String nimMhs;

    @Column(name = "nama_mhs")
    private String namaMhs;

    @Column(name = "foto_mhs", columnDefinition = "BLOB")
    private byte[] fotoMhs;

    public String getNimMhs() { return nimMhs; }

    public void setNimMhs(String nimMhs) { this.nimMhs = nimMhs; }

    public String getNamaMhs() { return namaMhs; }

    public void setNamaMhs(String namaMhs) { this.namaMhs = namaMhs; }

    public byte[] getFotoMhs() { return fotoMhs; }

    public void setFotoMhs(byte[] fotoMhs) { this.fotoMhs = fotoMhs; }
}
