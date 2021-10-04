package e3;


import java.net.PortUnreachableException;
import java.util.ArrayList;
import java.util.Objects;

public class Melody {

    public enum Notes {DO, RE, MI, FA, SOL, LA, SI};
    public enum Accidentals {NATURAL, SHARP, FLAT};



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

        if (note==null || accidental==null || time<=0) throw new IllegalArgumentException();


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

        if(index>notelist.size()-1) throw new IllegalArgumentException();
        return notelist.get(index).getNote();

}

    public Accidentals getAccidental (int index ) {
     /*
     * Returns the accidental of the note on the given position
     * @param index The position of the accidental to get .
     * @return The accidental on index .
     * @throws IllegalArgumentException if the index is not a valid position .
     */
        if(index>notelist.size()-1) throw new IllegalArgumentException();
        return notelist.get(index).getAcc();
    }

    public float getTime ( int index ) {
    /*
     * Returns the duration of the note on the given position
     * @param index The position of the time to get .
     * @return The time on index .
     * @throws IllegalArgumentException if the index is not a valid position .
     */

        if(index>notelist.size()-1) throw new IllegalArgumentException();
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
        String string="";


        for (int i=0; i<notelist.size();i++){
            if (i!=0) string=string+" ";
            string =string + notelist.get(i).getNote().toString() + notelist.get(i).getAcc().toString() + "(" + notelist.get(i).getT() + ")";
        }

        return string;
    }
}