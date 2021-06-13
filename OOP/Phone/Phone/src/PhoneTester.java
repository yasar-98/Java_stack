
public class PhoneTester {
	public static void main(String[] args) {
		Galaxy S9=new Galaxy("S9",99,"Verison","Ring Ring Ring");
		IPhone iphoneTen=new IPhone("x",100,"AT","Zing");
		S9.displayInfo();
		System.out.println(S9.ring());
		System.out.println(S9.unlock());
		
		iphoneTen.displayInfo();
		System.out.println(iphoneTen.ring());
		System.out.println(iphoneTen.unlock());
	}
}
