package com.bbz.service;

import java.util.List;
import java.util.Map;

public interface ArticleService {

    List<Map<String, Object>> search(int pageIndex, int pageSize,String key);


    List<Map<String, Object>> groupSearch(String group,int pageIndex, int pageSize);

    String store(String userId, String articleId);

    void addRemoveGroups(String articleId, String[] toAdd, String[] toRemove);

    void articleVote(String userId, String articleId);
}
