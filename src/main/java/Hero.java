import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.SGR;

public class Hero {
    Position position;
    public Hero(int X, int Y){
        position = new Position(X, Y);
    }

    public void draw(TextGraphics graphics) {
        graphics.setForegroundColor(TextColor.Factory.fromString("#FFFF33"));
        graphics.enableModifiers(SGR.BOLD);
        graphics.putString(new TerminalPosition(position.getX(), position.getY()), "X");
    }

    public Position move_up( ){
            return new Position(position.getX(), position.getY() - 1);
    }
    public Position move_down(){
        return new Position(position.getX(), position.getY() + 1);
    }
    public Position move_left(){
        return new Position(position.getX() - 1 , position.getY());
    }
    public Position move_right(){
        return new Position(position.getX() + 1, position.getY());
    }

    public void setPosition(Position position){
       /* int xx = position.getX();
        int yy = position.getY();
        System.out.println(xx);
        System.out.println(yy);*/
        this.position = position;
    }
}
