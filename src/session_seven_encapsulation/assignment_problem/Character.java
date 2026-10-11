package session_seven_encapsulation.assignment_problem;

public class Character {
    private final int maxHealth;
    private int health;

    public Character(int maxHealth) {
        this.maxHealth = maxHealth;
        this.health = maxHealth;
    }

    public void takeDamage(int amount) {
        this.health = Math.max(0, this.health - amount);
    }

    public void heal(int amount) {
        this.health = Math.min(this.maxHealth, this.health + amount);
    }

    public int getHealth() {
        return this.health;
    }

    public int getMaxHealth() {
        return this.maxHealth;
    }

    public static void main(String[] args) {
        Character c = new Character(100);
        c.takeDamage(30);
        System.out.println("c.takeDamage(30) -> health = " + c.getHealth());
        c.heal(50);
        System.out.println("c.heal(50) -> health = " + c.getHealth() + " (capped)");
        c.takeDamage(150);
        System.out.println("c.takeDamage(150) -> health = " + c.getHealth() + " (floored)");
    }
}
