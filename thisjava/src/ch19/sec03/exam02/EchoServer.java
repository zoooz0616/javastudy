package ch19.sec03.exam02;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class EchoServer {
	private static ServerSocket serverSocket = null;
	public static void main(String[] args) {
		System.out.println("------------------------------------------");
		System.out.println("서버를 종료하려면 q를 입력하고 Enter 키를 입력하세요");
		System.out.println("-------------------------------------------");
		
		startServer();
		Scanner scanner = new Scanner(System.in);
		while(true) {
			String key=scanner.nextLine();
			if (key.toLowerCase().equals("q")) {
				break;
			}
		}
		scanner.close();
		
		stopServer();
	}
	
	public static void startServer() {
		Thread thread = new Thread() {
			@Override
			public void run() {
				try {
					serverSocket = new ServerSocket(50001);
					System.out.println("[서버] 시작됨");
					
					while (true) {
						System.out.println("\n[서버] 연결 요청을 기다림\n");
						Socket socket = serverSocket.accept();
						
						InetSocketAddress isa=
								(InetSocketAddress)socket.getRemoteSocketAddress();
						System.out.println("[서버]"+isa.getHostName()+"의 연결 요청을 수락함");
						
						DataInputStream dis = new DataInputStream(socket.getInputStream());
						String message=dis.readUTF();
						
						DataOutputStream dos=new DataOutputStream(socket.getOutputStream());
						dos.writeUTF(message);
						dos.flush();
						System.out.println("[서버] 받은 데이터를 다시 보냄: "+message);
						
						socket.close();
						System.out.println("[서버]"+isa.getHostName()+"의 연결을 끊음");
					}
				} catch (Exception e) {
					// TODO: handle exception
				}
			}
		};
	}
	
	public static void stopServer() {
		try {
			serverSocket.close();
			System.out.println("[서버] 종료됨");
		} catch (IOException e) {
			// TODO: handle exception
		}
	}
}
