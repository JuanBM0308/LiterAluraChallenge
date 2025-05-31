package com.juanba.LiteAluraChallenge;

import com.juanba.LiteAluraChallenge.entity.Book;
import com.juanba.LiteAluraChallenge.menu.ShowMenu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LiteAluraChallengeApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(LiteAluraChallengeApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		ShowMenu showMenu = new ShowMenu();
		showMenu.show();
	}
}
