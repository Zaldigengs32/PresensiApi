package com.example.presensiapi.repository;

import com.example.presensiapi.model.Mahasiswa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MahasiswaRepository extends JpaRepository<Mahasiswa, String> {
}
