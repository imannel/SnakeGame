package org.example.entities;

import org.example.enums.Direction;
import org.example.enums.TypeSegment;

import java.util.ArrayList;

public class Game {
    private Snake snake;
    private Plateau plateau;
    private Direction direction;

    private boolean gameOver = false;

    public Game(Plateau plateau) {


        this.plateau = plateau;

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

    public boolean isGameOver() {
        return gameOver;
    }

    public void startGame() {

       Segment[][] segments=plateau.getSegments();
        for(int i=0;i<plateau.getnLigne();i++){
            for(int j=0;j< plateau.getnColumn();j++){
             segments[i][j]=new Segment(TypeSegment.EMPTY, i, j);
            }
        }
        int cln = (int) (Math.random() * 10);
        int ligne = (int) (Math.random() * 7);
        snake = new Snake(new Segment(TypeSegment.SNACK_NODE, cln, ligne));
        direction = Direction.LEFT;
        plateau.produireAliment();
    }

    public void endGame() {
        gameOver = true;
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
        if(checkBorderCollision() ||  checkSnackCollision()){
            endGame();

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


        if (l < 0 || l >= plateau.getnLigne() || c < 0 || c >= plateau.getnColumn()) {
            return true;
        }
        return false;
    }







}
