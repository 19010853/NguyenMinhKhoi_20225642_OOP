public class NumberOfDaysOfAMonth {
    public static void main(String[] args) {
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        System.out.println("Enter a month: ");
        String month = scanner.nextLine();
        System.out.println("Enter the year: ");
        int year = Integer.parseInt(scanner.nextLine());
        if (month.equals("Jan") || month.equals("Mar") || month.equals("May") || month.equals("Jul")
                || month.equals("Aug") || month.equals("Oct") || month.equals("Dec")) {
            System.out.println("This month has 31 days");
        } else if (month.equals("Apr") || month.equals("Jun") || month.equals("Sep") || month.equals("Nov")) {
            System.out.println("This month has 30 days");
        } else if (month.equals("Feb")) {
            if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) {
                System.out.println("This month has 29 days");
            } else {
                System.out.println("This month has 28 days");
            }
        } else {
            System.out.println("Invalid month");
        }
        scanner.close();
    }
}
