package byog.lab5;
import org.junit.Test;
import static org.junit.Assert.*;

import byog.TileEngine.TERenderer;
import byog.TileEngine.TETile;
import byog.TileEngine.Tileset;

import java.util.Random;

/**
 * Draws a world consisting of hexagonal regions.
 */
public class HexWorld {

    private static final long SEED = 2873123;
    private static final Random RANDOM = new Random(SEED);

    private static int computeWidth(int size) {
        return size * 2 + (size * 3 - 2) * 3 + 2 * 4;
    }

    private static int computeHeight(int size) {
        return 2 * size * 5 + 2 * 4;
    }

    private static void addRandomHexagon(TETile[][] tiles, int size, int x, int y) {
        int tileNum = RANDOM.nextInt(5);
        for (int i = 0; i < size; i += 1) {
            for (int j = x - i; j < x + i + size; j += 1) {
                tiles[j][y + i] = randomColorTile(tileNum);
                tiles[j][y + 2 * size - 1 - i] = randomColorTile(tileNum);
            }
        }
    }

    private static TETile randomColorTile(int tileNum) {
        return switch (tileNum) {
            case 1 -> TETile.colorVariant(Tileset.FLOWER, 25, 25, 25, RANDOM);
            case 2 -> TETile.colorVariant(Tileset.SAND, 25, 25, 25, RANDOM);
            case 3 -> TETile.colorVariant(Tileset.TREE, 25, 25, 25, RANDOM);
            case 4 -> TETile.colorVariant(Tileset.MOUNTAIN, 25, 25, 25, RANDOM);
            default -> TETile.colorVariant(Tileset.GRASS, 25, 25, 25, RANDOM);
        };
    }

    private static void add19Hexagon(TETile[][] tiles, int size, int firstX, int firstY) {
        addRandomHexagon(tiles, size, firstX, firstY);
        addRandomHexagon(tiles, size, firstX, firstY + 2 * size);
        addRandomHexagon(tiles, size, firstX, firstY + 4 * size);
        addRandomHexagon(tiles, size, firstX, firstY + 6 * size);
        addRandomHexagon(tiles, size, firstX, firstY + 8 * size);
        addRandomHexagon(tiles, size, firstX - 2 * size + 1, firstY + size);
        addRandomHexagon(tiles, size, firstX + 2 * size - 1, firstY + size);
        addRandomHexagon(tiles, size, firstX - 2 * size + 1, firstY + 3 * size);
        addRandomHexagon(tiles, size, firstX + 2 * size - 1, firstY + 3 * size);
        addRandomHexagon(tiles, size, firstX - 2 * size + 1, firstY + 5 * size);
        addRandomHexagon(tiles, size, firstX + 2 * size - 1, firstY + 5 * size);
        addRandomHexagon(tiles, size, firstX - 2 * size + 1, firstY + 7 * size);
        addRandomHexagon(tiles, size, firstX + 2 * size - 1, firstY + 7 * size);
        addRandomHexagon(tiles, size, firstX - 4 * size + 2, firstY + 2 * size);
        addRandomHexagon(tiles, size, firstX + 4 * size - 2, firstY + 2 * size);
        addRandomHexagon(tiles, size, firstX - 4 * size + 2, firstY + 4 * size);
        addRandomHexagon(tiles, size, firstX + 4 * size - 2, firstY + 4 * size);
        addRandomHexagon(tiles, size, firstX - 4 * size + 2, firstY + 6 * size);
        addRandomHexagon(tiles, size, firstX + 4 * size - 2, firstY + 6 * size);
    }

    public static void main(String[] args) {
        TERenderer ter = new TERenderer();
        int size = Integer.parseInt(args[0]);
        int width = computeWidth(size);
        int height = computeHeight(size);
        ter.initialize(width, height);
        TETile[][] tiles = new TETile[width][height];
        for (int x = 0; x < width; x += 1) {
            for (int y = 0; y < height; y += 1) {
                tiles[x][y] = Tileset.NOTHING;
            }
        }
        int firstX = 4 + (size * 3 - 2) + size * 2 - 1;
        int firstY = 4;
        add19Hexagon(tiles, size, firstX, firstY);
        ter.renderFrame(tiles);
    }
}
