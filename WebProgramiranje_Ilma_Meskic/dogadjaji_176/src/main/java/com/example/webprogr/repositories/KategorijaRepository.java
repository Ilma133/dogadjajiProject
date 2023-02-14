package com.example.webprogr.repositories;

import com.example.webprogr.models.Lokacija;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.webprogr.models.Kategorija;

import java.util.List;

@Repository
public interface KategorijaRepository extends JpaRepository<Kategorija, Integer> {
    Kategorija findByName(String name);

    @Query(value = "select * from Kategorija k where k.name like %:keyword% ", nativeQuery = true)
    List<Kategorija> findByKeyword(@Param("keyword") String keyword);
}
