public class ProjectTest{
    public static void main(String[] args) {
		ProjectClass elevatorPitch = new ProjectClass();
		ProjectClass elevatorPitch2 = new ProjectClass("Isalm");
		elevatorPitch.setName("yasar");
		String name = elevatorPitch.getName();
		String name2 = elevatorPitch2.getName();
		System.out.println(name);
		System.out.println(name2);
	}
}