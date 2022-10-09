package com.laioffer.tinnews.database;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.laioffer.tinnews.model.Article;

import java.util.List;

@Dao
public interface ArticleDao {

    @Query("select * from article")
    LiveData<List<Article>> getAllArticles();

    @Insert
    void saveArticle(Article... article);

    @Delete
    void deleteArticle(Article article);
}
