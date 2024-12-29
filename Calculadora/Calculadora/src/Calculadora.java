import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;

public class Calculadora extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField pantallaCalculadora;
	private JLabel lblCerrar, lblNumeroIntroducido;
	private Image cerrar1, cerrarreescalado;
	private ImageIcon cerrarRedimensionado, cerrar;
	private JButton btnPorcentaje, btnCE, btnC, btnBorrar, btnDividir, btnMultiplicar, btnRestar, btnSumar, btnIgual,
			btnSiete, btnOcho, btnNueve, btnCinco, btnSeis, btnTres, btnDos, btnUno, btnCero, btnmasmenos, btncoma,
			btnCuatro;
	private boolean resultadoMostrado = false;
	private String operacionActual = "";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Calculadora frame = new Calculadora();
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
	public Calculadora() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 289, 450);
		setResizable(false);
		setUndecorated(true); // Quita la barra de arriba de la calculadora.
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(new Color(240, 240, 240));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		// I C O N O  D E  L A  A P L I C A C I O N
        setIconImage(new ImageIcon(getClass().getResource("/imagenes/calculadora.png")).getImage());

		// J L A B E L
		lblNumeroIntroducido = new JLabel("");
		lblNumeroIntroducido.setForeground(Color.GRAY);
		lblNumeroIntroducido.setBounds(208, 43, 46, 14);
		contentPane.add(lblNumeroIntroducido);

		// El JFrame captura los numeros del teclado númerico que estemos presionando al
		// momento y los envía al JTextField.

		addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (Character.isDigit(c) || c == '.') {
                    String currentText = pantallaCalculadora.getText();
                    pantallaCalculadora.setText(currentText + c);
                }
            }
            
            // Cuando se pulsa la tecla ESCAPE se cierra automaticamente la aplicación
            
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
                    dispose();
                }
            }
        });
        setFocusable(true);

		// Imagen de la X, para cerrar el programa.

		cerrar = new ImageIcon(this.getClass().getResource("/imagenes/x.png"));
		cerrar1 = cerrar.getImage();
		cerrarreescalado = cerrar1.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
		cerrarRedimensionado = new ImageIcon(cerrarreescalado);
		lblCerrar = new JLabel(cerrarRedimensionado);
		lblCerrar.setBounds(10, 10, 20, 20);
		lblCerrar.setFocusable(true);

		contentPane.add(lblCerrar);

		lblCerrar.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				dispose();
			}
		});

		// J T E X T F I E L D P A N T A L L A C A L C U L A D O R A
		pantallaCalculadora = new JTextField("");
		pantallaCalculadora.setBounds(10, 65, 253, 46);
		contentPane.add(pantallaCalculadora);
		pantallaCalculadora.setColumns(10);
		pantallaCalculadora.setEditable(false);
		pantallaCalculadora.setHorizontalAlignment(SwingConstants.RIGHT);
		pantallaCalculadora.setFont(new Font("Arial", 0, 25));

		pantallaCalculadora.addKeyListener(new KeyAdapter() {
		    @Override
		    public void keyTyped(KeyEvent e) {
		        char c = e.getKeyChar();
		        if (Character.isDigit(c) || c == '.') {
		            String textoActual = pantallaCalculadora.getText();
		            pantallaCalculadora.setText(textoActual + c);
		        } else if (c == KeyEvent.VK_BACK_SPACE) {
		            String textoActual = pantallaCalculadora.getText();
		            if (textoActual.length() > 0) {
		                pantallaCalculadora.setText(textoActual.substring(0, textoActual.length() - 1));
		            }
		        }
		    }
		});

		// J B U T T O N S

		btnPorcentaje = new JButton("%");
		btnPorcentaje.setBounds(10, 117, 56, 46);
		btnPorcentaje.setBackground(new Color(255, 182, 193));
		contentPane.add(btnPorcentaje);
		

		btnCE = new JButton("CE");
		btnCE.setBounds(76, 117, 56, 46);
		btnCE.setBackground(new Color(255, 182, 193));
		contentPane.add(btnCE);
		
		btnCE.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pantallaCalculadora.setText("");
			}
		});

		btnC = new JButton("C");
		btnC.setBounds(142, 117, 56, 46);
		btnC.setBackground(new Color(255, 182, 193));
		contentPane.add(btnC);

		btnC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pantallaCalculadora.setText("");
			}
		});

		btnBorrar = new JButton("DEL");
		btnBorrar.setBounds(208, 117, 56, 46);
		btnBorrar.setBackground(new Color(255, 182, 193));
		contentPane.add(btnBorrar);

		btnBorrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String textoActual = pantallaCalculadora.getText();
				if (textoActual.length() > 0) {
					pantallaCalculadora.setText(textoActual.substring(0, textoActual.length() - 1));
					pantallaCalculadora.requestFocusInWindow();
				}
			}
		});

		btnDividir = new JButton("/");
		btnDividir.setBounds(208, 171, 56, 46);
		btnDividir.setBackground(new Color(255, 182, 193));
		contentPane.add(btnDividir);

		btnDividir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblNumeroIntroducido.setText(pantallaCalculadora.getText());
				pantallaCalculadora.setText("");
				operacionActual = "/";
				pantallaCalculadora.requestFocusInWindow();
			}
		});

		btnMultiplicar = new JButton("X");
		btnMultiplicar.setBounds(208, 228, 56, 46);
		btnMultiplicar.setBackground(new Color(255, 182, 193));
		contentPane.add(btnMultiplicar);

		btnMultiplicar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblNumeroIntroducido.setText(pantallaCalculadora.getText());
				pantallaCalculadora.setText("");
				operacionActual = "X";
				pantallaCalculadora.requestFocusInWindow();
			}
		});

		btnRestar = new JButton("-");
		btnRestar.setBounds(208, 285, 56, 46);
		btnRestar.setBackground(new Color(255, 182, 193));
		contentPane.add(btnRestar);

		btnRestar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblNumeroIntroducido.setText(pantallaCalculadora.getText());
				pantallaCalculadora.setText("");
				operacionActual = "-";
				pantallaCalculadora.requestFocusInWindow();
			}
		});

		btnSumar = new JButton("+");
		btnSumar.setBounds(208, 342, 56, 46);
		btnSumar.setBackground(new Color(255, 182, 193));
		contentPane.add(btnSumar);

		btnSumar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblNumeroIntroducido.setText(pantallaCalculadora.getText());
				pantallaCalculadora.setText("");
				operacionActual = "+";
				pantallaCalculadora.requestFocusInWindow();
			}
		});

		btnIgual = new JButton("=");
		btnIgual.setBounds(208, 393, 56, 46);
		btnIgual.setBackground(new Color(255, 182, 193));
		contentPane.add(btnIgual);

		btnIgual.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					double numeroActual = Double.parseDouble(pantallaCalculadora.getText());
					double numeroAnterior = Double.parseDouble(lblNumeroIntroducido.getText());
					double resultado = 0;
					switch (operacionActual) {
					case "+":
						resultado = numeroAnterior + numeroActual;
						break;
					case "-":
						resultado = numeroAnterior - numeroActual;
						break;
					case "X":
						resultado = numeroAnterior * numeroActual;
						break;
					case "/":
						if (numeroActual != 0) {
							resultado = numeroAnterior / numeroActual;
						} else {
							pantallaCalculadora.setText("Error");
							return;
						}
						break;
					}
					lblNumeroIntroducido.setText("");
					pantallaCalculadora.setText(String.valueOf(resultado));
					resultadoMostrado = true;
				} catch (NumberFormatException ex) {
					pantallaCalculadora.setText("Error");
				}
				pantallaCalculadora.requestFocusInWindow();
			}
		});

		btnSiete = new JButton("7");
		btnSiete.setBounds(10, 174, 56, 46);
		btnSiete.setBackground(new Color(255, 182, 193));
		contentPane.add(btnSiete);

		btnSiete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (resultadoMostrado) {
					pantallaCalculadora.setText("");
					resultadoMostrado = false;
				}
				String textoActual = pantallaCalculadora.getText();
				pantallaCalculadora.setText(textoActual + "7");
				pantallaCalculadora.requestFocusInWindow();
			}
		});

		btnOcho = new JButton("8");
		btnOcho.setBounds(76, 174, 56, 46);
		btnOcho.setBackground(new Color(255, 182, 193));
		contentPane.add(btnOcho);

		btnOcho.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (resultadoMostrado) {
					pantallaCalculadora.setText("");
					resultadoMostrado = false;
				}
				String textoActual = pantallaCalculadora.getText();
				pantallaCalculadora.setText(textoActual + "8");
				pantallaCalculadora.requestFocusInWindow();
			}
		});

		btnNueve = new JButton("9");
		btnNueve.setBounds(142, 174, 56, 46);
		btnNueve.setBackground(new Color(255, 182, 193));
		contentPane.add(btnNueve);

		btnNueve.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (resultadoMostrado) {
					pantallaCalculadora.setText("");
					resultadoMostrado = false;
				}
				String textoActual = pantallaCalculadora.getText();
				pantallaCalculadora.setText(textoActual + "9");
				pantallaCalculadora.requestFocusInWindow();
			}
		});

		btnCuatro = new JButton("4");
		btnCuatro.setBounds(10, 228, 56, 46);
		btnCuatro.setBackground(new Color(255, 182, 193));
		contentPane.add(btnCuatro);

		btnCuatro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (resultadoMostrado) {
					pantallaCalculadora.setText("");
					resultadoMostrado = false;
				}
				String textoActual = pantallaCalculadora.getText();
				pantallaCalculadora.setText(textoActual + "4");
				pantallaCalculadora.requestFocusInWindow();
			}
		});

		btnCinco = new JButton("5");
		btnCinco.setBounds(76, 228, 56, 46);
		btnCinco.setBackground(new Color(255, 182, 193));
		contentPane.add(btnCinco);

		btnCinco.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (resultadoMostrado) {
					pantallaCalculadora.setText("");
					resultadoMostrado = false;
				}
				String textoActual = pantallaCalculadora.getText();
				pantallaCalculadora.setText(textoActual + "5");
				pantallaCalculadora.requestFocusInWindow();
			}
		});

		btnSeis = new JButton("6");
		btnSeis.setBounds(142, 228, 56, 46);
		btnSeis.setBackground(new Color(255, 182, 193));
		contentPane.add(btnSeis);

		btnSeis.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (resultadoMostrado) {
					pantallaCalculadora.setText("");
					resultadoMostrado = false;
				}
				String textoActual = pantallaCalculadora.getText();
				pantallaCalculadora.setText(textoActual + "6");
				pantallaCalculadora.requestFocusInWindow();
			}
		});

		btnTres = new JButton("3");
		btnTres.setBounds(10, 285, 56, 46);
		btnTres.setBackground(new Color(255, 182, 193));
		contentPane.add(btnTres);

		btnTres.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (resultadoMostrado) {
					pantallaCalculadora.setText("");
					resultadoMostrado = false;
				}
				String textoActual = pantallaCalculadora.getText();
				pantallaCalculadora.setText(textoActual + "3");
				pantallaCalculadora.requestFocusInWindow();
			}
		});

		btnDos = new JButton("2");
		btnDos.setBounds(76, 285, 56, 46);
		btnDos.setBackground(new Color(255, 182, 193));
		contentPane.add(btnDos);

		btnDos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (resultadoMostrado) {
					pantallaCalculadora.setText("");
					resultadoMostrado = false;
				}
				String textoActual = pantallaCalculadora.getText();
				pantallaCalculadora.setText(textoActual + "2");
				pantallaCalculadora.requestFocusInWindow();
			}
		});

		btnUno = new JButton("1");
		btnUno.setBounds(142, 285, 56, 46);
		btnUno.setBackground(new Color(255, 182, 193));
		contentPane.add(btnUno);

		btnUno.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (resultadoMostrado) {
					pantallaCalculadora.setText("");
					resultadoMostrado = false;
				}
				String textoActual = pantallaCalculadora.getText();
				pantallaCalculadora.setText(textoActual + "1");
				pantallaCalculadora.requestFocusInWindow();
			}
		});

		btnCero = new JButton("0");
		btnCero.setBounds(76, 342, 56, 46);
		btnCero.setBackground(new Color(255, 182, 193));
		contentPane.add(btnCero);

		btnCero.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (resultadoMostrado) {
					pantallaCalculadora.setText("");
					resultadoMostrado = false;
				}
				String textoActual = pantallaCalculadora.getText();
				pantallaCalculadora.setText(textoActual + "0");
				pantallaCalculadora.requestFocusInWindow();
			}
		});

		btnmasmenos = new JButton("+/-");
		btnmasmenos.setBounds(10, 342, 56, 46);
		btnmasmenos.setBackground(new Color(255, 182, 193));
		contentPane.add(btnmasmenos);

		btncoma = new JButton(",");
		btncoma.setBounds(142, 342, 56, 46);
		btncoma.setBackground(new Color(255, 182, 193));
		contentPane.add(btncoma);

		btncoma.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String textoActual = pantallaCalculadora.getText();
				if (!textoActual.contains(".")) {
					pantallaCalculadora.setText(textoActual + ".");
					pantallaCalculadora.requestFocusInWindow();
				}
			}
		});

	}
}
