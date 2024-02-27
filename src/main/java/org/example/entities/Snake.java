package org.example.entities;

import org.example.enums.Direction;
import org.example.enums.TypeSegment;

import java.util.ArrayList;
import java.util.Random;

public class Snake {
    private ArrayList<Segment> snakeList = new ArrayList<>();


    public ArrayList<Segment> getSnakeList() {
        return snakeList;
    }

    // this constructor is for tests
    public Snake(int size,int height,int width) {
        ArrayList<Segment> snakeList = new ArrayList<>();
        Random random = new Random();
        int headX = random.nextInt(width);
        int headY = random.nextInt(height);
        // Initiate a random snake with the exact size
        Direction[] directions = Direction.values();
        Direction currentDirection = directions[random.nextInt(directions.length)];
       for(int i=0;i<size;i++){
           switch (currentDirection) {
               case UP:
                   headY--;
                   break;
               case DOWN:
                   headY++;
                   break;
               case LEFT:
                   headX--;
                   break;
               case RIGHT:
                   headX++;
                   break;
           }
           headX = (headX + width) % width;
           headY = (headY + height) % height;
           snakeList.add(new Segment(TypeSegment.SNACK_NODE, headX, headY));

       }
    }

    public Snake(Segment segment){
        segment.setTypeSegment(TypeSegment.SNACK_NODE);
        snakeList.add(segment);
    }
    public ArrayList<Segment> add(Segment s){

      snakeList.add(s);
      return snakeList;

    }

    public void moveRight() {

        Segment headSegment = snakeList.get(snakeList.size() - 1);
        int colonne = headSegment.getColonne();
        int ligne = headSegment.getLigne();
        snakeList.add(new Segment(TypeSegment.SNACK_NODE, ligne, colonne + 1));
        snakeList.remove(0);



    }
    public void moveUp() {
        Segment headSegment = snakeList.get(snakeList.size() - 1);
        int currentCol = headSegment.getColonne();
        int currentRow = headSegment.getLigne();
        snakeList.add(new Segment(TypeSegment.SNACK_NODE, currentRow - 1, currentCol));
        snakeList.remove(0);
    }

    public void moveDown() {
        Segment headSegment = snakeList.get(snakeList.size() - 1);
        int currentCol = headSegment.getColonne();
        int currentRow = headSegment.getLigne();
        Segment segment=new Segment(TypeSegment.SNACK_NODE, currentRow + 1, currentCol);
        snakeList.add(segment);
        snakeList.remove(0);

    }

    public void moveLeft() {
        Segment headSegment = snakeList.get(snakeList.size() - 1);
        int currentCol = headSegment.getColonne();
        int currentRow = headSegment.getLigne();
        snakeList.add(new Segment(TypeSegment.SNACK_NODE, currentRow, currentCol - 1));
        snakeList.remove(0);
    }
    public ArrayList<Segment> grow(Segment segment){
        snakeList.add(segment);
        segment.setTypeSegment(TypeSegment.SNACK_NODE);
        return snakeList;
    }


}
