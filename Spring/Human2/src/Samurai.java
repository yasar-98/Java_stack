public class Samurai extends Human2 {
    private static int numofSamurai = 0;
    private static int deftHealth = 200;
    public static int howMany() {
        return Samurai.numofSamurai;
    }
    public Samurai() {
        this.health = Samurai.deftHealth;
        Samurai.numofSamurai += 1;
    }
    public void deathBlow(Human2 target) {
        target.health = 0;
        this.health = (this.health/2);
    }
    public void meditate() {
        this.health = Samurai.deftHealth;
    }
}