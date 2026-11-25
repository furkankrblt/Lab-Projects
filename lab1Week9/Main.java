/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package lab1week9;

public class Main {

    public static void main(String[] args) {
        Team team = new Team("Heroes");
        team.addCharacter(new Warrior("Arthur", 10, 150, 8));
        team.addCharacter(new Mage("Merlin", 12, 100, 50));
        team.addCharacter(new Healer("Elara", 8, 90, 15));
        team.addCharacter(new Warrior("Lancelot", 9, 130, 6));

        Warrior golem = new Warrior("Golem", 15, 400, 20);

        System.out.println();
        team.displayTeam();
        System.out.println("Enemy: " + golem.getCharacterInfo());

        for (int round = 1; round <= 3; round++) {
            System.out.println("\n----- ROUND " + round + " -----");

            int dealt = team.attackAll(golem);
            System.out.println("Team dealt " + dealt + " damage in total. Golem health: "
                    + golem.getHealth() + "/" + golem.getMaxHealth());
            if (!golem.isAlive()) {
                System.out.println("Golem is defeated!");
                break;
            }

            for (GameCharacter member : team.getMembers()) {
                if (member.isAlive()) {
                    int damage = golem.attack(member);
                    System.out.println("Golem attacks " + member.getName() + " for " + damage
                            + " damage. (" + member.getHealth() + "/" + member.getMaxHealth() + ")");
                    if (!member.isAlive()) {
                        System.out.println(member.getName() + " is defeated!");
                    }
                }
            }

            int healed = team.healTeam();
            System.out.println("Team restored " + healed + " health in total.");
        }

        System.out.println("\n----- TEAM MANAGEMENT -----");
        team.removeCharacter("Lancelot");

        GameCharacter found = team.findByName("Merlin");
        System.out.println("Search 'Merlin': " + (found != null ? found.getCharacterInfo() : "not found"));
        GameCharacter notFound = team.findByName("Gandalf");
        System.out.println("Search 'Gandalf': " + (notFound != null ? notFound.getCharacterInfo() : "not found"));

        System.out.println();
        team.displayTeam();

        System.out.println("\n----- INVALID INPUT TESTS -----");
        team.addCharacter(new Healer("Elara", 5, 80, 10));
        Warrior badLevel = new Warrior("Bob", 150, 100, 5);
        Mage badHealth = new Mage("Zed", 5, -50, 30);
        System.out.println(badLevel.getCharacterInfo());
        System.out.println(badHealth.getCharacterInfo());
        team.removeCharacter("Nobody");

        Healer dummy = new Healer("Dummy", 1, 10, 5);
        dummy.takeDamage(999);
        System.out.println("Heal a defeated character: " + dummy.restoreHealth(50) + " restored");
        System.out.println("Attack a defeated character: " + golem.attack(dummy) + " damage");
    }
}
