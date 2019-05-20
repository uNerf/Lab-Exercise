
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class JubhertNotepad {

    private JFrame f;
    private JPanel panelA;
    private JButton load, save, clear, close;
    private JTextArea textArea;
    private JScrollPane scroll;
    private String fileName = "noname.txt";
    private String content = "";

    //GUI
    public JubhertNotepad() {
        f = new JFrame("Jubhert's Simple Notepad");
        panelA = new JPanel();
    }

    public void components() {
        load = new JButton("Load " + fileName);
        save = new JButton("Save " + fileName);
        clear = new JButton("Clear " + fileName);
        close = new JButton("Close " + fileName);

        textArea = new JTextArea();
        scroll = new JScrollPane(textArea);

        f.setSize(800, 600);
        f.add(scroll, BorderLayout.CENTER);
    }

    public void launchFrame() {
        //Arranging GUI
        f.add(panelA, BorderLayout.PAGE_END);
        panelA.setLayout(new GridLayout(1, 4));
        panelA.add(load);
        panelA.add(save);
        panelA.add(clear);
        panelA.add(close);

        f.setVisible(true);

        //Assigning Event handler
        load.addActionListener(new ButtonHandler());
        save.addActionListener(new ButtonHandler());
        clear.addActionListener(new ButtonHandler());
        close.addActionListener(new ButtonHandler());

        f.addWindowListener(new MyCloseButtonHandler());
    }

    //Event Handler
    private class ButtonHandler implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            Object source = e.getSource();

            if (source == load) {
                content = "";
                try{
                    fileRead();
                }
                catch(Exception ignore){}                
                textArea.setText(content);
            } else if (source == save) {
                try{
                    fileSaver();
                }
                catch(Exception ignore){}
            } else if (source == clear) {
                textArea.setText("");
            } else if (source == close) {
                System.exit(0);
            } else {
            }
        }
    }

    private class MyCloseButtonHandler extends WindowAdapter {
        public void windowClosing(WindowEvent e) {
            System.exit(0);
        }
    }
    
    //Load and Save Method
    public void fileRead() throws IOException {
        File f = new File(fileName);
        BufferedReader br = new BufferedReader(new FileReader(f));
        String str;
        while ((str = br.readLine()) != null) {
            content += str + '\n';
        }
        br.close();
    }
    public void fileSaver() throws IOException {
        File f = new File(fileName);
	PrintWriter output = new PrintWriter(new FileWriter(f));
        output.println(textArea.getText());
	output.close();
    }

    //Main Method
    public static void main(String args[]) throws IOException {
        JubhertNotepad cal = new JubhertNotepad();
        if (args.length == 1) {
            cal.fileName = args[0];
        }
        cal.components();
        cal.launchFrame();
    }
}
