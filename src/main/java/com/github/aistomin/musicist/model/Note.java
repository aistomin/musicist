package com.github.aistomin.musicist.model;

/**
 * Created by aistomin on 04.05.17.
 * <p>
 * Notes: 12-tone chromatic scale enum.
 */
public enum Note {

    /**
     * Note C.
     */
    C("note.c"),

    /**
     * Note C#.
     */
    C_SHARP("note.c.sharp"),

    /**
     * Note D.
     */
    D("note.d"),

    /**
     * Note D#.
     */
    D_SHARP("note.d.sharp"),

    /**
     * Note E.
     */
    E("note.e"),

    /**
     * Note F.
     */
    F("note.f"),

    /**
     * Note F#.
     */
    F_SHARP("note.f.sharp"),

    /**
     * Note G.
     */
    G("note.g"),

    /**
     * Note G#.
     */
    G_SHARP("note.g.sharp"),

    /**
     * Note A.
     */
    A("note.a"),

    /**
     * Note A#.
     */
    A_SHARP("note.a.sharp"),

    /**
     * Note B.
     */
    B("note.b");

    /**
     * Internationalisation key for displaying the note.
     */
    private final String i18nkey;

    /**
     * Ctor.
     * @param key Internationalisation key for displaying the note.
     */
    Note(final String key) {
        this.i18nkey = key;
    }

    /**
     * Get Internationalisation key for displaying the note.
     * @return Key.
     */
    public String getI18nkey() {
        return i18nkey;
    }
}
