import java.awt.*;  
import java.awt.event.*;  
import javax.swing.*;  
  
class OnlineExam extends JFrame implements ActionListener  
{  
    JLabel label;  
    JRadioButton radioButton[]=new JRadioButton[5];  
    JButton b1,b2;  
    ButtonGroup bg;  
    int count=0,current=0,x=1,y=1,now=0;  
    int m[]=new int[10];      
    OnlineExam(String s)  
    {  
        super(s);  
        label=new JLabel();  
        add(label);  
        bg=new ButtonGroup();  
        for(int i=0;i<5;i++)  
        {  
            radioButton[i]=new JRadioButton();     
            add(radioButton[i]);  
            bg.add(radioButton[i]);  
        }  
        b1=new JButton("Next");  
        b2=new JButton("Revisit");  
        b1.addActionListener(this);  
        b2.addActionListener(this);  
        add(b1);add(b2);  
        set();  
        label.setBounds(30,40,450,20);  
        radioButton[0].setBounds(50,80,100,20);  
        radioButton[1].setBounds(50,110,100,20);  
        radioButton[2].setBounds(50,140,100,20);  
        radioButton[3].setBounds(50,170,100,20);  
        b1.setBounds(100,240,100,30);  
        b2.setBounds(270,240,100,30);  
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
        setLayout(null);  
        setLocation(250,100);  
        setVisible(true);  
        setSize(600,350);  
    }  
    public void actionPerformed(ActionEvent e)  
    {  
        if(e.getSource()==b1)  
        {  
            if(check())  
                count=count+1;  
            current++;  
            set();    
            if(current==9)  
            {  
                b1.setEnabled(false);  
                b2.setText("Result");  
            }  
        }  
        if(e.getActionCommand().equals("Revisit"))  
        {  
            JButton bk=new JButton("Revisit"+x);  
            bk.setBounds(480,20+30*x,100,30);  
            add(bk);  
            bk.addActionListener(this);  
            m[x]=current;  
            x++;  
            current++;  
            set();    
            if(current==9)  
                b2.setText("Result");  
            setVisible(false);  
            setVisible(true);  
        }  
        for(int i=0,y=1;i<x;i++,y++)  
        {  
        if(e.getActionCommand().equals("Revisit"+y))  
        {  
            if(check())  
                count=count+1;  
            now=current;  
            current=m[y];  
            set();  
            ((JButton)e.getSource()).setEnabled(false);  
            current=now;  
        }  
        }  
      
        if(e.getActionCommand().equals("Result"))  
        {  
            if(check())  
                count=count+1;  
            current++;  
            //System.out.println("correct ans="+count);  
            JOptionPane.showMessageDialog(this,"correct ans="+count);  
            System.exit(0);  
        }  
    }  
    void set()  
    {  
        radioButton[4].setSelected(true);  
        if(current==0)  
        {  
            label.setText("1. Which of the following is NOT a valid Java keyword?");  
            radioButton[0].setText("constant");radioButton[1].setText("instanceof");radioButton[2].setText("synchronized");radioButton[3].setText("volatile");   
        }  
        if(current==1)  
        {  
            label.setText("2. Which of the following statements is true about Java's assert keyword?");  
            radioButton[0].setText("It is used to declare a new class");radioButton[1].setText("It is used to define a new method");radioButton[2].setText("It is used to check a condition and throw an exception if the condition is false");radioButton[3].setText("It is used to perform bitwise operations");  
        }  
        if(current==2)  
        {  
            label.setText("3. In Java, which method is invoked when an object is garbage collected?");  
            radioButton[0].setText("finalize()");radioButton[1].setText("clean()");radioButton[2].setText("dispose()");radioButton[3].setText("delete()");  
        }  
        if(current==3)  
        {  
            label.setText("4. What is the purpose of the enum keyword in Java?");  
            radioButton[0].setText(" It is used to define a method");radioButton[1].setText("It is used to define a new class");radioButton[2].setText("It is used to define a constant set of values");radioButton[3].setText(" It is used to define a static block");  
        }  
        if(current==4)  
        {  
            label.setText("5. Which of the following is NOT a valid Java identifier?");  
            radioButton[0].setText("first_name");radioButton[1].setText("2ndPlace");radioButton[2].setText("myVariable");radioButton[3].setText("_$var");  
        }  
        if(current==5)  
        {  
            label.setText("6. Which of the following data structures in Java provides a LIFO (Last In, First Out) mechanism?");  
            radioButton[0].setText("ArrayList");radioButton[1].setText("LinkedList");radioButton[2].setText("Stack");radioButton[3].setText("Queue");  
        }  
        if(current==6)  
        {  
            label.setText("7. In Java, which of the following access modifiers restricts access the most?");  
            radioButton[0].setText("private");radioButton[1].setText("protected");radioButton[2].setText("public");  
                        radioButton[3].setText("default");  
        }  
        if(current==7)  
        {  
            label.setText("8. In Java, which keyword is used to explicitly call the superclass constructor?");  
            radioButton[0].setText("this");radioButton[1].setText("superclass");radioButton[2].setText("extends");  
                        radioButton[3].setText("super");         
        }  
        if(current==8)  
        {  
            label.setText("9. In Java, which of the following is NOT a valid type of loop?");  
            radioButton[0].setText("for loop");radioButton[1].setText("do-while loop");radioButton[2].setText("foreach loop");radioButton[3].setText("while-do loop");  
        }  
        if(current==9)  
        {  
            label.setText("10. What does the finally block in a Java try-catch-finally statement do?");  
            radioButton[0].setText("It is executed if an exception is caught");radioButton[1].setText("It is executed regardless of whether an exception is caught");radioButton[2].setText("It is executed before the try block");  
                        radioButton[3].setText("It is executed after the catch block");  
        }  
        label.setBounds(30,40,600,20);  
        for(int i=0,j=0;i<=90;i+=30,j++)  
            radioButton[j].setBounds(50,80+i,800,20);  
    }  
    boolean check()  
    {  
        if(current==0)  
            return(radioButton[0].isSelected());  
        if(current==1)  
            return(radioButton[2].isSelected());  
        if(current==2)  
            return(radioButton[0].isSelected());  
        if(current==3)  
            return(radioButton[2].isSelected());  
        if(current==4)  
            return(radioButton[1].isSelected());  
        if(current==5)  
            return(radioButton[2].isSelected());  
        if(current==6)  
            return(radioButton[0].isSelected());  
        if(current==7)  
            return(radioButton[3].isSelected());  
        if(current==8)  
            return(radioButton[3].isSelected());  
        if(current==9)  
            return(radioButton[1].isSelected());  
        return false;  
    }  
    public static void main(String s[])  
    {  
        new OnlineExam("Online Examination Of Java");  
    }  
}  
