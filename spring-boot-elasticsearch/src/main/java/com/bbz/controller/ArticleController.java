package com.bbz.controller;

import com.bbz.base.BaseController;
import com.bbz.base.ResultView;
import com.bbz.entity.index.Article;
import com.bbz.service.ArticleService;
import com.bbz.util.Dates;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalDate;
import java.util.HashSet;

@Controller
@RequestMapping("/article")
public class ArticleController extends BaseController {

    @Autowired
    private ArticleService articleService;


    @RequestMapping(value = "/getArticleList", method = RequestMethod.GET)
    public ResultView getArticleList() {

        return null;
    }


    @RequestMapping("/save")
    @ResponseBody
    public ResultView save() {
        Article article = new Article();
        article.setArticleId("XHDK-A-1293-#fJ3");
        article.setUserId("1");
        article.setHidden(false);
        article.setPostDate(Dates.localDateToUdate(LocalDate.parse("2017-01-01")));
        article.setViewCnt(60);
        article.setTypes(new HashSet<String>() {
            {
                add("新闻");
            }
        });
        articleService.save(article);
        return okResult("保存成功!");
    }
}
