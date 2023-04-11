package ch06.test.test19;

public class AccountExample {

	public static void main(String[] args) {
		Account account = new Account();
		
		account.setBalance(100000);
		System.out.println("현재 잔고: "+account.getBalance());
		
		account.setBalance(-100);
		System.out.println("현재 잔고: "+account.getBalance());
		
		account.setBalance(2000000);
		System.out.println("현재 잔고: "+account.getBalance());
		
		account.setBalance(30000);
		System.out.println("현재 잔고: "+account.getBalance());
	
	}

}
