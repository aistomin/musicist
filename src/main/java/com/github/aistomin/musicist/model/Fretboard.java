package com.github.aistomin.musicist.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by aistomin on 11.05.17.
 * <p>
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
        final ArrayList<Note> first = new ArrayList<>();
        first.add(Note.E);
        first.add(Note.F);
        first.add(Note.F_SHARP);
        first.add(Note.G);
        first.add(Note.G_SHARP);
        first.add(Note.A);
        first.add(Note.A_SHARP);
        first.add(Note.B);
        first.add(Note.C);
        first.add(Note.C_SHARP);
        first.add(Note.D);
        first.add(Note.D_SHARP);
        first.add(Note.E);
        frets.add(first);
        final ArrayList<Note> second = new ArrayList<>();
        second.add(Note.B);
        second.add(Note.C);
        second.add(Note.C_SHARP);
        second.add(Note.D);
        second.add(Note.D_SHARP);
        second.add(Note.E);
        second.add(Note.F);
        second.add(Note.F_SHARP);
        second.add(Note.G);
        second.add(Note.G_SHARP);
        second.add(Note.A);
        second.add(Note.A_SHARP);
        second.add(Note.B);
        frets.add(second);
        final ArrayList<Note> third = new ArrayList<>();
        third.add(Note.G);
        third.add(Note.G_SHARP);
        third.add(Note.A);
        third.add(Note.A_SHARP);
        third.add(Note.B);
        third.add(Note.C);
        third.add(Note.C_SHARP);
        third.add(Note.D);
        third.add(Note.D_SHARP);
        third.add(Note.E);
        third.add(Note.F);
        third.add(Note.F_SHARP);
        third.add(Note.G);
        frets.add(third);
        final ArrayList<Note> fourth = new ArrayList<>();
        fourth.add(Note.D);
        fourth.add(Note.D_SHARP);
        fourth.add(Note.E);
        fourth.add(Note.F);
        fourth.add(Note.F_SHARP);
        fourth.add(Note.G);
        fourth.add(Note.G_SHARP);
        fourth.add(Note.A);
        fourth.add(Note.A_SHARP);
        fourth.add(Note.B);
        fourth.add(Note.C);
        fourth.add(Note.C_SHARP);
        fourth.add(Note.D);
        frets.add(fourth);
        final ArrayList<Note> fifth = new ArrayList<>();
        fifth.add(Note.A);
        fifth.add(Note.A_SHARP);
        fifth.add(Note.B);
        fifth.add(Note.C);
        fifth.add(Note.C_SHARP);
        fifth.add(Note.D);
        fifth.add(Note.D_SHARP);
        fifth.add(Note.E);
        fifth.add(Note.F);
        fifth.add(Note.F_SHARP);
        fifth.add(Note.G);
        fifth.add(Note.G_SHARP);
        fifth.add(Note.A);
        frets.add(fifth);
        final ArrayList<Note> sixth = new ArrayList<>();
        sixth.add(Note.E);
        sixth.add(Note.F);
        sixth.add(Note.F_SHARP);
        sixth.add(Note.G);
        sixth.add(Note.G_SHARP);
        sixth.add(Note.A);
        sixth.add(Note.A_SHARP);
        sixth.add(Note.B);
        sixth.add(Note.C);
        sixth.add(Note.C_SHARP);
        sixth.add(Note.D);
        sixth.add(Note.D_SHARP);
        sixth.add(Note.E);
        frets.add(sixth);
    }

    /**
     * The matrix which represents the frets + strings. Rows are strings and
     * columns are frets. Value of the column #0 is the open string sound. The
     * other columns are corresponding string/fret sound.
     *
     * @return Matrix.
     */
    public List<List<Note>> getFrets() {
        return frets;
    }
}
