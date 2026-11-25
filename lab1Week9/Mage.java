/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab1week9;

/**
 *
 * @author mfkar
 */
public class Mage extends GameCharacter implements Attacker, Supporter {

    private static final int ATTACK_MANA_COST = 20;
    private static final int HEAL_MANA_COST = 15;

    private int mana;

    public Mage(String name, int level, int maxHealth, int mana) {
        super(name, level, maxHealth);
        if (mana < 0) {
            System.out.println("Warning: invalid mana (" + mana + ") for " + name + ". Mana set to 0.");
            this.mana = 0;
        } else {
            this.mana = mana;
        }
    }

    @Override
    public int calculatePower() {
        return getLevel() * 8 + mana;
    }

    @Override
    public int attack(GameCharacter target) {
        if (!isAlive() || target == null || !target.isAlive()) {
            return 0;
        }
        if (mana < ATTACK_MANA_COST) {
            System.out.println(getName() + " does not have enough mana to attack!");
            return 0;
        }
        int power = calculatePower();
        mana -= ATTACK_MANA_COST;
        return target.takeDamage(power / 3);
    }

    @Override
    public int heal(GameCharacter target) {
        if (!isAlive() || target == null || !target.isAlive()) {
            return 0;
        }
        if (mana < HEAL_MANA_COST) {
            System.out.println(getName() + " does not have enough mana to heal!");
            return 0;
        }
        mana -= HEAL_MANA_COST;
        return target.restoreHealth(getLevel() * 2);
    }

    @Override
    public String getCharacterInfo() {
        return "[Mage] " + getBaseInfo() + " | Mana: " + mana;
    }

    public int getMana() {
        return mana;
    }
}
