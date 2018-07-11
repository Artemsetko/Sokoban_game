package view;


import controller.EventListener;
import model.Direction;
import model.GameObject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Set;

public class Field extends JPanel {

    private View view;
    private EventListener eventListener;
    Graphics g = null;

    public Field(View view) {
        this.view = view;
        addKeyListener(new KeyHandler());
        setFocusable(true);
    }

    @Override
    public void paint(Graphics g) {
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, 300, 300);

        Set<GameObject> allObjects = view.getGameObjects().getAll();
        for (GameObject allObject : allObjects) {
            allObject.draw(g);
        }
        this.g = g;
    }

    public void setEventListener(EventListener eventListener) {
        this.eventListener = eventListener;
    }


    public class KeyHandler extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent keyEvent) {

            switch (keyEvent.getKeyCode()) {
                case KeyEvent.VK_LEFT:
                    eventListener.move(Direction.LEFT);
                    break;
                case KeyEvent.VK_RIGHT:
                    eventListener.move(Direction.RIGHT);
                    break;
                case KeyEvent.VK_UP:
                    eventListener.move(Direction.UP);
                    break;
                case KeyEvent.VK_DOWN:
                    eventListener.move(Direction.DOWN);
                    break;
                case KeyEvent.VK_R:
                    eventListener.restart();
                    break;
            }

        }
    }
}
