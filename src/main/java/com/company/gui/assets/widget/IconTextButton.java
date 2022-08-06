package com.company.gui.assets.widget;

import com.company.gui.configuration.GuiSetting;
import org.kordamp.ikonli.Ikon;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by kami on 7/29/2022.
 */
public class IconTextButton extends JPanel {

    IconButton btn;
    JLabel lbl;

    public IconTextButton(Ikon ikon, String text, int size, Color base, Color hover) {
        super();
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.setBackground(GuiSetting.selectedTheme.getPrimaryColor());
        btn = new IconButton(ikon, size, base, hover);
        btn.setBorder(BorderFactory.createEmptyBorder());
        btn.setContentAreaFilled(false);
        btn.setRolloverEnabled(true);
        btn.setAlignmentX(Component.CENTER_ALIGNMENT);
        this.add(btn);
        btn.setRolloverIcon(FontIcon.of(ikon, size, hover));
        lbl = new JLabel(text);
        lbl.setForeground(base);
        lbl.setAlignmentX(Component.CENTER_ALIGNMENT);
        this.add(lbl);

        btn.addActionListener(new MyPanelComponentsActionListener());

    }

    public void changeColor(Color base, Color hover) {
        btn.changeColor(base, hover);
        this.setBackground(GuiSetting.selectedTheme.getPrimaryColor());
        lbl.setForeground(base);
    }

    public IconTextButton(Ikon ikon, String text, int iconSize, Color base, Color textColor, Color iconBase, Color iconHover) {
        super();
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.setBackground(base);
        btn = new IconButton(ikon, iconSize, iconBase, iconHover);
        btn.setBorder(BorderFactory.createEmptyBorder());
        btn.setContentAreaFilled(false);
        btn.setRolloverEnabled(true);
        btn.setAlignmentX(Component.CENTER_ALIGNMENT);
        this.add(btn);
        btn.setRolloverIcon(FontIcon.of(ikon, iconSize, iconHover));
        lbl = new JLabel(text);
        lbl.setForeground(textColor);
        lbl.setAlignmentX(Component.CENTER_ALIGNMENT);
        this.add(lbl);

    }

    public void addActionListener(ActionListener l) {
        listenerList.add(ActionListener.class, l);
    }

    public void removeActionListener(ActionListener l) {
        listenerList.remove(ActionListener.class, l);
    }

    protected void fireActionPerformed(ActionEvent event) {
        // Guaranteed to return a non-null array
        Object[] listeners = listenerList.getListenerList();
        ActionEvent e = null;
        // Process the listeners last to first, notifying
        // those that are interested in this event
        for (int i = listeners.length - 2; i >= 0; i -= 2) {
            if (listeners[i] == ActionListener.class) {
                // Lazily create the event:
                if (e == null) {
                    String actionCommand = event.getActionCommand();
                    if (actionCommand == null) {
                        actionCommand = "FontChanged";
                    }
                    e = new ActionEvent(this,
                            ActionEvent.ACTION_PERFORMED,
                            actionCommand,
                            event.getWhen(),
                            event.getModifiers());
                }
                // here registered listener executing
                ((ActionListener) listeners[i + 1]).actionPerformed(e);
            }
        }
    }

    //!!! here your event generator
    class MyPanelComponentsActionListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            //do something usefull
            //.....
            fireActionPerformed(e);
        }
    }

}
