package com.example.SuperStore.Repository;

import com.example.SuperStore.Model.Aisle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AisleRepository extends JpaRepository<Aisle,Integer> {
}
