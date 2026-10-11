package session_seven_encapsulation.assignment_problem;

public class TrafficLight {
    private final String id;
    private String color;

    public TrafficLight(String id) {
        this.id = id;
        this.color = "RED";
    }

    public String getId() {
        return id;
    }

    public String getColor() {
        return color;
    }

    public String next() {
        if ("RED".equals(color)) {
            color = "GREEN";
        } else if ("GREEN".equals(color)) {
            color = "YELLOW";
        } else if ("YELLOW".equals(color)) {
            color = "RED";
        }
        return color;
    }

    public static void main(String[] args) {
        TrafficLight t = new TrafficLight("TL-9");
        System.out.println("t.getColor() -> \"" + t.getColor() + "\"");
        System.out.println("t.next() -> \"" + t.next() + "\"");
        System.out.println("t.next() -> \"" + t.next() + "\"");
        System.out.println("t.next() -> \"" + t.next() + "\"");
    }
}
