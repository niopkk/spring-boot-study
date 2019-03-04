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

import java.util.List;

@Service
public class ArticleServiceIpml implements ArticleService {

    @Autowired
    private ArticleRepository articleRepository;


    /**
     * 构建查询条件
     *
     * @param seach
     * @return
     */
    private BoolQueryBuilder createQuery(ArticleSeachTerm seach) {
        BoolQueryBuilder builder = QueryBuilders.boolQuery();
//        builder.must(QueryBuilders.termQuery("userId", seach.getUserId()));
//        builder.must(QueryBuilders.termQuery("articleId", seach.getArticleId()));
//        builder.must(QueryBuilders.rangeQuery("view_cnt").gte(30).lt(50));
//        builder.must(QueryBuilders.multiMatchQuery("书", "title", "content"));
//        builder.must(QueryBuilders.rangeQuery("viewCnt").gte(20).lt(50));


        return builder;
    }


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
}
