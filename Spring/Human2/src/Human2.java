
public class Human2 {
	protected  int strength = 3;
	protected  String  name = "";
	protected  int stealth = 3;
	protected  int intelligence = 3;
	protected  int health = 100;
	public void attack(Human2 x){
		x.health=x.health- this.strength;
	}
}
