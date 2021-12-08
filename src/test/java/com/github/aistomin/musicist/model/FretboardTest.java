package com.github.aistomin.musicist.model;

import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Created by aistomin on 11.05.17.
 * <p>
 * Test for {@link Fretboard}
 */
public final class FretboardTest {

    /**
     * Frets count.
     */
    private static final int FRETS = 12;

    /**
     * Check that we have 6 X 13 fretboard(open string + 12 frets).
     *
     * @throws Exception If something goes wrong.
     */
    @Test
    public void testFretboard() throws Exception {
        for (final List<Note> string : new Fretboard().getFrets()) {
            Assertions.assertEquals(1 + FRETS, string.size());
        }
    }

    /**
     * Check that every 12th fret has the same note as open string.
     *
     * @throws Exception If something goes wrong.
     */
    @Test
    public void testNotes() throws Exception {
        for (final List<Note> string : new Fretboard().getFrets()) {
            Assertions.assertEquals(string.get(0), string.get(FRETS));
        }
    }
}
