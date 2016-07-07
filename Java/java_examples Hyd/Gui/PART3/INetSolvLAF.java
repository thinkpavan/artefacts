/*
INetSolvLAF class is a new look and feel This class was
implemented by just modifying a part of cde l & f

 */


import java.awt.Toolkit;
import java.awt.Color;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.KeyEvent;
import java.awt.event.InputEvent;
import java.util.*;

import java.lang.reflect.*;

import javax.swing.*;
import javax.swing.plaf.*;
import javax.swing.border.*;
import javax.swing.text.JTextComponent;
import javax.swing.text.DefaultEditorKit;

import javax.swing.plaf.basic.BasicLookAndFeel;
import javax.swing.plaf.basic.BasicBorders;
import javax.swing.plaf.basic.BasicComboBoxRenderer;
import javax.swing.plaf.basic.BasicComboBoxEditor;

public class INetSolvLAF extends BasicLookAndFeel
{
    public String getName() {
        return "INetSolv LAF";
    }

    public String getID() {
        return "INetSolv";
    }

    public String getDescription() {
        return "A sample Look and Feel";
    }


    public boolean isNativeLookAndFeel() {
        String osName = System.getProperty("os.name");
        return (osName != null) && (osName.indexOf("Solaris") != -1);
    }


    public boolean isSupportedLookAndFeel() {
        return true;
    }



    protected void initSystemColorDefaults(UIDefaults table)
    {
        String[] defaultSystemColors = {
                  "desktop", "#005C5C", /* Color of the desktop background */
            "activeCaption", "#000080", /* Color for captions (title bars) when they are active. */
        "activeCaptionText", "#FFFFFF", /* Text color for text in captions (title bars). */
      "activeCaptionBorder", "#B24D7A", /* Border color for caption (title bar) window borders. */
          "inactiveCaption", "#AEB2C3", /* Color for captions (title bars) when not active. */
      "inactiveCaptionText", "#000000", /* Text color for text in inactive captions (title bars). */
    "inactiveCaptionBorder", "#AEB2C3", /* Border color for inactive caption (title bar) window borders. */
                   "window", "#AEB2C3", /* Default color for the interior of windows */
             "windowBorder", "#AEB2C3", /* ??? */
               "windowText", "#000000", /* ??? */
                     "menu", "#AEB2C3", /* ??? */
                 "menuText", "#000000", /* ??? */
                     "text", "#FFF7E9", /* Text background color */
                 "textText", "#000000", /* Text foreground color */
            "textHighlight", "#000000", /* Text background color when selected */
        "textHighlightText", "#FFF7E9", /* Text color when selected */
         "textInactiveText", "#808080", /* Text color when disabled */
                  "control", "#AEB2C3", /* Default color for controls (buttons, sliders, etc) */
              "controlText", "#000000", /* Default color for text in controls */
         "controlHighlight", "#DCDEE5", /* Highlight color for controls */
       "controlLtHighlight", "#DCDEE5", /* Light highlight color for controls */
            "controlShadow", "#63656F", /* Shadow color for controls */
       "controlLightShadow", "#9397A5", /* Shadow color for controls */           
          "controlDkShadow", "#000000", /* Dark shadow color for controls */
                "scrollbar", "#AEB2C3", /* Scrollbar ??? color. PENDING(jeff) foreground? background? ?*/
                     "info", "#FFF7E9", /* ??? */
                 "infoText", "#000000"  /* ??? */
        };

        loadSystemColors(table, defaultSystemColors, false/*is1dot2*/);
    }


