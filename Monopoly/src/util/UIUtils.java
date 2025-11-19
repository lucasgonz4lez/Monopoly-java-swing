package util;

import javax.swing.*;
import java.awt.*;

public class UIUtils {
    public static void setUIFont(String fontName, int fontSize) {
        UIManager.put("Button.font", new Font(fontName, Font.PLAIN, fontSize));
        UIManager.put("Label.font", new Font(fontName, Font.PLAIN, fontSize));
        UIManager.put("TextField.font", new Font(fontName, Font.PLAIN, fontSize));
        UIManager.put("TextArea.font", new Font(fontName, Font.PLAIN, fontSize));
        UIManager.put("ComboBox.font", new Font(fontName, Font.PLAIN, fontSize));
        UIManager.put("List.font", new Font(fontName, Font.PLAIN, fontSize));
        UIManager.put("Table.font", new Font(fontName, Font.PLAIN, fontSize));
        UIManager.put("Tree.font", new Font(fontName, Font.PLAIN, fontSize));
    }
}
