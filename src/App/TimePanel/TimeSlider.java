package App.TimePanel;

import App.Colors;

import javax.swing.*;
import javax.swing.plaf.basic.BasicSliderUI;
import java.awt.*;

public class TimeSlider extends BasicSliderUI {
    private int diameter;
    private int trackHeight;
    public TimeSlider(JSlider b, int diameter, int trackHeight) {
        super(b);
        this.diameter = diameter;
        this.trackHeight = trackHeight;
    }

    @Override
    public void paint(Graphics g, JComponent c) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        super.paint(g, c);
    }

    @Override
    protected Dimension getThumbSize() {
        return new Dimension(diameter, diameter);
    }

    @Override
    protected Color getFocusColor(){
        return Colors.color7_63_86;
    }

    @Override
    public void paintTrack(Graphics g) {
        int cy = (trackRect.height / 2) - 2;
        int cw = trackRect.width;

        g.translate(trackRect.x, trackRect.y + cy);

        g.setColor(Colors.color34_202_237);
        g.fillRect(1,0, thumbRect.x-1, trackHeight);
        g.setColor(Color.black);
        g.fillRect(thumbRect.x, 0, cw -2 -thumbRect.x, trackHeight);

        g.translate(-trackRect.x, -(trackRect.y + cy));
    }

    @Override
    public void paintThumb(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Colors.color34_202_237);
        g2d.fillOval(thumbRect.x, thumbRect.y, diameter, diameter);
    }
}
