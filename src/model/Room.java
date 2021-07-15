package model;

import java.util.Objects;

// class representing a single cell/room in a maze grid
public class Room {
    public int x; //is the y-coord in (row,col) given by columns in the maze
    public int y;
    public boolean visited;


    public Room(int x, int y) {
        this.x = x;
        this.y = y;
        visited = false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Room room = (Room) o;
        return x == room.x &&
                y == room.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
