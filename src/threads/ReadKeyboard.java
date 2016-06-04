package threads;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;

import jobs.CounterJob;

public class ReadKeyboard {
	
	private String jobName, jobName2, jobName3, jobName4;
	//private String jobName5;
	private int initValue, endValue, initValue2, endValue2, initValue3, endValue3, initValue4, endValue4;
	//private int initValue5, endValue5;
	
	public ReadKeyboard() {
		JLabel jobLabel = new JLabel("JOB No.", JLabel.CENTER);
		JLabel initLabel = new JLabel("Initial Value", JLabel.CENTER);
		JLabel endLabel = new JLabel("End Value", JLabel.CENTER);
		
		jobLabel.setFont(new Font("Arial", 1, 12));
		initLabel.setFont(new Font("Arial", 1, 12));
		endLabel.setFont(new Font("Arial", 1, 12));

		JPanel topPanel = new JPanel(new GridLayout(0, 3, 20, 0));

		topPanel.add(jobLabel);
		topPanel.add(initLabel);
		topPanel.add(endLabel);
		
		
		//job1
		JFormattedTextField jobField = new JFormattedTextField(NumberFormat.getIntegerInstance());
		JFormattedTextField initField = new JFormattedTextField(NumberFormat.getIntegerInstance());
		JFormattedTextField endField = new JFormattedTextField(NumberFormat.getIntegerInstance());
	
		JPanel inputPanel = new JPanel(new GridLayout(0, 3, 15, 0));

		inputPanel.add(jobField);
		inputPanel.add(initField);
		inputPanel.add(endField);
		
		/*
		 * Enter number in the input box and press "return" from keyboard, 
		 * then the variable "jobName" will get input text
		 */
		jobField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jobName = "JOB " + jobField.getText();
			}
		});
		
		/*
		 * Enter number in the input box and press "return" from keyboard, 
		 * then the variable "initValue" will get input value
		 */
		initField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Number n1 = (Number)initField.getValue();
				initValue = n1.intValue();
			}
		});
		
		/*
		 * Enter number in the input box and press "return" from keyboard, 
		 * then the variable "endValue" will get input value
		 * After pressing "return" from keyboard, 
		 * we create a new job since we have got all three arguments we need
		 */
		endField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Number n2 = (Number)endField.getValue();
				endValue = n2.intValue();
				new Task(jobName, new CounterJob(initValue, endValue));
			}
		});
		
		
		//job2
		JFormattedTextField jobField2 = new JFormattedTextField(NumberFormat.getIntegerInstance());
		JFormattedTextField initField2 = new JFormattedTextField(NumberFormat.getIntegerInstance());
		JFormattedTextField endField2 = new JFormattedTextField(NumberFormat.getIntegerInstance());
	
		JPanel inputPanel2 = new JPanel(new GridLayout(0, 3, 15, 0));

		inputPanel2.add(jobField2);
		inputPanel2.add(initField2);
		inputPanel2.add(endField2);
		
		jobField2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jobName2 = "JOB " + jobField2.getText();
			}
		});
		
		initField2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Number n1 = (Number)initField2.getValue();
				initValue2 = n1.intValue();
			}
		});
		
		endField2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Number n2 = (Number)endField2.getValue();
				endValue2 = n2.intValue();
				new Task(jobName2, new CounterJob(initValue2, endValue2));
			}
		});
		
		
		//job3
		JFormattedTextField jobField3 = new JFormattedTextField(NumberFormat.getIntegerInstance());
		JFormattedTextField initField3 = new JFormattedTextField(NumberFormat.getIntegerInstance());
		JFormattedTextField endField3 = new JFormattedTextField(NumberFormat.getIntegerInstance());
	
		JPanel inputPanel3 = new JPanel(new GridLayout(0, 3, 15, 0));

		inputPanel3.add(jobField3);
		inputPanel3.add(initField3);
		inputPanel3.add(endField3);
		
		jobField3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jobName3 = "JOB " + jobField3.getText();
			}
		});
		
		initField3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Number n1 = (Number)initField3.getValue();
				initValue3 = n1.intValue();
			}
		});
		
		endField3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Number n2 = (Number)endField3.getValue();
				endValue3 = n2.intValue();
				new Task(jobName3, new CounterJob(initValue3, endValue3));
			}
		});
		
		
		//job4
		JFormattedTextField jobField4 = new JFormattedTextField(NumberFormat.getIntegerInstance());
		JFormattedTextField initField4 = new JFormattedTextField(NumberFormat.getIntegerInstance());
		JFormattedTextField endField4 = new JFormattedTextField(NumberFormat.getIntegerInstance());
	
		JPanel inputPanel4 = new JPanel(new GridLayout(0, 3, 15, 0));

		inputPanel4.add(jobField4);
		inputPanel4.add(initField4);
		inputPanel4.add(endField4);
		
		jobField4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jobName4 = "JOB " + jobField4.getText();
			}
		});
		
		initField4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Number n1 = (Number)initField4.getValue();
				initValue4 = n1.intValue();
			}
		});
		
		endField4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Number n2 = (Number)endField4.getValue();
				endValue4 = n2.intValue();
				new Task(jobName4, new CounterJob(initValue4, endValue4));
			}
		});
		
		
		/*
		//job5
		JFormattedTextField jobField5 = new JFormattedTextField(NumberFormat.getIntegerInstance());
		JFormattedTextField initField5 = new JFormattedTextField(NumberFormat.getIntegerInstance());
		JFormattedTextField endField5 = new JFormattedTextField(NumberFormat.getIntegerInstance());
	
		JPanel inputPanel5 = new JPanel(new GridLayout(0, 3, 15, 0));

		inputPanel5.add(jobField5);
		inputPanel5.add(initField5);
		inputPanel5.add(endField5);
		
		jobField5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jobName5 = "JOB " + jobField5.getText();
			}
		});
		
		initField5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Number n1 = (Number)initField5.getValue();
				initValue5 = n1.intValue();
			}
		});
		
		endField5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Number n2 = (Number)endField5.getValue();
				endValue5 = n2.intValue();
				new Task(jobName5, new CounterJob(initValue5, endValue5));
				//new Task(jobName5, initValue5, endValue5);
			}
		});
		*/
		
		
		JPanel mainPanel = new JPanel(new GridLayout(6, 0, 0, 5));
		mainPanel.add(topPanel);
		
		mainPanel.add(inputPanel);
		mainPanel.add(inputPanel2);
		mainPanel.add(inputPanel3);
		mainPanel.add(inputPanel4);
		//mainPanel.add(inputPanel5);
		
		JFrame window = new JFrame();
		window.setContentPane(mainPanel);
		window.pack();
		window.setTitle("Read Keyboard Input");
		window.setSize(330, 270);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setVisible(true);	
        
	}

}
