package bomberman_map;


import bomberman_map.builder.MapBuilder;
import bomberman_map.map_factory.Map;
import bomberman_map.map_services.item_map_factory.items.Bomberman;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * This is the famous Bomberman game.
 * <p>
 * A map is always a square. A bomberman can navigate the map using the commands :
 * forward : move forward by 1
 * right : turn right without moving
 * left : turn left without moving
 * <p>
 * The bomberman can put bombs in the map. After being triggered, all bombs put in the map explode.
 * Each bomb explosion can hit only what is directly next to it in every direction (top, bottom, left and right.
 * The bomberman dies when hit by an explosion.
 * <p>
 * A map can have rocks. The bomberman cannot bypass a rock. There are 3 types of rocks :
 * - a basic rock : this is the basic type. After being destroyed, it turns to a ' '.
 * - a star rock : this rock hides a star that can make the bomberman move by 2 steps instead of one step.
 * The star can be consumed once the rock is destroyed. When a star rock is destroyed, it turns to a '*'
 * - an enhancer rock : this rock take a number as a parameter. This rock hides an enhancer that make the explosion's extent
 * longer according to the number passed as a parameter.
 * It turns to the number it enhance the explosion. (example : '3' if the enhancer rock took 3 as a parameter).
 * <p>
 * All rocks are represented by 'X' before being destroyed by a bomb.
 *
 * @author SQli
 */
/*public class BomberTest {
    @Test
    public void aSimpleBombermanMap() {
        Map map = new MapBuilder(3)
                .addRock(1, 1) // line 1, column 1
                .addRock(2, 1) // line 2, column 1
                .build();
        String expectedMap =
                "   \n" +
                        " X \n" +
                        " X ";
        assertEquals(expectedMap, map.draw());
    }


    @Test
    public void aBombermanInAMap() {
        Map map = new MapBuilder(3).addRock(1, 1).build();

        Bomberman bomber = new Bomberman("Hamid"); // the bomberman's name is Hamid
        bomber.startIn(map);

        String expectedMap =
                "h  \n" +
                        " X \n" +
                        "   ";
        assertEquals(expectedMap, map.draw());
    }


    @Test
    public void aBombermanCanMoveForward() {
        Map map = new MapBuilder(3).addRock(1, 1).build();

        Bomberman bomber = new Bomberman("Hamid");
        bomber.startIn(map);

        bomber.forward().forward();

        String expectedMap =
                "  h\n" +
                        " X \n" +
                        "   ";
        assertEquals(expectedMap, map.draw());
    }


    /*@Test
    public void aBombermanCanMoveRight() {
        Map map = new MapBuilder(3).addRock(1, 1).build();

        Bomberman bomber = new Bomberman("Hamid");
        bomber.startIn(map);

        bomber.forward().forward().right().forward().forward();

        String expectedMap =
                "   \n" +
                        " X \n" +
                        "  h";
        assertEquals(expectedMap, map.draw());

        bomber.right().forward().forward()
                .right().forward();
        expectedMap =
                "   \n" +
                        "hX \n" +
                        "   ";
        assertEquals(expectedMap, map.draw());
    }


    @Test
    public void aBombermanCanPutABomb() {
        Map map = new MapBuilder(2).build();

        Bomberman bomber = new Bomberman("Hamid");
        bomber.startIn(map);

        String expectedMap =
                "h \n" +
                        "  ";
        assertEquals(expectedMap, map.draw());
        bomber.forward().bomb()
                .right().forward()
                .right().forward();

        expectedMap =
                " o\n" + // a bomb is represented by a 'o'
                        "h ";
        assertEquals(expectedMap, map.draw());

        map.trigger(); // this will fire all bombs put in the map
        expectedMap =
                "  \n" +
                        "h ";
        assertEquals(expectedMap, map.draw());
    }


    @Test
    public void aBombermanDiesWhenHitByExplosion() {
        Map map = new MapBuilder(2).build();
        Bomberman bomber = new Bomberman("Hamid");
        bomber.startIn(map);

        String expectedMap =
                "h \n" +
                        "  ";
        assertEquals(expectedMap, map.draw());

        bomber.forward().bomb().right().forward();

        expectedMap =
                " o\n" +
                        " h";
        assertEquals(expectedMap, map.draw());

        map.trigger();

        expectedMap =
                "  \n" +
                        " D";  // the bomberman is dead, and represented by 'D'

        assertEquals(expectedMap, map.draw());
    }


    @Test
    public void aBombermanCanDestroyARock() {
        Map map = new MapBuilder(3).addRock(1, 1).build();

        Bomberman bomber = new Bomberman("Hamid");
        bomber.startIn(map);
        String expectedMap = "h  \n"+
                " X \n"+
                "   ";
        assertEquals(expectedMap , map.draw());

        bomber.forward().bomb().forward().right().forward();
        expectedMap = " o \n"+ // a bomb is represented by a 'o'
                " Xh\n"+
                "   ";
        assertEquals(expectedMap , map.draw());

        map.trigger(); // this will fire all bombs put in the map
        expectedMap = "   \n"+
                "  h\n"+
                "   ";
        assertEquals(expectedMap , map.draw());

    }


    @Test
    public void aBombCanDestroyEverythingNextToIt() {
        Map map = new MapBuilder(3).addRock(0, 1).addRock(2, 1).addRock(1, 2).build();
        Bomberman bomber = new Bomberman("Hamid");
        bomber.startIn(map);
        String expectedMap = "hX \n"+
                "  X\n"+
                " X ";
        assertEquals(expectedMap , map.draw());
        bomber.right().forward()
                .left().forward().bomb()
                .right().right().forward();

        expectedMap = " X \n"+ // a bomb is represented by a 'o'
                "hoX\n"+
                " X ";
        assertEquals(expectedMap , map.draw());

        map.trigger(); // this will fire all bombs put in the map
        expectedMap = "   \n"+
                "D  \n"+
                "   ";
        assertEquals(expectedMap , map.draw());
    }


    @Test
    public void aBombermanMapCanHaveStarRocks() {
        Map map = new MapBuilder(4).addRock(1, 1).addStarRock(2,3).build();
        Bomberman bomber = new Bomberman("Hamid");
        bomber.startIn(map);

        String expectedMap = "h   \n"+
                " X  \n"+
                "   X\n"+
                "    ";
        assertEquals(expectedMap , map.draw());

        bomber.forward().forward()
                .right().forward().forward().bomb().forward()
                .left().forward();
        expectedMap = "    \n"+
                " X  \n"+
                "  oX\n"+
                "   h";
        assertEquals(expectedMap , map.draw());

        map.trigger();
        expectedMap = "    \n"+
                " X  \n"+
                "   *\n"+
                "   h";
        assertEquals(expectedMap , map.draw());

        bomber.left().forward();
        expectedMap = "    \n"+
                " X  \n"+
                "   h\n"+
                "    ";
        assertEquals(expectedMap , map.draw());

        bomber.forward(); // move by 2 steps after a star
        expectedMap = "   h\n"+
                " X  \n"+
                "    \n"+
                "    ";
        assertEquals(expectedMap , map.draw());
    }


    @Test
    public void aBombermanCanHaveEnhancerRocks() {
        int rangeEnhancer = 2;
        Map map = new MapBuilder(4).addRock(1, 1).addEnhancerRock(2, 3, rangeEnhancer).build();
        Bomberman bomber = new Bomberman("Hamid");
        bomber.startIn(map);

        String expectedMap = "h   \n"+
                " X  \n"+
                "   X\n"+
                "    ";
        assertEquals(expectedMap , map.draw());

        bomber.forward().forward()
                .right().forward().forward().bomb().forward()
                .left().forward();

        expectedMap = "    \n"+
                " X  \n"+
                "  oX\n"+
                "   h";
        assertEquals(expectedMap , map.draw());

        map.trigger();
        expectedMap = "    \n"+
                " X  \n"+
                "   2\n"+
                "   h";

        assertEquals(expectedMap , map.draw());

        bomber.left().forward();
        expectedMap = "    \n"+
                " X  \n"+
                "   h\n"+
                "    ";
        assertEquals(expectedMap , map.draw());

        bomber.forward().bomb().forward()
                .left().forward();
        expectedMap = "  h \n"+
                " X o\n"+
                "    \n"+
                "    ";
        assertEquals(expectedMap , map.draw());

        map.trigger(); // explosion can hit anything distant by 2 after a 2-Enhancer
        expectedMap = "  h \n"+
                "    \n"+
                "    \n"+
                "    ";
        assertEquals(expectedMap , map.draw());
    }
}*/


