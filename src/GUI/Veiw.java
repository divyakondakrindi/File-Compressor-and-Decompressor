package GUI;

import codeFiles.Compress;
import codeFiles.Decompress;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;


public class Veiw extends JFrame implements ActionListener {
    JButton compress;
    JButton decompress;

    Veiw() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setSize(500, 200);
        compress = new JButton("select to compress");
        compress.addActionListener(this);
        compress.setBounds(20, 100, 200,30);
        decompress = new JButton("select to decompress");
        decompress.addActionListener(this);
        decompress.setBounds(250, 100, 200,30);
        this.add(compress);
        this.add(decompress);
        this.getContentPane().setBackground(Color.BLACK);
        this.setSize(500,200);

    }




    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == compress){
            JFileChooser chooser = new JFileChooser();
            int response = chooser.showSaveDialog(null);
            if(response == JFileChooser.APPROVE_OPTION){
                File file = new File(chooser.getSelectedFile().getAbsolutePath());
                try{
                    Compress.method(file);
                }
                catch (Exception excp){
                    JOptionPane.showMessageDialog(null,excp.toString());
                }
            }
        }
        if(e.getSource() == decompress){
            JFileChooser chooser = new JFileChooser();
            int response = chooser.showSaveDialog(null);
            if(response == JFileChooser.APPROVE_OPTION){
                File file = new File(chooser.getSelectedFile().getAbsolutePath());
                try{
                    Decompress.method(file);
                }
                catch (Exception excp){
                    JOptionPane.showMessageDialog(null,excp.toString());
                }
            }
        }


    }

    public static void main(String[] args) {
        Veiw veiw = new Veiw();
        veiw.setVisible(true);
    }
}
