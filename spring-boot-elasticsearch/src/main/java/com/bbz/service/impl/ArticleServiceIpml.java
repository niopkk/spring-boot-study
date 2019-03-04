package com.bbz.service.impl;

import com.bbz.entity.index.Article;
import com.bbz.repository.ArticleRepository;
import com.bbz.serch.ArticleSeachTerm;
import com.bbz.service.ArticleService;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.SearchQuery;
import org.springframework.stereotype.Service;

@Service
public class ArticleServiceIpml implements ArticleService {

    @Autowired
    private ArticleRepository articleRepository;


    @Override
    public Page<Article> findArticleList(ArticleSeachTerm term, PageRequest request) {
        SearchQuery searchQuery = new NativeSearchQueryBuilder()
                .withQuery(createQuery(term))
                .withPageable(request)
                .build();
        return articleRepository.search(searchQuery);
    }

    @Override
    public Article save(Article article) {
        return articleRepository.save(article);
    }


    /**
     * 构建查询条件 (5.X以上版本 传入参数不能为 null)
     *
     * @param term
     * @return
     */
    private BoolQueryBuilder createQuery(ArticleSeachTerm term) {
        BoolQueryBuilder builder = QueryBuilders.boolQuery();
        if (term.getUserId() != null) {
            builder.filter(QueryBuilders.termQuery("userId", term.getUserId()));
        }
        if (term.getHidden() != null) {
            builder.filter(QueryBuilders.termQuery("hidden", term.getHidden()));
        }
        if (term.getPostDate() != null) {
            builder.filter(QueryBuilders.termQuery("postDate", term.getPostDate()));
        }

        return builder;
    }

}
