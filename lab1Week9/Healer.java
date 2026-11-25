/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab1week9;

/**
 *
 * @author mfkar
 */
public class Healer extends GameCharacter implements Supporter {
    private int healAmount;

    public Healer(String name, int level, int maxHealth, int healAmount) {
        super(name, level, maxHealth);
        if (healAmount < 0) {
            System.out.println("Warning: invalid healAmount (" + healAmount + ") for " + name + ". healAmount set to 0.");
            this.healAmount = 0;
        } else {
            this.healAmount = healAmount;
        }
    }

    @Override
    public int calculatePower() {
        return getLevel() * 5 + healAmount;
    }

    @Override
    public int heal(GameCharacter target) {
        if (!isAlive() || target == null || !target.isAlive()) {
            return 0;
        }
        return target.restoreHealth(healAmount + getLevel());
    }

    @Override
    public String getCharacterInfo() {
        return "[Healer] " + getBaseInfo() + " | Heal Amount: " + healAmount;
    }

    public int getHealAmount() {
        return healAmount;
    }
}
