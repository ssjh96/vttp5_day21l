package vttp5.paf.day21.util;

public class Queries {
    
    // SQL Commands
    // Game
    public static final String SQL_SELECT_GAME =    
        """
            select * from game limit 10
        """; // triple quotes for multiple lines?

    public static final String SQL_SELECT_GAME_LIMIT = 
        """
            select * from game limit ?
        """;

    // Books
    public static final String SQL_KINDLE_AUTHOR_LIMIT = 
        """
            select * from kindle where author like ? limit ?
        """;

    public static final String SQL_KINDLE_ASIN = 
        """
            select * from kindle where asin = ? 
        """;
}
