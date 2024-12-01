package aims.media;

public class Track {
    private String title;
    private int length;

    public Track (String title, int length){
        this.title = title;
        this.length = length;
    }

    //Generate Getter for these objects
    public String getTitle() {
        return title;
    }

    public int getLength() {
        return length;
    }

    public void play(){
        System.out.println("Playing DVD: " + this.getTitle());

        System.out.println("DVD length: " + this.getLength());
    }
}
