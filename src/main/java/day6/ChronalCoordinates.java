package day6;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ChronalCoordinates {



    private List<Point> points = new ArrayList<>();



    public int doPartOne(List<String> coordinates, int worldSize) {
        String[][] currentWorld = buildWorld(coordinates, worldSize);
        String[][] worldWithAllPointsMarked = processDistanceBetweenPointsForWorld(currentWorld);
        removePointsWhichAreInfinite(worldWithAllPointsMarked);

        return findTheLargestFiniteArea(worldWithAllPointsMarked);
    }


    public int doPartTwo(List<String> coordinates, int worldSize, int maxDistance) {
        String[][] currentWorld = buildWorld(coordinates, worldSize);
        updateWorldWithSafeRegions(maxDistance, currentWorld);


        return calculateNumberOfSafePoints(currentWorld);

    }

    private int calculateNumberOfSafePoints(String[][] currentWorld) {
        int total = 0;
        for (int i = 0; i < currentWorld.length; i++) {
            for (int j = 0; j < currentWorld[i].length; j++) {

                if (currentWorld[j][i].equals("#")) {
                    total ++;
                }
            }
        }
        return total;
    }

    private void updateWorldWithSafeRegions(int maxDistance, String[][] currentWorld) {
        for (int i = 0; i < currentWorld.length; i++) {
            for (int j = 0; j < currentWorld[i].length; j++) {
                int total = 0;


                for (Point point : points) {
                    total += calculateManhattanDistance(i, j, point.getX(), point.getY());
                }

                if (total < maxDistance) {
                    currentWorld[j][i] = "#";
                }
            }
        }
    }


    private int findTheLargestFiniteArea(String[][] worldWithAllPointsMarked) {
        int largestArea = Integer.MIN_VALUE;
        for (Point point : points) {
            int countForGivenPoint = getCountForGivenPoint(worldWithAllPointsMarked, Integer.toString(point.getId()));
            if (countForGivenPoint > largestArea) {
                largestArea = countForGivenPoint;
            }
        }
        return largestArea;
    }

    private int getCountForGivenPoint(String[][] world, String id) {
        int count = 0;
        for (int i = 0; i < world.length; i++) {
            for (int j = 0; j < world[i].length; j++) {
                if (world[j][i].equals(id)) {
                    count++;
                }
            }
        }
        return count;
    }

    public void removePointsWhichAreInfinite(String[][] currentWorld) {
        Set<String> infinitePoints = getInfinitePoints(currentWorld);
        for (int i = points.size()-1; i >= 0; i--) {
            if (infinitePoints.contains(Integer.toString(points.get(i).getId()))) {
                points.remove(i);
            }
        }
    }

    public Set<String> getInfinitePoints(String[][] currentWorld) {
        Set<String> infinitePoints = new HashSet<>();
        for (int i = 0; i < currentWorld.length; i++) {
            infinitePoints.add(currentWorld[0][i]);
            infinitePoints.add(currentWorld[i][0]);
            infinitePoints.add(currentWorld[currentWorld.length-1][i]);
            infinitePoints.add(currentWorld[i][currentWorld.length-1]);
        }
        return infinitePoints;
    }

    public String[][] buildWorld(List<String> coordinates, int worldSize) {
        String[][] world = new String[worldSize][worldSize];
        initialiseWorld(world);

        for (int i = 0; i < coordinates.size(); i++) {
            String coordinate = coordinates.get(i);

            int x = getX(coordinate);
            int y = getY(coordinate);
            Point point = new Point(i, x, y);

            points.add(point);
            world[y][x] = Integer.toString(i);
        }

        return world;
    }

    public String[][] processDistanceBetweenPointsForWorld(String[][] world) {
        for (int i = 0; i < world.length; i++) {
            for (int j = 0; j < world[i].length; j++) {
                processPoint(i, j, world);
            }
        }
        return world;
    }

    private void processPoint(int i, int j, String[][] world) {
        int smallestDistance = Integer.MAX_VALUE;
        int bestPoint = 0;
        boolean isEquidistant = false;
        for (Point point : points) {
            int distance = calculateManhattanDistance(i, j, point.getX(), point.getY());
            if (distance < smallestDistance) {
                smallestDistance = distance;
                bestPoint = point.getId();
                isEquidistant = false;
            } else if (distance == smallestDistance) {
                isEquidistant = true;
            }
        }

        if (isEquidistant) {
            world[j][i] = ".";
        } else {
            world[j][i] = Integer.toString(bestPoint);
        }

    }


    public int getX(String input) {
        return Integer.valueOf(input.substring(0, input.indexOf(',')));
    }


    public int getY(String input) {
        return Integer.valueOf(input.substring(input.indexOf(",") + 2, input.length()));
    }

    public int calculateManhattanDistance(int x, int y, int x1, int y1) {
        return Math.abs(x - x1) + Math.abs(y - y1);
    }



    public void initialiseWorld(String[][] world) {

        for (int i = 0; i < world.length; i++) {
            for (int j = 0; j < world[i].length; j++) {
                world[i][j] = ".";
            }
        }
    }


    public void visualWorld(String[][] world) {
        for (int i = 0; i < world.length; i++) {
            for (int j = 0; j < world[i].length; j++) {
                System.out.print(world[i][j]);
            }
            System.out.println();
        }
    }

}
