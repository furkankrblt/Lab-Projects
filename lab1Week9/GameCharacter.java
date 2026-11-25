/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab1week9;

/**
 *
 * @author mfkar
 */
public abstract class GameCharacter {
    private String name;
    private int level;
    private int health;
    private int maxHealth;

    public GameCharacter(String name, int level, int maxHealth) {
        this.name = name;

        if (level < 1 || level > 100) {
            System.out.println("Warning: invalid level (" + level + ") for " + name + ". Level set to 1.");
            this.level = 1;
        } else {
            this.level = level;
        }

        if (maxHealth <= 0) {
            System.out.println("Warning: invalid maxHealth (" + maxHealth + ") for " + name + ". maxHealth set to 100.");
            this.maxHealth = 100;
        } else {
            this.maxHealth = maxHealth;
        }

        this.health = this.maxHealth;
    }

    public boolean isAlive() {
        return health > 0;
    }

    public int takeDamage(int damage) {
        if (damage <= 0 || !isAlive()) {
            return 0;
        }
        int taken = Math.min(damage, health);
        health -= taken;
        return taken;
    }

    public int restoreHealth(int amount) {
        if (amount <= 0 || !isAlive()) {
            return 0;
        }
        int restored = Math.min(amount, maxHealth - health);
        health += restored;
        return restored;
    }

    public abstract String getCharacterInfo();

    public abstract int calculatePower();

    public String getName() {
        return name;
    }

    public int getLevel() {
        return level;
    }

    public int getHealth() {
        return health;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public double getHealthRatio() {
        return (double) health / maxHealth;
    }

    protected String getBaseInfo() {
        return name + " | Level: " + level + " | Health: " + health + "/" + maxHealth
                + " | Power: " + calculatePower() + " | " + (isAlive() ? "Alive" : "Defeated");
    }
}

