package e3;


import java.net.PortUnreachableException;
import java.util.ArrayList;
import java.util.Objects;

public class Melody {



    static class Notes{

        public enum notes {DO, RE, MI, FA, SOL, LA, SI};
        notes value;
        String note_string;

        /*CONSTRUCTOR*/
        public Notes(Notes.notes value) {
            this.value = value;
            note_string=value.name();
        }

        /*GETTERS*/
        public String note_string() {
            return note_string;
        }
        public notes getValue() {
            return value;
        }

        @Override
        public String toString() {
            return note_string;
        }

        public static final Notes DO = new Notes(notes.DO);
        public static final Notes RE = new Notes(notes.RE);
        public static final Notes MI = new Notes(notes.MI);
        public static final Notes FA = new Notes(notes.FA);
        public static final Notes SOL = new Notes(notes.SOL);
        public static final Notes LA = new Notes(notes.LA);
        public static final Notes SI = new Notes(notes.SI);


        public static final Notes[] values = {DO, RE, MI, FA, SOL, LA, SI};
        public static Notes[] values() {
            return values;
        }

    }


    static class Accidentals{


        public enum accidentals {NATURAL, SHARP, FLAT};
        accidentals value;
        String AccName;

        /*CONSTRUCTOR*/

        public Accidentals(accidentals value) {
            this.value = value;
            switch ( value){
                case NATURAL: AccName=null; break;
                case SHARP: AccName="#"; break;
                case FLAT: AccName="b"; break;
                default:break;
            }
        }

        /*GETTERS*/
        public String getAccName() {
            return AccName;
        }

        public accidentals getValue() {
            return value;
        }

        @Override
        public String toString() {
            if (AccName==null) return "";
            else return AccName;
        }

        public static final Accidentals NATURAL = new Accidentals(accidentals.NATURAL);
        public static final Accidentals SHARP = new Accidentals(accidentals.SHARP);
        public static final Accidentals FLAT = new Accidentals(accidentals.FLAT);


        public static final Accidentals[] values = {NATURAL, SHARP, FLAT};
        public static Accidentals[] values() {

            return values;

        }


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

            if(Float.compare(noteNode.t, t) == 0 && Objects.equals(note, noteNode.note) && Objects.equals(acc, noteNode.acc)) return true;


            switch (note.getValue()){
                case DO:
                    switch (acc.getValue()){
                        case NATURAL: if((noteNode.note.getValue()== Notes.notes.SI) && (noteNode.acc.getValue()==Accidentals.accidentals.SHARP)) return true; break;
                        case SHARP: if((noteNode.note.getValue()== Notes.notes.RE) && (noteNode.acc.getValue()==Accidentals.accidentals.FLAT)) return true; break;
                        case FLAT: if((noteNode.note.getValue()== Notes.notes.SI) && (noteNode.acc.getValue()==Accidentals.accidentals.NATURAL)) return true; break;
                    } break;
                case RE:
                    switch (acc.getValue()){
                        case SHARP: if((noteNode.note.getValue()== Notes.notes.MI) && (noteNode.acc.getValue()==Accidentals.accidentals.FLAT)) return true; break;
                        case FLAT:  if((noteNode.note.getValue()== Notes.notes.DO) && (noteNode.acc.getValue()==Accidentals.accidentals.SHARP)) return true; break;
                    } break;
                case MI:
                    switch (acc.getValue()){
                        case NATURAL: if((noteNode.note.getValue()== Notes.notes.FA) && (noteNode.acc.getValue()==Accidentals.accidentals.FLAT)) return true; break;
                        case SHARP: if((noteNode.note.getValue()== Notes.notes.FA) && (noteNode.acc.getValue()== Accidentals.accidentals.NATURAL)) return true; break;
                        case FLAT:  if((noteNode.note.getValue()== Notes.notes.RE) && (noteNode.acc.getValue()==Accidentals.accidentals.SHARP)) return true; break;
                    } break;
                case FA:
                    switch (acc.getValue()){
                        case NATURAL: if((noteNode.note.getValue()== Notes.notes.MI) && (noteNode.acc.getValue()== Accidentals.accidentals.SHARP)) return true; break;
                        case SHARP:  if((noteNode.note.getValue()== Notes.notes.SOL) && (noteNode.acc.getValue()==Accidentals.accidentals.FLAT)) return true; break;
                        case FLAT: if((noteNode.note.getValue()== Notes.notes.MI) && (noteNode.acc.getValue()== Accidentals.accidentals.NATURAL)) return true; break;
                    } break;
                case SOL:
                    switch (acc.getValue()){
                        case SHARP: if((noteNode.note.getValue()== Notes.notes.LA) && (noteNode.acc.getValue()== Accidentals.accidentals.FLAT)) return true; break;
                        case FLAT: if((noteNode.note.getValue()== Notes.notes.FA) && (noteNode.acc.getValue()== Accidentals.accidentals.SHARP)) return true; break;
                    } break;
                case LA:
                    switch (acc.getValue()){
                        case SHARP: if((noteNode.note.getValue()== Notes.notes.SI) && (noteNode.acc.getValue()== Accidentals.accidentals.FLAT)) return true; break;
                        case FLAT:  if((noteNode.note.getValue()== Notes.notes.SOL) && (noteNode.acc.getValue()==Accidentals.accidentals.SHARP)) return true; break;
                    } break;
                case SI:
                    switch (acc.getValue()){
                        case NATURAL: if((noteNode.note.getValue()== Notes.notes.DO) && (noteNode.acc.getValue()== Accidentals.accidentals.FLAT)) return true; break;
                        case SHARP: if((noteNode.note.getValue()== Notes.notes.DO) && (noteNode.acc.getValue()== Accidentals.accidentals.NATURAL)) return true; break;
                        case FLAT: if((noteNode.note.getValue()== Notes.notes.LA) && (noteNode.acc.getValue()== Accidentals.accidentals.SHARP)) return true; break;
                    } break;
            }
            return false;
            }


