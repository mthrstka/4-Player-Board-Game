import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Font;
import javax.swing.JToggleButton;
import java.awt.Insets;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GUI_GuessWindow extends JFrame {

	// Create the buttons used on the form as class variables since they will be called in methods
	static JToggleButton tglbtnNumber1 = new JToggleButton("1");
	static JToggleButton tglbtnNumber2 = new JToggleButton("2");
	static JToggleButton tglbtnNumber3 = new JToggleButton("3");
	static JToggleButton tglbtnNumber4 = new JToggleButton("4");
	static JToggleButton tglbtnNumber5 = new JToggleButton("5");
	static JToggleButton tglbtnNumber6 = new JToggleButton("6");
	static JToggleButton tglbtnNumber7 = new JToggleButton("7");
	static JToggleButton tglbtnNumber8 = new JToggleButton("8");
	static JToggleButton tglbtnNumber9 = new JToggleButton("9");
	static JToggleButton tglbtnNumber10 = new JToggleButton("10");
	static JToggleButton tglbtnNumber11 = new JToggleButton("11");
	static JToggleButton tglbtnNumber12 = new JToggleButton("12");
	static JToggleButton tglbtnNumber13 = new JToggleButton("13");
	static JToggleButton tglbtnNumber14 = new JToggleButton("14");
	static JToggleButton tglbtnNumber15 = new JToggleButton("15");
	static JToggleButton tglbtnNumber16 = new JToggleButton("16");
	static JToggleButton tglbtnNumber17 = new JToggleButton("17");
	static JToggleButton tglbtnNumber18 = new JToggleButton("18");
	static JToggleButton tglbtnNumber19 = new JToggleButton("19");
	static JToggleButton tglbtnNumber20 = new JToggleButton("20");
	int guess = 0; // Create a class variable guess to hold the guess number
	
	
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	// TODO: Add a parameter to main of an integer array containing buttons to disable (previous guesses)
	public static void main(String[] args) {
		
		// TODO: Delete the auto generated block below and trigger running the GUI_GuessWindow elsewhere 
		// Begin auto generated block to run the main GUI_GuessWindow method
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI_GuessWindow frame = new GUI_GuessWindow();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		// End auto generated block
		
		// TODO: Delete this test array block below
		// Below are some test values - delete later
		int[] intArray = new int[4];	// Example of an int array of numbers to disable
		intArray[0] = 1; 				// Populate some values into the test array
		intArray[1] = 0;
		intArray[2] = 14;
		intArray[3] = 19;
		
		
		lockButtons(intArray); 			// Run the lockButtons method with intArray
		
	} // End main driver code

	
	/**
	 * Create the frame.
	 */
	public GUI_GuessWindow() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 435, 282);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[] {60, 60, 60, 60, 60};
		gbl_contentPane.rowHeights = new int[] {0, 0, 0, 0, 0, 50, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel lblInstructions = new JLabel("Please select your guess number.");
		lblInstructions.setFont(new Font("Tahoma", Font.PLAIN, 12));
		GridBagConstraints gbc_lblInstructions = new GridBagConstraints();
		gbc_lblInstructions.insets = new Insets(0, 0, 5, 0);
		gbc_lblInstructions.gridwidth = 5;
		gbc_lblInstructions.gridx = 0;
		gbc_lblInstructions.gridy = 0;
		contentPane.add(lblInstructions, gbc_lblInstructions);

		
		tglbtnNumber1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GridBagConstraints gbc_tglbtnNumber1 = new GridBagConstraints();
		gbc_tglbtnNumber1.fill = GridBagConstraints.BOTH;
		gbc_tglbtnNumber1.insets = new Insets(0, 0, 5, 5);
		gbc_tglbtnNumber1.gridx = 0;
		gbc_tglbtnNumber1.gridy = 1;
		contentPane.add(tglbtnNumber1, gbc_tglbtnNumber1);
		tglbtnNumber1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				untoggleButtons(1);					// Call the method to untoggle all other buttons...
		    	tglbtnNumber1.setSelected(true);	// ...and then toggle this button on.
				
			} // End actionPerformed method for tglbtnNumber1
		});
		
		tglbtnNumber2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GridBagConstraints gbc_tglbtnNumber2 = new GridBagConstraints();
		gbc_tglbtnNumber2.fill = GridBagConstraints.BOTH;
		gbc_tglbtnNumber2.insets = new Insets(0, 0, 5, 5);
		gbc_tglbtnNumber2.gridx = 1;
		gbc_tglbtnNumber2.gridy = 1;
		contentPane.add(tglbtnNumber2, gbc_tglbtnNumber2);
		tglbtnNumber2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				untoggleButtons(2);					// Call the method to untoggle all other buttons...
		    	tglbtnNumber2.setSelected(true);	// ...and then toggle this button on.
				
			} // End actionPerformed method for tglbtnNumber2
		});
		
		tglbtnNumber3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GridBagConstraints gbc_tglbtnNumber3 = new GridBagConstraints();
		gbc_tglbtnNumber3.fill = GridBagConstraints.BOTH;
		gbc_tglbtnNumber3.insets = new Insets(0, 0, 5, 5);
		gbc_tglbtnNumber3.gridx = 2;
		gbc_tglbtnNumber3.gridy = 1;
		contentPane.add(tglbtnNumber3, gbc_tglbtnNumber3);
		tglbtnNumber3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				untoggleButtons(3);					// Call the method to untoggle all other buttons...
		    	tglbtnNumber3.setSelected(true);	// ...and then toggle this button on.
				
			} // End actionPerformed method for tglbtnNumber3
		});
		
		tglbtnNumber4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GridBagConstraints gbc_tglbtnNumber4 = new GridBagConstraints();
		gbc_tglbtnNumber4.fill = GridBagConstraints.BOTH;
		gbc_tglbtnNumber4.insets = new Insets(0, 0, 5, 5);
		gbc_tglbtnNumber4.gridx = 3;
		gbc_tglbtnNumber4.gridy = 1;
		contentPane.add(tglbtnNumber4, gbc_tglbtnNumber4);
		tglbtnNumber4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				untoggleButtons(4);					// Call the method to untoggle all other buttons...
		    	tglbtnNumber4.setSelected(true);	// ...and then toggle this button on.
				
			} // End actionPerformed method for tglbtnNumber4
		});
		
		tglbtnNumber5.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GridBagConstraints gbc_tglbtnNumber5 = new GridBagConstraints();
		gbc_tglbtnNumber5.fill = GridBagConstraints.BOTH;
		gbc_tglbtnNumber5.insets = new Insets(0, 0, 5, 5);
		gbc_tglbtnNumber5.gridx = 4;
		gbc_tglbtnNumber5.gridy = 1;
		contentPane.add(tglbtnNumber5, gbc_tglbtnNumber5);
		tglbtnNumber5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				untoggleButtons(5);					// Call the method to untoggle all other buttons...
		    	tglbtnNumber5.setSelected(true);	// ...and then toggle this button on.
				
			} // End actionPerformed method for tglbtnNumber5
		});
		
		tglbtnNumber6.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GridBagConstraints gbc_tglbtnNumber6 = new GridBagConstraints();
		gbc_tglbtnNumber6.fill = GridBagConstraints.BOTH;
		gbc_tglbtnNumber6.insets = new Insets(0, 0, 5, 5);
		gbc_tglbtnNumber6.gridx = 0;
		gbc_tglbtnNumber6.gridy = 2;
		contentPane.add(tglbtnNumber6, gbc_tglbtnNumber6);
		tglbtnNumber6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				untoggleButtons(6);					// Call the method to untoggle all other buttons...
		    	tglbtnNumber6.setSelected(true);	// ...and then toggle this button on.
				
			} // End actionPerformed method for tglbtnNumber6
		});
		
		tglbtnNumber7.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GridBagConstraints gbc_tglbtnNumber7 = new GridBagConstraints();
		gbc_tglbtnNumber7.fill = GridBagConstraints.BOTH;
		gbc_tglbtnNumber7.insets = new Insets(0, 0, 5, 5);
		gbc_tglbtnNumber7.gridx = 1;
		gbc_tglbtnNumber7.gridy = 2;
		contentPane.add(tglbtnNumber7, gbc_tglbtnNumber7);
		tglbtnNumber7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				untoggleButtons(7);					// Call the method to untoggle all other buttons...
		    	tglbtnNumber7.setSelected(true);	// ...and then toggle this button on.
				
			} // End actionPerformed method for tglbtnNumber7
		});
		
		tglbtnNumber8.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GridBagConstraints gbc_tglbtnNumber8 = new GridBagConstraints();
		gbc_tglbtnNumber8.fill = GridBagConstraints.BOTH;
		gbc_tglbtnNumber8.insets = new Insets(0, 0, 5, 5);
		gbc_tglbtnNumber8.gridx = 2;
		gbc_tglbtnNumber8.gridy = 2;
		contentPane.add(tglbtnNumber8, gbc_tglbtnNumber8);
		tglbtnNumber8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				untoggleButtons(8);					// Call the method to untoggle all other buttons...
		    	tglbtnNumber8.setSelected(true);	// ...and then toggle this button on.
				
			} // End actionPerformed method for tglbtnNumber8
		});
		
		tglbtnNumber9.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GridBagConstraints gbc_tglbtnNumber9 = new GridBagConstraints();
		gbc_tglbtnNumber9.fill = GridBagConstraints.BOTH;
		gbc_tglbtnNumber9.insets = new Insets(0, 0, 5, 5);
		gbc_tglbtnNumber9.gridx = 3;
		gbc_tglbtnNumber9.gridy = 2;
		contentPane.add(tglbtnNumber9, gbc_tglbtnNumber9);
		tglbtnNumber9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				untoggleButtons(9);					// Call the method to untoggle all other buttons...
		    	tglbtnNumber9.setSelected(true);	// ...and then toggle this button on.
				
			} // End actionPerformed method for tglbtnNumber9
		});
		
		tglbtnNumber10.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GridBagConstraints gbc_tglbtnNumber10 = new GridBagConstraints();
		gbc_tglbtnNumber10.fill = GridBagConstraints.BOTH;
		gbc_tglbtnNumber10.insets = new Insets(0, 0, 5, 5);
		gbc_tglbtnNumber10.gridx = 4;
		gbc_tglbtnNumber10.gridy = 2;
		contentPane.add(tglbtnNumber10, gbc_tglbtnNumber10);
		tglbtnNumber10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				untoggleButtons(10);					// Call the method to untoggle all other buttons...
		    	tglbtnNumber10.setSelected(true);		// ...and then toggle this button on.
				
			} // End actionPerformed method for tglbtnNumber10
		});
		
		tglbtnNumber11.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GridBagConstraints gbc_tglbtnNumber11 = new GridBagConstraints();
		gbc_tglbtnNumber11.fill = GridBagConstraints.BOTH;
		gbc_tglbtnNumber11.insets = new Insets(0, 0, 5, 5);
		gbc_tglbtnNumber11.gridx = 0;
		gbc_tglbtnNumber11.gridy = 3;
		contentPane.add(tglbtnNumber11, gbc_tglbtnNumber11);
		tglbtnNumber11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				untoggleButtons(11);					// Call the method to untoggle all other buttons...
		    	tglbtnNumber11.setSelected(true);		// ...and then toggle this button on.
				
			} // End actionPerformed method for tglbtnNumber11
		});
		
		tglbtnNumber12.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GridBagConstraints gbc_tglbtnNumber12 = new GridBagConstraints();
		gbc_tglbtnNumber12.fill = GridBagConstraints.BOTH;
		gbc_tglbtnNumber12.insets = new Insets(0, 0, 5, 5);
		gbc_tglbtnNumber12.gridx = 1;
		gbc_tglbtnNumber12.gridy = 3;
		contentPane.add(tglbtnNumber12, gbc_tglbtnNumber12);
		tglbtnNumber12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				untoggleButtons(12);					// Call the method to untoggle all other buttons...
		    	tglbtnNumber12.setSelected(true);		// ...and then toggle this button on.
				
			} // End actionPerformed method for tglbtnNumber12
		});
		
		tglbtnNumber13.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GridBagConstraints gbc_tglbtnNumber13 = new GridBagConstraints();
		gbc_tglbtnNumber13.fill = GridBagConstraints.BOTH;
		gbc_tglbtnNumber13.insets = new Insets(0, 0, 5, 5);
		gbc_tglbtnNumber13.gridx = 2;
		gbc_tglbtnNumber13.gridy = 3;
		contentPane.add(tglbtnNumber13, gbc_tglbtnNumber13);
		tglbtnNumber13.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				untoggleButtons(13);					// Call the method to untoggle all other buttons...
		    	tglbtnNumber13.setSelected(true);		// ...and then toggle this button on.
				
			} // End actionPerformed method for tglbtnNumber13
		});
		
		tglbtnNumber14.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GridBagConstraints gbc_tglbtnNumber14 = new GridBagConstraints();
		gbc_tglbtnNumber14.fill = GridBagConstraints.BOTH;
		gbc_tglbtnNumber14.insets = new Insets(0, 0, 5, 5);
		gbc_tglbtnNumber14.gridx = 3;
		gbc_tglbtnNumber14.gridy = 3;
		contentPane.add(tglbtnNumber14, gbc_tglbtnNumber14);
		tglbtnNumber14.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				untoggleButtons(14);					// Call the method to untoggle all other buttons...
		    	tglbtnNumber14.setSelected(true);		// ...and then toggle this button on.
				
			} // End actionPerformed method for tglbtnNumber14
		});
		
		tglbtnNumber15.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GridBagConstraints gbc_tglbtnNumber15 = new GridBagConstraints();
		gbc_tglbtnNumber15.fill = GridBagConstraints.BOTH;
		gbc_tglbtnNumber15.insets = new Insets(0, 0, 5, 5);
		gbc_tglbtnNumber15.gridx = 4;
		gbc_tglbtnNumber15.gridy = 3;
		contentPane.add(tglbtnNumber15, gbc_tglbtnNumber15);
		tglbtnNumber15.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				untoggleButtons(15);					// Call the method to untoggle all other buttons...
		    	tglbtnNumber15.setSelected(true);		// ...and then toggle this button on.
				
			} // End actionPerformed method for tglbtnNumber15
		});
		
		tglbtnNumber16.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GridBagConstraints gbc_tglbtnNumber16 = new GridBagConstraints();
		gbc_tglbtnNumber16.fill = GridBagConstraints.BOTH;
		gbc_tglbtnNumber16.insets = new Insets(0, 0, 5, 5);
		gbc_tglbtnNumber16.gridx = 0;
		gbc_tglbtnNumber16.gridy = 4;
		contentPane.add(tglbtnNumber16, gbc_tglbtnNumber16);
		tglbtnNumber16.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				untoggleButtons(16);					// Call the method to untoggle all other buttons...
		    	tglbtnNumber16.setSelected(true);		// ...and then toggle this button on.
				
			} // End actionPerformed method for tglbtnNumber16
		});
		
		tglbtnNumber17.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GridBagConstraints gbc_tglbtnNumber17 = new GridBagConstraints();
		gbc_tglbtnNumber17.fill = GridBagConstraints.BOTH;
		gbc_tglbtnNumber17.insets = new Insets(0, 0, 5, 5);
		gbc_tglbtnNumber17.gridx = 1;
		gbc_tglbtnNumber17.gridy = 4;
		contentPane.add(tglbtnNumber17, gbc_tglbtnNumber17);
		tglbtnNumber17.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				untoggleButtons(17);					// Call the method to untoggle all other buttons...
		    	tglbtnNumber17.setSelected(true);		// ...and then toggle this button on.
				
			} // End actionPerformed method for tglbtnNumber17
		});
		
		tglbtnNumber18.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GridBagConstraints gbc_tglbtnNumber18 = new GridBagConstraints();
		gbc_tglbtnNumber18.fill = GridBagConstraints.BOTH;
		gbc_tglbtnNumber18.insets = new Insets(0, 0, 5, 5);
		gbc_tglbtnNumber18.gridx = 2;
		gbc_tglbtnNumber18.gridy = 4;
		contentPane.add(tglbtnNumber18, gbc_tglbtnNumber18);
		tglbtnNumber18.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				untoggleButtons(18);					// Call the method to untoggle all other buttons...
		    	tglbtnNumber18.setSelected(true);		// ...and then toggle this button on.
				
			} // End actionPerformed method for tglbtnNumber18
		});
		
		tglbtnNumber19.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GridBagConstraints gbc_tglbtnNumber19 = new GridBagConstraints();
		gbc_tglbtnNumber19.fill = GridBagConstraints.BOTH;
		gbc_tglbtnNumber19.insets = new Insets(0, 0, 5, 5);
		gbc_tglbtnNumber19.gridx = 3;
		gbc_tglbtnNumber19.gridy = 4;
		contentPane.add(tglbtnNumber19, gbc_tglbtnNumber19);
		tglbtnNumber19.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				untoggleButtons(19);					// Call the method to untoggle all other buttons...
		    	tglbtnNumber19.setSelected(true);		// ...and then toggle this button on.
				
			} // End actionPerformed method for tglbtnNumber19
		});
		
		tglbtnNumber20.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GridBagConstraints gbc_tglbtnNumber20 = new GridBagConstraints();
		gbc_tglbtnNumber20.fill = GridBagConstraints.BOTH;
		gbc_tglbtnNumber20.insets = new Insets(0, 0, 5, 5);
		gbc_tglbtnNumber20.gridx = 4;
		gbc_tglbtnNumber20.gridy = 4;
		contentPane.add(tglbtnNumber20, gbc_tglbtnNumber20);
		tglbtnNumber20.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				untoggleButtons(20);					// Call the method to untoggle all other buttons...
		    	tglbtnNumber20.setSelected(true);		// ...and then toggle this button on.
				
			} // End actionPerformed method for tglbtnNumber20
		});
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				guess = getGuessNumber();	// Assign the selected guess button's number to the guess class variable
				
				// TODO: Delete the test output below
				System.out.println(guess); // Test output - print the number to the console
				
				// if (guess != 0)
					// TODO: Complete the if statement above and close the GUI_GuessWindow below
					
				
				
			} // End actionPerformed on Submit button method
		});
		btnSubmit.setFont(new Font("Tahoma", Font.PLAIN, 12));
		GridBagConstraints gbc_btnSubmit = new GridBagConstraints();
		gbc_btnSubmit.gridwidth = 3;
		gbc_btnSubmit.insets = new Insets(0, 0, 0, 5);
		gbc_btnSubmit.gridx = 1;
		gbc_btnSubmit.gridy = 6;
		contentPane.add(btnSubmit, gbc_btnSubmit);
		
	} // End GUI_GuessWindow method

	// This method will unlock all buttons on the form.
	// This method may not be useful, it depends on if the lock
	// state of the buttons persists through instances.
	public static void unlockButtons() {
		
		tglbtnNumber1.setEnabled(true);
		tglbtnNumber2.setEnabled(true);
		tglbtnNumber3.setEnabled(true);
		tglbtnNumber4.setEnabled(true);
		tglbtnNumber5.setEnabled(true);
		tglbtnNumber6.setEnabled(true);
		tglbtnNumber7.setEnabled(true);
		tglbtnNumber8.setEnabled(true);
		tglbtnNumber9.setEnabled(true);
		tglbtnNumber10.setEnabled(true);
		tglbtnNumber11.setEnabled(true);
		tglbtnNumber12.setEnabled(true);
		tglbtnNumber13.setEnabled(true);
		tglbtnNumber14.setEnabled(true);
		tglbtnNumber15.setEnabled(true);
		tglbtnNumber16.setEnabled(true);
		tglbtnNumber17.setEnabled(true);
		tglbtnNumber18.setEnabled(true);
		tglbtnNumber19.setEnabled(true);
		tglbtnNumber20.setEnabled(true);

	} // End unlockButtons method
	
	// This method will lock buttons that are already guessed/invalid.
	// It requires a parameter of an array of integers that represent
	// which buttons are to be disabled from selection.
    public static void lockButtons(int[] arr) {
    	
    	for (int i = 0; i < arr.length; i++) {
    		
    		System.out.println(arr[i]);
    		
    		switch (arr[i]) {
				case 1: 
					tglbtnNumber1.setEnabled(false);
					break;
				case 2: 
					tglbtnNumber2.setEnabled(false);
					break;
				case 3: 
					tglbtnNumber3.setEnabled(false);
					break;
				case 4: 
					tglbtnNumber4.setEnabled(false);
					break;
				case 5: 
					tglbtnNumber5.setEnabled(false);
					break;
				case 6: 
					tglbtnNumber6.setEnabled(false);
					break;
				case 7: 
					tglbtnNumber7.setEnabled(false);
					break;
				case 8: 
					tglbtnNumber8.setEnabled(false);
					break;
				case 9: 
					tglbtnNumber9.setEnabled(false);
					break;
				case 10: 
					tglbtnNumber10.setEnabled(false);
					break;
				case 11: 
					tglbtnNumber11.setEnabled(false);
					break;
				case 12: 
					tglbtnNumber12.setEnabled(false);
					break;
				case 13: 
					tglbtnNumber13.setEnabled(false);
					break;
				case 14: 
					tglbtnNumber14.setEnabled(false);
					break;
				case 15: 
					tglbtnNumber15.setEnabled(false);
					break;
				case 16: 
					tglbtnNumber16.setEnabled(false);
					break;
				case 17: 
					tglbtnNumber17.setEnabled(false);
					break;
				case 18: 
					tglbtnNumber18.setEnabled(false);
					break;
				case 19: 
					tglbtnNumber19.setEnabled(false);
					break;
				case 20: 
					tglbtnNumber20.setEnabled(false);
					break;
					
    		} // End switch block
    		
    	} // End for loop
				
				
        		
    } // End lockButtons method
	
    // This method will un-toggle all other buttons.
    // The integer parameter is the number of the button that called
    // this method. This button will not be toggled off.
    public static void untoggleButtons(int num) {
    	
    	if (num != 1) tglbtnNumber1.setSelected(false);
    	if (num != 2) tglbtnNumber2.setSelected(false);
    	if (num != 3) tglbtnNumber3.setSelected(false);
    	if (num != 4) tglbtnNumber4.setSelected(false);
    	if (num != 5) tglbtnNumber5.setSelected(false);
    	if (num != 6) tglbtnNumber6.setSelected(false);
    	if (num != 7) tglbtnNumber7.setSelected(false);
    	if (num != 8) tglbtnNumber8.setSelected(false);
    	if (num != 9) tglbtnNumber9.setSelected(false);
    	if (num != 10) tglbtnNumber10.setSelected(false);
    	if (num != 11) tglbtnNumber11.setSelected(false);
    	if (num != 12) tglbtnNumber12.setSelected(false);
    	if (num != 13) tglbtnNumber13.setSelected(false);
    	if (num != 14) tglbtnNumber14.setSelected(false);
    	if (num != 15) tglbtnNumber15.setSelected(false);
    	if (num != 16) tglbtnNumber16.setSelected(false);
    	if (num != 17) tglbtnNumber17.setSelected(false);
    	if (num != 18) tglbtnNumber18.setSelected(false);
    	if (num != 19) tglbtnNumber19.setSelected(false);
    	if (num != 20) tglbtnNumber20.setSelected(false);
    	
    } // End untoggleButtons method
    
	// This method will get the toggled button's integer value to return.
    // If there are no buttons selected, this method will return 0.
	public static int getGuessNumber() {
		
		if (tglbtnNumber1.isSelected() == true) return 1;
		if (tglbtnNumber2.isSelected() == true) return 2;
		if (tglbtnNumber3.isSelected() == true) return 3;
		if (tglbtnNumber4.isSelected() == true) return 4;
		if (tglbtnNumber5.isSelected() == true) return 5;
		if (tglbtnNumber6.isSelected() == true) return 6;
		if (tglbtnNumber7.isSelected() == true) return 7;
		if (tglbtnNumber8.isSelected() == true) return 8;
		if (tglbtnNumber9.isSelected() == true) return 9;
		if (tglbtnNumber10.isSelected() == true) return 10;
		if (tglbtnNumber11.isSelected() == true) return 11;
		if (tglbtnNumber12.isSelected() == true) return 12;
		if (tglbtnNumber13.isSelected() == true) return 13;
		if (tglbtnNumber14.isSelected() == true) return 14;
		if (tglbtnNumber15.isSelected() == true) return 15;
		if (tglbtnNumber16.isSelected() == true) return 16;
		if (tglbtnNumber17.isSelected() == true) return 17;
		if (tglbtnNumber18.isSelected() == true) return 18;
		if (tglbtnNumber19.isSelected() == true) return 19;
		if (tglbtnNumber20.isSelected() == true) return 20;
		
		return 0; // If the method hasn't already returned a value by this point, return 0 
		
	} // End submitGuess method
		
	
} // End GUI_GuessWindow class
