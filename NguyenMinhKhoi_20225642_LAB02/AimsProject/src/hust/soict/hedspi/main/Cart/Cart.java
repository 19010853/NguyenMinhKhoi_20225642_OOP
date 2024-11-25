package Cart;

import DVD.DigitalVideoDisc;

public class Cart {
    //Maximum order
    public static final int MAX_NUMBER_ORDERED=20;
    //Array which stores DVDs in the cart
    private DigitalVideoDisc itemsOrdered[]= new DigitalVideoDisc[MAX_NUMBER_ORDERED];
    //Number of ordered DVDs
    private int qtyOrdered;

    //Function which add one DVD at a time in the cart
    public void addDigitalVideoDisc(DigitalVideoDisc disc)
    {
        if (qtyOrdered == MAX_NUMBER_ORDERED)
        {
            System.out.println("The cart is almost full");
        }
        else
        {
            qtyOrdered++;
            itemsOrdered[qtyOrdered-1]=disc;
            System.out.println("The DVD " + '\"' +disc.getTitle() + '\"' + " has been successfully added!");
        }
    }

    //Function which add multiple DVDs with the same name in the cart
    public int addDigitalVideoDisc(DigitalVideoDisc[] dvdList){
        int addingNumber = 0;
        for (DigitalVideoDisc disc : dvdList){
            if (qtyOrdered == MAX_NUMBER_ORDERED){
                System.out.println("The cart is almost full");
                break;
            } else {
                itemsOrdered[qtyOrdered - 1] = disc;
                qtyOrdered++;
                System.out.println("The DVD " + disc.getTitle() + " has been successfully added!");
                addingNumber++;
            }
        }
        return addingNumber;
    }

    //Function which add 2 DVDs with different names
    public void addDigitalVideoDisc(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2){
        if (qtyOrdered + 1 >= MAX_NUMBER_ORDERED){
            System.out.println("The cart is almost full");
        } else {
            itemsOrdered[qtyOrdered] = dvd1;
            qtyOrdered++;
            System.out.println("The DVD " + dvd1.getTitle() + " has been successfully added!");

            itemsOrdered[qtyOrdered] = dvd2;
            qtyOrdered++;
            System.out.println("The DVD " + dvd2.getTitle() + " has been successfully added!");
        }
    }

    //Function which remove DVDs in the cart
    public int removeDigitalVideoDisc(DigitalVideoDisc disc)
    {
        if(itemsOrdered[0] ==  null) {
            System.out.println("Your cart is empty!");
            return 0;
        }
        for(int i =0; i < qtyOrdered;i++) {
            if(itemsOrdered[i]==disc) {
                for(int j = i;i<qtyOrdered-1;i++) {
                    itemsOrdered[i] = itemsOrdered[i+1];
                }
                itemsOrdered[qtyOrdered-1] = null;
                qtyOrdered--;
                System.out.println("The DVD " + '\"' +disc.getTitle() + '\"' + " has been successfully removed!");
                return 0;
            }
        }
        System.out.println("Not DVD match!");
        return 0;
    }

    //Function which calculate total cost
    public float totalCost() {
        float sum = 0.00f;
        for(int i =0;i< qtyOrdered;i++) {
            sum += itemsOrdered[i].getCost();
        }
        return sum;
    }

    //Print function
    public void Print(){
        StringBuilder output = new StringBuilder();

        output.append("***********************CART***********************\n");
        output.append("Ordered Items:\n");
        for (int i = 0; i < qtyOrdered; i++){
            output.append(String.format("%d. [%s] - [%s] - [%s] - [%d]: %.2f $\n",
                    i+1,
                    itemsOrdered[i].getTitle(),
                    itemsOrdered[i].getCategory(),
                    itemsOrdered[i].getDirector(),
                    itemsOrdered[i].getLength(),
                    itemsOrdered[i].getCost()
                    ));
        }
        output.append("Total cost: ").append("[").append(totalCost()).append("]");
        System.out.println(output.toString());
    }

    //Function which search DVDs by ID
    public void searchDVDsByID(int id){
        if (id > qtyOrdered){
            System.out.println("No DVD found!");
        } else {
            System.out.println("Result for ID " + itemsOrdered[id - 1].getId() + " :\n");
            System.out.println(String.format("%d. [%s] - [%s] - [%s] - [%d]: %.2f $\n",
                    itemsOrdered[id - 1].getId(),
                    itemsOrdered[id - 1].getTitle(),
                    itemsOrdered[id - 1].getCategory(),
                    itemsOrdered[id - 1].getDirector(),
                    itemsOrdered[id - 1].getLength(),
                    itemsOrdered[id - 1].getCost()
            ));
        }
    }

    //Function which search DVDs by Title
    public void searchDVDsByTitle(String Title){
        StringBuilder output = new StringBuilder();
        boolean rightTitle = false;
        for (int i = 0; i < qtyOrdered; i++){
            if (itemsOrdered[i].getTitle().equals(Title)){
                output.append("Result for Title " + itemsOrdered[i].getTitle() + " :\n");
                output.append(String.format("%d. [%s] - [%s] - [%s] - [%d]: %.2f $\n",
                        itemsOrdered[i].getId(),
                        itemsOrdered[i].getTitle(),
                        itemsOrdered[i].getCategory(),
                        itemsOrdered[i].getDirector(),
                        itemsOrdered[i].getLength(),
                        itemsOrdered[i].getCost()
                ));
                rightTitle = true;
                break;
            }
        }
        if (!rightTitle){
            output.append("No DVD found!\n");
        }
        System.out.println(output.toString());
    }
}
