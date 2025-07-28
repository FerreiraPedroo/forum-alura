package br.com.alura.forum_alura;

import org.flywaydb.core.Flyway;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ForumAluraApplication {

	public static void main(String[] args) {
		SpringApplication.run(ForumAluraApplication.class, args);

//		Flyway flyway = Flyway.configure()
//				.dataSource("jdbc:mysql://localhost:3306/forumAlura", "root", "root") // Substitua com suas credenciais
//				.load();
//
//		flyway.repair();

	}


}
