package Java;

import java.time.LocalDateTime;

class Plane {
    // Private fields: encapsulated data
    private String flightNumber;
    private int passengerCount;
    private LocalDateTime takeoffTime;
    private LocalDateTime landingTime;
    private boolean inAir;

    public Plane(String flightNumber) {
        this.flightNumber = flightNumber;
        this.passengerCount = 0;
        this.inAir = false;
    }

    // Controlled passenger onboarding
    public void boardPassengers(int passengers) {
        if (passengers <= 0) {
            System.out.println("Passenger count must be greater than zero.");
            return;
        }

        if (inAir) {
            System.out.println("Passengers cannot board while the plane is in the air.");
            return;
        }

        passengerCount += passengers;
        System.out.println(passengers + " passenger(s) boarded.");
    }

    // Update takeoff time only through this method
    public void takeOff() {
        if (inAir) {
            System.out.println("The plane has already taken off.");
            return;
        }

        if (passengerCount == 0) {
            System.out.println("The plane cannot take off without passengers.");
            return;
        }

        takeoffTime = LocalDateTime.now();
        landingTime = null;
        inAir = true;

        System.out.println("Plane took off at: " + takeoffTime);
    }

    // Update landing time only through this method
    public void land() {
        if (!inAir) {
            System.out.println("The plane is already on the ground.");
            return;
        }

        landingTime = LocalDateTime.now();
        inAir = false;

        System.out.println("Plane landed at: " + landingTime);
    }

    // Getter methods provide read-only access to private fields
    public String getFlightNumber() {
        return flightNumber;
    }

    public int getPassengerCount() {
        return passengerCount;
    }

    public LocalDateTime getTakeoffTime() {
        return takeoffTime;
    }

    public LocalDateTime getLandingTime() {
        return landingTime;
    }

    public boolean isInAir() {
        return inAir;
    }
}

 class Mainn {
    public static void main(String[] args) {
        Plane plane = new Plane("AI-101");

        plane.boardPassengers(150);
        plane.takeOff();

        System.out.println("Flight: " + plane.getFlightNumber());
        System.out.println("Passengers: " + plane.getPassengerCount());
        System.out.println("Takeoff time: " + plane.getTakeoffTime());

        plane.land();

        System.out.println("Landing time: " + plane.getLandingTime());
    }
}