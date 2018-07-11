package model;

import java.awt.*;

public class Wall extends CollisionObject {
    public Wall(int x, int y) {
        super(x, y);
    }

    @Override
    public void draw(Graphics graphics) {
        graphics.setColor(Color.DARK_GRAY);

        int x = getX() - getWidth() / 2;
        int y = getY() - getHeight() / 2;

        graphics.drawOval(x, y, getWidth(), getHeight());
        graphics.fillOval(x, y, getWidth(), getHeight());
    }
}
