import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JSeparator;
import java.awt.Toolkit;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.text.DecimalFormat;

public class ctbPPcalculator {

	private JFrame frmCtbPpCalculator;
	private JTextField stars;
	private JTextField ar;
	private JTextField mcombo;
	private JTextField combo;
	private JTextField acc;
	private JTextField miss;
	private JTextField hdpp;
	private JTextField flpp;
	private JTextField nomodpp;
	private JTextField hdflpp;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ctbPPcalculator window = new ctbPPcalculator();
					window.frmCtbPpCalculator.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ctbPPcalculator() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmCtbPpCalculator = new JFrame();
		frmCtbPpCalculator.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\++++++\\osu ctb pp calculator\\icon.png"));
		frmCtbPpCalculator.setTitle("CTB PP CALCULATOR");
		frmCtbPpCalculator.setResizable(false);
		frmCtbPpCalculator.setBounds(100, 100, 491, 410);
		frmCtbPpCalculator.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmCtbPpCalculator.getContentPane().setLayout(null);
		
		JLabel lblCtbPpCalculator = new JLabel("CTB PP CALCULATOR");
		lblCtbPpCalculator.setBounds(10, 11, 166, 14);
		frmCtbPpCalculator.getContentPane().add(lblCtbPpCalculator);
		
		JLabel lblNewLabel = new JLabel("Star difficulty: (include DT/HT/HR/EZ if used): ");
		lblNewLabel.setBounds(10, 36, 253, 14);
		frmCtbPpCalculator.getContentPane().add(lblNewLabel);
		
		stars = new JTextField();
		stars.setBounds(273, 33, 86, 20);
		frmCtbPpCalculator.getContentPane().add(stars);
		stars.setColumns(10);
		
		JLabel lblAr = new JLabel("Approach Rate:");
		lblAr.setBounds(10, 61, 96, 14);
		frmCtbPpCalculator.getContentPane().add(lblAr);
		
		ar = new JTextField();
		ar.setBounds(273, 58, 86, 20);
		frmCtbPpCalculator.getContentPane().add(ar);
		ar.setColumns(10);
		
		JButton btnDT = new JButton("+DT");
		btnDT.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double ms,ar_value;
				DecimalFormat df2 = new DecimalFormat(".##");
				ar_value = Double.parseDouble(ar.getText().toString());				
				
				if (ar_value>5)	ms = 200+(11-ar_value)*100;
				else ms = 800+(5-ar_value)*80;
				
				if (ms<300) ar_value = 11;
				else if (ms<1200) ar_value = Math.round((11-(ms-300)/150)*100)/100;
				else ar_value = Math.round((5-(ms-1200)/120)*100)/100;
				
