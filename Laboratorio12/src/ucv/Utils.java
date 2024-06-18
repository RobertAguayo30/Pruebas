package ucv;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

public class Utils {

	public static JTextField createText(String titulo, int x, int y, int w, int h) {
		JTextField jText = new JTextField();
		jText.setBorder(new TitledBorder(null, titulo, TitledBorder.LEADING, TitledBorder.TOP, null, null));
		jText.setBounds(x, y, w, h);
		jText.setColumns(10);
		return jText;
	}

	public static JTextField createText(String titulo, int x, int y, int w, int h, boolean editable) {
		JTextField jText = createText(titulo, x, y, w, h);
		jText.setEditable(editable);
		return jText;
	}

	public static JComboBox<String> createCombo(String titulo, int x, int y, int w, int h, String[] opciones) {
		JComboBox<String> jCombo = new JComboBox<String>();
		jCombo.setModel(new DefaultComboBoxModel<String>(opciones));
		jCombo.setBorder(new TitledBorder(null, titulo, TitledBorder.LEADING, TitledBorder.TOP, null, null));
		jCombo.setBounds(x, y, w, h);
		return jCombo;
	}

	public static JButton createButton(String titulo, int x, int y, int w, int h) {
		JButton jButton = new JButton(titulo);
		jButton.setBounds(x, y, w, h);
		return jButton;
	}
}
