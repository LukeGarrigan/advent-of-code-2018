package day3;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Fabric {


    private Object[][] canvas;

    private Set<Object> compromisedFabric = new HashSet<>();


    /**
     * Part 1
     * @param inputs
     * @return
     */
    public int processClaimsAndGetTotal(List<String> inputs) {
        for (String input : inputs) {
            processClaim(input);
        }
        return addNumberOfCrossovers();
    }


    /**
     * Part 2
     * @param inputs
     * @return
     */
    public int processClaimsAndGetFabricWhichIsntCompromised(List<String> inputs) {
        for (String input : inputs) {
            processClaim(input);
        }

        for (String input : inputs) {

            int id = getId(input);

            if (!compromisedFabric.contains(id)) {
                return id;
            }
        }
        return 0;
    }




    public void processClaim(String input) {
        int id = getId(input);
        int x = getX(input);
        int y = getY(input);
        int width = getWidth(input);
        int height = getHeight(input);
        addClaim(id, x, y, width, height);
    }

    public void addClaim(int id, int x, int y, int width, int height) {
        for (int i = x; i < x + width; i++) {
            for (int j = y; j < y + height; j++) {
                if (canvas[j][i].equals('.')) {
                    canvas[j][i] = id;
                } else {
                    compromisedFabric.add(id);
                    compromisedFabric.add(canvas[j][i]);
                    canvas[j][i] = 'X';
                }
            }
        }
        System.out.println();
    }


    public int addNumberOfCrossovers() {
        int total = 0;
        for (int i = 0; i < canvas.length; i++) {
            for (int j = 0; j < canvas.length; j++) {
                if (canvas[i][j].equals('X')) {
                    total++;
                }
            }
        }
        return total;
    }


    public void initialiseCanvas(int canvasWidth, int canvasHeight) {
        canvas = new Object[canvasWidth][canvasHeight];
        for (int i = 0; i < canvas.length; i++) {
            for (int j = 0; j < canvas.length; j++) {
                canvas[i][j] = '.';
            }
        }
    }

    public void visualiseCanvas() {
        for (int i = 0; i < canvas.length; i++) {
            for (int j = 0; j < canvas.length; j++) {
                System.out.print(canvas[i][j]);
            }
            System.out.println();
        }
    }



    public int getId(String input) {
        return Integer.valueOf(input.substring(1, input.indexOf('@') -1));
    }

    public int getX(String input) {
        return Integer.valueOf(input.substring(input.indexOf('@') + 2, input.indexOf(',')));
    }

    public int getY(String input) {
        return Integer.valueOf(input.substring(input.indexOf(",") + 1, input.indexOf(":")));
    }

    public int getWidth(String input) {
        return Integer.valueOf(input.substring(input.indexOf(":") + 2, input.indexOf("x")));
    }

    public int getHeight(String input) {
        return Integer.valueOf(input.substring(input.indexOf("x") + 1, input.length()));
    }

}
