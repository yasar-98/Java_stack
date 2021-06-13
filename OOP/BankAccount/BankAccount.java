import java.util.Random;

class BankAccount {
	String accountNumber="";
	Double checkingBalance=0.0;
	Double savingBalance=0.0;
	public static Integer numberOfAccount=0;
	public static Double totalMoney=0.0;
	public BankAccount(){
		numberOfAccount++;
		this.tenDigit();
	}
	private String tenDigit(){
		Random r = new Random();
		for(int i=1;i<11;i++){
			accountNumber+=r.nextInt(10);
		}
		return accountNumber;
	}


	public Double getCheckingBalance(){
		return this.checkingBalance;
	}
	public Double getSavingBalance(){
		return this.savingBalance;
	}
	public void deposit(Double money,String account){
		if (account.equals("saving")){
			this.savingBalance+=money;
			totalMoney+=money;
		}else if(account.equals("checking")){
			this.checkingBalance+=money;
			totalMoney+=money;
		}
	}
	public void withDraw(Double money,String account){
		if (account.equals("checking")){
			if (checkingBalance-money>0){
				this.checkingBalance-=money;
			}else{
				totalMoney-=money;
			}
		}else if(account.equals("saving")){
			if (savingBalance-money>0){
				this.savingBalance-=money;
				totalMoney-=money;
			}
		}
	}
	public Double getAllBalance(){
		return this.savingBalance+this.checkingBalance;
	}
	
}
