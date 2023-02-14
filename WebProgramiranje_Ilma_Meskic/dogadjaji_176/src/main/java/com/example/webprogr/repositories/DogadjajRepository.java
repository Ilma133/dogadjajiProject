package com.example.webprogr.repositories;

import com.example.webprogr.dto.DodajDogadjajDto;
import com.example.webprogr.models.Lokacija;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.webprogr.models.Dogadjaj;

import java.util.List;

@Repository
public interface DogadjajRepository extends JpaRepository<Dogadjaj, Integer> {
    Dogadjaj findByDogadjajname(String name);


   @Query(value = "select * from Dogadjaj d where d.dogadjajname like %:keyword% or d.datum like %:keyword% ", nativeQuery = true)
   List<Dogadjaj> findByKeyword(@Param("keyword") String keyword);




}
