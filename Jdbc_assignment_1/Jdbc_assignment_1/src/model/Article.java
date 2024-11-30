package model;

import java.util.Date;

public class Article {
    private int id;
    private String name;
    private Category category;
    private Date dateCreated;
    private String creatorName;

    public enum Category {
        PAINTING, SCULPTURE, ARTIFACT;
    }


    public Article() {}

    public Article(int id, String name, Category category, Date dateCreated, String creatorName) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.dateCreated = dateCreated;
        this.creatorName = creatorName;
    }

    // Getters and Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public Category getCategory() { return category; }
    public void setCategory(Category category) { this.category = category; }

    public Date getDateCreated() { return dateCreated; }
    public void setDateCreated(Date dateCreated) { this.dateCreated = dateCreated; }

    public String getCreatorName() { return creatorName; }
    public void setCreatorName(String creatorName) { this.creatorName = creatorName; }

    @Override
    public String toString() {
        return "Article [id=" + id + ", name=" + name + ", category=" + category 
                + ", dateCreated=" + dateCreated + ", creatorName=" + creatorName + "]";
    }
}
