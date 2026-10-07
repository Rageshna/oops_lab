class Railway {
    int seats = 2;

    synchronized void bookTicket() {
        try {
            while (seats == 0) {
                System.out.println("No seats available. Booking thread is waiting...");
                wait();
            }

            seats--;
            System.out.println("Ticket booked successfully.");
            System.out.println("Available seats: " + seats);

        } catch (InterruptedException e) {
            System.out.println(e);
        }
    }

    synchronized void cancelTicket() {
        seats++;
        System.out.println("Ticket cancelled successfully.");
        System.out.println("Available seats: " + seats);

        notifyAll();
    }
}

class Booking extends Thread {
    Railway r;

    Booking(Railway r) {
        this.r = r;
    }

    public void run() {
        r.bookTicket();
        r.bookTicket();
        r.bookTicket();
    }
}

class Cancellation extends Thread {
    Railway r;

    Cancellation(Railway r) {
        this.r = r;
    }

    public void run() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println(e);
        }

        r.cancelTicket();
    }
}

public class RailwayBooking {
    public static void main(String[] args) {

        Railway r = new Railway();

        Booking b = new Booking(r);
        Cancellation c = new Cancellation(r);

        b.start();
        c.start();
    }
}

Output:
Ticket booked successfully.
Available seats: 1

Ticket booked successfully.
Available seats: 0

No seats available. Booking thread is waiting…

Ticket cancelled successfully.
Available seats: 1

Ticket booked successfully.
Available seats: 0
