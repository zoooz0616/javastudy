package ch12.sec03.exam02;

public class Student {
	private int no;
	private String name;
	
	public Student(int no,String name) {
		this.no=no;
		this.name = name;
	}

	public int getNo() {
		return no;
	}

	public String getName() {
		return name;
	}

	@Override
	public int hashCode() {
		int result = no+name.hashCode();
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Student) {
			Student target = (Student)obj;
			if (no == target.getNo() && name.equals(target.getName()) ) {
				return true;
			}
		}
		return false;
	}
	
	
}