    protected void initClassDefaults(UIDefaults table)
    {
        super.initClassDefaults(table);
        String motifPackageName = "com.sun.java.swing.plaf.motif.";
	  String windowsPackageName = "com.sun.java.swing.plaf.windows.";
        Object[] uiDefaults = {
                   "ButtonUI", windowsPackageName + "WindowsButtonUI",
                 "CheckBoxUI", motifPackageName + "MotifCheckBoxUI",
            "DirectoryPaneUI", motifPackageName + "MotifDirectoryPaneUI",
              "FileChooserUI", motifPackageName + "MotifFileChooserUI",
                    "LabelUI", motifPackageName + "MotifLabelUI",
                  "MenuBarUI", motifPackageName + "MotifMenuBarUI",
                     "MenuUI", motifPackageName + "MotifMenuUI",
                 "MenuItemUI", motifPackageName + "MotifMenuItemUI",
         "CheckBoxMenuItemUI", motifPackageName + "MotifCheckBoxMenuItemUI",
      "RadioButtonMenuItemUI", motifPackageName + "MotifRadioButtonMenuItemUI",
              "RadioButtonUI", motifPackageName + "MotifRadioButtonUI",
             "ToggleButtonUI", motifPackageName + "MotifToggleButtonUI",
                "PopupMenuUI", motifPackageName + "MotifPopupMenuUI",
              "ProgressBarUI", motifPackageName + "MotifProgressBarUI",
                "ScrollBarUI", motifPackageName + "MotifScrollBarUI",
               "ScrollPaneUI", motifPackageName + "MotifScrollPaneUI",
                   "SliderUI", motifPackageName + "MotifSliderUI",
                "SplitPaneUI", motifPackageName + "MotifSplitPaneUI",
               "TabbedPaneUI", motifPackageName + "MotifTabbedPaneUI",
                 "TextAreaUI", windowsPackageName + "WindowsTextAreaUI",
                "TextFieldUI", motifPackageName + "MotifTextFieldUI",
            "PasswordFieldUI", motifPackageName + "MotifPasswordFieldUI",
                 "TextPaneUI", motifPackageName + "MotifTextPaneUI",
               "EditorPaneUI", motifPackageName + "MotifEditorPaneUI",
                     "TreeUI", motifPackageName + "MotifTreeUI",
            "InternalFrameUI", motifPackageName + "MotifInternalFrameUI",
              "DesktopPaneUI", motifPackageName + "MotifDesktopPaneUI",
                "SeparatorUI", motifPackageName + "MotifSeparatorUI",
       "PopupMenuSeparatorUI", motifPackageName + "MotifPopupMenuSeparatorUI",
               "OptionPaneUI", motifPackageName + "MotifOptionPaneUI",
                 "ComboBoxUI", motifPackageName + "MotifComboBoxUI",
              "DesktopIconUI", motifPackageName + "MotifDesktopIconUI"
        };

        table.putDefaults(uiDefaults);
    }


    private void loadResourceBundle(UIDefaults table) {
        ResourceBundle bundle = ResourceBundle.getBundle("com.sun.java.swing.plaf.motif.resources.motif");
	Enumeration iter = bundle.getKeys();
	while(iter.hasMoreElements()) {
	    String key = (String)iter.nextElement();
	    //System.out.println("key :" +key+ " value: " + bundle.getObject(key));
	    table.put( key, bundle.getObject(key) );
	}
    }


