package br.unesp.soo.grupo1.redistutorial.controller;

import br.unesp.soo.grupo1.redistutorial.entities.News;
import br.unesp.soo.grupo1.redistutorial.repository.NewsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/news")
@RequiredArgsConstructor
public class NewsController {

    private final NewsRepository newsRepository;

    @GetMapping
    public List<News> findAll() {
        return newsRepository.findAll();
    }

}
