package com.bbz.service.impl;

import com.bbz.entity.index.Article;
import com.bbz.repository.ArticleRepository;
import com.bbz.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArticleServiceIpml implements ArticleService {

    @Autowired
    private ArticleRepository articleRepository;


    @Override
    public Article save(Article article) {
        return articleRepository.save(article);
    }
}
