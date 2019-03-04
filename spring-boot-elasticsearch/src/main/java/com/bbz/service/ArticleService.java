package com.bbz.service;

import com.bbz.entity.index.Article;
import com.bbz.serch.ArticleSeachTerm;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

public interface ArticleService {


    Page<Article> findArticleList(ArticleSeachTerm term, PageRequest request);

    Article save(Article article);
}
