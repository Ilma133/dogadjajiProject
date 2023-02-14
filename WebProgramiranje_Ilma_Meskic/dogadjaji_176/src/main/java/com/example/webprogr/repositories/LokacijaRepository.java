package com.example.webprogr.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.webprogr.models.Lokacija;

import java.util.List;

@Repository
public interface LokacijaRepository extends JpaRepository<Lokacija, Integer> {
    Lokacija findByName(String name);

@Query(value = "select * from Lokacija l where l.name like %:keyword% ", nativeQuery = true)
    List<Lokacija> findByKeyword(@Param("keyword") String keyword);
}
