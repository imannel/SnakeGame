package org.example.entities;

import org.example.enums.TypeSegment;

public class Plateau {
    private Segment[][] segments;
    private int width;
    private int height;

    public Plateau(int height, int width) {
        this.segments = new Segment[height][width];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                segments[i][j] = new Segment(TypeSegment.EMPTY, i, j);
            }
        }
    }

    public Plateau(Segment[][] segments, int height, int width) {
        this.segments = segments;
        this.width = width;
        this.height = height;
    }

    public Segment produireAliment() {
        int cln, l;
        do {
            cln = (int) (Math.random() * width);
            l = (int) (Math.random() * height);
        } while (segments[l][cln].getTypeSegment() == TypeSegment.SNACK_NODE);
        Segment s = segments[l][cln];
        segments[l][cln].setTypeSegment(TypeSegment.ALIMENT);
        return s;
    }

    public Segment produireAlimentIndice(int ligne, int colonne) {
        Segment s = segments[ligne][colonne];
        boolean segmentHorsPlateau = ligne < 0 || ligne >= height || colonne < 0 || colonne >= width;
        if (segmentHorsPlateau || segments[ligne][colonne].getTypeSegment() == TypeSegment.SNACK_NODE) {
            segments[ligne][colonne].setTypeSegment(TypeSegment.ALIMENT);
        }
        return s;
    }

    public Segment[][] getSegments() {
        return segments;
    }

    public void setSegments(Segment[][] segments) {
        this.segments = segments;
    }

    public int getWidth() {
        return width;
    }



    public int getHeight() {
        return height;
    }


}
