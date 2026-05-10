package com.example.presensiapi.config;

import com.example.presensiapi.model.Presensi;
import com.example.presensiapi.model.User;
import com.example.presensiapi.repository.PresensiRepository;
import com.example.presensiapi.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Component
public class DatabaseSeeder implements CommandLineRunner {

    private static final Logger logger = LoggerFactory.getLogger(DatabaseSeeder.class);
    private static final String PRESENT_STATUS = "Present";
    private static final Random random = new Random();

    private final PresensiRepository repository;
    private final UserRepository userRepository;

    public DatabaseSeeder(PresensiRepository repository, UserRepository userRepository) {
        this.repository = repository;
        this.userRepository = userRepository;
    }

    @Override
    @SuppressWarnings("NullableProblems")
    public void run(String... args) {
        if (repository.count() == 0) {
            logger.info("Tabel Presensi kosong. Sedang men-generate 200 data dummy...");

            List<Presensi> dummyDataList = new ArrayList<>();

            String[] namaMk = {"Mobile Programming", "Web Programming", "Database System",
                    "Computer Network", "Software Engineering"};
            String[] kodeMk = {"TRPL205", "TRPL201", "TRPL203", "TRPL204", "TRPL202"};

            String[] dosenList = {"Bpk. Budi", "Ibu Rina", "Bpk. Andi", "Ibu Siti", "Bpk. Joko"};

            String[] statusOpsi = {PRESENT_STATUS, PRESENT_STATUS, PRESENT_STATUS, PRESENT_STATUS, PRESENT_STATUS,
                    PRESENT_STATUS, "Absent", "Absent", "Late"};

            LocalDate startDate = LocalDate.of(2026, 2, 1);

            for (int i = 1; i <= 200; i++) {
                Presensi p = new Presensi();

                int mkIndex = random.nextInt(namaMk.length);
                p.setKodeMk(kodeMk[mkIndex]);
                p.setCourse(namaMk[mkIndex]);

                startDate = startDate.plusDays(random.nextInt(3));
                p.setDate(startDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));

                int jam = 7 + random.nextInt(8);
                int menit = random.nextInt(60);
                int detik = random.nextInt(60);
                LocalTime randomTime = LocalTime.of(jam, menit, detik);
                p.setJamPresensi(randomTime.format(DateTimeFormatter.ofPattern("HH:mm:ss")));

                p.setPertemuanKe((i % 14) + 1);

                p.setStatus(statusOpsi[random.nextInt(statusOpsi.length)]);

                p.setNimMhs("0325260031");

                p.setRuangan("Lab Komputer " + (random.nextInt(3) + 1));

                p.setDosenPengampu(dosenList[mkIndex]);

                dummyDataList.add(p);
            }

            repository.saveAll(dummyDataList);

            logger.info("Berhasil menyimpan 200 data dummy ke database SQLite!");
        } else {
            logger.info("Data presensi sudah ada, lewati proses Seeding.");
        }

        if (userRepository.count() == 0) {
            logger.info("Tabel User kosong. Generate data user...");

            List<User> users = new ArrayList<>();

            User u = new User();
            u.setMhsNim("0325260031");
            u.setPassword("123456");
            u.setMhsName("Hanif");
            u.setProdi("Manajemen Informatika");

            users.add(u);

            userRepository.saveAll(users);

            logger.info("User berhasil ditambahkan!");
        }
    }
}
