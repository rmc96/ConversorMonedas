package principal;

import java.awt.EventQueue;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import conversorMonedas.ConvertirMonedasGUI;
import conversorTemperatura.ConvertirTemperaturaGUI;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class principalGUI extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
    JComboBox<String> comboBox;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					principalGUI frame = new principalGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
	}

	/**
	 * Create the frame.
	 */
	public principalGUI() {
		setTitle("Menu");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel(new FlowLayout(FlowLayout.CENTER)); //center
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS)); // Use BoxLayout with Y_AXIS
		contentPane.setBorder(new EmptyBorder(20, 20, 20, 20));
		setContentPane(contentPane);
		
		JLabel label = new JLabel("Seleccione una opción de conversión");
		label.setAlignmentX(0.5f);
		label.setFont(new Font("Arial Black", Font.PLAIN, 12));
		label.setBorder(new EmptyBorder(0, 0, 5, 0));
		contentPane.add(label);

		// Crear un arreglo con los elementos para la JComboBox
        String[] elementos = { "Seleccione","Conversor de Monedas", "Conversor de Temperatura"};
        // Crear la JComboBox y agregar los elementos
        comboBox = new JComboBox<>(elementos);
		comboBox.setFont(new Font("Arial Black", Font.PLAIN, 12));
		comboBox.setBorder(new EmptyBorder(5, 0, 5, 0));
		contentPane.add(comboBox);
        
		
		// Crear un panel para atrapar los botones and align them horizontally
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JButton btnAceptar = new JButton("OK");
        btnAceptar.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		if (validateComboBox()) {
        			 String comboSelect = (String) comboBox.getSelectedItem();
        			 if(comboSelect.trim() =="Seleccione") {
        				 JOptionPane.showMessageDialog(null, "Por favor elija que acción desea realizar"); 
        			 }
        			 else if(comboSelect.trim() =="Conversor de Monedas")  { 
            	         //System.out.println("Selected option: " + comboSelect);
        				 
            	         ConvertirMonedasGUI convertirMonedasFrame = new ConvertirMonedasGUI(principalGUI.this);
            	         convertirMonedasFrame.setVisible(true);
            	         
//            	         dispose();
        			 }else if(comboSelect.trim() =="Conversor de Temperatura"){
//            	         System.out.println("Selected option: " + comboSelect);
        				 ConvertirTemperaturaGUI convertirTemperaturaFrame = new ConvertirTemperaturaGUI(principalGUI.this);
        				 convertirTemperaturaFrame.setVisible(true);
        			 }
        	         //JOptionPane.showMessageDialog(null, comboSelect);  
                    //dispose(); // Close the JFrame when all JComboBox components have valid selections
                } else {
                    JOptionPane.showMessageDialog(principalGUI.this, "Seleccione una opción de conversión válida.", "Error", JOptionPane.ERROR_MESSAGE);
                }
        	}
        });
        btnAceptar.setFont(new Font("Arial Black", Font.PLAIN, 12));
        buttonPanel.add(btnAceptar);

        JButton btnCancelar = new JButton("Cancelar");
        btnCancelar.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		dispose();
        	}
        });
        btnCancelar.setFont(new Font("Arial Black", Font.PLAIN, 12));
        buttonPanel.add(btnCancelar);
        contentPane.add(buttonPanel);

        pack();
        setLocationRelativeTo(null);
	}

	 // Validate the JComboBox selection
    private boolean validateComboBox() {
		return comboBox.getSelectedIndex() >= 0;
    }
}
