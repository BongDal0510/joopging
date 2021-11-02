package com.team4.joopging.controller;

import com.team4.joopging.entity.Article;
import com.team4.joopging.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping(value = "/article")
public class ArticleController {

    @Autowired
    private ArticleRepository articleRepository;

    @GetMapping(value = "/{id}")
    public String getArticle(Model model, @PathVariable int id) {
        Article article = articleRepository.findById(id).orElse(null);
        model.addAttribute("article", article);
        return "/article/detail";
    }

    @GetMapping(value = "")
    public String getArticleList(Model model) {
        List<Article> articleList = articleRepository.findAll();
        model.addAttribute("articleList", articleList);
        return "/article/list";
    }

    @PostMapping(value = "")
    public String setArticle(Article article) {
        article.setRegDate(new Date());

        System.out.println(article);

        return "redirect:/article/" + articleRepository.save(article).getId();
    }
}

