package vttp5.paf.day21.repositories;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import vttp5.paf.day21.model.Game;
import vttp5.paf.day21.util.Queries;

@Repository
public class GameRepository {
    
    @Autowired
    private JdbcTemplate template;

    // List all show names
    // use bgg;
    // show databases;
    // show tables;

    // select * from game limit 10;

    public List<Game> getGames(int limit)
    {
        SqlRowSet rs = template.queryForRowSet(Queries.SQL_SELECT_GAME_LIMIT, limit);
        List<Game> results = new LinkedList<>(); // allows expansion?

        while (rs.next()) // while true, calling it the first time to move the cursor down once to read the record
        {
            // int gid = rs.getInt("gid");
            // String name = rs.get
            // Use model instead
            results.add(Game.toGame(rs));
        }

        return results;
    }


    // Default
    public List<Game> getGames()
    {
        return getGames(5);
    }


    // Never construct like this (concat), leads to sql injection, -10 marks in assessment
    // or true query will just give everything up, esp so in impt things like user pass
    // public List<Game> getGames(int limit)
    // {
    //     String query = "select * from game Limit " + limit;
    //     return null;
    // }

    
}
