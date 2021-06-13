public class BankAccountTest {
    public static void main(String[] args) {
		BankAccount first= new BankAccount();
		first.deposit(155.2,"checking");
		first.deposit(75.2,"saving");
		first.withDraw(72.4,"saving");
		System.out.println(first.getAllBalance());
		System.out.println(first.getCheckingBalance());
		System.out.println(first.getSavingBalance());
	}
}