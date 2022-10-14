import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

import java.util.ArrayList;
import java.util.List;

public class Wall extends Element{


    private List<Wall> walls;
    public Wall(int x, int y){
        super(x,y);
    }
     public void draw(TextGraphics graphics){
         graphics.setForegroundColor(TextColor.Factory.fromString("#FF0000"));
         graphics.putString(new TerminalPosition(getPosition().getX(), getPosition().getY()),"#");
     }
}
