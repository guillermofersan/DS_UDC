package e3;


import java.util.ArrayList;
import java.util.Objects;

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


        public static final Notes[] values = { DO, RE, MI, FA, SOL, LA, SI};
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


        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            NoteNode noteNode = (NoteNode) o;



            return Float.compare(noteNode.t, t) == 0 && Objects.equals(note, noteNode.note) && Objects.equals(acc, noteNode.acc);

        }



        @Override
        public int hashCode() {

            return Objects.hash(note, acc, t);

        }

    }


    /*melody functions*/

    ArrayList<NoteNode> notelist = new ArrayList<NoteNode>();

    /*melody constructor*/
    public Melody () {

        /*
         * Creates an empty Melody instance.
         */


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

        NoteNode item = new NoteNode(note,accidental,time);



        notelist.add(item);


   }

    public Notes getNote ( int index ) {
    /*
     * Returns the note on the given position
     * @param index The position of the note to get .
     * @return The note on index .
     * @throws IllegalArgumentException if the index is not a valid position .
     */
        return notelist.get(index).getNote();
}

    public Accidentals getAccidental (int index ) {
     /*
     * Returns the accidental of the note on the given position
     * @param index The position of the accidental to get .
     * @return The accidental on index .
     * @throws IllegalArgumentException if the index is not a valid position .
     */

        return notelist.get(index).getAcc();
    }

    public float getTime ( int index ) {
    /*
     * Returns the duration of the note on the given position
     * @param index The position of the time to get .
     * @return The time on index .
     * @throws IllegalArgumentException if the index is not a valid position .
     */

        return notelist.get(index).getT();
    }

    public int size () {
    /*
     * Returns the number of notes in this melody .
     * @return The number of notes in this melody .
     */

        return notelist.size();

    }

    public float getDuration () {
        /*
         * Returns the duration of this melody .
         * @return The duration of this melody in milliseconds .
         */
        float totalTime=0;



        for (int i=0; i<notelist.size();i++){
            totalTime+=notelist.get(i).getT();
        }

        return totalTime;
    }


    @Override
    public boolean equals(Object o) {
        /*
         * Performs the equality tests of the current melody with another melody
         * passed as a parameter . Two melodies are equal if they represent the same
         * music fragment regardless of the name of its notes .
         * @param o The melody to be compared with the current melody .
         * @return true if the melodies are equals , false otherwise .
         */


        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Melody melody = (Melody) o;
        return Objects.equals(notelist, melody.notelist);



    }

    @Override
    public int hashCode() {


        return Objects.hash(notelist);


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

