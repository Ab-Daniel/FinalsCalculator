import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class CalculatorFrame extends JFrame 
{
	
	public CalculatorFrame()
	{
		
		setTitle("Finals Calculator");
		setSize(600,300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		createControlPanel();
		add(displayScore, BorderLayout.SOUTH);
		//pack();
		
	}
	
	
	
	public void createControlPanel()
	{
		
		
		
		JButton calcButton = new JButton("Calculate what you need on the final");
		
		controlPanel.add(currGradeLabel);
		controlPanel.add(currGradeField);
		controlPanel.add(wantGradeLabel);
		controlPanel.add(wantGradeField);
		controlPanel.add(finalWorthLabel);
		controlPanel.add(finalWorthField);
		controlPanel.add(calcButton);
		
		add(controlPanel);
		
		
		class CalcButtonListener implements ActionListener
		{

			public void actionPerformed(ActionEvent arg0) 
			{
				
				currGrade = Double.parseDouble(currGradeField.getText());
				wantGrade = Double.parseDouble(wantGradeField.getText());
				finalWorth = Double.parseDouble(finalWorthField.getText());
				getScore(currGrade, wantGrade, finalWorth);		
				
			}
			
		}
		
		ActionListener listener = new CalcButtonListener();
		calcButton.addActionListener(listener);
		
		//displayScore = new JLabel("You need to get a " + finalTestScore+"%");
		
		
		//add(displayPanel);
		
		
		
		
		
	}
	
	public void getScore(double currentGrade, double wantedGrade, double finalWeight)
	{
		
		finalTestScore = calculateGrade(currentGrade, wantedGrade, finalWeight);
		String scoreMessage = "You need to score a "+finalTestScore+"% to get the desired grade.";
		
		displayScore.setText(scoreMessage);
		displayScore.repaint();
		
	}
	
	public double calculateGrade(double currentGrade, double wantedGrade, double finalWeight)
	{
		
		double x = ((wantedGrade/100) - (currentGrade/100)*(1 - (finalWeight/100))) / (finalWeight/100);
		return Math.round(x * 100.0);
		
	}
	
	private double finalTestScore;
	
	private double currGrade;
	private double wantGrade;
	private double finalWorth;
	
	private JPanel controlPanel = new JPanel();
	private JPanel displayPanel = new JPanel();
	
	private JLabel displayScore = new JLabel();
	
	
	final JLabel currGradeLabel = new JLabel("Your current grade is: %");
	final JTextField currGradeField = new JTextField(10);
	final JLabel wantGradeLabel = new JLabel("You want (at least) a %");
	final JTextField wantGradeField = new JTextField(10);
	final JLabel finalWorthLabel = new JLabel("Your final is worth: %");
	final JTextField finalWorthField = new JTextField(10);
	
}
