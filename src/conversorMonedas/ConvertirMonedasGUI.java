package conversorMonedas;

import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
//import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.AbstractDocument;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ConvertirMonedasGUI extends JDialog {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField inputText;
	FunctionMonedas monedas = new FunctionMonedas();
	/**
	 * Create the frame.
	 */
	public ConvertirMonedasGUI(JFrame parent) {

        super(parent, "Convertir Monedas", true); // The "true" parameter makes it a modal dialog
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        setSize(400, 300); // Set your preferred size
        setLocationRelativeTo(parent); // Center the dialog on the parent JFrame
        
		setBounds(100, 100, 450, 200);
		contentPane = new JPanel();
		contentPane = new JPanel(new FlowLayout(FlowLayout.CENTER)); //center
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JPanel inputPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		
		JLabel label = new JLabel("Ingresa la cantidad de dinero que desea convertir");
		label.setAlignmentX(0.5f);
		label.setFont(new Font("Arial Black", Font.PLAIN, 12));
		label.setBorder(new EmptyBorder(0, 0, 5, 0));
		inputPanel.add(label);
		contentPane.add(inputPanel);
		
		inputText = new JTextField();
		((AbstractDocument) inputText.getDocument()).setDocumentFilter(new NumberDocumentFilter());
        contentPane.add(inputText);
		inputText.setFont(new Font("Arial Black", Font.PLAIN, 12));
		inputText.setColumns(10);
		contentPane.add(inputText);
		
		JLabel labelText = new JLabel("Elija la moneda a la que desea convertir tu dinero");
		labelText.setAlignmentX(0.5f);
		labelText.setFont(new Font("Arial Black", Font.PLAIN, 12));
		labelText.setBorder(new EmptyBorder(0, 0, 5, 0));
		contentPane.add(labelText);
		
		String[] tipos = {"De Soles a Dólar", "De Soles a Euro", "De Soles a Libras Esterlinas", "De Soles a Yen",
				"De Soles a Won Coreano","De Dólar a Soles", "De Euro a Soles","De Libras Esterlinas a Soles", 
				"De Yen a Soles","De Won Coreano a Soles"};
        // Crear la JComboBox y agregar los tipos
		JComboBox<String> comboBox = new JComboBox<>(tipos);
		comboBox.setFont(new Font("Arial Black", Font.PLAIN, 12));
		comboBox.setBorder(new EmptyBorder(5, 0, 5, 0));
		contentPane.add(comboBox);
		
		
		
		JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JButton btnConvertir = new JButton("OK");
        btnConvertir.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		String input = inputText.getText();
        		String comboSelect = (String) comboBox.getSelectedItem();
        		if(ValidarNumero(input) == true && input!= "") {
        			double valor = Double.parseDouble(input);
                    String resultado = monedas.ConvertirMonedas(valor, comboSelect);
                    JOptionPane.showMessageDialog(null, resultado); 
        		}else {
        			JOptionPane.showMessageDialog(null, "Ingrese un valor válido");
        		}
        	}
        });
        
        btnConvertir.setFont(new Font("Arial Black", Font.PLAIN, 12));
        buttonPanel.add(btnConvertir);
        contentPane.add(buttonPanel);
        
	}
    // Custom document filter to allow only numeric input in the JTextField
    private class NumberDocumentFilter extends DocumentFilter {
        @Override
        public void insertString(FilterBypass fb, int offset, String string, AttributeSet attr) throws BadLocationException {
            // Allow only numeric characters to be inserted
            if (string.matches("[0-9.]*")) {
                super.insertString(fb, offset, string, attr);
            }
        }

        @Override
        public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
            // Allow only numeric characters to be replaced
            if (text.matches("[0-9.]*")) {
                super.replace(fb, offset, length, text, attrs);
            }
        }
    }
    public static boolean ValidarNumero(String input) {
        try {
            double x = Double.parseDouble(input);
            if(x >= 0 || x < 0);
                return true;
            } catch (NumberFormatException e) {
                return false;
            }
    }
}
