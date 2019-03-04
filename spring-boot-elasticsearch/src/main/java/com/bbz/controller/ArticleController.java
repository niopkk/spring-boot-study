package com.bbz.controller;

import com.bbz.base.BaseController;
import com.bbz.base.ResultView;
import com.bbz.entity.index.Article;
import com.bbz.serch.ArticleSeachTerm;
import com.bbz.service.ArticleService;
import com.bbz.util.Dates;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashSet;
import java.util.UUID;

@Controller
@RequestMapping("/article")
public class ArticleController extends BaseController {

    @Autowired
    private ArticleService articleService;


    @RequestMapping(value = "/getArticleList", method = RequestMethod.GET)
    @ResponseBody
    public ResultView getArticleList(ArticleSeachTerm term) {
        PageRequest request = PageRequest.of(0, 20);
        Page<Article> page = articleService.findArticleList(term, request);
        return okResult("查询成功", page.getContent(), page.getTotalElements());
    }


    @RequestMapping("/save")
    @ResponseBody
    public ResultView save() {
        Article article = new Article();
        article.setId(UUID.randomUUID().toString());
        article.setArticleId("XHDK-A-1293-#fJ4");
        article.setUserId("2");
        article.setHidden(false);
        article.setPostDate(Dates.unixNow());
        article.setViewCnt(80);
        article.setTypes(new HashSet<String>() {
            {
                add("新闻11111");
            }
        });
        articleService.save(article);
        return okResult("保存成功!");
    }
}
