package test.polymorphism;

import aims.media.*;

import java.util.ArrayList;
import java.util.List;

public class PolymorphismTesting {
    public static void main(String[] args){
        // creat some media here
        List<Media> mediae = new ArrayList<Media>();
        DigitalVideoDisc dvd = new DigitalVideoDisc(1, "Cu Lao Xac Song", "Survival", 3.0f, "Nhat Trung", 93);

        ArrayList<Track> tracks = new ArrayList<Track>();
        tracks.add(new Track("Khong Phai Dang Vua Dau", 4));
        tracks.add(new Track("Anh Sai Roi", 3));
        tracks.add(new Track("Am Tham Ben Em", 5));

        CompactDisc cd = new CompactDisc(2, "m-tp MTP", "Vietnames Pop", 6.3f, "Son Tung M-TP", tracks);

        List<String> authors = new ArrayList<String>();
        authors.add("George R.R. Martin");

        Book book = new Book(3, "Game of Thrones", "Fantasy", 3.99f, authors );

        // for example: cd, dvd, book
        mediae.add(dvd);
        mediae.add(cd);
        mediae.add(book);

        for (Media m : mediae){
            System.out.println(m.toString());
        }


    }
}
