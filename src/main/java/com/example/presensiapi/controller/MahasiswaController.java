package com.example.presensiapi.controller;

import com.example.presensiapi.model.Mahasiswa;
import com.example.presensiapi.repository.MahasiswaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Optional;

@RestController
@RequestMapping("/api/mahasiswa")
@CrossOrigin(origins = "*")
public class MahasiswaController {

    private final MahasiswaRepository repository;

    public MahasiswaController(MahasiswaRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/{nim}")
    public ResponseEntity<Object> getMahasiswa(@PathVariable String nim) {
        Optional<Mahasiswa> mahasiswa = repository.findById(nim);
        return mahasiswa.<ResponseEntity<Object>>map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(404)
                        .body("Error: Data mahasiswa dengan NIM " + nim + " tidak ditemukan dalam database"));
    }

    @PostMapping("/upload")
    public ResponseEntity<String> uploadProfile(
            @RequestParam("nim") String nim,
            @RequestParam("nama") String nama,
            @RequestParam("foto") MultipartFile file) {

        if (file.isEmpty()) {
            return ResponseEntity.badRequest().body("Error: File foto tidak boleh kosong");
        }

        String contentType = file.getContentType();
        if (contentType == null || !contentType.startsWith("image/")) {
            return ResponseEntity.badRequest().body("Error: File harus berupa gambar (JPEG, PNG, dll)");
        }

        if (file.getSize() > 5 * 1024 * 1024) {
            return ResponseEntity.badRequest().body("Error: Ukuran file terlalu besar. Maksimal 5MB.");
        }

        if (nim == null || nim.trim().isEmpty()) {
            return ResponseEntity.badRequest().body("Error: NIM tidak boleh kosong");
        }
        if (nama == null || nama.trim().isEmpty()) {
            return ResponseEntity.badRequest().body("Error: Nama tidak boleh kosong");
        }

        try {
            Mahasiswa mhs = repository.findById(nim).orElse(new Mahasiswa());
            mhs.setNimMhs(nim.trim());
            mhs.setNamaMhs(nama.trim());
            mhs.setFotoMhs(file.getBytes());

            repository.save(mhs);
            return ResponseEntity.ok("Data mahasiswa dengan NIM " + nim + " berhasil diperbarui");
        } catch (Exception e) {
            return ResponseEntity.internalServerError()
                    .body("Error: Gagal menyimpan data - " + e.getMessage());
        }
    }
}
