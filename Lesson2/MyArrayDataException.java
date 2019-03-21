class MyArrayDataException extends Exception {

    private int x;
    private int y;

    MyArrayDataException(int x, int y) {
        this.x = x;
        this.y = y;
    }

    int getX() {
        return x;
    }

    int getY() {
        return y;
    }
}
