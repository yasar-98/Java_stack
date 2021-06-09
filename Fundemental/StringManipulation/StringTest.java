public class StringTest {
    public static void main(String[] args) {
		StringManipulator manipulator = new StringManipulator();
		String str = manipulator.trimAndConcat(" hello    ", "                 world    ");
		char letter ='z';
		int a = manipulator.getIndexOrNull("hello", letter);
		String subString = "world";
		int n = manipulator.getIndexOrNull("hello world", subString);
		String word = manipulator.concatSubstring("Hello", 1, 2, "world");

		System.out.println(str);
		System.out.println(a);
		System.out.println(n);
		System.out.println(word); // eworld

}
}


