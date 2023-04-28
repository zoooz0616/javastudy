package ch19.sec02;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetAddressExample {
	public static void main(String[] args) {
		try {
			InetAddress local=InetAddress.getLocalHost();
			System.out.println("내 컴퓨터 IP: "+local.getHostAddress());
			InetAddress[] iaArrAddresses =InetAddress.getAllByName("www.naver.com");
			for (InetAddress remote:iaArrAddresses) {
				System.out.println("네이버 ip: "+remote);
			}
		} catch (UnknownHostException e) {
			// TODO: handle exception
		}
	}
}
