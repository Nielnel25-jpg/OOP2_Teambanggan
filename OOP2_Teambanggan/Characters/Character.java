import java.util.Random;

import Enemies.Enemy;

import java.text.DecimalFormat;

public abstract class Character {
    Random rand = new Random();

    private String name;
    private int currentHp;
    private int maxHp;
    private int currentEnergy;
    private int maxEnergy = 100;
    private int attack;
    private int level;
    private int exp;
    private double money = 10;
    private int tanggo;
    private int healingSalve;
    private int bottle;
    private int enhanceMango;
    private int skill1;
    private int skill2;
    private int skill3;

    public Character(String name, int hp, int energy, int attack, int level, int exp, double money, int skill1, int skill2, int skill3) {
        this.name = name;
        this.currentHp = hp;
        this.maxHp = hp;
        this.currentEnergy = energy;
        this.maxEnergy = energy;
        this.attack = attack;
        this.level = 1;
        this.exp = 0;
        this.money = money;
        this.skill1 = skill1;
        this.skill2 = skill2;
        this.skill3 = skill3;
    }

    // Player Actions and Status

    public int getDamage(){
        return attack;
    }
    public boolean isAlive() { 
        return currentHp > 0;
    }

    public void takeDamage(int amount){
        currentHp = Math.max(0, currentHp - amount);
    }

    public void heal(int amount) {
        currentHp = Math.min(maxHp, currentHp +  amount);
    }

    public void addExp(int exp){
        this.exp += exp;
    }

    public void addEnergy(int amount) {
        currentEnergy = Math.max(0, Math.min(maxEnergy, currentEnergy + amount));
    }


    public void setExp(int exp){
        this.exp = exp;
    }

    public void levelUp() {
        level++;
        maxHp += 10;
        currentHp = maxHp;
        attack += 5;
        System.out.println(getName() + " Leveled up!");
        currentEnergy = maxEnergy;
        exp -= 50;
    }

    public void rest(){
        currentEnergy = Math.min(maxEnergy, currentEnergy + 20);
        currentHp = Math.min(maxHp, currentHp + 15);
        
    }
    public void addMoney(double amount){
        this.money += amount;
    }
    public void useMoney(double amount){
        this.money -= amount;
    }


    // Items
    public void addTanggo(int amount){
        this.tanggo += amount;
    }
    public void addHealingSalve(int amount){
        this.healingSalve += amount;
    }
    public void addBottle(int amount){
        this.bottle += amount;
    }
    public void addEnhanceMango(int amount){
        this.enhanceMango += amount;
    }

    public void useTanggo(){
        heal(20);
        this.tanggo -= 1;
        System.out.println(name + " consumed tanggo, +20 HP" );
    }
    public void useHealingSalve(){
        heal(30);
        this.healingSalve -= 1;
        System.out.println(name + " consumed healing salve, +30 HP" );
    }
    public void useBottle(){
        addEnergy(15);
        this.bottle -= 1;
        System.out.println(name + " consumed bottle, +15 energy" );
    }
    public void useEnhanceMango(){
        addEnergy(30);
        this.enhanceMango -= 1;
        System.out.println(name + " consumed enhance mango, +30 energy" );
    }


    // Getters and Setters

    public String getName() { 
        return name; 
    }
    public int getHp() { 
        return currentHp; 
    }
    public int getMaxHp() { 
        return maxHp; 
    }
    public int getAttack() { 
        return attack;
    }
    public int getLevel() { 
        return level; 
    }
    public int getExp() {
        return exp; 
    }

    //Getters for money and items kay private sila then wala ka create og getters 
    public double getMoney(){
        return money;
    }

    public int getMaxEnergy() {
    return maxEnergy;
    }

    public int getCurrentEnergy() {
        return currentEnergy;
    }

    public void setCurrentEnergy(int currentEnergy){
        this.currentEnergy = currentEnergy;
    }

    public int getTanggo(){
        return tanggo;
    }
    public int getHealingSalve(){
        return healingSalve;
    }
    public int getBottle(){
        return bottle;
    }
    public int getEnhanceMango(){
        return enhanceMango;
    }


    public void showStats(){
        System.out.println("\n╔══════════════════════════════════════════════════════╗");
        System.out.println("  " + name + "'s' Stats ");
        System.out.println("  Level : " + level);
        System.out.println("  Exp   : " + getExp()+ "/50");
        System.out.println("  HP    : " + currentHp + "/" + maxHp);
        System.out.println("  Energy: " + currentEnergy + "/" + maxEnergy);
        System.out.println("╚══════════════════════════════════════════════════════╝");

    }

    public void displayStatus(){
        DecimalFormat df = new DecimalFormat("##,##0.00");

        System.out.println(name + " - HP: " + currentHp +  "/" + maxHp + " | Energy: " + currentEnergy + "/" + maxEnergy +
        " | level: " + level + " | exp: " + exp + " | Money: PHP " + df.format(money));

    }

    // cooldown 
    public int getSkill1CD() { return skill1; }
    public int getSkill2CD() { return skill2; }
    public int getSkill3CD() { return skill3; }

    public void setSkill1(int skill1){
        this.skill1 = skill1;
    }
    public void setSkill2(int skill2){
        this.skill2 = skill2;
    }
    public void setSSkill3(int skill3){
        this.skill3 = skill3;
    }

    public void reduceCooldowns(){
        if (skill1 > 0) skill1--;
        if (skill2 > 0) skill2--;
        if (skill3 > 0) skill3--;
    }

    
    // Hero Skills 
    public abstract void displaySkills();
    public abstract void useBasic(Enemy enemy);
    public abstract void useSkill1(Enemy enemy);
    public abstract void useSkill2(Enemy enemy);
    public abstract void useSkill3(Enemy enemy);

}