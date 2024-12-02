package aims.media;

import java.util.ArrayList;

public class CompactDisc extends Disc implements Playable{
    private String artist;
    private ArrayList<Track> tracks;

    public CompactDisc(int id, String title, String category, float cost, String artist, ArrayList<Track> tracks){
        super(id, title, category, cost);
        this.artist = artist;
        this.tracks = tracks;
        this.setLength(getLength());
    }

    public CompactDisc(int id, String title, String category, float cost, StringBuilder artist, ArrayList<Track> tracks){
        super(id, title, category, cost);
    }

    //Create functions which add or remove tracks
    public void addTrack(Track soundTrack){
        if (tracks.contains(soundTrack)){
            System.out.println(soundTrack + " is already in the list of tracks!");
        } else {
            tracks.add(soundTrack);
        }
    }

    public void removeTrack(Track soundTrack){
        if (tracks.contains(soundTrack)){
            tracks.remove(soundTrack);
            System.out.println(soundTrack + " is already in the list of tracks!");
        } else {
            System.out.println(soundTrack + " is not in the list of tracks!");
        }
    }


    //Generate Getter for artist
    public String getArtist() {
        return artist;
    }

    @Override
    public float getLength(){
        float sumOfLength = 0;
        for (Track soundTrack : tracks){
            sumOfLength += soundTrack.getLength();
        }
        return sumOfLength;
    }

    @Override
    public String toString() {
        StringBuilder print = new StringBuilder("CD: " +
                " [id = " + getId() +
                ", artist: " + artist +
                ", title = '" + getTitle() + '\'' +
                ", category = '" + getCategory() + '\'' +
                ", length : " + getLength() + " min" +
                ", cost= " + getCost() + "$]" + '\n' + "Tracks: \n"
                + "===================" + '\n');
        for (Track track : tracks) {
            print.append(track.getTitle());
            print.append('\t');
            print.append(track.getLength());
            print.append(" min");
            print.append('\n');
        }
        return print.toString();
    }

    public void play(){
        System.out.println("\nTitle: " + getTitle()
                            + "\nCategory: " + getCategory()
                            + "\nArtist: " + getArtist() + "\n");

        for (Track soundTrack : tracks){
            soundTrack.play();
        }
    }



}
