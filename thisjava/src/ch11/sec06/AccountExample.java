package ch11.sec06;import java.nio.channels.AcceptPendingException;

public class AccountExample {

	public static void main(String[] args) {
		Account account = new Account();
		
		account.deposit(10000);
		System.out.println("예금액 : "+account.getBalance());
		
		//출금
		try {
			account.withdraw(30000);
		} catch (InsufficientException e) {
			String messageString = e.getMessage();
			System.out.println(messageString);
		}
	}

}
