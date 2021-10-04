package e3;

import java.util.Objects;

import static e3.Melody.Accidentals.*;
import static e3.Melody.Notes.*;

class NoteNode{
    private final Melody.Notes note;
    private final Melody.Accidentals acc;
    private final float t;

    public NoteNode(Melody.Notes note, Melody.Accidentals acc, float t) {
        this.note = note;
        this.acc = acc;
        this.t = t;
    }

    public Melody.Notes getNote() {
        return note;
    }

    public Melody.Accidentals getAcc() {
        return acc;
    }

    public float getT() {
        return t;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NoteNode that = (NoteNode) o;

        if(Float.compare(that.t, t) == 0 && Objects.equals(note, that.note) && Objects.equals(acc, that.acc)) return true;
        
        switch (note){
            case DO:
                switch (acc){
                    case NATURAL: if((that.note == SI) && (that.acc == SHARP)) return true; break;
                    case SHARP: if((that.note== RE) && (that.acc== FLAT)) return true; break;
                    case FLAT: if((that.note== SI) && (that.acc== NATURAL)) return true; break;
                } break;
            case RE:
                switch (acc){
                    case SHARP: if((that.note== MI) && (that.acc== FLAT)) return true; break;
                    case FLAT:  if((that.note== DO) && (that.acc== SHARP)) return true; break;
                } break;
            case MI:
                switch (acc){
                    case NATURAL: if((that.note== FA) && (that.acc== FLAT)) return true; break;
                    case SHARP: if((that.note== FA) && (that.acc== NATURAL)) return true; break;
                    case FLAT:  if((that.note== RE) && (that.acc== SHARP)) return true; break;
                } break;
            case FA:
                switch (acc){
                    case NATURAL: if((that.note== MI) && (that.acc== SHARP)) return true; break;
                    case SHARP:  if((that.note== SOL) && (that.acc== FLAT)) return true; break;
                    case FLAT: if((that.note== MI) && (that.acc== NATURAL)) return true; break;
                } break;
            case SOL:
                switch (acc){
                    case SHARP: if((that.note== LA) && (that.acc== FLAT)) return true; break;
                    case FLAT: if((that.note== FA) && (that.acc== SHARP)) return true; break;
                } break;
            case LA:
                switch (acc){
                    case SHARP: if((that.note== SI) && (that.acc== FLAT)) return true; break;
                    case FLAT:  if((that.note== SOL) && (that.acc== SHARP)) return true; break;
                } break;
            case SI:
                switch (acc){
                    case NATURAL: if((that.note== DO) && (that.acc== FLAT)) return true; break;
                    case SHARP: if((that.note== DO) && (that.acc== NATURAL)) return true; break;
                    case FLAT: if((that.note== LA) && (that.acc== SHARP)) return true; break;
                } break;
        }
        return false;
    }


    @Override
    public int hashCode() {

        if((note== DO && acc== SHARP) ||  (note== RE && acc== FLAT)) return 2 * Objects.hash(t);
        else if ((note== RE && acc== SHARP) ||  (note== MI && acc== FLAT)) return 3 * Objects.hash(t);
        else if ((note== MI && acc== NATURAL) ||  (note== FA && acc== FLAT)) return 3 * Objects.hash(t);
        else if ((note== MI && acc== SHARP) ||  (note== FA && acc== NATURAL)) return 3 * Objects.hash(t);
        else if ((note== FA && acc== SHARP) ||  (note== SOL && acc== FLAT)) return 3 * Objects.hash(t);
        else if ((note== SOL && acc== SHARP) ||  (note== LA && acc== FLAT)) return 3 * Objects.hash(t);
        else if ((note== LA && acc== SHARP) ||  (note== SI && acc== FLAT)) return 3 * Objects.hash(t);
        else if ((note== SI && acc== NATURAL) ||  (note== DO && acc== FLAT)) return 3 * Objects.hash(t);
        else if ((note== SI && acc== SHARP) ||  (note== DO && acc== NATURAL)) return 3 * Objects.hash(t);
        else return Objects.hash(note, acc, t);

    }

}
