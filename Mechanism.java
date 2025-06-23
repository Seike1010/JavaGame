package application;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

abstract class Mechanism
{
    protected double x, y, width, height;
    protected Rectangle shape;

    public Mechanism(double x, double y, double width, double height, Color color)
    {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.shape = new Rectangle(width, height, color);
        this.shape.setX(x);
        this.shape.setY(y);
    }

    public Rectangle getShape()
    {
        return shape;
    }

    public boolean isColliding(Rectangle other)
    {
        return shape.getBoundsInParent().intersects(other.getBoundsInParent());
    }
}

class Pool extends Mechanism
{
    private String type;

    public Pool(double x, double y, double width, double height, String type)
    {
        super(x, y, width, height, type.equals("fire") ? Color.RED : Color.BLUE);
        this.type = type;
    }

    public boolean checkCollision(Rectangle player, String playerType)
    {
        if (isColliding(player) && !playerType.equals(type))
        {
            return true;
        }
        return false;
    }
}

class Switch extends Mechanism
{
    private boolean isPressed;

    public Switch(double x, double y, double width, double height)
    {
        super(x, y, width, height, Color.GRAY);
        this.isPressed = false;
    }

    public void setPressed(boolean pressed)
    {
        isPressed = pressed;
        shape.setFill(pressed ? Color.GREEN : Color.GRAY);
    }

    public boolean isPressed()
    {
        return isPressed;
    }
}

class Door extends Mechanism
{
    private double originalY;
    private double loweredY;
    private boolean isLowering;
    private boolean isRaising;

    public Door(double x, double y, double width, double height)
    {
        super(x, y, width, height, Color.BROWN);
        this.originalY = y;
        this.loweredY = y + 50;
        this.isLowering = false;
        this.isRaising = false;
    }

    public void lower()
    {
        isLowering = true;
        isRaising = false;
    }

    public void raise()
    {
        isLowering = false;
        isRaising = true;
    }

    public void update()
    {
        if (isLowering && y < loweredY)
        {
            y += 1;
            shape.setY(y);
        }
        else if (isRaising && y > originalY)
        {
            y -= 1;
            shape.setY(y);
        }
    }
}


class Hazard extends Mechanism
{
    private double speedY;

    public Hazard(double x, double y, double width, double height, double speedY)
    {
        super(x, y, width, height, Color.BLACK);
        this.speedY = speedY;
    }

    public void move() {
        y += speedY;
        if (y <= 50 || y >= 350)
        {
            speedY = -speedY;
        }
        shape.setY(y);
    }

    public boolean checkCollision(Rectangle player)
    {
        return isColliding(player);
    }
}

class Pit extends Mechanism
{
    private double fallToY;

    public Pit(double x, double y, double width, double height, double fallToY)
    {
        super(x, y, width, height, Color.BLACK);
        this.fallToY = fallToY;
    }

    public boolean checkCollision(Rectangle player)
    {
        return isColliding(player);
    }

    public double getFallToY()
    {
        return fallToY;
    }
}
