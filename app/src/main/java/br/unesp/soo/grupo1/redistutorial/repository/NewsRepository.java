package br.unesp.soo.grupo1.redistutorial.repository;

import br.unesp.soo.grupo1.redistutorial.entities.News;
import com.github.javafaker.Faker;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

import static br.unesp.soo.grupo1.redistutorial.config.RedisConfiguration.NEWS_KEY;

@Component
public class NewsRepository {
    private final Faker FAKER = new Faker();
    private final List<News> DATABASE = new ArrayList<>();
    private static final int NEWS_DB_SIZE = 100;

    @PostConstruct
    public void setup() {
        for (int index = 0; index < NEWS_DB_SIZE; index++) {
            DATABASE.add(News.builder()
                    .author(FAKER.name().fullName())
                    .title(FAKER.lorem().characters(10, 20))
                    .content(FAKER.lorem().characters(1000, 10_000))
                    .build());
        }
    }

    @Cacheable(value = NEWS_KEY)
    public List<News> findAll() {
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return DATABASE;
    }
}
