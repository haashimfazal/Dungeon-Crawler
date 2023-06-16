package logic;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyPressed implements KeyListener {
    private boolean d;
    private boolean w;
    private boolean s;
    private boolean a;
    private boolean right;
    private boolean left;
    private boolean up;
    private boolean down;
    private boolean shift;
    private boolean enter;
    private boolean space;
    private boolean esc;

    public void keyPressed(KeyEvent e)
    {

        keyAction(e,true);
    }

    /**
     * Updates of current actions of the user.
     * @param e KeyEvent which has been triggerd.
     * @param yn True or false for specified key event.
     */
    public void keyAction(KeyEvent e,boolean yn)
    {

        int code = e.getKeyCode();

        if (code == KeyEvent.VK_UP)
            up = yn;
        if (code == KeyEvent.VK_DOWN)
            down = yn;
        if (code == KeyEvent.VK_LEFT)
            left = yn;
        if (code == KeyEvent.VK_RIGHT)
            right = yn;
        if (code == KeyEvent.VK_SPACE)
            space = yn;
        if (code == KeyEvent.VK_SHIFT)
            shift = yn;
        if (code == KeyEvent.VK_ESCAPE)
            esc = yn;
        if (code == KeyEvent.VK_ENTER)
            enter = yn;
        if (code == KeyEvent.VK_W)
            w = yn;
        if (code == KeyEvent.VK_D)
            d = yn;
        if (code == KeyEvent.VK_A)
            a = yn;
        if (code == KeyEvent.VK_S)
            s = yn;
    }


    public void keyReleased(KeyEvent e){
        keyAction(e,false);
    }


    public void keyTyped(KeyEvent e)
    {
    }

    /**
     * Accessor method
     * @return True if 'w' has been pressed by user.
     */
    public boolean wPressed()
    {
        return w;
    }


    /**
     * Accessor method
     * @return True if 'd' has been pressed by user.
     */
    public boolean dPressed()
    {
        return d;
    }


    /**
     * Accessor method
     * @return True if 'a' has been pressed by user.
     */
    public boolean aPressed()
    {
        return a;
    }


    /**
     * Accessor method
     * @return True if 's' has been pressed by user.
     */
    public boolean sPressed()
    {
       return s;
    }


    /**
     * Accessor method
     * @return True if 'space' has been pressed by user.
     */
    public boolean spacePressed()
    {
        return space;
    }


    /**
     * Accessor method
     * @return True if 'right' has been pressed by user.
     */
    public boolean rightPressed()
    {
        return right;
    }


    /**
     * Accessor method
     * @return True if 'left' has been pressed by user.
     */
    public boolean leftPressed()
    {
        return left;
    }

    /**
     * Accessor method
     * @return True if 'left' has been pressed by user.
     */
    public boolean downPressed()
    {
        return down;
    }


    /**
     * Accessor method
     * @return True if 'up' has been pressed by user.
     */
    public boolean upPressed()
    {
        return up;
    }


    /**
     * Accessor method
     * @return True if 'shift' has been pressed by user.
     */
    public boolean shiftPressed()
    {
        return shift;
    }

    /**
     * Accessor method
     * @return True if 'enter' has been pressed by user.
     */
    public boolean enterPressed()
    {
        return enter;
    }


    /**
     * Accessor method
     * @return True if 'esc' has been pressed by user.
     */
    public boolean escPressed()
    {
        return esc;
    }
}
