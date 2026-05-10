package com.example.presensiapi.controller;

import com.example.presensiapi.dto.PageResponse;
import com.example.presensiapi.dto.PresensiRequest;
import com.example.presensiapi.dto.PresensiUpdateRequest;
import com.example.presensiapi.model.Presensi;
import com.example.presensiapi.repository.PresensiRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/presensi")
@CrossOrigin(origins = "*")
public class PresensiController {

    private final PresensiRepository repository;

    public PresensiController(PresensiRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/history/{nim}")
    public PageResponse<Presensi> getHistory(
            @PathVariable String nim,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {

        Pageable pageable = PageRequest.of(page, size, Sort.by("id").descending());
        Page<Presensi> pageResult = repository.findByNimMhs(nim, pageable);

        return new PageResponse<>(
                pageResult.getContent(),
                pageResult.getNumber(),
                pageResult.getSize(),
                pageResult.getTotalElements(),
                pageResult.getTotalPages(),
                pageResult.isFirst(),
                pageResult.isLast()
        );
    }

    @PostMapping
    public Presensi savePresensi(@RequestBody PresensiRequest request) {
        Presensi presensi = new Presensi();
        presensi.setKodeMk(request.getKodeMk());
        presensi.setCourse(request.getCourse());
        presensi.setDate(request.getDate());
        presensi.setJamPresensi(request.getJamPresensi());
        presensi.setPertemuanKe(request.getPertemuanKe());
        presensi.setStatus(request.getStatus());
        presensi.setNimMhs(request.getNimMhs());
        presensi.setRuangan(request.getRuangan());
        presensi.setDosenPengampu(request.getDosenPengampu());

        return repository.save(presensi);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Presensi> updatePresensi(@PathVariable Long id, @RequestBody PresensiUpdateRequest request) {
        return repository.findById(id).map(p -> {
            p.setStatus(request.getStatus());
            p.setJamPresensi(request.getJamPresensi());
            return ResponseEntity.ok(repository.save(p));
        }).orElse(ResponseEntity.notFound().build());
    }
}
