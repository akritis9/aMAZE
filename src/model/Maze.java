package model;

import java.util.*;

// represents a maze grid
public class Maze {
    public int numRows; // dimensions of the maze
    public int numCols; // dimensions of the maze
    public HashMap<Room, List<Room>> roomsAndNeighbours; // a room and a list of its neighbours
    public Set<Wall> innerWalls; // All the inner walls of the maze, excludes the boundary walls
    public Set<Wall> boundaryWalls;
    public Wall startWall;
    public Wall endWall;

    public Maze(int x, int y) {
        numRows = y;
        numCols = x;
        roomsAndNeighbours = new HashMap<>();
        createRoomsAndNeighbours(x,y);
        innerWalls = new HashSet<>();
        createInnerWalls(x, y);
        /*boundaryWalls = createBoundaryWalls(x, y);
        startWall = createStartWall(x, y);
        endWall = createEndWall(x, y);*/
    }

    /*private Wall createEndWall(int x, int y) {
        //may not need to implement
    }

    private Wall createStartWall(int x, int y) {
        // may not need to implement
    }

    private Set<Wall> createBoundaryWalls(int x, int y) {
        // may not need to implement
    }*/

    // for all the rooms, create a wall between the room and its neighbours.
    private void createInnerWalls(int x, int y) {
        Iterator allRooms = roomsAndNeighbours.keySet().iterator();
        while (allRooms.hasNext()) {
            Room room1 = (Room) allRooms.next();
            List<Room> neighbours = roomsAndNeighbours.get(room1);

            for (int i = 0; i < neighbours.size(); i++) {
                Room room2 = neighbours.get(i);
                Wall wall = new Wall(room1,room2);
                if (!innerWalls.contains(wall)) {
                    innerWalls.add(wall);
                }
            }
        }
    }

    private void createRoomsAndNeighbours(int x, int y) {

        //start with the yth row and iterate through all columns
        for (int i = 0; i < y; i++) {
            for (int j = 0; j < x; j++) {
                Room rm = new Room(i, j);
                roomsAndNeighbours.put(rm, new ArrayList<>());
            }
        }
        // now assign neighbours to each room in the hashMap
        // first figure out if the number of neighbours is 1,2,3,or 4
        // then find and fill the list of neighbours with those neighbours
        Iterator allRooms1 = roomsAndNeighbours.keySet().iterator();
        while (allRooms1.hasNext()) {
            Room room = (Room) allRooms1.next();
            List<Room> neighbours = roomsAndNeighbours.get(room);

            Iterator allRooms2 = roomsAndNeighbours.keySet().iterator();

            while (allRooms2.hasNext()) {
                Room neighbour = (Room) allRooms2.next();

                // check which of the four possible neighbours are in the maze
                // locate them in the hashset and add them to the list for a room

                //north neighbour
                if (((room.y - neighbour.y) == 1) && (room.x - neighbour.x == 0)) {
                    neighbours.add(neighbour);
                } else if (((room.y - neighbour.y) == -1) && (room.x - neighbour.x == 0)) {
                    //south neighbour
                    neighbours.add(neighbour);
                } else if (((room.x - neighbour.x) == -1) && (room.y - neighbour.y == 0)) {
                    //east neighbour
                    neighbours.add(neighbour);
                } else if (((room.x - neighbour.x) == 1) && (room.y - neighbour.y == 0)) {
                    // west neighbour
                    neighbours.add(neighbour);
                }
            }
        }
    }
}