        @Override
        public int hashCode() {

            if((note.getValue()== Notes.notes.DO && acc.getValue()== Accidentals.accidentals.SHARP) ||  (note.getValue()== Notes.notes.RE && acc.getValue()== Accidentals.accidentals.FLAT)) return 2 * Objects.hash(t);
            else if ((note.getValue()== Notes.notes.RE && acc.getValue()== Accidentals.accidentals.SHARP) ||  (note.getValue()== Notes.notes.MI && acc.getValue()== Accidentals.accidentals.FLAT)) return 3 * Objects.hash(t);
            else if ((note.getValue()== Notes.notes.MI && acc.getValue()== Accidentals.accidentals.NATURAL) ||  (note.getValue()== Notes.notes.FA && acc.getValue()== Accidentals.accidentals.FLAT)) return 3 * Objects.hash(t);
            else if ((note.getValue()== Notes.notes.MI && acc.getValue()== Accidentals.accidentals.SHARP) ||  (note.getValue()== Notes.notes.FA && acc.getValue()== Accidentals.accidentals.NATURAL)) return 3 * Objects.hash(t);
            else if ((note.getValue()== Notes.notes.FA && acc.getValue()== Accidentals.accidentals.SHARP) ||  (note.getValue()== Notes.notes.SOL && acc.getValue()== Accidentals.accidentals.FLAT)) return 3 * Objects.hash(t);
            else if ((note.getValue()== Notes.notes.SOL && acc.getValue()== Accidentals.accidentals.SHARP) ||  (note.getValue()== Notes.notes.LA && acc.getValue()== Accidentals.accidentals.FLAT)) return 3 * Objects.hash(t);
            else if ((note.getValue()== Notes.notes.LA && acc.getValue()== Accidentals.accidentals.SHARP) ||  (note.getValue()== Notes.notes.SI && acc.getValue()== Accidentals.accidentals.FLAT)) return 3 * Objects.hash(t);
            else if ((note.getValue()== Notes.notes.SI && acc.getValue()== Accidentals.accidentals.NATURAL) ||  (note.getValue()== Notes.notes.DO && acc.getValue()== Accidentals.accidentals.FLAT)) return 3 * Objects.hash(t);
            else if ((note.getValue()== Notes.notes.SI && acc.getValue()== Accidentals.accidentals.SHARP) ||  (note.getValue()== Notes.notes.DO && acc.getValue()== Accidentals.accidentals.NATURAL)) return 3 * Objects.hash(t);
            else return Objects.hash(note, acc, t);

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
            string =string + notelist.get(i).getNote().toString() + notelist.get(i).getAcc().toString() + "(" + notelist.get(i).t + ")";
        }

        return string;
    }
}