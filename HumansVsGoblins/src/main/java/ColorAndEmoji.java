public class ColorAndEmoji {
    // COLORS
    public static final String ANSI_YELLOW =    "\u001B[33m";
    public static final String ANSI_GREEN =     "\u001B[32m";
    public static final String ANSI_CYAN =      "\u001B[36m";
    public static final String ANSI_BLUE =      "\u001B[34m";
    public static final String ANSI_RED =       "\u001B[31m";
    public static final String ANSI_PURPLE =    "\u001B[35m";
    public static final String ANSI_RESET =     "\u001B[0m";

    // SYMBOLS
    public static final String ALMOST_EQUALS_SYMBOL =   "\u2248";
    public static final String SPADE_SYMBOL =           "\u2660";
    public static final String CLUB_SYMBOL = 	        "\u2663";
    public static final String INTERSECTION_SYMBOL =    "\u2229";
    public static final String TRANGLE_SYMBOL =	        "\u25B2";

    public static String CROSSED_SWORDS_EMOJI = "\u2694";

    public static final String WATER =      ANSI_BLUE + ALMOST_EQUALS_SYMBOL + ANSI_RESET;
    public static final String SAND =       ANSI_YELLOW + ALMOST_EQUALS_SYMBOL + ANSI_RESET;
    public static final String GRASS =      ANSI_GREEN + "=" + ANSI_RESET;
    public static final String TREE1 =      ANSI_GREEN + CLUB_SYMBOL + ANSI_RESET;
    public static final String TREE2 =      ANSI_GREEN + SPADE_SYMBOL + ANSI_RESET;
    public static final String LOW_HILL =	ANSI_GREEN + "n" + ANSI_RESET;
    public static final String TALL_HILL =	ANSI_GREEN + INTERSECTION_SYMBOL + ANSI_RESET;
    public static final String MOUNTAIN =	TRANGLE_SYMBOL;

}
