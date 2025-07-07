package com.lfelipe.alura.music;

import com.lfelipe.alura.music.controller.GroqController;
import com.lfelipe.alura.music.repository.ArtistaRepository;
import com.lfelipe.alura.music.repository.MusicaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AluraMusicApplication implements CommandLineRunner {

	@Autowired
	MusicaRepository musicaRepository;
	@Autowired
	ArtistaRepository artistaRepository;
	@Autowired
	GroqController groqController;

	public static void main(String[] args) {
		SpringApplication.run(AluraMusicApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Menu menu = new Menu(artistaRepository, musicaRepository, groqController);
		menu.showMenu();
	}
}