    protected void initComponentDefaults(UIDefaults table) 
    {
        super.initComponentDefaults(table);

        loadResourceBundle(table);

        FontUIResource dialogPlain12 = new FontUIResource("Dialog", 
                                                          Font.PLAIN, 12);
        FontUIResource serifPlain12 = new FontUIResource("Serif", 
                                                          Font.PLAIN, 12);
        FontUIResource sansSerifPlain12 = new FontUIResource("SansSerif", 
                                                          Font.PLAIN, 12);
        FontUIResource monospacedPlain12 = new FontUIResource("Monospaced", 
                                                          Font.PLAIN, 12);
        ColorUIResource red = new ColorUIResource(Color.red);
        ColorUIResource black = new ColorUIResource(Color.black);
        ColorUIResource white = new ColorUIResource(Color.white);
        ColorUIResource lightGray = new ColorUIResource(Color.lightGray);
        ColorUIResource controlDarker = new ColorUIResource(147, 151, 165);  // slate blue
        ColorUIResource scrollBarTrack = controlDarker;
        ColorUIResource menuItemPressedBackground = new ColorUIResource(165,165,165);
        ColorUIResource menuItemPressedForeground = new ColorUIResource(0,0,0);




        Object unselectedTabBackground = new UIDefaults.LazyValue() {
            public Object createValue(UIDefaults table) { 
                Color c = (Color)table.getColor("control");
                return new ColorUIResource(Math.max((int)(c.getRed()*.85),0), 
                                           Math.max((int)(c.getGreen()*.85),0), 
                                           Math.max((int)(c.getBlue()*.85),0));
            }
        };

        Object unselectedTabForeground = new UIDefaults.LazyValue() {
            public Object createValue(UIDefaults table) { 
                Color c = (Color)table.getColor("controlText");
                return new ColorUIResource(Math.max((int)(c.getRed()*.85),0), 
                                           Math.max((int)(c.getGreen()*.85),0), 
                                           Math.max((int)(c.getBlue()*.85),0));
            }
        };

        Object unselectedTabShadow = new UIDefaults.LazyValue() {
            public Object createValue(UIDefaults table) { 
                Color c = (Color)table.getColor("control");
                Color base = new Color(Math.max((int)(c.getRed()*.85),0), 
                                       Math.max((int)(c.getGreen()*.85),0), 
                                       Math.max((int)(c.getBlue()*.85),0));
                return new ColorUIResource(base.darker());
            }
        };

        Object unselectedTabHighlight = new UIDefaults.LazyValue() {
            public Object createValue(UIDefaults table) { 
                Color c = (Color)table.getColor("control");
                Color base = new Color(Math.max((int)(c.getRed()*.85),0), 
                                       Math.max((int)(c.getGreen()*.85),0), 
                                       Math.max((int)(c.getBlue()*.85),0));
                return new ColorUIResource(base.brighter());
            }
        };

	// *** Text

	JTextComponent.KeyBinding[] fieldBindings = {
	    new JTextComponent.KeyBinding(KeyStroke.getKeyStroke(KeyEvent.VK_INSERT, 
								 InputEvent.CTRL_MASK),
					  DefaultEditorKit.copyAction),
	    new JTextComponent.KeyBinding(KeyStroke.getKeyStroke(KeyEvent.VK_INSERT, 
								 InputEvent.SHIFT_MASK),
					  DefaultEditorKit.pasteAction),
	    new JTextComponent.KeyBinding(KeyStroke.getKeyStroke(KeyEvent.VK_DELETE, 
								 InputEvent.SHIFT_MASK),
					  DefaultEditorKit.cutAction),
	    new JTextComponent.KeyBinding(KeyStroke.getKeyStroke(KeyEvent.VK_F, 
								 InputEvent.CTRL_MASK),
					  DefaultEditorKit.forwardAction),
	    new JTextComponent.KeyBinding(KeyStroke.getKeyStroke(KeyEvent.VK_B, 
								 InputEvent.CTRL_MASK),
					  DefaultEditorKit.backwardAction),
	    new JTextComponent.KeyBinding(KeyStroke.getKeyStroke(KeyEvent.VK_D, 
								 InputEvent.CTRL_MASK),
					  DefaultEditorKit.deleteNextCharAction),
	    new JTextComponent.KeyBinding(KeyStroke.getKeyStroke(KeyEvent.VK_LEFT, 
								 InputEvent.SHIFT_MASK),
					  DefaultEditorKit.selectionBackwardAction),
	    new JTextComponent.KeyBinding(KeyStroke.getKeyStroke(KeyEvent.VK_RIGHT, 
								 InputEvent.SHIFT_MASK),
					  DefaultEditorKit.selectionForwardAction),
	    new JTextComponent.KeyBinding(KeyStroke.getKeyStroke(KeyEvent.VK_LEFT, 
								 InputEvent.CTRL_MASK),
					  DefaultEditorKit.previousWordAction),
	    new JTextComponent.KeyBinding(KeyStroke.getKeyStroke(KeyEvent.VK_RIGHT, 
								 InputEvent.CTRL_MASK),
					  DefaultEditorKit.nextWordAction),
	    new JTextComponent.KeyBinding(KeyStroke.getKeyStroke(KeyEvent.VK_LEFT, 
								 InputEvent.CTRL_MASK | 
								 InputEvent.SHIFT_MASK),
					  DefaultEditorKit.selectionPreviousWordAction),
	    new JTextComponent.KeyBinding(KeyStroke.getKeyStroke(KeyEvent.VK_RIGHT, 
								 InputEvent.CTRL_MASK |
								 InputEvent.SHIFT_MASK),
					  DefaultEditorKit.selectionNextWordAction),
	    new JTextComponent.KeyBinding(KeyStroke.getKeyStroke(KeyEvent.VK_SLASH, 
								 InputEvent.CTRL_MASK),
					  DefaultEditorKit.selectAllAction),
	    new JTextComponent.KeyBinding(KeyStroke.getKeyStroke(KeyEvent.VK_HOME, 0),
					  DefaultEditorKit.beginLineAction),
	    new JTextComponent.KeyBinding(KeyStroke.getKeyStroke(KeyEvent.VK_END, 0),
					  DefaultEditorKit.endLineAction),
	    new JTextComponent.KeyBinding(KeyStroke.getKeyStroke(KeyEvent.VK_HOME, 
								 InputEvent.SHIFT_MASK),
					  DefaultEditorKit.selectionBeginLineAction),
	    new JTextComponent.KeyBinding(KeyStroke.getKeyStroke(KeyEvent.VK_END, 
								 InputEvent.SHIFT_MASK),
					  DefaultEditorKit.selectionEndLineAction),
	    new JTextComponent.KeyBinding(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0),
					  JTextField.notifyAction)
	};

