import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.HashMap;
import java.util.stream.IntStream;
import java.util.Arrays;

public class PuzzleJava {
    public static void main(String[] args) {
        ArrayList<Integer> numbers = new ArrayList<Integer>();
        numbers.add(5);
        numbers.add(4);
        numbers.add(3);
        numbers.add(2);
        numbers.add(1);
        
        //Collections.shuffle(numbers);
        //System.out.println(numbers); // [1, 5, 2, 4, 3]
        //Collections.sort(numbers);
        //System.out.println(numbers); // [1, 2, 3, 4, 5]
                
        //Random r = new Random();
        //System.out.println(r.nextInt()); // without bounds
        //System.out.println(r.nextInt(5)); // with bounds 0 to 5
		PuzzleJava puzz = new PuzzleJava();
		int[] arr ={1,3,2,4,5,70};
		String[] arr2 ={"ahmad","saeed","zaid","anas","mahmoud"};
		//System.out.println(puzz.sumLarger10(arr));
		//System.out.println(puzz.longer5(arr2));
		Character[] alphabet = {
		'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'
		};
		//puzz.shuffleChar(alphabet);
		//System.out.println(puzz.random55());
		//puzz.random55Sort();
		//puzz.string5();
		puzz.arrString5();
		
    }
	public ArrayList<Integer> sumLarger10(int[] myArray){
		int sum = 0;
		ArrayList<Integer> list = new ArrayList<Integer>();
		for(int i = 0; i < myArray.length; i++){
			sum+=myArray[i];
			if (myArray[i]>10){
				list.add(myArray[i]);
			}
		}
		System.out.println(sum);
		return list;
	}
	public ArrayList<String> longer5(String[] myArray){
		ArrayList<String> list = new ArrayList<String>();
		ArrayList<String> list2 = new ArrayList<String>();
		for(int i = 0; i < myArray.length; i++){
			list.add(myArray[i]);
			if (myArray[i].length()>5){
				list2.add(myArray[i]);
			}
		}
		Collections.shuffle(list);
		System.out.println(list);
		return list2;
	}
	public void shuffleChar(Character[] myArray){
		ArrayList<Character> list = new ArrayList<Character>();
		Character[] vow ={'a','e','i','o','u'};
		for(int i = 0; i < myArray.length; i++){
			list.add(myArray[i]);
		}
		Collections.shuffle(list);
		System.out.println(list.get(list.size() - 1));
		for (Character x : vow) {
			if (list.get(0) == x) {
				System.out.println("It is a vowel");
			}
		}
	}
	public ArrayList<Integer> random55(){
		ArrayList<Integer> list = new ArrayList<Integer>();
		Random rand = new Random();
		for(int i = 1; i < 11; i++){
			list.add(rand.nextInt(45)+55);
		}
		return list;
	}
	public void random55Sort(){
		ArrayList<Integer> list = new ArrayList<Integer>();
		Random rand = new Random();
		for(int i = 1; i < 11; i++){
			list.add(rand.nextInt(45)+55);
		}
		Collections.sort(list);
		System.out.println(list);
		int max=list.get(0);
		int min=list.get(0);
		for (int i = 0; i < list.size(); i++){
			if(list.get(i)>max){
				max=list.get(i);
			}
			if(list.get(i)<min){
				min=list.get(i);
			}
		}
		System.out.println(max);
		System.out.println(min);

	}
	public void string5(){
		int leftLimit = 97; // letter 'a'
		int rightLimit = 122; // letter 'z'
		int targetStringLength = 5;
		Random random = new Random();
		StringBuilder buffer = new StringBuilder(targetStringLength);
		for (int i = 0; i < targetStringLength; i++) {
			int randomLimitedInt = leftLimit + (int) 
			  (random.nextFloat() * (rightLimit - leftLimit + 1));
			buffer.append((char) randomLimitedInt);
		}
		String generatedString = buffer.toString();

		System.out.println(generatedString);
	}
	public void arrString5(){
		int leftLimit = 97; // letter 'a'
		int rightLimit = 122; // letter 'z'
		int targetStringLength = 5;
		Random random = new Random();
		ArrayList<String> list = new ArrayList<String>();
		for(int j = 1; j < 11; j++){
			StringBuilder buffer = new StringBuilder(targetStringLength);
			for (int i = 0; i < targetStringLength; i++) {
				int randomLimitedInt = leftLimit + (int) 
				  (random.nextFloat() * (rightLimit - leftLimit + 1));
				buffer.append((char) randomLimitedInt);
			}
			String generatedString = buffer.toString();
			list.add(generatedString);
		}

		System.out.println(list);
	}


}
