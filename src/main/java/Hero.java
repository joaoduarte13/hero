import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;

public class Hero {
    Position position;
    public Hero(int X, int Y){
        position = new Position(X, Y);
    }

    public void draw(Screen screen){
        screen.setCharacter(position.getX(), position.getY(), TextCharacter.fromCharacter('X')[0]);
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
        int xx = position.getX();
        int yy = position.getY();
        System.out.println(xx);
        System.out.println(yy);
        this.position = position;
    }
}
