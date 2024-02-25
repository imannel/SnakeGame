package org.example.entities;

import org.example.enums.TypeSegment;

public class Segment {
    private TypeSegment typeSegment;
    private int ligne;
    private int colonne;

    public Segment(TypeSegment typeSegment, int ligne, int colonne) {
        this.typeSegment = typeSegment;
        this.ligne = ligne;
        this.colonne = colonne;
    }
    public TypeSegment getTypeSegment() {
        return typeSegment;
    }

    public void setTypeSegment(TypeSegment typeSegment) {
        this.typeSegment = typeSegment;
    }

    public int getLigne() {
        return ligne;
    }

    public int getColonne() {
        return colonne;
    }



}
