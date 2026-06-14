package summer_assignments.DAY_28;
import java.util.*;
public class Q111_ticket_booking_system {
    static class Booking {
        int bookingId;
        String customerName;
        int seatCount;
        double totalAmount;

        Booking(int bookingId, String customerName, int seatCount, double totalAmount) {
            this.bookingId = bookingId;
            this.customerName = customerName;
            this.seatCount = seatCount;
            this.totalAmount = totalAmount;
        }
    }
    static int availableSeats = 100;
    static final double TICKET_PRICE = 250.00;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Booking> bookingList = new ArrayList<>();
        boolean running = true;

        while (running) {
            displayMenu();
            if (!sc.hasNextInt()) {
                System.out.println("\nError: Please enter a valid numerical choice.");
                sc.nextLine();
                continue;
            }
            int choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1:
                    bookTickets(sc, bookingList);
                    break;
                case 2:
                    viewAllBookings(bookingList);
                    break;
                case 3:
                    cancelBooking(sc, bookingList);
                    break;
                case 4:
                    checkAvailability();
                    break;
                case 5:
                    running = false;
                    break;
                default:
                    System.out.println("\nInvalid Option! Please select a choice from 1 to 5.");
            }
        }
        displayExitBanner();
        sc.close();
    }
    public static void displayMenu() {
        System.out.println("\n" + "=".repeat(60));
        System.out.println("                   TICKET BOOKING SYSTEM");
        System.out.println("=".repeat(60));
        System.out.println("1. Book New Tickets");
        System.out.println("2. View All Bookings");
        System.out.println("3. Cancel Ticket Booking");
        System.out.println("4. Check Seat Availability");
        System.out.println("5. Exit System");
        System.out.println("=".repeat(60));
        System.out.print("Please Select an Operation: ");
    }
    public static void bookTickets(Scanner sc, ArrayList<Booking> bookingList) {
        System.out.println("\n--- BOOK NEW TICKETS ---");
        if (availableSeats == 0) {
            System.out.println("Sold Out: No seats available for booking.");
            return;
        }
        int id = -1;
        while (id <= 0) {
            System.out.print("Enter Unique Booking ID (Positive Integer): ");
            if (sc.hasNextInt()) {
                id = sc.nextInt();
                sc.nextLine();

                if (id <= 0) {
                    System.out.println("Invalid! ID must be greater than 0.");
                } else if (findBooking(bookingList, id) != null) {
                    System.out.println("Error: A booking with ID " + id + " already exists!");
                    id = -1;
                }
            } else {
                System.out.println("Error: Booking ID must be an integer value.");
                sc.nextLine();
            }
        }
        System.out.print("Enter Customer Full Name: ");
        String name = sc.nextLine().trim();

        int seatsToBook = -1;
        while (seatsToBook <= 0) {
            System.out.print("Enter Number of Tickets to Book: ");
            if (sc.hasNextInt()) {
                seatsToBook = sc.nextInt();
                sc.nextLine();

                if (seatsToBook <= 0) {
                    System.out.println("Invalid! Number of tickets must be greater than 0.");
                } else if (seatsToBook > availableSeats) {
                    System.out.println("Insufficient Seats! Only " + availableSeats + " seats are available.");
                    seatsToBook = -1;
                }
            } else {
                System.out.println("Error: Number of tickets must be a whole number.");
                sc.nextLine();
            }
        }
        double totalAmount = seatsToBook * TICKET_PRICE;
        availableSeats -= seatsToBook;
        bookingList.add(new Booking(id, name, seatsToBook, totalAmount));

        System.out.println("Success: Tickets booked successfully!");
        System.out.printf("Total Amount Payable: ₹%,.2f\n", totalAmount);
    }
    public static void viewAllBookings(ArrayList<Booking> bookingList) {
        System.out.println("\n--- ALL RESERVATION RECORDS ---");
        if (bookingList.isEmpty()) {
            System.out.println("No ticket bookings found in the system directory.");
            return;
        }
        System.out.printf("%-12s %-25s %-15s %-15s\n", "Booking ID", "Customer Name", "Seats Booked", "Total Paid");
        System.out.println("-".repeat(70));
        for (Booking b : bookingList) {
            System.out.printf("%-12d %-25s %-15d ₹%,-15.2f\n", b.bookingId, b.customerName, b.seatCount, b.totalAmount);
        }
    }
    public static void cancelBooking(Scanner sc, ArrayList<Booking> bookingList) {
        System.out.println("\n--- CANCEL TICKET BOOKING ---");
        if (bookingList.isEmpty()) {
            System.out.println("No booking logs registered to modify.");
            return;
        }

        System.out.print("Enter Booking ID to cancel: ");
        if (!sc.hasNextInt()) {
            System.out.println("Invalid ID format entered.");
            sc.nextLine();
            return;
        }
        int id = sc.nextInt();
        sc.nextLine();

        Booking target = findBooking(bookingList, id);
        if (target == null) {
            System.out.println("Error: No booking records match ID " + id);
        } else {
            availableSeats += target.seatCount;
            bookingList.remove(target);
            System.out.println("Success: Booking canceled. Refund processed for ₹" + String.format("%,.2f", target.totalAmount));
        }
    }
    public static void checkAvailability() {
        System.out.println("\n--- SEAT AVAILABILITY STATUS ---");
        System.out.println("Remaining Seats in Venue: " + availableSeats + " / 100");
    }
    public static Booking findBooking(ArrayList<Booking> bookingList, int id) {
        for (Booking b : bookingList) {
            if (b.bookingId == id) {
                return b;
            }
        }
        return null;
    }
    public static void displayExitBanner() {
        System.out.println("\n" + "=".repeat(60));
        System.out.println("          BOOKING ENGINE OFFLINE. ALL SESSIONS CONCLUDED.");
        System.out.println("=".repeat(60));
    }
}