				ar.setText(String.valueOf(df2.format(ar_value)));
			}
		});
		btnDT.setBackground(Color.LIGHT_GRAY);
		btnDT.setBounds(369, 57, 86, 23);
		frmCtbPpCalculator.getContentPane().add(btnDT);
		
		JLabel lblNewLabel_1 = new JLabel("Maximum Combo:");
		lblNewLabel_1.setBounds(10, 86, 96, 14);
		frmCtbPpCalculator.getContentPane().add(lblNewLabel_1);
		
		mcombo = new JTextField();
		mcombo.setBounds(273, 83, 86, 20);
		frmCtbPpCalculator.getContentPane().add(mcombo);
		mcombo.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Player Combo:");
		lblNewLabel_2.setBounds(10, 111, 108, 14);
		frmCtbPpCalculator.getContentPane().add(lblNewLabel_2);
		
		combo = new JTextField();
		combo.setBounds(273, 108, 86, 20);
		frmCtbPpCalculator.getContentPane().add(combo);
		combo.setColumns(10);
		
		JLabel lblAccuracyoutOf = new JLabel("Accuracy (out of 100):");
		lblAccuracyoutOf.setBounds(10, 136, 137, 14);
		frmCtbPpCalculator.getContentPane().add(lblAccuracyoutOf);
		
		acc = new JTextField();
		acc.setText("100");
		acc.setBounds(273, 133, 86, 20);
		frmCtbPpCalculator.getContentPane().add(acc);
		acc.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Misses:");
		lblNewLabel_3.setBounds(10, 161, 46, 14);
		frmCtbPpCalculator.getContentPane().add(lblNewLabel_3);
		
		miss = new JTextField();
		miss.setText("0");
		miss.setBounds(273, 158, 86, 20);
		frmCtbPpCalculator.getContentPane().add(miss);
		miss.setColumns(10);
		
		JButton btnCalculate = new JButton("CALCULATE");
		btnCalculate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double final_value,stars_value,ar_value,mcombo_value,combo_value,acc_value,miss_value;
				double lengthbonus;
				DecimalFormat df2 = new DecimalFormat(".##");
				
				try {
					stars_value = Double.parseDouble(stars.getText().toString());
					ar_value = Double.parseDouble(ar.getText().toString());
					mcombo_value = Double.parseDouble(mcombo.getText().toString());
					combo_value = Double.parseDouble(combo.getText().toString());
					acc_value = Double.parseDouble(acc.getText().toString());
					miss_value = Double.parseDouble(miss.getText().toString());
					
					if(stars_value <= 0) {
						stars_value = 0;
						stars.setText(String.valueOf(stars_value));
					}
					if (combo_value == 0) combo_value=mcombo_value;
					if (acc_value == 0 || acc_value > 100) {
						acc_value=100;
						acc.setText(String.valueOf(acc_value));
					}	
					if (miss_value <= 0) {
						miss_value=0;
						miss.setText("0");
					} 
					if(combo_value>mcombo_value) {
						combo_value=mcombo_value;
						combo.setText(String.valueOf(combo_value));
					}
					if (ar_value>11) {
						ar_value=11;
						ar.setText(String.valueOf(ar_value));
					}
					
					// Conversion from Star rating to pp
					final_value = Math.pow(((5*(stars_value)/ 0.0049)-4),2)/100000; 
					// Length Bonus
					lengthbonus = (0.95 + 0.4 * Math.min(1.0, mcombo_value / 3000.0) + (mcombo_value > 3000 ? Math.log10(mcombo_value / 3000.0) * 0.5 : 0.0));
					final_value *= lengthbonus;
					// Miss Penalty
					final_value *= Math.pow(0.97, miss_value);
					// Not FC combo penalty
					final_value *= Math.pow(combo_value/mcombo_value,0.8);
					// AR Bonus
					if (ar_value>9)
						final_value*= 1+  0.1 * (ar_value - 9.0);
					if (ar_value<8)
						final_value*= 1+  0.025 * (8.0 - ar_value);
					// Acc Penalty
					final_value *= Math.pow(acc_value/100, 5.5);
					
					nomodpp.setText(String.valueOf(df2.format(final_value))+"pp");
					hdpp.setText(String.valueOf(df2.format(final_value* (1.05 + 0.075 * (10.0 - Math.min(10, ar_value)))))+"pp");
					flpp.setText(String.valueOf(df2.format(final_value* 1.35 * lengthbonus))+"pp");
					hdflpp.setText(String.valueOf(df2.format(final_value* 1.35 * lengthbonus*(1.05 + 0.075 * (10.0 - Math.min(10, ar_value)))))+"pp");
					
					
				}catch(Exception calc) {
					JOptionPane.showMessageDialog(null, "Invalid Input");
				}
				
			}			
		});
		btnCalculate.setBackground(Color.LIGHT_GRAY);
		btnCalculate.setBounds(273, 189, 125, 23);
		frmCtbPpCalculator.getContentPane().add(btnCalculate);
		
		JButton btnClear = new JButton("CLEAR");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				stars.setText(null);
				ar.setText(null);
				mcombo.setText(null);
				combo.setText(null);
				nomodpp.setText(null);
				hdpp.setText(null);
				flpp.setText(null);
				hdflpp.setText(null);
			}
		});
		btnClear.setBackground(Color.LIGHT_GRAY);
		btnClear.setBounds(273, 219, 125, 23);
		frmCtbPpCalculator.getContentPane().add(btnClear);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(193, 211, 1, 2);
		frmCtbPpCalculator.getContentPane().add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 259, 465, 2);
		frmCtbPpCalculator.getContentPane().add(separator_1);
		
		JLabel lblNoModPp = new JLabel("No Mod PP:");
		lblNoModPp.setBounds(10, 272, 96, 14);
		frmCtbPpCalculator.getContentPane().add(lblNoModPp);
		
		JLabel lblhd = new JLabel("+HD:");
		lblhd.setBounds(10, 297, 46, 14);
		frmCtbPpCalculator.getContentPane().add(lblhd);
		
		JLabel lblNewLabel_4 = new JLabel("+FL:");
		lblNewLabel_4.setBounds(10, 322, 46, 14);
		frmCtbPpCalculator.getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("+HDFL:");
		lblNewLabel_5.setBounds(10, 347, 46, 14);
		frmCtbPpCalculator.getContentPane().add(lblNewLabel_5);
		
		hdpp = new JTextField();
		hdpp.setText("0pp");
		hdpp.setEditable(false);
		hdpp.setBounds(273, 294, 86, 20);
		frmCtbPpCalculator.getContentPane().add(hdpp);
		hdpp.setColumns(10);
		
		flpp = new JTextField();
		flpp.setText("0pp");
		flpp.setEditable(false);
		flpp.setBounds(273, 319, 86, 20);
		frmCtbPpCalculator.getContentPane().add(flpp);
		flpp.setColumns(10);
		
		nomodpp = new JTextField();
		nomodpp.setText("0pp");
		nomodpp.setEditable(false);
		nomodpp.setBounds(273, 269, 86, 20);
		frmCtbPpCalculator.getContentPane().add(nomodpp);
		nomodpp.setColumns(10);
		
		hdflpp = new JTextField();
		hdflpp.setText("0pp");
		hdflpp.setEditable(false);
		hdflpp.setBounds(273, 344, 86, 20);
		frmCtbPpCalculator.getContentPane().add(hdflpp);
		hdflpp.setColumns(10);
	}
}
