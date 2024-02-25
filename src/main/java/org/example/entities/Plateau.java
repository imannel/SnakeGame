package org.example.entities;

import org.example.enums.TypeSegment;

public class Plateau {
    private Segment[][] segments;
    private int nColumn;
    private int nLigne;
    public Plateau(Segment[][] segments, int nLigne, int nColumn) {
        this.segments = segments;
        this.nColumn = nColumn;
        this.nLigne = nLigne;
    }
    public Segment produireAliment(){
        int cln, l;

        do {
            cln = (int)(Math.random() * nColumn);
            l = (int)(Math.random() * nLigne);
        } while (segments[cln][l].getTypeSegment() == TypeSegment.SNACK_NODE);
        Segment s=segments[cln][l];
        segments[cln][l].setTypeSegment(TypeSegment.ALIMENT);
        return s;
        }

    public Segment[][] getSegments() {
        return segments;
    }

    public void setSegments(Segment[][] segments) {
        this.segments = segments;
    }

    public int getnColumn() {
        return nColumn;
    }

    public void setnColumn(int nColumn) {
        this.nColumn = nColumn;
    }

    public int getnLigne() {
        return nLigne;
    }

    public void setnLigne(int nLigne) {
        this.nLigne = nLigne;
    }
}
