import java.util.Scanner;

public class ReservationSystem {

    private static final int TOTAL_SEATS = 10;
    private boolean[] seats = new boolean[TOTAL_SEATS];

    public static void main(String[] args) {
        ReservationSystem system = new ReservationSystem();
        system.run();
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            displayMenu();
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    makeReservation(scanner);
                    break;
                case 2:
                    cancelReservation(scanner);
                    break;
                case 3:
                    displaySeats();
                    break;
                case 0:
                    System.out.println("Thank you for using the reservation system.");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 0);
        scanner.close();
    }

    private void displayMenu() {
        System.out.println("\n--- Online Reservation System ---");
        System.out.println("1. Make a reservation");
        System.out.println("2. Cancel a reservation");
        System.out.println("3. Display seats");
        System.out.println("0. Exit");
        System.out.print("Enter your choice: ");
    }

    private void makeReservation(Scanner scanner) {
        System.out.print("Enter seat number (1-10) to reserve: ");
        int seatNumber = scanner.nextInt();
        if (seatNumber < 1 || seatNumber > TOTAL_SEATS) {
            System.out.println("Invalid seat number. Please enter a number between 1 and 10.");
        } else if (seats[seatNumber - 1]) {
            System.out.println("Sorry, this seat is already reserved.");
        } else {
            seats[seatNumber - 1] = true;
            System.out.println("Seat " + seatNumber + " has been successfully reserved.");
        }
    }

    private void cancelReservation(Scanner scanner) {
        System.out.print("Enter seat number (1-10) to cancel reservation: ");
        int seatNumber = scanner.nextInt();
        if (seatNumber < 1 || seatNumber > TOTAL_SEATS) {
            System.out.println("Invalid seat number. Please enter a number between 1 and 10.");
        } else if (!seats[seatNumber - 1]) {
            System.out.println("This seat is not reserved.");
        } else {
            seats[seatNumber - 1] = false;
            System.out.println("Reservation for seat " + seatNumber + " has been successfully canceled.");
        }
    }

    private void displaySeats() {
        System.out.println("\nCurrent seat reservations:");
        for (int i = 0; i < TOTAL_SEATS; i++) {
            String status = seats[i] ? "Reserved" : "Available";
            System.out.println("Seat " + (i + 1) + ": " + status);
        }
    }
}
