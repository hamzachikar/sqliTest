package bomberman;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestSqli {
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
    @Test
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

        bomber.forward();// move by 2 steps after a star
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
}


