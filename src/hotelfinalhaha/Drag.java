package hotelfinalhaha;

import java.awt.Component;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;

public class Drag {
    private int xOffset, yOffset;
    private final Component component;

    public Drag(Component component) {
        this.component = component;
        init();
    }

    private void init() {
        component.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                xOffset = e.getX();
                yOffset = e.getY();
            }
        });

        component.addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                Component parent = component.getParent();
                while (!(parent instanceof JFrame) && parent != null) {
                    parent = parent.getParent();
                }
                if (parent instanceof JFrame) {
                    JFrame frame = (JFrame) parent;
                    Point newPoint = frame.getLocation();
                    newPoint.translate(e.getX() - xOffset, e.getY() - yOffset);
                    frame.setLocation(newPoint);
                }
            }
        });
    }
}
