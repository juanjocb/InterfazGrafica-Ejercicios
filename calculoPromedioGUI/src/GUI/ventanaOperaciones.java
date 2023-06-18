package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import operaciones.Procesos;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.Color;

public class ventanaOperaciones extends JFrame implements ActionListener {

	private JPanel panelPrincipal;
	private JTextField txtNombre;
	private JTextField txtNota1;
	private JTextField txtNota2;
	private JTextField txtNota3;
	private JButton btnCalcular;
	private JLabel lblResultadoPromedio;
	private JLabel lblResulPromedio;
	Procesos misProcesos;

	public ventanaOperaciones() {

		misProcesos = new Procesos();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		/*
		 * Uno mismo le da un tamaño a la ventana cuando se ejecuta setBounds(550, 150,
		 * 800, 500);
		 */
		setSize(800, 500);
		// Genera la ventana centrada
		setLocationRelativeTo(null);
		// Pone el titulo de la ventana
		setTitle("CALCULO DE PROMEDIO");
		// No deja maximizar la ventana
		setResizable(false);
		iniciarComponentes();

	}

	private void iniciarComponentes() {

		panelPrincipal = new JPanel();
		panelPrincipal.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(panelPrincipal);
		panelPrincipal.setLayout(null);

		JLabel lblTitulo = new JLabel("CALCULAR PROMEDIO");
		lblTitulo.setBackground(Color.BLACK);
		lblTitulo.setForeground(Color.WHITE);
		lblTitulo.setOpaque(true);
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblTitulo.setBounds(-40, 0, 864, 71);
		panelPrincipal.add(lblTitulo);

		JLabel lblNombre = new JLabel("Nombre: ");
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNombre.setBounds(85, 105, 98, 26);
		panelPrincipal.add(lblNombre);

		txtNombre = new JTextField();
		txtNombre.setHorizontalAlignment(SwingConstants.CENTER);
		txtNombre.setBounds(154, 104, 487, 26);
		txtNombre.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panelPrincipal.add(txtNombre);
		txtNombre.setColumns(10);

		JLabel lblNota1 = new JLabel("Nota 1: ");
		lblNota1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNota1.setBounds(85, 159, 98, 26);
		panelPrincipal.add(lblNota1);

		txtNota1 = new JTextField();
		txtNota1.setHorizontalAlignment(SwingConstants.CENTER);
		txtNota1.setColumns(10);
		txtNota1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtNota1.setBounds(154, 158, 86, 26);
		panelPrincipal.add(txtNota1);

		JLabel lblNota2 = new JLabel("Nota 2: ");
		lblNota2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNota2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNota2.setBounds(278, 159, 98, 26);
		panelPrincipal.add(lblNota2);

		txtNota2 = new JTextField();
		txtNota2.setColumns(10);
		txtNota2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtNota2.setBounds(365, 160, 86, 26);
		panelPrincipal.add(txtNota2);

		JLabel lblNota3 = new JLabel("Nota 3: ");
		lblNota3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNota3.setBounds(486, 159, 98, 26);
		panelPrincipal.add(lblNota3);

		txtNota3 = new JTextField();
		txtNota3.setHorizontalAlignment(SwingConstants.CENTER);
		txtNota3.setColumns(10);
		txtNota3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtNota3.setBounds(555, 158, 86, 26);
		panelPrincipal.add(txtNota3);

		JLabel lblPromedio = new JLabel("PROMEDIO:");
		lblPromedio.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblPromedio.setBounds(159, 233, 118, 44);
		panelPrincipal.add(lblPromedio);

		lblResultadoPromedio = new JLabel("");
		lblResultadoPromedio.setHorizontalAlignment(SwingConstants.CENTER);
		lblResultadoPromedio.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblResultadoPromedio.setBounds(287, 233, 354, 44);
		panelPrincipal.add(lblResultadoPromedio);

		lblResulPromedio = new JLabel("");
		lblResulPromedio.setHorizontalAlignment(SwingConstants.CENTER);
		lblResulPromedio.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblResulPromedio.setBounds(154, 290, 487, 44);
		panelPrincipal.add(lblResulPromedio);

		btnCalcular = new JButton("CALCULAR");
		btnCalcular.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnCalcular.setForeground(Color.BLACK);
		btnCalcular.setBackground(Color.WHITE);
		btnCalcular.setBounds(317, 361, 150, 54);
		btnCalcular.addActionListener(this);
		panelPrincipal.add(btnCalcular);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == btnCalcular) {

			calcularPromedio();

		}

	}

	private void calcularPromedio() {

		String nombre = txtNombre.getText();

		try {

			double nota1 = Integer.parseInt(txtNota1.getText());
			double nota2 = Integer.parseInt(txtNota2.getText());
			double nota3 = Integer.parseInt(txtNota3.getText());

			if (misProcesos.validarNotas(nota1, nota2, nota3)) {

				double promedio = misProcesos.calcularPromedio(nota1, nota2, nota3);
				lblResultadoPromedio.setText(nombre + " su promedio es: " + promedio + "");

				String resultado = misProcesos.calcularDefinitiva(promedio);

				if (resultado.equalsIgnoreCase("GANA")) {
					lblResulPromedio.setText("Felicidades, has ganado la materia");
					lblResulPromedio.setForeground(Color.GREEN);
				} else {
					lblResulPromedio.setText("Ups! Perdiste.");
					lblResulPromedio.setForeground(Color.RED);
				}
			} else {
				JOptionPane.showMessageDialog(null, "Ups! Numeros invalidos. (Limite: 1-5)", "ERROR",
						JOptionPane.ERROR_MESSAGE);
			}

		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "Hubo un error, ingreso de texto.", "ERROR", JOptionPane.ERROR_MESSAGE);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Ocurre un error.", "ERROR", JOptionPane.ERROR_MESSAGE);
		}
	}
}
