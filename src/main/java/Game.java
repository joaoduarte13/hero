import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;

import java.io.IOException;

public class Game {
    private Screen screen;
    Arena arena;
    TextGraphics graphics;
    public Game(){
        try{
            TerminalSize terminalSize = new TerminalSize(40, 20);
            DefaultTerminalFactory terminalFactory = new DefaultTerminalFactory().setInitialTerminalSize(terminalSize);

            Terminal terminal = terminalFactory.createTerminal();
            screen = new TerminalScreen(terminal);
            screen.setCursorPosition(null); // we don't need a cursor
            screen.startScreen(); // screens must be started
            screen.doResizeIfNecessary();

            graphics = screen.newTextGraphics();
            arena = new Arena(40, 20);
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }

    private void draw() throws IOException{
        screen.clear();
        arena.draw(graphics);
        screen.refresh();
    }

    public void run() throws IOException{
        while(true) {
            draw();
            com.googlecode.lanterna.input.KeyStroke key = screen.readInput();
            processKey(key);

            if(arena.verifyMonsterCollisions()){
                screen.close();
                break;
            }

            if (key.getKeyType() == KeyType.Character && key.getCharacter() == ('q'))
                screen.close();
            if (key.getKeyType() == KeyType.EOF)
                break;

            arena.moveMonsters();
            if(arena.verifyMonsterCollisions()){
                screen.close();
                break;
            }
        }
    }
    public void processKey(KeyStroke key){
        switch (key.getKeyType()) {
            case ArrowUp    -> arena.moveHero(arena.move_up());
            case ArrowDown  -> arena.moveHero(arena.move_down());
            case ArrowLeft  -> arena.moveHero(arena.move_left());
            case ArrowRight -> arena.moveHero(arena.move_right());
        }
    }

}
