import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;

import static java.lang.Math.abs;

public class Arena {
    private int width;
    private int height;
    Hero hero;
    public Arena(int width, int height){
        this.width = width;
        this.height = height;
        hero = new Hero(10, 10);

    }

    public boolean processKey(KeyStroke key){
        if((key.getKeyType()== KeyType.Character && key.getCharacter()=='q') ||key.getKeyType() == KeyType.EOF){
            return false;
        }
        if (key.getKeyType() == KeyType.ArrowUp){
            moveHero(hero.move_up());
        }
        if (key.getKeyType() == KeyType.ArrowDown){
            moveHero(hero.move_down());
        }
        if (key.getKeyType() == KeyType.ArrowLeft){
            moveHero(hero.move_left());
        }
        if (key.getKeyType() == KeyType.ArrowRight){
            moveHero(hero.move_right());
        }
        return true;
    }

    public void draw(TextGraphics graphics){
        graphics.setBackgroundColor(TextColor.Factory.fromString("#336699"));
        graphics.fillRectangle(new TerminalPosition(0, 0), new TerminalSize(this.width, this.height), ' ');
        hero.draw(graphics);
    }

    private void moveHero(Position position){
        if(canHeroMove(position))
            hero.setPosition(position);
    }

    private boolean canHeroMove(Position position){
        System.out.println(position.getX());
        System.out.println(position.getY());
        if(abs(position.getX()) >= this.width ||  abs(position.getY()) >= this.height)
            return false;
        return true;
    }
}
