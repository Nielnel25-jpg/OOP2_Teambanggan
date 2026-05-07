package Characters;
 
import Enemies.Enemy;
 

public abstract class DrowRanger extends Character {
 
    public DrowRanger() {
        super("DrowRanger",    120, 40,  20,  1,  0,   50,   0,   0,   0);
    }
 
    @Override
    public void displaySkills() {
        System.out.println();
        System.out.println("  0. Basic Attack       : Dmg " + getAttack()        + "          | Gain 30 Energy");
        System.out.println("  1. Yearner        : Dmg " + (getAttack() + 10) + "  | Cost 30 EN | CD 2 turns");
        System.out.println("  2. WhyCantBeMe?      : Dmg " + (getAttack() + 20) + "  | Cost 20 EN | CD 3 turns");
        System.out.println("  3. Death Shroud Strike : Dmg " + (getAttack() + 30) + "  | Cost 40 EN | CD 3 turns");
        System.out.println();
    }
 
    
    public void useBasic(Enemy enemy) {
        int dmg = getAttack();
        addEnergy(30);
        System.out.println("\n  DrowRanger looses a Shadow Shot from the dark!");
        System.out.println("  Deals " + dmg + " damage.");
        enemy.takeDamage(dmg);
    }
     @Override
    public void Skill1(Enemy enemy) {
        if (getSkill1CD() > 0) {
            System.out.println("  Poison Arrow is on cooldown! (" + getSkill1CD() + " turn/s left)");
            return;
        }
        if (getCurrentEnergy() < 30) {
            System.out.println("  Not enough energy for Poison Arrow!");
            return;
        }
        int dmg = rand.nextInt(11) + 5;           // 5–15 bonus
        setCurrentEnergy(getCurrentEnergy() - 30);
        int total = dmg + getAttack();
        System.out.println("\n  DrowRanger fires a venom-tipped arrow!");
        System.out.println("  Poison Arrow hits for " + total + " damage!");
        enemy.takeDamage(total);
        setSKill1CD(2);
    }
 
    // ── Skill 2 — Rain of Arrows ─────────────────
    @Override
    public void useSkill2(Enemy enemy) {
        if (getSkill2CD() > 0) {
            System.out.println("  Rain of Arrows is on cooldown! (" + getSkill2CD() + " turn/s left)");
            return;
        }
        if (getCurrentEnergy() < 20) {
            System.out.println("  Not enough energy for Rain of Arrows!");
            return;
        }
        int dmg = rand.nextInt(11) + 15;          // 15–25 bonus
        setCurrentEnergy(getCurrentEnergy() - 20);
        int total = dmg + getAttack();
        System.out.println("\n  The sky darkens — DrowRanger unleashes a hail of arrows!");
        System.out.println("  Rain of Arrows strikes for " + total + " damage!");
        enemy.takeDamage(total);
        setSKill2CD(3);
    }
 
    // ── Skill 3 — Death Shroud Strike ────────────
    @Override
    public void useSkill3(Enemy enemy) {
        if (getSkill3CD() > 0) {
            System.out.println("  Death Shroud Strike is on cooldown! (" + getSkill3CD() + " turn/s left)");
            return;
        }
        if (getCurrentEnergy() < 40) {
            System.out.println("  Not enough energy for Death Shroud Strike!");
            return;
        }
        int dmg = rand.nextInt(16) + 20;          // 20–35 bonus
        setCurrentEnergy(getCurrentEnergy() - 40);
        int total = dmg + getAttack();
        System.out.println("\n  DrowRanger vanishes into shadow and reappears behind the enemy!");
        System.out.println("  Death Shroud Strike devastates for " + total + " damage!");
        enemy.takeDamage(total);
        setSKill3CD(3);
    }
}
