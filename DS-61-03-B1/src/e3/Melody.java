package e3;


import java.util.ArrayList;

public class Melody {



    static class Notes{
        String value;

        /*CONSTRUCTOR*/
        public Notes(String val) {
            value=val;
        }

        /*GETTER*/
        public String getValue() {
            return value;
        }

        public static final Notes DO = new Notes("DO");
        public static final Notes RE = new Notes("RE");
        public static final Notes MI = new Notes("MI");
        public static final Notes FA = new Notes("FA");
        public static final Notes SOL = new Notes("SOL");
        public static final Notes LA = new Notes("LA");
        public static final Notes SI = new Notes("SI");
    }


    static class Accidentals{

        String AccName;

        /*CONSTRUCTOR*/
        public Accidentals(String accName) {
            AccName = accName;
        }

        /*GETTER*/
        public String getAccName() {
            return AccName;
        }

        public static final Accidentals NATURAL = new Accidentals(null);
        public static final Accidentals SHARP = new Accidentals("#");
        public static final Accidentals FLAT = new Accidentals("b");
    }


    static class NoteNode{
        Notes note;
        Accidentals acc;
        float t;

        public NoteNode(Notes note, Accidentals acc, float t) {
            this.note = note;
            this.acc = acc;
            this.t = t;
        }

        public Notes getNote() {
            return note;
        }

        public Accidentals getAcc() {
            return acc;
        }

        public float getT() {
            return t;
        }
    }


    /*melody functions*/
    int lastpos;

    ArrayList<NoteNode> notelist = new ArrayList<NoteNode>();


    NoteNode[] Notelist;//pregunta: maximo?

    /*melody constructor*/
    public Melody () {
        /*
         * Creates an empty Melody instance .a
         */
        lastpos=-1;

    }

    public void addNote ( Notes note , Accidentals accidental , float time ) {

        /*
         * Add a note at the end of this melody .
         * @param note The note to add
         * @param accidental The accidental of the note
         * @param time The duration of the note in milliseconds
         * @throws IllegalArgumentException if the note , the accidental
         * or the time are not valid values .
         */

        NoteNode temp = new NoteNode(note,accidental,time);

        lastpos++;

        Notelist[lastpos]=temp;


   }

    public Notes getNote ( int index ) {
    /*
     * Returns the note on the given position
     * @param index The position of the note to get .
     * @return The note on index .
     * @throws IllegalArgumentException if the index is not a valid position .
     */
        if(index>lastpos) throw new IllegalArgumentException();

        return Notelist[0].getNote();
}

    public Accidentals getAccidental (int index ) {
     /*
     * Returns the accidental of the note on the given position
     * @param index The position of the accidental to get .
     * @return The accidental on index .
     * @throws IllegalArgumentException if the index is not a valid position .
     */

        if(index>lastpos) throw new IllegalArgumentException();

        return Notelist[0].getAcc();
    }

    public float getTime ( int index ) {
    /*
     * Returns the duration of the note on the given position
     * @param index The position of the time to get .
     * @return The time on index .
     * @throws IllegalArgumentException if the index is not a valid position .
     */

        if(index>lastpos) throw new IllegalArgumentException();

        return Notelist[0].getT();
    }

    public int size () {
    /*
     * Returns the number of notes in this melody .
     * @return The number of notes in this melody .
     */

        return lastpos+1;

    }

    public float getDuration () {
        /*
         * Returns the duration of this melody .
         * @return The duration of this melody in milliseconds .
         */
        float totalTime=0;
        for (int i=0; i<=lastpos;i++){
            totalTime+=Notelist[i].getT();
        }

        return totalTime;
    }


    @Override

    public boolean equals ( Object o) {
        /*
     * Performs the equality tests of the current melody with another melody
     * passed as a parameter . Two melodies are equal if they represent the same
     * music fragment regardless of the name of its notes .
     * @param o The melody to be compared with the current melody .
    6
     * @return true if the melodies are equals , false otherwise .
     */
        boolean eq=true;

        return eq;
    }

    @Override

    public int hashCode () {
        /*
         * Returns an integer that is a hash code representation of the melody .
         * Two melodies m1 , m2 that are equals (m1. equals (m2) == true ) must
         * have the same hash code .
         * @return The hash code of this melody .
         */

        return 0;
    }

    @Override
    public String toString () {
        /*
         * The string representation of this melody .
         * @return The String representantion of this melody .
         */

        return "a";
    }
}

