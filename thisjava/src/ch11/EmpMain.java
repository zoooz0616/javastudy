package ch11;

public class EmpMain {
	public static void main(String[] args) {
		IEmpService empService = new EmpService();
		
		try{
			empService.insert(null);
		}catch (RuntimeException e) {
			System.out.println(e.getMessage());
		}
	}
}