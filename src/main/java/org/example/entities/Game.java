package org.example.entities;

import org.example.enums.Direction;
import org.example.enums.TypeSegment;

import java.util.ArrayList;

public class Game {

    // private int gamePaste = 1000;
    private Snake snake;
    private Plateau plateau;
    private Direction direction = Direction.LEFT;

    public Game(Plateau plateau) {
        this.plateau = plateau;
    }

    public Game(int plateauHeight, int plateauWidth, int snakeSize) {
        this.plateau = new Plateau(plateauHeight, plateauWidth);
        this.snake = new Snake(snakeSize,plateauHeight,plateauWidth);
         plateau.produireAliment();
    }
    public Game(int plateauHeight, int plateauWidth) {
        this.plateau = new Plateau(plateauHeight, plateauWidth);
    }


    public Snake getSnake() {
        return snake;
    }

    public void setSnake(Snake snake) {
        this.snake = snake;
    }

    public Plateau getPlateau() {
        return plateau;
    }

    public void setPlateau(Plateau plateau) {
        this.plateau = plateau;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public void startGame() {
        // Check initialization
        // each 1000 ms execute the function that will move the snake in the last given direction
        // 1. listen to user direction getUserDirection()
        // 2. move snake moveSnake()
        // 3. check game state
    }

    public void move(Direction direction) {
        if (direction.opposite() == this.direction) {
            return;
        }

        this.direction = direction;
        switch (direction) {
            case LEFT:
                snake.moveLeft();
                break;
            case RIGHT:
                snake.moveRight();
                break;
            case UP:
                snake.moveUp();
                break;
            case DOWN:
                snake.moveDown();
                break;

        }

    }

    public boolean checkSnackCollision() {
        ArrayList<Segment> segments = snake.getSnakeList();
        Segment headSegments=segments.get(segments.size() -1);
        int c=headSegments.getColonne();
        int l=headSegments.getLigne();
        for (int i = 0; i < segments.size() - 1; i++) {
            Segment segment=segments.get(i);
            if (segment.getLigne() == headSegments.getLigne()&&segment.getColonne()==headSegments.getColonne()) {
               return true;
            }
        }
        return false;
    }
    public boolean checkBorderCollision() {
        ArrayList<Segment> segments = snake.getSnakeList();
        Segment headSegment = segments.get(segments.size() - 1);
        int l = headSegment.getLigne();
        int c = headSegment.getColonne();


        if (l < 0 || l>= plateau.getHeight() || c < 0 || c>= plateau.getWidth()) {
            return true;
        }
        return false;
    }

    public boolean isGameOver() {
        return checkSnackCollision() || checkSnackCollision();
    }

    }


