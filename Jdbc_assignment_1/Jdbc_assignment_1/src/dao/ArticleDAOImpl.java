package dao;

import java.util.*;

import model.Article;

public class ArticleDAOImpl implements ArticleDAO {
    private final Map<Integer, Article> articles = new HashMap<>();

    @Override
    public void createArticle(Article article) {
        if (articles.containsKey(article.getId())) {
            System.out.println("Article with this ID already exists!");
        } else {
            articles.put(article.getId(), article);
            System.out.println("Article created successfully.");
        }
    }

    @Override
    public Article getArticleById(int id) {
        return articles.getOrDefault(id, null);
    }

    @Override
    public Collection<Article> getAllArticles() {
        return articles.values();
    }

    @Override
    public void updateArticle(Article article) {
        if (articles.containsKey(article.getId())) {
            articles.put(article.getId(), article);
            System.out.println("Article updated successfully.");
        } else {
            System.out.println("Article not found.");
        }
    }

    @Override
    public void deleteArticle(int id) {
        if (articles.remove(id) != null) {
            System.out.println("Article deleted successfully.");
        } else {
            System.out.println("Article not found.");
        }
    }
}
