package com.example.doolhof.repository;

import com.example.doolhof.domeinen.Tile;
import com.example.doolhof.domeinen.Treasure;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface TreasureRepository extends JpaRepository<Treasure, UUID> {
}
