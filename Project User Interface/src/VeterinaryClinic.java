// Name: Mujtaba Ghulam
// Date: April 24 2026
// Description: Final project application for the veterinary clinic patient registration

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.ButtonGroup;
import javax.swing.JFileChooser;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.PrintWriter;
import java.util.Date;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class VeterinaryClinic {
    public static void main(String[] arguments) {
        // setting up the application window
        JFrame applicationWindow = new JFrame("Veterinary Clinic Patient Registration");
        applicationWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        applicationWindow.setSize(500, 600);

        JPanel applicationPanel = new JPanel();
        applicationPanel.setLayout(new GridLayout(16, 1));

        // setting up text fields and labels for patient information
        JLabel patientNameLabel = new JLabel("Patient Name:");
        JTextField patientNameTextField = new JTextField();

        JLabel ownerNameLabel = new JLabel("Owner Name:");
        JTextField ownerNameTextField = new JTextField();

        JLabel emailAddressLabel = new JLabel("Email Address:");
        JTextField emailAddressTextField = new JTextField();

        // setting up the radio buttons for the three veterinarians
        JLabel veterinarianLabel = new JLabel("Select Veterinarian:");
        JRadioButton veterinarianOneRadioButton = new JRadioButton("Doctor Mujtaba");
        JRadioButton veterinarianTwoRadioButton = new JRadioButton("Doctor Kyle");
        JRadioButton veterinarianThreeRadioButton = new JRadioButton("Doctor Ken");

        // grouping the radio buttons so only one can be clicked at a time
        ButtonGroup veterinarianButtonGroup = new ButtonGroup();
        veterinarianButtonGroup.add(veterinarianOneRadioButton);
        veterinarianButtonGroup.add(veterinarianTwoRadioButton);
        veterinarianButtonGroup.add(veterinarianThreeRadioButton);

        // setting the first radio button to be checked automatically when it loads
        veterinarianOneRadioButton.setSelected(true);

        // this label is required to display successful writes or error messages
        JLabel messageLabel = new JLabel("Welcome! Please enter new patient information.");

        // setting up the three required buttons to control the form
        JButton registerPatientButton = new JButton("Register New Patient");
        JButton clearFormButton = new JButton("Clear Form");
        JButton exitFormButton = new JButton("Exit Form");

        // adding everything to the main panel
        applicationPanel.add(patientNameLabel);
        applicationPanel.add(patientNameTextField);
        applicationPanel.add(ownerNameLabel);
        applicationPanel.add(ownerNameTextField);
        applicationPanel.add(emailAddressLabel);
        applicationPanel.add(emailAddressTextField);
        applicationPanel.add(veterinarianLabel);
        applicationPanel.add(veterinarianOneRadioButton);
        applicationPanel.add(veterinarianTwoRadioButton);
        applicationPanel.add(veterinarianThreeRadioButton);
        applicationPanel.add(registerPatientButton);
        applicationPanel.add(clearFormButton);
        applicationPanel.add(exitFormButton);
        applicationPanel.add(messageLabel);

        applicationWindow.add(applicationPanel);

        // action for the clear button to reset the entire form
        clearFormButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                patientNameTextField.setText("");
                ownerNameTextField.setText("");
                emailAddressTextField.setText("");
                veterinarianOneRadioButton.setSelected(true);
                messageLabel.setText("Form has been cleared.");
            }
        });

        // action for the exit button to close the application completely
        exitFormButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                System.exit(0);
            }
        });

        // action for the register button that validates input and writes to the file
        registerPatientButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                // storing text field data in string variables
                String patientNameString = patientNameTextField.getText();
                String ownerNameString = ownerNameTextField.getText();
                String emailAddressString = emailAddressTextField.getText();

                // checking if any fields are completely empty
                if (patientNameString.isEmpty()) {
                    messageLabel.setText("Error: Patient name cannot be empty.");
                } else if (ownerNameString.isEmpty()) {
                    messageLabel.setText("Error: Owner name cannot be empty.");
                } else if (emailAddressString.isEmpty()) {
                    messageLabel.setText("Error: Email address cannot be empty.");
                } else {
                    // checking if the email address format is valid using the required pattern
                    String regularExpressionPattern = "^[\\w!#$%&'*+/=?^`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?^`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";
                    Pattern emailPattern = Pattern.compile(regularExpressionPattern);
                    Matcher emailMatcher = emailPattern.matcher(emailAddressString);

                    if (emailMatcher.matches() == false) {
                        messageLabel.setText("Error: The email address is not valid.");
                    } else {
                        // finding out which veterinarian radio button is currently selected
                        String selectedVeterinarianName = "";
                        if (veterinarianOneRadioButton.isSelected()) {
                            selectedVeterinarianName = "Doctor Mujtaba";
                        } else if (veterinarianTwoRadioButton.isSelected()) {
                            selectedVeterinarianName = "Doctor Kyle";
                        } else if (veterinarianThreeRadioButton.isSelected()) {
                            selectedVeterinarianName = "Doctor Ken";
                        }

                        // getting the current date as required
                        Date currentDateObject = new Date();

                        // opening the file chooser so the user can name the file
                        JFileChooser fileChooserObject = new JFileChooser();
                        int fileChooserResult = fileChooserObject.showSaveDialog(applicationWindow);

                        if (fileChooserResult == JFileChooser.APPROVE_OPTION) {
                            File fileToSave = fileChooserObject.getSelectedFile();
                            try {
                                // writing the formatted output to the newly created file
                                PrintWriter fileWriterObject = new PrintWriter(fileToSave);
                                fileWriterObject.println("**Patient Registration Document**");
                                fileWriterObject.println("Patient Name: " + patientNameString);
                                fileWriterObject.println("Owner Name: " + ownerNameString);
                                fileWriterObject.println("Email Address: " + emailAddressString);
                                fileWriterObject.println("Selected Veterinarian: " + selectedVeterinarianName);
                                fileWriterObject.println("Date: " + currentDateObject.toString());
                                fileWriterObject.close();

                                messageLabel.setText("Success: The file was successfully written.");
                            } catch (Exception exceptionCaught) {
                                messageLabel.setText("Error: The file write was not successful.");
                            }
                        }
                    }
                }
            }
        });

        // showing the window
        applicationWindow.setVisible(true);
    }
}