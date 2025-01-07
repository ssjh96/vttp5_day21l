package vttp5.paf.day21.model;

import java.util.Date;

import org.springframework.jdbc.support.rowset.SqlRowSet;

public class Book 
{
    private String asin;
    private String title;
    private String author;
    private String soldBy;
    private String imgUrl;
    private String productURL;
    private float stars;
    private int reviews;
    private double price; // Can use BigDecimal also, for big values
    private Date publishedDate;
    private String category_name;

    public Book() {
    }
    
    public Book(String asin, String title, String author, String soldBy, String imgUrl, String productURL, float stars,
            int reviews, double price, Date publishedDate, String category_name) {
        this.asin = asin;
        this.title = title;
        this.author = author;
        this.soldBy = soldBy;
        this.imgUrl = imgUrl;
        this.productURL = productURL;
        this.stars = stars;
        this.reviews = reviews;
        this.price = price;
        this.publishedDate = publishedDate;
        this.category_name = category_name;
    }

    public String getAsin() {
        return asin;
    }

    public void setAsin(String asin) {
        this.asin = asin;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getSoldBy() {
        return soldBy;
    }

    public void setSoldBy(String soldBy) {
        this.soldBy = soldBy;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getProductURL() {
        return productURL;
    }

    public void setProductURL(String productURL) {
        this.productURL = productURL;
    }

    public float getStars() {
        return stars;
    }

    public void setStars(float stars) {
        this.stars = stars;
    }

    public int getReviews() {
        return reviews;
    }

    public void setReviews(int reviews) {
        this.reviews = reviews;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Date getPublishedDate() {
        return publishedDate;
    }

    public void setPublishedDate(Date publishedDate) {
        this.publishedDate = publishedDate;
    }

    public String getCategory_name() {
        return category_name;
    }

    public void setCategory_name(String category_name) {
        this.category_name = category_name;
    }   


     public static Book toBook(SqlRowSet rs)
    {
        Book b = new Book();

        b.setAsin(rs.getString("asin"));
        b.setTitle(rs.getString("title"));
        b.setAuthor(rs.getString("author"));
        b.setSoldBy(rs.getString("soldBy"));
        b.setImgUrl(rs.getString("imgUrl"));
        b.setProductURL(rs.getString("productURL"));
        b.setStars(rs.getFloat("stars"));
        b.setReviews(rs.getInt("reviews"));
        b.setPrice(rs.getDouble("price"));
        b.setPublishedDate(rs.getDate("publishedDate"));
        b.setCategory_name(rs.getNString("category_name"));

        return b;
    }
    
}
