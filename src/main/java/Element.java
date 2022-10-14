import com.googlecode.lanterna.graphics.TextGraphics;

public abstract class Element {
    Position position;

    public Element(int x, int y) {
        this.position = new Position(x,y);
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Position getPosition(){
        return position;
    }

    public abstract void draw(TextGraphics screen);
}
