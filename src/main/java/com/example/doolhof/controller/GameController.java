package com.example.doolhof.controller;

import com.example.doolhof.controller.request.InviteRequest;
import com.example.doolhof.controller.request.AcceptInviteRequest;
import com.example.doolhof.domeinen.Game;
import com.example.doolhof.exception.NotAuthorizedException;
import com.example.doolhof.exception.NotFoundException;
import com.example.doolhof.service.GameService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("api/games")
public class GameController {
    private final GameService gameService;

    public GameController(GameService gameService) {
        this.gameService = gameService;
    }


    @GetMapping("/{game_id}")
    public ResponseEntity<Game> getGame(@PathVariable UUID game_id) {
        try {
            Game game = gameService.getGame(game_id).get();
            return ResponseEntity.ok(game);
        } catch (NotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PostMapping("/{player_id}")
    public ResponseEntity<Game> createGame(@PathVariable UUID player_id) {
        try {
            Game game = gameService.createGame(player_id);
            return ResponseEntity.ok(game);

        } catch (NotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @DeleteMapping("/{game_id}")
    public ResponseEntity<Void> deleteGame(@PathVariable UUID game_id) {
        try {
            gameService.deleteGame(game_id);
        } catch (NotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }


    //-Speler 1 gaat uitnodiging sturen naar speler 2 om zijn spel deel te nemen
    //-Hieronder endpoint zal uitgevoerd worden wanneer speler 1 op een knop uitnodigen drukt
    // met meegegeven naam van een speler die hij wenst deel te nemen.

    //-Out of the scope: In deze endpoint mail service gebruiken. Mail verzenden naar uitgenodigde
    // om te laten weten dat hij een uitnodiging kreeg van Speler 1.

    //-Uitgenodigde moet ingelogd zijn wanneer hij een uitnodiging krijgt want als uitgenodigde niet
    // bestaat zal de uitnodiging ook niet kunnen gestuurd worden.
    // Hij zal naar uitnodiging pagina moeten navigeren en zal een lijst van uitnodiging zien
    // in de frontend. Hij kan al dan niet accepteren.
    @PutMapping("/{game_id}")
    public ResponseEntity<Game> invitePlayerToGame(@PathVariable UUID game_id, @RequestBody InviteRequest player) {
        try {
            gameService.invitePlayer(game_id, player.getSenderId(), player.getName());
        } catch (NotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @PutMapping("{player_id}/accept_invite")
    public ResponseEntity<Game> acceptGameInvite(@PathVariable UUID player_id, @RequestBody UUID game_id) {
        try {
            return ResponseEntity.ok(gameService.acceptInvite(game_id, player_id));
        } catch (NotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }


    @PutMapping("{game_id}/start")
    public ResponseEntity<Game> startGame(@PathVariable UUID game_id, @RequestBody UUID player_id) {
        try {
            return ResponseEntity.ok(gameService.startGame(game_id, player_id));
        } catch (NotAuthorizedException e) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
        } catch (NotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }



    /*
    @PutMapping("{game_id}/step")
    public ResponseEntity<Game> playerTakesAction(@PathVariable UUID game_id, @RequestBody PlayerActionRequest playerAction) {
        try {
            gameService.takeAStep(game_id, playerAction.getPlayerId(), playerAction.getSteps());
        }
    }
*/


}
