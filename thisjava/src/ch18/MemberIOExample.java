package ch18;

import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

public class MemberIOExample {
	public static void main(String[] args) {
		List<Member> memberlist=new ArrayList<Member>();
		FileInputStream reader = null;
		DataInputStream in=null;
		memberlist.add(new Member("홍길동",20,30000,"hong@hong.com"));
		memberlist.add(new Member("홍길서",24,10000.5,"west@hong.com"));
		memberlist.add(new Member("홍길남",28,20000,"honghong@hong.com"));
		FileWriter writer=null;
		BufferedWriter out = null;
		try {
			writer =new FileWriter("member.csv");
			out=new BufferedWriter(writer);
			for(Member m:memberlist) {
				out.write(m.toCSV()+"\n");
			}
			System.out.println("file saved");
		}catch (IOException e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				out.close();
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		try {
			reader = new FileInputStream("member.data");
			in=new DataInputStream(reader);
			while(true) {
				String name=in.readUTF();
				if (name==null || name.trim().length()==0) {
					break;
				}
				int age= in.readInt();
				double salary=in.readDouble();
				String email=in.readUTF();
				memberlist.add(new Member(name, age, salary,email));
			}
		}catch (Exception e) {
			// TODO: handle exception
		}
	}
}

@AllArgsConstructor @NoArgsConstructor
@Setter @Getter @ToString
class Member{
	private String name;
	private int age;
	private double salary;
	private String email;
	
	public String toCSV() {
		return name+","+age+","+salary+","+email;
	}
}