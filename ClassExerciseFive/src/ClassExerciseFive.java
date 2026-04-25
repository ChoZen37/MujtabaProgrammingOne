// Name: Mujtaba Ghulam
// Date: April 17th 2026
// Description: Class exercise five for creating a graphical user interface and saving files

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;

public class ClassExerciseFive {
    public static void main(String[] arguments) {
        // setting up the main application window
        // jframe is the java class that makes the actual window on your screen
        JFrame applicationWindow = new JFrame("Class Exercise Five");
        applicationWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        applicationWindow.setSize(400, 400);

        // creating a panel to hold all our input boxes and buttons
        // grid layout automatically stacks everything in rows and columns
        JPanel applicationPanel = new JPanel();
        applicationPanel.setLayout(new GridLayout(9, 1));

        // creating text fields for the patient information we need for the project
        JLabel patientNameLabel = new JLabel("Patient Name:");
        JTextField patientNameTextField = new JTextField();

        JLabel ownerNameLabel = new JLabel("Owner Name:");
        JTextField ownerNameTextField = new JTextField();

        JLabel emailAddressLabel = new JLabel("Email Address:");
        JTextField emailAddressTextField = new JTextField();

        // this label will tell us if saving or opening worked
        JLabel statusLabel = new JLabel("Waiting for your action...");

        // creating the two buttons required by the exercise instructions
        JButton saveToFileButton = new JButton("Save To File");
        JButton openFileButton = new JButton("Open File");

        // adding everything to our panel in order from top to bottom
        applicationPanel.add(patientNameLabel);
        applicationPanel.add(patientNameTextField);
        applicationPanel.add(ownerNameLabel);
        applicationPanel.add(ownerNameTextField);
        applicationPanel.add(emailAddressLabel);
        applicationPanel.add(emailAddressTextField);
        applicationPanel.add(saveToFileButton);
        applicationPanel.add(openFileButton);
        applicationPanel.add(statusLabel);

        // attaching the panel to the actual window
        applicationWindow.add(applicationPanel);

        // setting up what happens when you click the save button
        saveToFileButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                // opening a file chooser dialog to pick where to save
                JFileChooser fileChooserObject = new JFileChooser();
                int fileChooserResult = fileChooserObject.showSaveDialog(applicationWindow);

                if (fileChooserResult == JFileChooser.APPROVE_OPTION) {
                    File fileToSave = fileChooserObject.getSelectedFile();
                    try {
                        // writing the text from our text fields into the file
                        PrintWriter fileWriterObject = new PrintWriter(fileToSave);
                        fileWriterObject.println(patientNameTextField.getText());
                        fileWriterObject.println(ownerNameTextField.getText());
                        fileWriterObject.println(emailAddressTextField.getText());
                        fileWriterObject.close();
                        statusLabel.setText("Success: Saved to file successfully.");
                    } catch (Exception exceptionCaught) {
                        statusLabel.setText("Error: Could not save the file.");
                    }
                }
            }
        });

        // setting up what happens when you click the open button
        openFileButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                // opening a file chooser dialog to pick a file to load
                JFileChooser fileChooserObject = new JFileChooser();
                int fileChooserResult = fileChooserObject.showOpenDialog(applicationWindow);

                if (fileChooserResult == JFileChooser.APPROVE_OPTION) {
                    File fileToOpen = fileChooserObject.getSelectedFile();
                    try {
                        // reading the file line by line and putting text back into the text fields
                        Scanner fileReaderObject = new Scanner(fileToOpen);
                        if (fileReaderObject.hasNextLine()) {
                            patientNameTextField.setText(fileReaderObject.nextLine());
                        }
                        if (fileReaderObject.hasNextLine()) {
                            ownerNameTextField.setText(fileReaderObject.nextLine());
                        }
                        if (fileReaderObject.hasNextLine()) {
                            emailAddressTextField.setText(fileReaderObject.nextLine());
                        }
                        fileReaderObject.close();
                        statusLabel.setText("Success: Opened file successfully.");
                    } catch (Exception exceptionCaught) {
                        statusLabel.setText("Error: Could not open the file.");
                    }
                }
            }
        });

        // making the window visible on the screen so we can see it
        applicationWindow.setVisible(true);
    }
}