	JTextComponent.KeyBinding[] multilineBindings = {
	    new JTextComponent.KeyBinding(KeyStroke.getKeyStroke(KeyEvent.VK_INSERT, 
								 InputEvent.CTRL_MASK),
					  DefaultEditorKit.copyAction),
	    new JTextComponent.KeyBinding(KeyStroke.getKeyStroke(KeyEvent.VK_INSERT, 
								 InputEvent.SHIFT_MASK),
					  DefaultEditorKit.pasteAction),
	    new JTextComponent.KeyBinding(KeyStroke.getKeyStroke(KeyEvent.VK_DELETE, 
								 InputEvent.SHIFT_MASK),
					  DefaultEditorKit.cutAction),
	    new JTextComponent.KeyBinding(KeyStroke.getKeyStroke(KeyEvent.VK_F, 
								 InputEvent.CTRL_MASK),
					  DefaultEditorKit.forwardAction),
	    new JTextComponent.KeyBinding(KeyStroke.getKeyStroke(KeyEvent.VK_B, 
								 InputEvent.CTRL_MASK),
					  DefaultEditorKit.backwardAction),
	    new JTextComponent.KeyBinding(KeyStroke.getKeyStroke(KeyEvent.VK_D, 
								 InputEvent.CTRL_MASK),
					  DefaultEditorKit.deleteNextCharAction),
	    new JTextComponent.KeyBinding(KeyStroke.getKeyStroke(KeyEvent.VK_N,
								 InputEvent.CTRL_MASK),
					  DefaultEditorKit.downAction),
	    new JTextComponent.KeyBinding(KeyStroke.getKeyStroke(KeyEvent.VK_P,
								 InputEvent.CTRL_MASK),
					  DefaultEditorKit.upAction),
	    new JTextComponent.KeyBinding(KeyStroke.getKeyStroke(KeyEvent.VK_LEFT, 
								 InputEvent.SHIFT_MASK),
					  DefaultEditorKit.selectionBackwardAction),
	    new JTextComponent.KeyBinding(KeyStroke.getKeyStroke(KeyEvent.VK_RIGHT, 
								 InputEvent.SHIFT_MASK),
					  DefaultEditorKit.selectionForwardAction),
	    new JTextComponent.KeyBinding(KeyStroke.getKeyStroke(KeyEvent.VK_LEFT, 
								 InputEvent.CTRL_MASK),
					  DefaultEditorKit.previousWordAction),
	    new JTextComponent.KeyBinding(KeyStroke.getKeyStroke(KeyEvent.VK_RIGHT, 
								 InputEvent.CTRL_MASK),
					  DefaultEditorKit.nextWordAction),
	    new JTextComponent.KeyBinding(KeyStroke.getKeyStroke(KeyEvent.VK_LEFT, 
								 InputEvent.CTRL_MASK | 
								 InputEvent.SHIFT_MASK),
					  DefaultEditorKit.selectionPreviousWordAction),
	    new JTextComponent.KeyBinding(KeyStroke.getKeyStroke(KeyEvent.VK_RIGHT, 
								 InputEvent.CTRL_MASK |
								 InputEvent.SHIFT_MASK),
					  DefaultEditorKit.selectionNextWordAction),
	    new JTextComponent.KeyBinding(KeyStroke.getKeyStroke(KeyEvent.VK_SLASH, 
								 InputEvent.CTRL_MASK),
					  DefaultEditorKit.selectAllAction),
	    new JTextComponent.KeyBinding(KeyStroke.getKeyStroke(KeyEvent.VK_HOME, 0),
					  DefaultEditorKit.beginLineAction),
	    new JTextComponent.KeyBinding(KeyStroke.getKeyStroke(KeyEvent.VK_END, 0),
					  DefaultEditorKit.endLineAction),
	    new JTextComponent.KeyBinding(KeyStroke.getKeyStroke(KeyEvent.VK_HOME, 
								 InputEvent.SHIFT_MASK),
					  DefaultEditorKit.selectionBeginLineAction),
	    new JTextComponent.KeyBinding(KeyStroke.getKeyStroke(KeyEvent.VK_END, 
								 InputEvent.SHIFT_MASK),
					  DefaultEditorKit.selectionEndLineAction),
	    new JTextComponent.KeyBinding(KeyStroke.getKeyStroke(KeyEvent.VK_UP, 0),
					  DefaultEditorKit.upAction),
	    new JTextComponent.KeyBinding(KeyStroke.getKeyStroke(KeyEvent.VK_DOWN, 0),
					  DefaultEditorKit.downAction),
	    new JTextComponent.KeyBinding(KeyStroke.getKeyStroke(KeyEvent.VK_PAGE_UP, 0),
					  DefaultEditorKit.pageUpAction),
	    new JTextComponent.KeyBinding(KeyStroke.getKeyStroke(KeyEvent.VK_PAGE_DOWN, 0),
					  DefaultEditorKit.pageDownAction),
	    new JTextComponent.KeyBinding(KeyStroke.getKeyStroke(KeyEvent.VK_UP,
								 InputEvent.SHIFT_MASK),
					  DefaultEditorKit.selectionUpAction),
	    new JTextComponent.KeyBinding(KeyStroke.getKeyStroke(KeyEvent.VK_DOWN,
								 InputEvent.SHIFT_MASK),
					  DefaultEditorKit.selectionDownAction),
	    new JTextComponent.KeyBinding(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0),
					  DefaultEditorKit.insertBreakAction),
	    new JTextComponent.KeyBinding(KeyStroke.getKeyStroke(KeyEvent.VK_TAB, 0),
					  DefaultEditorKit.insertTabAction)
	};

        // *** Tree

        Object treeOpenIcon = LookAndFeel.makeIcon(getClass(), 
                                                           "icons/TreeOpen.gif");

        Object treeClosedIcon = LookAndFeel.makeIcon(getClass(), 
                                                             "icons/TreeClosed.gif");


        Border focusCellHighlightBorder = new BorderUIResource.LineBorderUIResource( 
                                                table.getColor("activeCaptionBorder"));

	Object sliderFocusInsets = new InsetsUIResource( 0, 0, 0, 0 );

	// ** for tabbedpane

        Object tabbedPaneTabInsets = new InsetsUIResource(3, 4, 3, 4);

        Object tabbedPaneTabPadInsets = new InsetsUIResource(3, 0, 1, 0);
	 
	Object tabbedPaneTabAreaInsets = new InsetsUIResource(4, 2, 0, 8);

        Object tabbedPaneContentBorderInsets = new InsetsUIResource(2, 2, 2, 2);


        // ** for optionpane

        Object optionPaneBorder = new BorderUIResource.EmptyBorderUIResource(10,0,10,0);

        Object optionPaneButtonAreaBorder = new BorderUIResource.EmptyBorderUIResource(10,10,12,10);

        Object optionPaneMessageAreaBorder = new BorderUIResource.EmptyBorderUIResource(0,10,12,10);


        Object[] defaults = {

            "Desktop.background", table.get("desktop"),

            "Panel.background", table.get("control"),
            "Panel.foreground", table.get("textText"),
            "Panel.font", dialogPlain12,

            "ProgressBar.font", dialogPlain12,
            "ProgressBar.foreground", controlDarker,
            "ProgressBar.background", table.get("control"), 
	    "ProgressBar.selectionForeground", table.get("control"),
	    "ProgressBar.selectionBackground", table.get("controlText"),
            "ProgressBar.cellLength", new Integer(6),
            "ProgressBar.cellSpacing", new Integer(0),

	    // Buttons
	    "Button.margin", new InsetsUIResource(2, 4, 2, 4),
            "Button.background", table.get("control"),
            "Button.foreground", table.get("controlText"),
            "Button.select", table.get("controlLightShadow"),
            "Button.font", dialogPlain12,

	    "CheckBox.textIconGap", new Integer(8),
	    "CheckBox.margin", new InsetsUIResource(2, 2, 6, 2),
            "CheckBox.focus", table.get("activeCaptionBorder"),

	    "RadioButton.margin", new InsetsUIResource(2, 2, 6, 2),
	    "RadioButton.textIconGap", new Integer(8),
            "RadioButton.background", table.get("control"),
            "RadioButton.foreground", table.get("controlText"),
            "RadioButton.focus", table.get("activeCaptionBorder"),

            "ToggleButton.background", table.get("control"),
            "ToggleButton.foreground", table.get("controlText"),
            "ToggleButton.focus", table.get("controlText"),
            "ToggleButton.select", table.get("controlLightShadow"),

	    // Menus

            "Menu.font", dialogPlain12,
            "Menu.acceleratorFont", dialogPlain12,
            "Menu.foreground", table.get("menuText"),
            "Menu.background", table.get("menu"),
            "Menu.selectionForeground", menuItemPressedForeground,
            "Menu.selectionBackground", menuItemPressedBackground,

            "MenuBar.background", table.get("menu"),
            "MenuBar.foreground", table.get("menuText"),
            "MenuBar.font", dialogPlain12,

            "MenuItem.font", dialogPlain12,
            "MenuItem.acceleratorFont", dialogPlain12,
            "MenuItem.foreground", table.get("menuText"),
            "MenuItem.background", table.get("menu"),
            "MenuItem.selectionForeground", menuItemPressedForeground,
            "MenuItem.selectionBackground", menuItemPressedBackground,


            "RadioButtonMenuItem.font", dialogPlain12,
            "RadioButtonMenuItem.acceleratorFont", dialogPlain12,
            "RadioButtonMenuItem.foreground", table.get("menuText"),
            "RadioButtonMenuItem.background", table.get("menu"),
            "RadioButtonMenuItem.selectionForeground", menuItemPressedForeground,
            "RadioButtonMenuItem.selectionBackground", menuItemPressedBackground,
            "CheckBoxMenuItem.font", dialogPlain12,
            "CheckBoxMenuItem.acceleratorFont", dialogPlain12,
            "CheckBoxMenuItem.foreground", table.get("menuText"),
            "CheckBoxMenuItem.background", table.get("menu"),
            "CheckBoxMenuItem.selectionForeground", menuItemPressedForeground,
            "CheckBoxMenuItem.selectionBackground", menuItemPressedBackground,

            "PopupMenu.background", table.get("menu"),
            "PopupMenu.foreground", table.get("menuText"),
            "PopupMenu.font", dialogPlain12,

            "Label.font", dialogPlain12,
            "Label.background", table.get("control"),
            "Label.foreground", table.get("controlText"),

            "Separator.shadow", table.get("controlShadow"),
            "Separator.highlight", table.get("controlLtHighlight"),

            "List.focusCellHighlightBorder", focusCellHighlightBorder,

            "DesktopIcon.icon", LookAndFeel.makeIcon(getClass(), 
                                                             "icons/DesktopIcon.gif"),
	    "DesktopIcon.border", null,

            "ScrollBar.background", scrollBarTrack,
            "ScrollBar.foreground", table.get("control"),
            "ScrollBar.track", scrollBarTrack,
            "ScrollBar.trackHighlight", table.get("controlDkShadow"),
            "ScrollBar.thumb", table.get("control"),
            "ScrollBar.thumbHighlight", table.get("controlHighlight"),
            "ScrollBar.thumbDarkShadow", table.get("controlDkShadow"),
            "ScrollBar.thumbLightShadow", table.get("controlShadow"), 
            "ScrollPane.font", dialogPlain12,
            "ScrollPane.background", table.get("control"),
            "ScrollPane.foreground", table.get("controlText"),
            "ScrollPane.border", null,

            "Slider.foreground", table.get("control"),
            "Slider.background", controlDarker,
            "Slider.highlight", table.get("controlHighlight"),
            "Slider.shadow", table.get("controlShadow"),
            "Slider.focus", table.get("controlDkShadow"),
	    "Slider.focusInsets", sliderFocusInsets,

            "SplitPane.background", table.get("control"),
            "SplitPane.highlight", table.get("controlHighlight"),
            "SplitPane.shadow", table.get("controlShadow"),
            "SplitPane.dividerSize", new Integer(18),
            "SplitPane.activeThumb", table.get("activeCaptionBorder"),

            "TabbedPane.font", dialogPlain12,
            "TabbedPane.background", table.get("control"),
            "TabbedPane.foreground", table.get("controlText"),
            "TabbedPane.highlight", table.get("controlHighlight"),
            "TabbedPane.lightHighlight", table.get("controlLtHighlight"),
            "TabbedPane.shadow", table.get("controlShadow"),
            "TabbedPane.darkShadow", table.get("controlShadow"),
            "TabbedPane.unselectedTabBackground", unselectedTabBackground,
            "TabbedPane.unselectedTabForeground", unselectedTabForeground,
            "TabbedPane.unselectedTabHighlight", unselectedTabHighlight,
            "TabbedPane.unselectedTabShadow", unselectedTabShadow,
            "TabbedPane.focus", table.get("activeCaptionBorder"),
            "TabbedPane.tabInsets", tabbedPaneTabInsets,
            "TabbedPane.selectedTabPadInsets", tabbedPaneTabPadInsets,
            "TabbedPane.tabAreaInsets", tabbedPaneTabAreaInsets,
            "TabbedPane.contentBorderInsets", tabbedPaneContentBorderInsets,


            "Tree.background", controlDarker,                              // default: dark slate blue
            "Tree.hash", table.get("controlDkShadow"),                     // default: black
            "Tree.iconShadow", table.get("controlShadow"),
            "Tree.iconHighlight", table.get("controlHighlight"),
            "Tree.iconBackground", table.get("control"),                              
            "Tree.iconForeground", table.get("controlShadow"),             // default: black
            "Tree.textBackground", controlDarker,             // default: dark slate blue
            "Tree.textForeground", table.get("textText"),           // default: black
            "Tree.selectionBackground", table.get("text"),            // default: white
            "Tree.selectionForeground", table.get("textText"),              // default: black
            "Tree.selectionBorderColor", table.get("activeCaptionBorder"), // default: maroon
            "Tree.openIcon", treeOpenIcon,
            "Tree.closedIcon", treeClosedIcon,
	    "Tree.editorBorderSelectionColor", table.get("activeCaptionBorder"),
	    "Tree.rowHeight", new Integer(18),
	    "Tree.changeSelectionWithFocus", Boolean.FALSE,
	    "Tree.drawsFocusBorderAroundIcon", Boolean.TRUE,

            "Table.focusCellHighlightBorder", focusCellHighlightBorder,
            "Table.scrollPaneBorder", null,

            //      "Table.background", white,  // cell background color
            //      "Table.focusCellBackground", white,



            "ComboBox.control", table.get("control"),
            "ComboBox.controlForeground", black,
            "ComboBox.background", table.get("window"), 
            "ComboBox.foreground", black,
            "ComboBox.selectionBackground", black,
            "ComboBox.selectionForeground", table.get("text"),
            "ComboBox.disabledBackground", table.get("control"),
            "ComboBox.disabledForeground", table.get("textInactiveText"),
            "ComboBox.font", dialogPlain12,

            "TextField.caretForeground", black,
            "TextField.caretBlinkRate", new Integer(500),
            "TextField.inactiveForeground", table.get("textInactiveText"),
            "TextField.selectionBackground", table.get("textHighlight"),
            "TextField.selectionForeground", table.get("textHighlightText"),
            "TextField.background", table.get("window"),
            "TextField.foreground", table.get("textText"),
            "TextField.font", sansSerifPlain12,
	    "TextField.keyBindings", fieldBindings,
            
            "PasswordField.caretForeground", black,
            "PasswordField.caretBlinkRate", new Integer(500),
            "PasswordField.inactiveForeground", table.get("textInactiveText"),
            "PasswordField.selectionBackground", table.get("textHighlight"),
            "PasswordField.selectionForeground", table.get("textHighlightText"),
            "PasswordField.background", table.get("window"),
            "PasswordField.foreground", table.get("textText"),
            "PasswordField.font", monospacedPlain12,
	    "PasswordField.keyBindings", fieldBindings,
            
            "TextArea.caretForeground", black,
            "TextArea.caretBlinkRate", new Integer(500),
            "TextArea.inactiveForeground", table.get("textInactiveText"),
            "TextArea.selectionBackground", table.get("textHighlight"),
            "TextArea.selectionForeground", table.get("textHighlightText"),
            "TextArea.background", table.get("window"),
            "TextArea.foreground", table.get("textText"),
            "TextArea.font", monospacedPlain12,
	    "TextArea.keyBindings", multilineBindings,
            
            "TextPane.caretForeground", black,
            "TextPane.caretBlinkRate", new Integer(500),
            "TextPane.inactiveForeground", table.get("textInactiveText"),
            "TextPane.selectionBackground", lightGray,
            "TextPane.selectionForeground", table.get("textHighlightText"),
            "TextPane.background", white,
            "TextPane.foreground", table.get("textText"),
            "TextPane.font", serifPlain12,
	    "TextPane.keyBindings", multilineBindings,
            
            "EditorPane.caretForeground", red,
            "EditorPane.caretBlinkRate", new Integer(500),
            "EditorPane.inactiveForeground", table.get("textInactiveText"),
            "EditorPane.selectionBackground", lightGray,
            "EditorPane.selectionForeground", table.get("textHighlightText"),
            "EditorPane.background", white,
            "EditorPane.foreground", table.get("textText"),
            "EditorPane.font", serifPlain12,
	    "FileChooser.pathLabelMnemonic", new Integer(KeyEvent.VK_P), // 'p'
	    "FileChooser.filterLabelMnemonic", new Integer (KeyEvent.VK_R), // 'r'
	    "FileChooser.foldersLabelMnemonic", new Integer (KeyEvent.VK_O), // 'o'
	    "FileChooser.filesLabelMnemonic", new Integer (KeyEvent.VK_I), // 'i'
	    "FileChooser.enterFileNameLabelMnemonic", new Integer (KeyEvent.VK_N), // 'n'
            "ToolTip.background", table.get("info"),
            "ToolTip.foreground", table.get("infoText"),

            "OptionPane.border", optionPaneBorder,
            "OptionPane.messageAreaBorder", optionPaneMessageAreaBorder,
            "OptionPane.buttonAreaBorder", optionPaneButtonAreaBorder,
            "OptionPane.errorIcon", LookAndFeel.makeIcon(getClass(), 
                                                         "icons/Error.gif"),
            "OptionPane.informationIcon", LookAndFeel.makeIcon(getClass(), 
                                                               "icons/Inform.gif"),
            "OptionPane.warningIcon", LookAndFeel.makeIcon(getClass(), 
                                                           "icons/Warn.gif"),
            "OptionPane.questionIcon", LookAndFeel.makeIcon(getClass(), 
                                                            "icons/Question.gif")
        };

        table.putDefaults(defaults);
    }

    /*
     * Returns whether this is being run on a JDK 1.2 or later VM.
     * This is a system-wide, rather than AppContext-wide, state.
     */
    /*package-private*/ static boolean is1dot2 = true;

    static {
        try {
            // Test if method introduced in 1.2 is available.
            Method m = Toolkit.class.getMethod("getMaximumCursorColors", null);
            is1dot2 = (m != null);
        } catch (NoSuchMethodException e) {
            is1dot2 = false;
        }
    }

}

