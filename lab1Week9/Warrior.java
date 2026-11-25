/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab1week9;

/**
 *
 * @author mfkar
 */
public class Warrior extends GameCharacter implements Attacker {

    private int armor;

    public Warrior(String name, int level, int maxHealth, int armor) {
        super(name, level, maxHealth);
        if (armor < 0) {
            System.out.println("Warning: invalid armor (" + armor + ") for " + name + ". Armor set to 0.");
            this.armor = 0;
        } else {
            this.armor = armor;
        }
    }

    @Override
    public int calculatePower() {
        return getLevel() * 10 + armor * 2;
    }

    @Override
    public int takeDamage(int damage) {
        if (damage <= 0) {
            return 0;
        }
        int reduced = Math.max(1, damage - armor / 2);
        return super.takeDamage(reduced);
    }

    @Override
    public int attack(GameCharacter target) {
        if (!isAlive() || target == null || !target.isAlive()) {
            return 0;
        }
        int damage = calculatePower() / 4;
        return target.takeDamage(damage);
    }

    @Override
    public String getCharacterInfo() {
        return "[Warrior] " + getBaseInfo() + " | Armor: " + armor;
    }

    public int getArmor() {
        return armor;
    }
}
