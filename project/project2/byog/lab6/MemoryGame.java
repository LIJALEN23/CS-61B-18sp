//package byog.lab6;
//
//
//import byog.TileEngine.TERenderer;
//import byog.TileEngine.TETile;
//import project0.StdDraw;
//
//import java.awt.Color;
//import java.awt.Font;
//import java.util.Random;
//import java.util.Scanner;
//
//public class MemoryGame {
//    private int width;
//    private int height;
//    private int round;
//    private Random rand;
//    private boolean gameOver;
//    private boolean playerTurn;
//    private static final char[] CHARACTERS = "abcdefghijklmnopqrstuvwxyz".toCharArray();
//    private static final String[] ENCOURAGEMENT = {"You can do this!", "I believe in you!",
//                                                   "You got this!", "You're a star!", "Go Bears!",
//                                                   "Too easy for you!", "Wow, so impressive!"};
//
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//
//        int seed = 0;
//
//        if (args.length < 1) {
//            System.out.println("Please enter a seed: ");
//            seed = scanner.nextInt();
//        }
//        else {
//            seed = Integer.parseInt(args[0]);
//        }
//
//        MemoryGame game = new MemoryGame(40, 40, seed);
//
//        game.drawFrame(game.generateRandomString(game.round));
//
//        game.startGame();
//    }
//
//    public MemoryGame(int width, int height, int seed) {
//        /* Sets up StdDraw so that it has a width by height grid of 16 by 16 squares as its canvas
//         * Also sets up the scale so the top left is (0,0) and the bottom right is (width, height)
//         */
//        this.width = width;
//        this.height = height;
//        StdDraw.setCanvasSize(this.width * 16, this.height * 16);
//        Font font = new Font("Monaco", Font.BOLD, 30);
//        StdDraw.setFont(font);
//        StdDraw.setXscale(0, this.width);
//        StdDraw.setYscale(0, this.height);
//        StdDraw.clear(Color.BLACK);
//        StdDraw.enableDoubleBuffering();
//
//        //TODO: Initialize random number generator
//        rand = new Random(seed);
//    }
//
//    public String generateRandomString(int length) {
//        String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
//        StringBuilder string = new StringBuilder(length);
//        for (int i = 0; i < length; i++) {
//            string.append(CHARACTERS.charAt(rand.nextInt(CHARACTERS.length())));
//        }
//        return string.toString();
//    }
//
//    public void drawFrame(String s) {
//        //TODO: Take the string and display it in the center of the screen
//        TERenderer ter = new TERenderer();
//        ter.initialize(width, height);
//
//        TETile[][] screen = new TETile[width][height];
//
//        StdDraw.clear();
//        StdDraw.setFont();
//        StdDraw.text(2, 2, s);
//        StdDraw.setPenColor(Color.red);
//        StdDraw.show();
//        //TODO: If game is not over, display relevant game information at the top of the screen
//    }
//
//    public void flashSequence(String letters) {
//        //TODO: Display each character in letters, making sure to blank the screen between letters
//    }
//
//    public String solicitNCharsInput(int n) {
//        //TODO: Read n letters of player input
//        return null;
//    }
//
//    public void startGame() {
//        //TODO: Set any relevant variables before the game starts
//
//        //TODO: Establish Game loop
//    }
//
//}
