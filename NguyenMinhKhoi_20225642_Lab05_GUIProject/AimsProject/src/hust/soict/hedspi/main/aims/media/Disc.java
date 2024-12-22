package aims.media;

import javax.sound.midi.Track;
import java.util.ArrayList;

public class Disc extends Media{
    private String director;
    private float length;

    public Disc(int id, String title, String category, float cost, String director, float length){
        super(id, title, category, cost);
        this.director = director;
        this.length = length;
    }

    public Disc(int id, String title, String category, float cost){
        super(id, title, category, cost);
    }

    //Generate getter for these methods
    public String getDirector() {
        return director;
    }

    public float getLength() {
        return length;
    }

    //Generate setter for these methods
    public void setDirector(String director) {
        this.director = director;
    }

    public void setLength(float length) {
        this.length = length;
    }
}
