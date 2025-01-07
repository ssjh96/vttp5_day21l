package vttp5.paf.day21.model;

import org.springframework.jdbc.support.rowset.SqlRowSet;

// Model use the describe in sql cmd, describe game;
public class Game {
    
    public int gid;
    public String name;
    public int year;
    public int ranking;
    public int users_rated;
    public String url;
    public String image;

    public Game() {
    }

    public Game(int gid, String name, int year, int ranking, int users_rated, String url, String image) {
        this.gid = gid;
        this.name = name;
        this.year = year;
        this.ranking = ranking;
        this.users_rated = users_rated;
        this.url = url;
        this.image = image;
    }

    public int getGid() {
        return gid;
    }

    public void setGid(int gid) {
        this.gid = gid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getRanking() {
        return ranking;
    }

    public void setRanking(int ranking) {
        this.ranking = ranking;
    }

    public int getUsers_rated() {
        return users_rated;
    }

    public void setUsers_rated(int users_rated) {
        this.users_rated = users_rated;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    

    public static Game toGame(SqlRowSet rs)
    {
        Game g = new Game();

        g.setGid(rs.getInt("gid"));
        g.setName(rs.getString("name"));
        g.setYear(rs.getInt("year"));
        g.setRanking(rs.getInt("ranking"));
        g.setUsers_rated(rs.getInt("users_rated"));
        g.setUrl(rs.getString("url"));
        g.setImage(rs.getString("image"));

        return g;
    }
    

}
