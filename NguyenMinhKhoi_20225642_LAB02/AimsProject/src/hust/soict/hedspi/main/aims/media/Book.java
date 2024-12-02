package aims.media;

import java.util.ArrayList;
import java.util.List;

public class Book extends Media {
    private List<String> authors = new ArrayList<String>();

    public Book(int id, String title, String category, float cost, List<String> authors){
        super(id, title, category, cost);
        this.authors = authors;
    }

    public Book(int id, String title, String category, float cost){
        super(id, title, category, cost);
    }

    public List<String> getAuthors() {
        return authors;
    }

    public void setAuthors(List<String> authors) {
        this.authors = authors;
    }

    public void addAuthor(String Name){
        if (authors.contains(Name)){
            System.out.println(Name + " is already on the list!");
        } else {
            System.out.println(Name + "have successfully added on the list!");
            authors.add(Name);
        }
    }

    public void removeAuthor(String Name){
        if (authors.contains(Name)){
            System.out.println(Name + "have successfully removed on the list!");
            authors.remove(Name);
        } else {
            System.out.println(Name + " is not on the list!");
        }
    }

    @Override
    public String toString() {
        StringBuilder print = new StringBuilder("Book: " +
                " [id=" + getId() +
                ", title='" + getTitle() + '\'' +
                ", category='" + getCategory() + '\'' +
                ", authors: ");
        for (String a : authors) {
            print.append(a);
            print.append(" ");
        }
        print.append(", cost: ");
        print.append(getCost());
        print.append("$]");
        return print.toString();

    }
}
