package session_nine_abstraction_interface.assignment_problem;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HomeApplianceEnergyReport {
    // Interface for appliances that can operate in saver mode
    public interface SaverModeCapable {
        default double applySaverMode(double normalUnits) {
            return normalUnits * 0.75; // 25% reduction
        }
    }

    public static abstract class Appliance {
        protected String name;
        protected double powerWatts;

        public Appliance(String name, double powerWatts) {
            this.name = name;
            this.powerWatts = powerWatts;
        }

        public double calculateNormalUnits(double hours) {
            return (powerWatts * hours) / 1000.0;
        }

        public double calculateCost(double units) {
            return units * 8.0;
        }

        public String getName() {
            return name;
        }
    }

    public static class FridgeAppliance extends Appliance {
        public FridgeAppliance() {
            super("FRIDGE", 150.0);
        }
    }

    public static class TVAppliance extends Appliance {
        public TVAppliance() {
            super("TV", 100.0);
        }
    }

    public static class ACAppliance extends Appliance implements SaverModeCapable {
        public ACAppliance() {
            super("AC", 1500.0);
        }
    }

    public static class WasherAppliance extends Appliance implements SaverModeCapable {
        public WasherAppliance() {
            super("WASHER", 500.0);
        }
    }

    public static class ApplianceReportEntry {
        Appliance appliance;
        double hours;
        boolean saverRequested;

        public ApplianceReportEntry(Appliance appliance, double hours, boolean saverRequested) {
            this.appliance = appliance;
            this.hours = hours;
            this.saverRequested = saverRequested;
        }
    }

    public static void generateReport(List<ApplianceReportEntry> entries) {
        double totalCost = 0.0;
        for (ApplianceReportEntry entry : entries) {
            Appliance app = entry.appliance;
            if (entry.saverRequested && !(app instanceof SaverModeCapable)) {
                System.out.printf("%s: saver mode not supported%n", app.getName());
                continue;
            }

            double units = app.calculateNormalUnits(entry.hours);
            if (entry.saverRequested && app instanceof SaverModeCapable) {
                units = ((SaverModeCapable) app).applySaverMode(units);
            }
            double cost = app.calculateCost(units);
            totalCost += cost;

            System.out.printf("%s: Units=%.2f Cost=%.2f%n", app.getName(), units, cost);
        }
        System.out.printf("Total Cost: %.2f%n", totalCost);
    }

    public static void main(String[] args) {
        String sampleInput = "4\nFRIDGE 24\nAC 8 SAVER\nTV 5\nWASHER 2 SAVER";
        Scanner scanner = new Scanner(sampleInput);

        int n = Integer.parseInt(scanner.nextLine().trim());
        List<ApplianceReportEntry> entries = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String line = scanner.nextLine().trim();
            String[] parts = line.split("\\s+");
            String type = parts[0];
            double hours = Double.parseDouble(parts[1]);
            boolean saverRequested = parts.length > 2 && "SAVER".equalsIgnoreCase(parts[2]);

            Appliance appliance = null;
            switch (type) {
                case "FRIDGE":
                    appliance = new FridgeAppliance();
                    break;
                case "AC":
                    appliance = new ACAppliance();
                    break;
                case "TV":
                    appliance = new TVAppliance();
                    break;
                case "WASHER":
                    appliance = new WasherAppliance();
                    break;
            }

            if (appliance != null) {
                entries.add(new ApplianceReportEntry(appliance, hours, saverRequested));
            }
        }
        scanner.close();

        generateReport(entries);
    }
}
