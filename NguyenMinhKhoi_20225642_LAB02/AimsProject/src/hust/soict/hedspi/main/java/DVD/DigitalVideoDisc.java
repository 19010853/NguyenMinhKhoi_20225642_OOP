package DVD;

public class DigitalVideoDisc {

        //Declare attributes
        private String title;
        private String category;
        private String director;
        private int length;
        private float cost;
        private static int nbDigitalVideoDisc = 0; // Declared class attribute
        private int id; //Instance attribute

        //Constructor by title
        public DigitalVideoDisc(String title) {
            this.title = title;
            this.id = ++nbDigitalVideoDisc;
        }

        //Constructor by category, title and cost
        public DigitalVideoDisc(String title, String category, float cost) {
            this.title = title;
            this.category = category;
            this.cost = cost;
            this.id = ++nbDigitalVideoDisc;
        }

        //Constructor by title, category , director, cost
        public DigitalVideoDisc(String title, String category, String director, float cost) {
            this.title = title;
            this.category = category;
            this.director = director;
            this.cost = cost;
            this.id = ++nbDigitalVideoDisc;
        }

        // Constructor by all attributes
        public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
            this.title = title;
            this.category = category;
            this.director = director;
            this.length = length;
            this.cost = cost;
            this.id = ++nbDigitalVideoDisc;
        }

        //Getter
        public String getTitle() {
            return title;
        }

        public String getCategory() {
            return category;
        }

        public String getDirector() {
            return director;
        }

        public int getLength() {
            return length;
        }

        public float getCost() {
            return cost;
        }

        public int getId() { return id; }
        //Setter
        public void setTitle(String title) {
            this.title = title;
        }

        public void setCategory(String category) {
            this.category = category;
        }

        public void setDirector(String director) {
            this.director = director;
        }

        public void setLength(int length) {
            this.length = length;
        }

        public void setCost(float cost) {
            this.cost = cost;
        }

        public void setId(int id) { this.id = id; }
    }
