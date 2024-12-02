package aims.media;

import java.util.*;

public class MediaComparatorByTitleCost implements Comparator<Media> {
    @Override
    public int compare(Media mediae1, Media mediae2){
        int titleComparison = mediae1.getTitle().compareTo(mediae2.getTitle());
        if (titleComparison != 0){
            return titleComparison;
        } else {
            if (mediae1.getCost() > mediae2.getCost()) return 1;
            else return -1;
        }
    }
}
