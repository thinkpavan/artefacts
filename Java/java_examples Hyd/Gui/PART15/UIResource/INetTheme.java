/*  our own ugly theme , created by modifying metal 's default theme
Author : Team -J
version: 1.0
*/
import javax.swing.plaf.*;
import javax.swing.plaf.metal.*;
import javax.swing.*;
import java.awt.*;

public class INetTheme extends DefaultMetalTheme {

    private FontUIResource controlFont;
    private FontUIResource systemFont;
    private FontUIResource userFont;
    private FontUIResource smallFont;

    public String getName() { return "INet Theme"; }

    public INetTheme() {
        controlFont = new FontUIResource("Dialog", Font.ITALIC, 40);
        systemFont =  new FontUIResource("Dialog", Font.ITALIC, 40);
        userFont =  new FontUIResource("Dialog", Font.ITALIC, 40);
        smallFont = new FontUIResource("Dialog", Font.ITALIC, 10);
    }

    public FontUIResource getControlTextFont() { return controlFont;}
    public FontUIResource getSystemTextFont() { return systemFont;}
    public FontUIResource getUserTextFont() { return userFont;}
    public FontUIResource getMenuTextFont() { return controlFont;}
    public FontUIResource getWindowTitleFont() { return controlFont;}
    public FontUIResource getSubTextFont() { return smallFont;}
}
