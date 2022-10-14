import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.abs;

public class Arena {
    private int width;
    private int height;
    Hero hero;
    public List<Wall> walls;

    public Arena(int width, int height){
        this.width = width;
        this.height = height;
        hero = new Hero(10, 10);
        this.walls = createWalls();
       /* wall = new Wall();*/
    }



    public void draw(TextGraphics graphics){
        graphics.setBackgroundColor(TextColor.Factory.fromString("#336699"));
        graphics.fillRectangle(new TerminalPosition(0, 0), new TerminalSize(width, height), ' ');

        hero.draw(graphics);

        for (Wall wall : walls)
            wall.draw(graphics);
    }

    public Position move_up(){return new Position(hero.getPosition().getX(), hero.getPosition().getY() - 1);}
    public Position move_down(){return new Position(hero.getPosition().getX(), hero.getPosition().getY() + 1);}
    public Position move_left(){
        return new Position(hero.getPosition().getX()-1, hero.getPosition().getY());
    }
    public Position move_right(){return new Position(hero.getPosition().getX()+1, hero.getPosition().getY());}

    public void moveHero(Position position){
        if(canHeroMove(position))
            hero.setPosition(position);
    }

    public boolean canHeroMove(Position position){
        return (position.getX() >= 0 && position.getX() < width) &&
                (position.getY() >= 0 && position.getY() < height) &&
                !walls.contains(new Wall(position.getX(), position.getY()));
    }

    private List<Wall> createWalls() {
        List<Wall> walls = new ArrayList<>();
        for (int c = 0; c < width; c++) {
            walls.add(new Wall(c, 0));
            walls.add(new Wall(c, height - 1));
        }
        for (int r = 1; r < height - 1; r++) {
            walls.add(new Wall(0, r));
            walls.add(new Wall(width - 1, r));
        }
        return walls;
    }
}
