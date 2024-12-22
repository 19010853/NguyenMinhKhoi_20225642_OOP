package aims.media;

import java.util.Collections;
import java.util.Comparator;

public class MediaComparatorByCostTitle implements Comparator<Media> {
    @Override
    public int compare (Media mediae1, Media mediae2){
        int titleComparison = mediae1.getTitle().compareTo(mediae2.getTitle());
        if (mediae1.getCost() != mediae2.getCost()){
            int costComparison = (int) (mediae1.getCost() - mediae2.getCost());
            return costComparison;
        } else {
            return titleComparison;
        }
    }
}
