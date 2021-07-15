package model;

import java.util.Objects;

// a wall represents the edge connecting two nodes (rooms)
public class Wall {
    public Room rm1; // room on left of wall or above wall
    public Room rm2; // room on right of wall or below wall
    public boolean inGrid; //true if the wall is not removed and stays in the grid
    public boolean isHorizontal; // true if wall is between two rooms that are stacked instead of side by side

    public Wall(Room rm1, Room rm2) {
        this.rm1 = rm1;
        this.rm2 = rm2;
        inGrid = true;
        isHorizontal = checkWallDirection(rm1, rm2);
    }

    // EFFECTS: returns true if wall is between two rooms that are stacked one on top of the other
    //          false if rooms are side by side
    private boolean checkWallDirection(Room rm1, Room rm2) {
        if (Math.abs(rm1.y - rm2.y) == 1) {
            return true;
        }
        return false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Wall wall = (Wall) o;
        return rm1.equals(wall.rm1) &&
                rm2.equals(wall.rm2);
    }

    @Override
    public int hashCode() {
        return Objects.hash(rm1, rm2);
    }
}
