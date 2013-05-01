package it.nicogiangregorio.passwordenc;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.StandardPasswordEncoder;

public class Main {
	PasswordEncoder encoder = new StandardPasswordEncoder();
	
	public static void main(String[] args) {
		StandardPasswordEncoder encoder = new StandardPasswordEncoder();
		System.out.println(encoder.encode("@dmin"));
		System.out.println(encoder.encode("@dmin"));
		System.out.println(encoder.encode("guest"));
		System.out.println(encoder.encode("guest"));
	}
}
