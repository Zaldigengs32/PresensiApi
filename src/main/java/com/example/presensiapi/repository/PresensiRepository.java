package com.example.presensiapi.repository;

import com.example.presensiapi.model.Presensi;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PresensiRepository extends JpaRepository<Presensi, Long> {
    Page<Presensi> findByNimMhs(String nimMhs, Pageable pageable);
}
