package simplecalculator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class SimpleCalculator extends JFrame {
    private JTextField num1Field, num2Field;
    private JComboBox<String> operatorBox;
    private JLabel resultLabel;
    
    // Array untuk menyimpan operator
    private final String[] operators = {"+", "-", "*", "/"};
    
    // Koleksi untuk menyimpan riwayat perhitungan
    private ArrayList<String> history = new ArrayList<>();

    public SimpleCalculator() {
        setTitle("Kalkulator Sederhana");
        setSize(300, 250);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridLayout(5, 2));
        
        add(new JLabel("Angka 1: "));
        num1Field = new JTextField();
        add(num1Field);
        
        add(new JLabel("Operator: "));
        operatorBox = new JComboBox<>(operators);
        add(operatorBox);
        
        add(new JLabel("Angka 2: "));
        num2Field = new JTextField();
        add(num2Field);
        
        JButton calculateButton = new JButton("Hitung");
        add(calculateButton);
        
        resultLabel = new JLabel("Hasil: ");
        add(resultLabel);
        
        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calculate();
            }
        });
        
        setVisible(true);
    }
    
    private void calculate() {
        try {
            // Konversi input menjadi angka
            double num1 = Double.parseDouble(num1Field.getText());
            double num2 = Double.parseDouble(num2Field.getText());
            String operator = (String) operatorBox.getSelectedItem();
            double result = 0;
            
            // Menggunakan switch-case dengan operator
            switch (operator) {
                case "+": result = num1 + num2; break;
                case "-": result = num1 - num2; break;
                case "*": result = num1 * num2; break;
                case "/": 
                    if (num2 != 0) result = num1 / num2;
                    else {
                        JOptionPane.showMessageDialog(this, "Tidak bisa dibagi nol!");
                        return;
                    }
                    break;
            }
            
            // Menampilkan hasil
            String historyEntry = num1 + " " + operator + " " + num2 + " = " + result;
            history.add(historyEntry);
            resultLabel.setText("Hasil: " + result);
            
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Masukkan angka yang valid!");
        }
    }
    
    public static void main(String[] args) {
        new SimpleCalculator();
    }
}
