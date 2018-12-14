package day8;

import junit.framework.TestCase;

/**
 * Created by lukegarrigan on 14/12/2018.
 */
public class MemoryTest extends TestCase {



    private Memory memory = new Memory();


    public void testParseData() {
        String input = "2 3 0 3 10 11 12 1 1 0 1 99 2 1 1 2";

        int[] ints = memory.processInput(input);

        assertEquals(input.split(" ").length, ints.length);
    }




    public void testProcessData() {

        String input = "2 3 0 3 10 11 12 1 1 0 1 99 2 1 1 2";

        int[] ints = memory.processInput(input);

        memory.processData(ints);
    }


}