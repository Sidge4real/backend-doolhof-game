package com.example.doolhof.service;

import com.example.doolhof.domeinen.Path;
import com.example.doolhof.domeinen.Tile;
import com.example.doolhof.domeinen.Treasure;
import com.example.doolhof.repository.TreasureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

// Service class to handle the creation of Tile objects
@Component
public class TileService {

    private final TreasureRepository treasureRepository;
    private List<Point> coordinates = new ArrayList<>();
    private final Random random = new Random();

    @Autowired
    public TileService(TreasureRepository treasureRepository) {
        this.treasureRepository = treasureRepository;
        addManualCoordinates();
    }

    public void reset(){
        addManualCoordinates();
    }

    public boolean checkup(){
        if(coordinates.size() != 0){
            return false;
        }
        return true;
    }

    // Methode om handmatig coördinaten toe te voegen
    private void addManualCoordinates() {
        coordinates.add(new Point(0, 1));
        coordinates.add(new Point(0, 3));
        coordinates.add(new Point(0, 5));
        coordinates.add(new Point(1, 0));
        coordinates.add(new Point(1, 1));
        coordinates.add(new Point(1, 2));
        coordinates.add(new Point(1, 3));
        coordinates.add(new Point(1, 4));
        coordinates.add(new Point(1, 5));
        coordinates.add(new Point(1, 6));
        coordinates.add(new Point(2, 1));
        coordinates.add(new Point(2, 3));
        coordinates.add(new Point(2, 5));
        coordinates.add(new Point(3, 0));
        coordinates.add(new Point(3, 1));
        coordinates.add(new Point(3, 2));
        coordinates.add(new Point(3, 3));
        coordinates.add(new Point(3, 4));
        coordinates.add(new Point(3, 5));
        coordinates.add(new Point(3, 6));
        coordinates.add(new Point(4, 1));
        coordinates.add(new Point(4, 3));
        coordinates.add(new Point(4, 5));
        coordinates.add(new Point(5, 0));
        coordinates.add(new Point(5, 1));
        coordinates.add(new Point(5, 2));
        coordinates.add(new Point(5, 3));
        coordinates.add(new Point(5, 4));
        coordinates.add(new Point(5, 5));
        coordinates.add(new Point(5, 6));
        coordinates.add(new Point(6, 1));
        coordinates.add(new Point(6, 3));
        coordinates.add(new Point(6, 5));
    }

    // Method to add tiles to the game board
    public List<Tile> createTiles() {
        List<Tile> tiles = new ArrayList<>();
        List<Treasure> treasures = treasureRepository.findAll();

        // Add CROSSPOINT tiles
        addCrosspointTiles(tiles, treasures);

        // Add CORNER tiles
        addCornerTiles(tiles, treasures);

        // Add STRAIGHT tiles
        addStraightTiles(tiles);

        return tiles;
    }

    private Point getRandomCoordinate() {
        int randomIndex = random.nextInt(coordinates.size());
        Point point = coordinates.get(randomIndex);
        coordinates.remove(randomIndex);
        return point;
    }

    private boolean[] generateRandomWalls(Path path) {
        boolean[][] configurations;

        switch (path) {
            case CROSSPOINT:
                configurations = new boolean[][]{{true, false, false, false}};
                shuffleArray(configurations[0]);
                break;
            case CORNER:
                configurations = new boolean[][]{
                        {true, false, true, false},
                        {false, true, true, false},
                        {false, true, false, true},
                        {true, false, false, true}
                };
                break;
            case STRAIGHT:
                configurations = new boolean[][]{
                        {true, true, false, false},
                        {false, false, true, true}
                };
                break;
            default:
                throw new IllegalArgumentException("Unsupported path type: " + path);
        }

        return configurations[random.nextInt(configurations.length)];
    }

    // Methode om een array te schudden
    private void shuffleArray(boolean[] array) {
        for (int i = array.length - 1; i > 0; i--) {
            int index = random.nextInt(i + 1);
            // Verwissel array[i] met het element op index
            boolean temp = array[i];
            array[i] = array[index];
            array[index] = temp;
        }
    }


