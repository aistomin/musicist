package com.github.aistomin.musicist.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by aistomin on 11.05.17.
 *
 * Fretboard representation.
 */
public final class Fretboard {

    /**
     * The matrix which represents the frets + strings. Rows are strings and
     * columns are frets. Value of the column #0 is the open string sound. The
     * other columns are corresponding string/fret sound.
     */
    private final List<List<Note>> frets;

    /**
     * Ctor.
     */
    public Fretboard() {
        frets = new ArrayList<>();
    }

    /**
     * The matrix which represents the frets + strings. Rows are strings and
     * columns are frets. Value of the column #0 is the open string sound. The
     * other columns are corresponding string/fret sound.
     * @return Matrix.
     */
    public List<List<Note>> getFrets() {
        return frets;
    }
}
