package com.educandoweb.movies_api.config;

import com.educandoweb.movies_api.entities.*;
import com.educandoweb.movies_api.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.Instant;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private MovieRepository movieRepository;

    DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ActorRepository actorRepository;

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {

        Category category1 = new Category(null, "Terror");
        Category category2 = new Category(null, "Ficção Científica");
        Category category3 = new Category(null, "Drama");
        Category category4 = new Category(null, "Ação");

        categoryRepository.saveAll(Arrays.asList(category1, category2, category3, category4));

        User user1 = new User(null, "Rodrigo", "rodrigo@gmail.com", "senha123");
        User user2 = new User(null, "Fernanda", "fernanda@gmail.com", "senha456");
        User user3 = new User(null, "Ana", "ana@gmail.com", "senha789");

        userRepository.saveAll(Arrays.asList(user1, user2, user3));

        Actor actor1 = new Actor(null, "Ryan Gosling", LocalDate.of(1980,11,12), "Canadense");
        Actor actor2 = new Actor(null, "Emma Stone", LocalDate.of(1988,11,6), "Americana");
        Actor actor3 = new Actor(null, "Leonardo DiCaprio", LocalDate.of(1974,11,11), "Americano");
        Actor actor4 = new Actor(null, "Scarlett Johansson", LocalDate.of(1984, 11, 22), "Americana");

        actorRepository.saveAll(Arrays.asList(actor1, actor2, actor3, actor4));

        Movie movie1 = new Movie(null, "It: A Coisa", "Um grupo de crianças enfrenta um palhaço assustador.",
                LocalDate.of(2017, 9, 8), 7.3, category1);
        Movie movie2 = new Movie(null, "Interestelar", "Exploração espacial em busca de um novo lar para a humanidade.",
                LocalDate.of(2014, 11, 7), 8.7, category2);
        Movie movie3 = new Movie(null, "Titanic", "Romance épico baseado em uma tragédia real.",
                LocalDate.of(1997, 12, 19), 7.9, category3);
        Movie movie4 = new Movie(null, "Vingadores: Ultimato", "Os heróis enfrentam Thanos na batalha final.",
                LocalDate.of(2019, 4, 26), 8.4, category4);

        movieRepository.saveAll(Arrays.asList(movie1, movie2, movie3, movie4));

        // Associando atores aos filmes
        Set<Actor> actors1 = new HashSet<>(Arrays.asList(actor1, actor2));
        Set<Actor> actors2 = new HashSet<>(Arrays.asList(actor3));
        Set<Actor> actors3 = new HashSet<>(Arrays.asList(actor3, actor4));
        Set<Actor> actors4 = new HashSet<>(Arrays.asList(actor4));

        movie1.setActors(actors1);
        movie2.setActors(actors2);
        movie3.setActors(actors3);
        movie4.setActors(actors4);

        movieRepository.saveAll(Arrays.asList(movie1, movie2, movie3, movie4));

        // Criando comentários
        Comment comment1 = new Comment(null, "Filme assustador, Pennywise é sinistro!", user1, Instant.now(), movie1);
        Comment comment2 = new Comment(null, "Ótima história e efeitos visuais impressionantes!", user2, Instant.now(), movie2);
        Comment comment3 = new Comment(null, "Sempre me emociono com esse filme.", user3, Instant.now(), movie3);
        Comment comment4 = new Comment(null, "A melhor batalha final do cinema!", user1, Instant.now(), movie4);

        commentRepository.saveAll(Arrays.asList(comment1, comment2, comment3, comment4));
    }
}
