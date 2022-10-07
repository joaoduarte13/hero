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

    public boolean processKey(KeyStroke key){
        if((key.getKeyType()== KeyType.Character && key.getCharacter()=='q') ||key.getKeyType() == KeyType.EOF){
            return false;
        }
        else if (key.getKeyType() == KeyType.ArrowUp){
            moveHero(hero.move_up());
        }
        else if (key.getKeyType() == KeyType.ArrowDown){
            moveHero(hero.move_down());
        }
        else if (key.getKeyType() == KeyType.ArrowLeft){
            moveHero(hero.move_left());
        }
        else if (key.getKeyType() == KeyType.ArrowRight){
            moveHero(hero.move_right());
        }
        return true;
    }

    public void draw(TextGraphics graphics){
        graphics.setBackgroundColor(TextColor.Factory.fromString("#336699"));
        graphics.fillRectangle(new TerminalPosition(0, 0), new TerminalSize(this.width, this.height), ' ');
        for (Wall wall : walls)
            wall.draw(graphics);
        hero.draw(graphics);

    }

    private void moveHero(Position position){
        System.out.println(canHeroMove(position));
        if(canHeroMove(position))
            hero.setPosition(position);
    }

    public boolean canHeroMove(Position position){
        for(Wall wall : walls){
             /*if(position.equals(wall.getPosition()))
                return false;*/

            if(abs(position.getX()) >= this.width ||  abs(position.getY()) >= this.height || position.equals(wall.getPosition()))
                return false;
        }

        return true;
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
