public class Wizard extends Human2 {
    public Wizard() {
        this.health = 50;
        this.intelligence = 8;
    }

    public void heal(Human2 target) {
        target.health += this.intelligence;
    }

    public void fireball(Human2 target) {
        target.health -= (this.intelligence * 3);
    }

    
}