import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;

import java.io.IOException;

public class Game {
    private Screen screen;
    /*private int x = 10;
    private int y = 10;*/
    Hero hero;


    public Game(){
        try{
            TerminalSize terminalSize = new TerminalSize(40, 20);
            DefaultTerminalFactory terminalFactory = new DefaultTerminalFactory().setInitialTerminalSize(terminalSize);

            Terminal terminal = terminalFactory.createTerminal();
            screen = new TerminalScreen(terminal);
            screen.setCursorPosition(null); // we don't need a cursor
            screen.startScreen(); // screens must be started
            screen.doResizeIfNecessary();
            hero = new Hero(10, 10);
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }

    private void draw() throws IOException{
        screen.clear();
        hero.draw(screen);
        screen.refresh();
    }

    public void run() throws IOException{
        boolean running = true;
        KeyStroke key;
        while(running){
            draw();
            key = screen.readInput();
            running = processKey(key);
        }
        screen.close();
    }

    private boolean processKey(KeyStroke key){
        if((key.getKeyType()== KeyType.Character && key.getCharacter()=='q') ||key.getKeyType() == KeyType.EOF){
            return false;
        }
        if (key.getKeyType() == KeyType.ArrowUp){
            hero.move_up();
        }
        if (key.getKeyType() == KeyType.ArrowDown){
            hero.move_down();
        }
        if (key.getKeyType() == KeyType.ArrowLeft){
            hero.move_left();
        }
        if (key.getKeyType() == KeyType.ArrowRight){
            hero.move_right();
        }


       /* System.out.println(x);
        System.out.println(y);*/
        return true;
    }
}
