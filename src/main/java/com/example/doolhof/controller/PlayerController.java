package com.example.doolhof.controller;

import com.example.doolhof.domeinen.Player;
import com.example.doolhof.exception.AlreadyExistException;
import com.example.doolhof.exception.NotFoundException;
import com.example.doolhof.service.PlayerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.Set;
import java.util.UUID;

@RestController
@RequestMapping("api/players")
public class PlayerController {
    private final PlayerService playerService;

    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @GetMapping("/{player_Id}")
    public ResponseEntity<Player> getPlayer(@PathVariable UUID player_Id) {
        Player player = playerService.getPlayer(player_Id).orElse(null);
        return ResponseEntity.ok(player);
    }

    @PostMapping("/log_in")
    public ResponseEntity<Player> addPlayer(@RequestBody Player player) {
        try {
            Player savedPlayer = playerService.addPlayer(player);
            return ResponseEntity.status(HttpStatus.CREATED).body(savedPlayer);
        } catch (AlreadyExistException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removePlayer(@PathVariable UUID id) {
        try {
            playerService.removePlayer(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }catch (NotFoundException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updatePlayer(@RequestBody Player player){
        try{
            playerService.updatePlayer(player);

        }catch (NotFoundException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @GetMapping("/test")
    public ResponseEntity<String> test() {
        return ResponseEntity.ok("test");
    }

    @GetMapping("/{player_Id}/invites")
    public  ResponseEntity<Set<String>> getInvites(@PathVariable UUID player_Id) {
        try{
            return ResponseEntity.ok(playerService.getInvites(player_Id));
        }catch(NotFoundException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

    }
}
