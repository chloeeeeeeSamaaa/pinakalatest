package hotelfinalhaha;

import java.awt.*;
import java.awt.geom.RoundRectangle2D;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class RoundTextField extends JTextField {
    private int radius; // Corner radius

    public RoundTextField(int columns, int radius) {
        super(columns);
        this.radius = radius;
        setOpaque(false); // Makes background transparent
        setBackground(Color.WHITE); // Background visible
        setFont(new Font("Tahoma", Font.PLAIN, 14)); // Bigger text

        // ✅ REMOVE DEFAULT BORDER TO PREVENT ISSUES
        setBorder(new EmptyBorder(0, 0, 0, 0));
    }

    // ✅ FIX: OVERRIDE getInsets() TO ADD PROPER INTERNAL PADDING
    @Override
    public Insets getInsets() {
        return new Insets(10, 20, 10, 20); // Top, Left, Bottom, Right (pushing text inside)
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Background color
        g2.setColor(getBackground());
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), radius, radius);

        super.paintComponent(g);
    }

    @Override
    protected void paintBorder(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Border color
        g2.setColor(getForeground());
        g2.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, radius, radius);
    }

    @Override
    public boolean contains(int x, int y) {
        Shape shape = new RoundRectangle2D.Float(0, 0, getWidth(), getHeight(), radius, radius);
        return shape.contains(x, y);
    }
}
