import java.util.ArrayList;
import java.lang.Math;

public class BasicJava {

    public void print255() {
		for(int i = 1; i <= 255; i++){
			System.out.println(i);
		}
	}	
	public void printOdd255() {
		for(int i = 1; i <= 255; i+=2){
			System.out.println(i);
		}
	}
	public void printSum255() {
		Integer sum = 0;
		for(int i = 1; i <= 255; i++){
			sum += i;
			System.out.println("New number : " + i + " Sum :" + sum);

		}
	}
	public void arrayLoop(int[] x) {
		for(int i = 0; i < x.length; i++){
			System.out.println(x[i]);
		}
	}
	public void arrayMax(int[] x) {
		int max =x[0];
		for(int i = 0; i < x.length; i++){
			if(x[i] > max){
				max = x[i];
			}
		}
		System.out.println(max);
	}
	public void printAvg(int[] x) {
		Integer sum = 0;
		Integer avg = 0;		
		for(int i = 0; i <x.length; i++){
			sum += x[i];
		}
		avg = sum / x.length;
		System.out.println(avg);
	}
	public void arrayOdd255() {
		ArrayList<Object> list = new ArrayList<Object>();
		for(int i = 1; i <= 255; i+=2){
			list.add(i);
		}
		System.out.println(list);
	}
	public void printGreaterY(int[] x, int y) {
		Integer c = 0;
		for(int i = 0; i <x.length; i++){
			if(x[i]>y){
				c++;
			}
		}
		System.out.println(c);
	}
	public int[] printSquare(int[] x) {
		for(int i = 0; i <x.length; i++){
			x[i] = (int)Math.pow(x[i],2);
		}
		return x;
	}
	public int[] eliminateNeg(int[] x) {
		for(int i = 0; i <x.length; i++){
			if(x[i]<0){
				x[i] = 0;
			}
		}
		return x;
	}
	public void printMaxMinAvg(int[] x) {
		Integer sum = 0;
		Integer avg = 0;		
		Integer max = x[0];		
		Integer min = x[0];		
		for(int i = 0; i <x.length; i++){
			sum += x[i];
			if(x[i] > max){
				max = x[i];
			}
			if(x[i] < min){
				min = x[i];
			}
		}
		avg = sum / x.length;
		System.out.println(max);
		System.out.println(min);
		System.out.println(avg);
	}
	public int[] shiftValue(int[] x) {
		for(int i = 0; i< x.length -1 ; i++){
			x[i]=x[i+1];
		}
		x[ x.length -1 ] = 0;
		return x;
	}
}