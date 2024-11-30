 package app;

 import java.text.SimpleDateFormat;
 import java.util.*;
 import dao.*;

import model.Article;

 public class ArticleApp {
     public static void main(String[] args) {
         ArticleDAO articleDAO = new ArticleDAOImpl();
         Scanner scanner = new Scanner(System.in);
         SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
         boolean exit = false;

         while (!exit) {
             System.out.println("\n===== Article Management System =====");
             System.out.println("1. Create Article");
             System.out.println("2. Get Article by ID");
             System.out.println("3. Get All Articles");
             System.out.println("4. Update Article");
             System.out.println("5. Delete Article");
             System.out.println("6. Exit");
             System.out.print("Enter your choice: ");
             int choice = scanner.nextInt();

             switch (choice) {
                 case 1: // Create Article
                     System.out.print("Enter Article ID: ");
                     int id = scanner.nextInt();
                     scanner.nextLine(); // Consume newline
                     System.out.print("Enter Article Name: ");
                     String name = scanner.nextLine();
                     System.out.print("Enter Category (PAINTING, SCULPTURE, ARTIFACT): ");
                     String categoryInput = scanner.nextLine().toUpperCase();
                     Article.Category category = Article.Category.valueOf(categoryInput);
                     System.out.print("Enter Creator Name: ");
                     String creatorName = scanner.nextLine();
                     System.out.print("Enter Date Created (yyyy-MM-dd): ");
                     String dateStr = scanner.nextLine();
                     try {
                         Date dateCreated = dateFormat.parse(dateStr);
                         Article article = new Article(id, name, category, dateCreated, creatorName);
                         articleDAO.createArticle(article);
                     } catch (Exception e) {
                         System.out.println("Invalid date format. Please try again.");
                     }
                     break;

                 case 2: // Get Article by ID
                     System.out.print("Enter Article ID: ");
                     id = scanner.nextInt();
                     Article article = articleDAO.getArticleById(id);
                     if (article != null) {
                         System.out.println(article);
                     } else {
                         System.out.println("Article not found.");
                     }
                     break;

                 case 3: // Get All Articles
                     Collection<Article> articles = articleDAO.getAllArticles();
                     if (articles.isEmpty()) {
                         System.out.println("No articles available.");
                     } else {
                         for (Article art : articles) {
                             System.out.println(art);
                         }
                     }
                     break;

                 case 4: // Update Article
                     System.out.print("Enter Article ID to Update: ");
                     id = scanner.nextInt();
                     scanner.nextLine(); // Consume newline
                     System.out.print("Enter New Article Name: ");
                     name = scanner.nextLine();
                     System.out.print("Enter New Category (PAINTING, SCULPTURE, ARTIFACT): ");
                     categoryInput = scanner.nextLine().toUpperCase();
                     category = Article.Category.valueOf(categoryInput);
                     System.out.print("Enter New Creator Name: ");
                     creatorName = scanner.nextLine();
                     System.out.print("Enter New Date Created (yyyy-MM-dd): ");
                     dateStr = scanner.nextLine();
                     try {
                         Date dateCreated = dateFormat.parse(dateStr);
                         article = new Article(id, name, category, dateCreated, creatorName);
                         articleDAO.updateArticle(article);
                     } catch (Exception e) {
                         System.out.println("Invalid date format. Please try again.");
                     }
                     break;

                 case 5: // Delete Article
                     System.out.print("Enter Article ID to Delete: ");
                     id = scanner.nextInt();
                     articleDAO.deleteArticle(id);
                     break;

                 case 6: // Exit
                     exit = true;
                     System.out.println("Exiting the system. Goodbye!");
                     break;

                 default:
                     System.out.println("Invalid choice. Please try again.");
             }
         }
         scanner.close();
     }
 }
