public class Element {
    Position position;

    public Element(int x, int y) {
        this.position = new Position(x,y);
    }

    public void setPosition(Position pos) {this.position.setX(pos.getX());this.position.setY(pos.getY());}

    public Position getPosition(){
        return this.position;
    }
}
