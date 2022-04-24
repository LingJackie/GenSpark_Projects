

public class Main {

    public static void main(String args[]){
//        GameWorld tmpWorld =new GameWorld();
//        System.out.println(tmpWorld);

//        Actor player = new Actor("jackie",10,5,10);
//        Actor goblin = new Actor("gobby",10,5,10);
//        System.out.println(goblin.getStats());
//        System.out.println(goblin.attack(player));

        HumansVsGoblins game1 = new HumansVsGoblins();
        game1.gameLoop();

//        double[][] stuff = new double[30][90];
//
//        final String ANSI_YELLOW = "\u001B[33m";
//        final String ANSI_GREEN = "\u001B[32m";
//        final String ANSI_CYAN = "\u001B[36m";
//        final String ANSI_BLUE = "\u001B[34m";
//        final String ANSI_RESET = "\u001B[0m";
//
//        String WATER_WAVE_EMOJI = "\uD83C\uDF0A";
//        String ALMOST_EQUALS_SYMBOL = "\u2248";
//        String TREE_EMOJI = "\uD83C\uDF32";
//        String POOFY_TREE_EMOJI = "\uD83C\uDF33";
//        String SPADE_SYMBOL ="\u2660";
//        String INTERSECTION_SYMBOL = "\u2229";
//        String CLUB_SYMBOL = 	"\u2663";
//        String TRANGLE_SYMBOL =	"\u25B2";
//
//        double scale = .045;// Play around with it should be under 0.1
//
//        for(int i = 0; i < stuff.length;i++){
//            for(int j = 0; j < stuff[0].length;j++){
//                stuff[i][j] = PerlinNoise.noise(i*scale,j*scale,7);
//                if(stuff[i][j] < -.3){// Water
//                    System.out.print(ANSI_BLUE+ALMOST_EQUALS_SYMBOL+ANSI_RESET);
//                }else if(stuff[i][j] < -.25){// Sand
//                    System.out.print(ANSI_YELLOW+ALMOST_EQUALS_SYMBOL+ANSI_RESET);
//                }else if(stuff[i][j] < 0){// Grasslands
//                    System.out.print(ANSI_GREEN+"="+ANSI_RESET);
//                }else if(stuff[i][j] < .2){// Forest1
//                    System.out.print(ANSI_GREEN+CLUB_SYMBOL+ANSI_RESET);
//                }else if(stuff[i][j] < .3){// Forest2
//                    System.out.print(ANSI_GREEN+SPADE_SYMBOL+ANSI_RESET);
//                }else if(stuff[i][j] < .4){// Low Hills
//                    System.out.print(ANSI_GREEN+"n"+ANSI_RESET);
//                }else if(stuff[i][j] <.6){// Tall Hills
//                    System.out.print(ANSI_GREEN+INTERSECTION_SYMBOL+ANSI_RESET);
//                }else if(stuff[i][j] <= 1){// Mountain
//                    System.out.print(TRANGLE_SYMBOL);
//                }
//            }
//            System.out.println();
//        }
    }
}
