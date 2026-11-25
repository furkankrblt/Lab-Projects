/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab1week9;

/**
 *
 * @author mfkar
 */
import java.util.ArrayList;

public class Team {
    private String teamName;
    private ArrayList<GameCharacter> members;

    public Team(String teamName) {
        this.teamName = teamName;
        this.members = new ArrayList<>();
    }

    public boolean addCharacter(GameCharacter character) {
        if (character == null) {
            System.out.println("Error: cannot add a null character.");
            return false;
        }
        if (findByName(character.getName()) != null) {
            System.out.println("Error: a character named '" + character.getName() + "' is already in the team.");
            return false;
        }
        members.add(character);
        System.out.println(character.getName() + " joined the team.");
        return true;
    }

    public boolean removeCharacter(String name) {
        GameCharacter character = findByName(name);
        if (character == null) {
            System.out.println("Error: no character named '" + name + "' in the team.");
            return false;
        }
        members.remove(character);
        System.out.println(name + " was removed from the team.");
        return true;
    }

    public GameCharacter findByName(String name) {
        if (name == null) {
            return null;
        }
        for (GameCharacter c : members) {
            if (c.getName().equalsIgnoreCase(name)) {
                return c;
            }
        }
        return null;
    }

    public int attackAll(GameCharacter target) {
        int totalDamage = 0;
        for (GameCharacter c : members) {
            if (c.isAlive() && c instanceof Attacker) {
                int damage = ((Attacker) c).attack(target);
                System.out.println(c.getName() + " attacks " + target.getName() + " for " + damage + " damage.");
                totalDamage += damage;
            }
        }
        return totalDamage;
    }

    public int healTeam() {
        int totalHealed = 0;
        for (GameCharacter c : members) {
            if (c.isAlive() && c instanceof Supporter) {
                GameCharacter weakest = findLowestHealthRatio();
                if (weakest == null) {
                    break;
                }
                int healed = ((Supporter) c).heal(weakest);
                System.out.println(c.getName() + " heals " + weakest.getName() + " for " + healed + " health.");
                totalHealed += healed;
            }
        }
        return totalHealed;
    }

    private GameCharacter findLowestHealthRatio() {
        GameCharacter weakest = null;
        for (GameCharacter c : members) {
            if (c.isAlive() && (weakest == null || c.getHealthRatio() < weakest.getHealthRatio())) {
                weakest = c;
            }
        }
        return weakest;
    }

    public int getTotalPower() {
        int total = 0;
        for (GameCharacter c : members) {
            if (c.isAlive()) {
                total += c.calculatePower();
            }
        }
        return total;
    }

    public void displayTeam() {
        System.out.println("===== Team " + teamName + " (" + members.size() + " members) =====");
        for (GameCharacter c : members) {
            System.out.println("  " + c.getCharacterInfo());
        }
        System.out.println("  Total power of alive members: " + getTotalPower());
    }

    public ArrayList<GameCharacter> getMembers() {
        return members;
    }
}

