import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.SGR;

import static java.lang.Math.abs;

public class Hero extends Element {

    public Hero(int X, int Y){
        super(X,Y);
    }

    public void draw(TextGraphics graphics) {
        graphics.setForegroundColor(TextColor.Factory.fromString("#FFFF33"));
        graphics.enableModifiers(SGR.BOLD);
        graphics.putString(new TerminalPosition(position.getX(), position.getY()), "X");
    }

    public Position move_up(){
      /*  System.out.println(position.getX());
        position.setY(position.getY()-1);
        return position;*/
        Position newPos = new Position(position.getX(), position.getY());
        System.out.println(newPos.getX());
        System.out.println(newPos.getY());
        return new Position(position.getX(), position.getY() - 1);
    }
    public Position move_down(){
       /* position.setY(position.getY()+1);
        return position;*/
        return new Position(position.getX(), position.getY()+1);
    }
    public Position move_left(){
        return new Position(position.getX(), position.getY());
    }
    public Position move_right(){
        return new Position(position.getX()-1, position.getY());
    }


    public void setPosition(Position position){
        /*int xx = position.getX();
        int yy = position.getY();
        System.out.println(xx);
        System.out.println(yy);*/
        this.position = position;
    }
}
