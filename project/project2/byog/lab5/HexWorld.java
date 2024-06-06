//package byog.lab5;
//import org.junit.Test;
//import static org.junit.Assert.*;
//
//import byog.TileEngine.TERenderer;
//import byog.TileEngine.TETile;
//import byog.TileEngine.Tileset;
//
//import javax.swing.text.Position;
//import java.awt.*;
//import java.util.Random;
//
///**
// * Draws a world consisting of hexagonal regions.
// */
//public class HexWorld {
//
//    //一个点的坐标(x,y)
//    public static class Position {
//        public int x;
//        public int y;
//
//        public Position(int x, int y) {
//            this.x = x;
//            this.y = y;
//        }
//    }
//
//    /**
//     * Computes the width of row i for a size s hexagon.
//     * @param s The size of the hex.
//     * @param i The row number where i = 0 is the bottom row.
//     * @return
//     */
//    public static int hexRowWidth(int s, int i) {
//        int effectiveI = i;
//        if (i >= s) {
//            effectiveI = 2 * s - 1 - effectiveI;
//        }
//
//        return s + 2 * effectiveI;
//    }
//
//    /**
//     * Computesrelative x coordinate of the leftmost tile in the ith
//     * row of a hexagon, assuming that the bottom row has an x-coordinate
//     * of zero. For example, if s = 3, and i = 2, this function
//     * returns -2, because the row 2 up from the bottom starts 2 to the left
//     * of the start position, e.g.
//     *   xxxx
//     *  xxxxxx
//     * xxxxxxxx
//     * xxxxxxxx <-- i = 2, starts 2 spots to the left of the bottom of the hex
//     *  xxxxxx
//     *   xxxx
//     *
//     * @param edgeLength size of the hexagon
//     * @param i row num of the hexagon, where i = 0 is the bottom
//     * @return
//     */
//    public static int hexRowOffset(int edgeLength, int i) {
//        int effectiveI = i;
//
//        if (i >= edgeLength) {
//            effectiveI = 2 * edgeLength - 1 - effectiveI;
//        }
//        return -effectiveI;
//    }
//
//    /**
//     * Adds a hexagon to the world.
//     * @param world the world to draw on
//     * @param p the bottom left coordinate of the hexagon
//     * @param edgeLength the size of the hexagon
//     * @param t the tile to draw
//     */
//
//
//    /** Adds a row of the same tile.
//     * @param world the world to draw on
//     * @param p the leftmost position of the row
//     * @param width the number of tiles wide to draw
//     * @param t the tile to draw
//     */
//    public static void addRow(TETile[][] world, Position p, int width, TETile t) {
//        Random RANDOM = new Random();
//        for (int xi = 0; xi < width; xi += 1) {
//            int xCoord = p.x + xi;
//            int yCoord = p.y;
//            world[xCoord][yCoord] = TETile.colorVariant(t, 32, 32, 32, RANDOM);
//        }
//    }
//
//   public static void addHexagon(int edgeLength, TETile[][] world, Position p, TETile t) {
//       if (edgeLength < 2) {
//           throw new IllegalArgumentException("Hexagon must be at least size 2!");
//       }
//
//       for (int yi = 0; yi < edgeLength * 2; yi++) {
//           int thisRowY = p.y + yi;
//
//           int xRowStart = p.x + hexRowOffset(edgeLength, yi);
//           Position rowStartP = new Position(xRowStart, thisRowY);
//
//           int rowWidth = hexRowWidth(edgeLength, yi);
//
//           addRow(world, rowStartP, rowWidth, t);
//       }
//   }
//
//
//
//
//    @Test
//    public void testHexRowWidth() {
//        assertEquals(3, hexRowWidth(3, 5));
//        assertEquals(5, hexRowWidth(3, 4));
//        assertEquals(7, hexRowWidth(3, 3));
//        assertEquals(7, hexRowWidth(3, 2));
//        assertEquals(5, hexRowWidth(3, 1));
//        assertEquals(3, hexRowWidth(3, 0));
//        assertEquals(2, hexRowWidth(2, 0));
//        assertEquals(4, hexRowWidth(2, 1));
//        assertEquals(4, hexRowWidth(2, 2));
//        assertEquals(2, hexRowWidth(2, 3));
//    }
//
//    @Test
//    public void testHexRowOffset() {
//        assertEquals(0, hexRowOffset(3, 5));
//        assertEquals(-1, hexRowOffset(3, 4));
//        assertEquals(-2, hexRowOffset(3, 3));
//        assertEquals(-2, hexRowOffset(3, 2));
//        assertEquals(-1, hexRowOffset(3, 1));
//        assertEquals(0, hexRowOffset(3, 0));
//        assertEquals(0, hexRowOffset(2, 0));
//        assertEquals(-1, hexRowOffset(2, 1));
//        assertEquals(-1, hexRowOffset(2, 2));
//        assertEquals(0, hexRowOffset(2, 3));
//    }
//
//
//
//    public static void main(String[] args) {
//        TERenderer ter = new TERenderer();
//        ter.initialize(40, 40);
//
//        TETile[][] world = new TETile[40][40];
//        Position p = new Position(1, 2);
//
//        TETile t = new TETile('#', Color.WHITE, Color.CYAN, "lijalen", "lijalen");
//
//        addHexagon(3, world, p, t);
//    }
//}
