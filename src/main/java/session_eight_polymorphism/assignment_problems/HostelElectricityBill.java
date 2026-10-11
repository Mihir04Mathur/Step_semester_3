package session_eight_polymorphism.assignment_problems;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HostelElectricityBill {
    public static abstract class RoomBill {
        protected String roomType;
        protected int units;

        public RoomBill(String roomType, int units) {
            this.roomType = roomType;
            this.units = units;
        }

        public abstract double calculateBill();

        public String getRoomType() {
            return roomType;
        }
    }

    public static class SingleRoomBill extends RoomBill {
        public SingleRoomBill(int units) {
            super("SINGLE", units);
        }

        @Override
        public double calculateBill() {
            return units * 8.0;
        }
    }

    public static class SharedRoomBill extends RoomBill {
        private int occupants;

        public SharedRoomBill(int units, int occupants) {
            super("SHARED", units);
            this.occupants = occupants;
        }

        @Override
        public double calculateBill() {
            return (units * 6.0) / occupants;
        }
    }

    public static class ACRoomBill extends RoomBill {
        public ACRoomBill(int units) {
            super("AC", units);
        }

        @Override
        public double calculateBill() {
            return units * 10.0 + 200.0;
        }
    }

    public static void processRooms(List<RoomBill> rooms) {
        double grandTotal = 0.0;
        for (RoomBill room : rooms) {
            double bill = room.calculateBill();
            grandTotal += bill;
            System.out.printf("%s: %.2f%n", room.getRoomType(), bill);
        }
        System.out.printf("Total: %.2f%n", grandTotal);
    }

    public static void main(String[] args) {
        String sampleInput = "3\nSINGLE 120\nSHARED 150 3\nAC 100";
        Scanner scanner = new Scanner(sampleInput);

        int n = Integer.parseInt(scanner.next());
        List<RoomBill> rooms = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String type = scanner.next();
            int units = scanner.nextInt();
            switch (type) {
                case "SINGLE":
                    rooms.add(new SingleRoomBill(units));
                    break;
                case "SHARED":
                    int occupants = scanner.nextInt();
                    rooms.add(new SharedRoomBill(units, occupants));
                    break;
                case "AC":
                    rooms.add(new ACRoomBill(units));
                    break;
            }
        }
        scanner.close();

        processRooms(rooms);
    }
}
