class Calculator{
	private Integer num1;
	private Integer num2;
	private Integer result;
	private char operation;
	public Calculator(){
		
	}
	public static void main(String[] args){
		Calculator c = new Calculator();
		c.setnum1(5);
		c.setnum2(7);
		c.setOperation('+');
		c.getResult();
	}
	
	public void getResult() {
		if (this.operation=='+'){
			this.result = num1+num2;
			System.out.println(result);
		}else if(this.operation=='-'){
			this.result = num1-num2;
			System.out.println(result);
		}else {
			System.out.println("no operation available");
		}
	}
	public void setOperation(char operation){
		this.operation=operation;
	}
	public void setnum1(Integer num1){
		this.num1= num1;
	}
	public void setnum2(Integer num2){
		this.num2= num2;
	}

}