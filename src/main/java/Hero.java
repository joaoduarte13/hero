import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;

public class Hero {
    private int x;
    private int y;
    public Hero(int X, int Y){
        x = X;
        y = Y;
        /*Hero hero = new Hero(x,y);*/
    }

    public void draw(Screen screen){
        screen.setCharacter(x, y, TextCharacter.fromCharacter('X')[0]);
    }

    public void move_up( ){
            y--;
    }
    public void move_down(){
            y++;
    }
    public void move_left(){
            x--;
    }
    public void move_right(){
            x++;
    }
}
