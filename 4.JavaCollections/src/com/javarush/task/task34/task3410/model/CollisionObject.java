package com.javarush.task.task34.task3410.model;

abstract public class CollisionObject extends GameObject {
    public CollisionObject(int x, int y) {
        super(x, y);
    }

    public boolean isCollision(GameObject gameObject, Direction direction) {
        if (gameObject == null || direction == null) return false;
        switch (direction) {
            case UP: {
                if (this.getX() == gameObject.getX()
                        && this.getY() - Model.FIELD_CELL_SIZE == gameObject.getY()) return true;
                break;
            }
            case DOWN: {
                if (this.getX() == gameObject.getX()
                        && this.getY() + Model.FIELD_CELL_SIZE == gameObject.getY()) return true;
                break;
            }
            case LEFT: {
                if (this.getX() - Model.FIELD_CELL_SIZE == gameObject.getX()
                        && this.getY() == gameObject.getY()) return true;
                break;
            }
            case RIGHT: {
                if (this.getX() + Model.FIELD_CELL_SIZE == gameObject.getX()
                        && this.getY() == gameObject.getY()) return true;
                break;
            }
        }
        return false;
    }
}