    private void addCrosspointTiles(List<Tile> tiles, List<Treasure> treasures) {
        tiles.add(createTile(Path.CROSSPOINT, false, false, true, false, 2, 0, treasures.get(0)));
        tiles.add(createTile(Path.CROSSPOINT, false, false, true, false, 4, 0, treasures.get(1)));
        tiles.add(createTile(Path.CROSSPOINT, true, false, false, false, 0, 2, treasures.get(2)));
        tiles.add(createTile(Path.CROSSPOINT, true, false, false, false, 2, 2, treasures.get(3)));
        tiles.add(createTile(Path.CROSSPOINT, false, false, true, false, 4, 2, treasures.get(4)));
        tiles.add(createTile(Path.CROSSPOINT, false, true, false, false, 6, 2, treasures.get(5)));
        tiles.add(createTile(Path.CROSSPOINT, true, false, false, false, 2, 4, treasures.get(6)));
        tiles.add(createTile(Path.CROSSPOINT, false, false, true, false, 4, 4, treasures.get(7)));
        tiles.add(createTile(Path.CROSSPOINT, false, true, false, false, 6, 4, treasures.get(8)));
        tiles.add(createTile(Path.CROSSPOINT, false, false, false, true, 2, 6, treasures.get(9)));
        tiles.add(createTile(Path.CROSSPOINT, false, false, false, true, 4, 6, treasures.get(10)));
        tiles.add(createTile(Path.CROSSPOINT, true, false, false, false, 0, 4, treasures.get(11)));
        for (int i = 18; i <= 23; i++) {
            // Kies een willekeurig coördinaat uit de lijst
            Point point = getRandomCoordinate();
            boolean[] walls = generateRandomWalls(Path.CROSSPOINT);
            tiles.add(createTile(Path.CROSSPOINT, walls[0], walls[1], walls[2], walls[3], point.x, point.y, treasures.get(i)));
        }
    }

    private void addCornerTiles(List<Tile> tiles, List<Treasure> treasures) {
        tiles.add(createTile(Path.CORNER, true, false, true, false, 0, 0, null));
        tiles.add(createTile(Path.CORNER, true, false, false, true, 0, 7, null));
        tiles.add(createTile(Path.CORNER, false, true, true, false, 7, 0, null));
        tiles.add(createTile(Path.CORNER, false, true, false, true, 7, 7, null));
        // doe het zelfde voor deze tegels
        for (int i = 12; i <= 17; i++) {
            Point point = getRandomCoordinate();
            boolean[] walls = generateRandomWalls(Path.CORNER);
            tiles.add(createTile(Path.CORNER, walls[0], walls[1], walls[2], walls[3], point.x, point.y, treasures.get(i)));
            // tiles.add(createTile(Path.CORNER, true, false, true, false, -1, -1, treasures.get(i)));
        }
        for (int i = 0; i < 11; i++) {
            Point point = getRandomCoordinate();
            boolean[] walls = generateRandomWalls(Path.CORNER);
            tiles.add(createTile(Path.CORNER, walls[0], walls[1], walls[2], walls[3], point.x, point.y, null));
            //tiles.add(createTile(Path.CORNER, true, false, true, false, -1, -1, null));
        }
    }

    private void addStraightTiles(List<Tile> tiles) {
        for (int i = 0; i < 12; i++) {
            Point point = getRandomCoordinate();
            boolean[] walls = generateRandomWalls(Path.STRAIGHT);
            tiles.add(createTile(Path.STRAIGHT, walls[0], walls[1], walls[2], walls[3], point.x, point.y, null));
            // tiles.add(createTile(Path.STRAIGHT, false, false, true, true, -1, -1, null));
        }
    }

    private Tile createTile(Path path, boolean isWallLeft, boolean isWallRight, boolean isWallTop, boolean isWallBottom, int posX, int posY, Treasure treasure) {
        Tile tile = new Tile();
        tile.setPath(path);
        tile.setWallLeft(isWallLeft);
        tile.setWallRight(isWallRight);
        tile.setWallTop(isWallTop);
        tile.setWallBottom(isWallBottom);
        tile.setPositionX(posX);
        tile.setPositionY(posY);
        tile.setTreasure(treasure);
        return tile;
    }


}

    /*
    (0,1)
(0,3)
(0,5)
(1,0)
(1,1)
(1,2)
(1,3)
(1,4)
(1,5)
(1,6)
(2,1)
(2,3)
(2,5)
(3,0)
(3,1)
(3,2)
(3,3)
(3,4)
(3,5)
(3,6)
(4,1)
(4,3)
(4,5)
(5,0)
(5,1)
(5,2)
(5,3)
(5,4)
(5,5)
(5,6)
(6,1)
(6,3)
(6,5)

    * */
