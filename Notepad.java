import java.awt.Font;
import java.awt.Color;
// allows us to use JFrame,JMenuBar, JMenu,JMenuItem,JTextArea
import javax.swing.*;
// allows us to import ActionListener
import java.awt.event.*;
import java.util.Scanner;
import java.io.*;

// inherits the class JFrame
class NotepadFrame extends JFrame implements ActionListener
{
     // creates an instance of TextArea
     JTextArea textArea = new JTextArea();

     public NotepadFrame()
     {
        // sets the initial size of notepad window
        this.setSize(500,300);
        // sets the title of notepad window
        this.setTitle("Notepad");
        // sets exit to be the default  operation when user clicks the cross button
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        JMenuBar menuBar = new JMenuBar();
        JMenu file = new JMenu("File");
        menuBar.add(file);
        // creates a menu
        JMenuItem neww = new JMenuItem("New");
        JMenuItem open = new JMenuItem("Open");
        JMenuItem save = new JMenuItem("Save");
        JMenuItem saveas = new JMenuItem("Save As");
        JMenuItem exit = new JMenuItem("Exit");
        file.add(neww);
        neww.setActionCommand("neww");
        // registers this object as a listener on component neww
        neww.addActionListener(this);
        //separates menu items
        file.addSeparator();
        file.add(open);
        open.setActionCommand("open");
        open.addActionListener(this);
        file.addSeparator();
        file.add(save);
        file.addSeparator();
        file.add(saveas);
        file.addSeparator();
        file.add(exit);
        // sets menuBar as the menubar of our JFrame
        this.setJMenuBar(menuBar);

        this.textArea.setFont(new Font("TimesNewRoman", Font.PLAIN, 12));
        //textArea.setForeground(Color.BLUE);
        this.add(textArea);
     
     }

     public void actionPerformed(ActionEvent ae)
     {
        if(ae.getActionCommand().equals("neww"))
        {
            NotepadFrame n = new NotepadFrame();
            n.setVisible(true);
        }
        else if(ae.getActionCommand().equals("open"))
        {
            NotepadFrame nFrame = new NotepadFrame();
            JFileChooser jfChooser = new JFileChooser();
            int option = jfChooser.showOpenDialog(this);

            if (option == JFileChooser.APPROVE_OPTION)
            {
	            try 
                    {
                       // create a scanner to read the file 
                       // getSelectedFile().getPath() will get the path to the file
	                  Scanner sc = new Scanner(new FileReader(jfChooser.getSelectedFile().getPath()));
	                  while (sc.hasNext()) // while there's still something to read
	                        nFrame.textArea.append(sc.nextLine() + "\n"); // append the line to the TextArea
	            } catch (Exception ex) 
                      { 
                          // catch any exceptions, and write to the debug console
	                    System.out.println(ex.getMessage());
	              }
	    }
            nFrame.setVisible(true);
        }
     }
}

public class Notepad
{
    public static void main(String[] args)
    {
        // creates an instance of NotepadFrame
        NotepadFrame nFrame = new NotepadFrame();
        nFrame.setVisible(true);
    }
}