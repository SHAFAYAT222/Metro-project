package GUI;
import EntityList.*;
import Entity.*;
import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class FoodGUI extends JFrame implements ActionListener {
    private JPanel Food;


    private JTextArea textArea;
    private JTextField deletefoodText;
    private JButton  Food1,Food2,Food3,Food4,Food5,Food6,Food7,Food8,Food9,Food10,PlaceOrder,DelOrder,Back;
    private JLabel   lfood1,lfood2,lFood3,lFood4,lFood5,lFood6,lFood7,lFood8,lFood9,lFood10;

    foodlist foodlist;
    public FoodGUI(foodlist foodlist){
        super("Metro Rail Management System");
        this.setSize(1007,667);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(null);
        this.foodlist=foodlist;

        Food=new JPanel();
        Food.setBounds(0, 0, 1007, 667);
        Food.setLayout(null);


        Food1 = createImageButton("img\\Food\\1.png");
        Food1.setBounds(0,0,200,200);
        Food1.addActionListener(this);
        Food.add(Food1);
        lfood1=new JLabel("Name:Burger,Price:150");
        lfood1.setBounds(0,200,200,20);
        Food.add(lfood1);


        Food2 = createImageButton("img\\Food\\2.png");
        Food2.setBounds(200,0,200,200);
        Food2.addActionListener(this);
        Food.add(Food2);
        lfood2=new JLabel("Name:Sandwich,Price:100");
        lfood2.setBounds(200,200,200,20);
        Food.add(lfood2);

        Food3 = createImageButton("img\\Food\\3.png");
        Food3.setBounds(400,0,200,200);
        Food3.addActionListener(this);
        Food.add(Food3);
        lFood3=new JLabel("Name:Coffee,Price:30");
        lFood3.setBounds(400,200,200,20);
        Food.add(lFood3);

        Food4 = createImageButton("img\\Food\\4.png");
        Food4.setBounds(600,0,200,200);
        Food4.addActionListener(this);
        Food.add(Food4);
        lFood4=new JLabel("Name:Tea,Price:20");
        lFood4.setBounds(600,200,200,20);
        Food.add(lFood4);

        Food5 = createImageButton("img\\Food\\5.png");
        Food5.setBounds(800,0,200,200);
        Food5.addActionListener(this);
        Food.add(Food5);
        lFood5=new JLabel("Name:Water,Price:20");
        lFood5.setBounds(800,200,200,20);
        Food.add(lFood5);

        Food6 = createImageButton("img\\Food\\6.png");
        Food6.setBounds(0,220,200,200);
        Food6.addActionListener(this);
        Food.add(Food6);
        lFood6=new JLabel("Name:Coke,Price:20");
        lFood6.setBounds(0,420,200,20);
        Food.add(lFood6);

        Food7 = createImageButton("img\\Food\\7.png");
        Food7.setBounds(200,220,200,200);
        Food7.addActionListener(this);
        Food.add(Food7);
        lFood7=new JLabel("Name:Brade,Price:60");
        lFood7.setBounds(200,420,200,20);
        Food.add(lFood7);

        Food8 = createImageButton("img\\Food\\8.png");
        Food8.setBounds(400,220,200,200);
        Food8.addActionListener(this);
        Food.add(Food8);
        lFood8=new JLabel("Name:cake,Price:50");
        lFood8.setBounds(400,420,200,20);
        Food.add(lFood8);

        Food9 = createImageButton("img\\Food\\9.png");
        Food9.setBounds(600,220,200,200);
        Food9.addActionListener(this);
        Food.add(Food9);
        lFood9=new JLabel("Name:Biryani,Price:300");
        lFood9.setBounds(600,420,200,20);
        Food.add(lFood9);

        Food10 = createImageButton("img\\Food\\10.png");
        Food10.setBounds(800,220,200,200);
        Food10.addActionListener(this);
        Food.add(Food10);
        lFood10=new JLabel("Name:French-Fries,Price:100");
        lFood10.setBounds(800,420,200,20);
        Food.add(lFood10);

        textArea =new JTextArea();
        textArea.setEditable(false);
        showAllFoodInScreen();
        JScrollPane jsp=new JScrollPane(textArea);
        jsp.setBounds(10,450,500,180);
        super.add(jsp);

        PlaceOrder =new JButton("Place Order");
        PlaceOrder.setForeground(new Color(0, 0, 0));
        PlaceOrder.setBounds(550,480,200,50);
        PlaceOrder.setBackground(new Color(0xFFF14C));
        PlaceOrder.addActionListener(this);
        Food.add(PlaceOrder);

        deletefoodText = new JTextField("");
        deletefoodText.setBounds(760,480,200,30);
        Food.add(deletefoodText);


        DelOrder =new JButton("Delete By Name");
        DelOrder.setForeground(new Color(0, 0, 0));
        DelOrder.setBounds(760,525,170,30);
        DelOrder.setBackground(new Color(0xFFF14C));
        DelOrder.addActionListener(this);
        Food.add(DelOrder);

        Back =new JButton("Back");
        Back.setForeground(new Color(0, 0, 0));
        Back.setBounds(550,550,200,50);
        Back.setBackground(new Color(0xFFF14C));
        Back.addActionListener(this);
        Food.add(Back);

        this.add(Food);
       // this.setVisible(true);
    }
    private static JButton createImageButton(String imagePath) {
        ImageIcon icon = new ImageIcon(imagePath);
        JButton button = new JButton(icon);
        return button;
    }
    public void showAllFoodInScreen(){
        textArea.setText(foodlist.ShowAllFood());
    }
public void actionPerformed(ActionEvent e) {
    String command = e.getActionCommand();

    if (e.getSource() == Food1) {
        foodlist.insert(new food("Burger", 150));
        showAllFoodInScreen();
    } else if (e.getSource() == Food2) {
        foodlist.insert(new food("Sandwich", 100));
        showAllFoodInScreen();
    } else if (e.getSource() == Food3) {
        foodlist.insert(new food("Coffee", 30));
        showAllFoodInScreen();
    } else if (e.getSource() == Food4) {
        foodlist.insert(new food("Tea", 20));
        showAllFoodInScreen();
    } else if (e.getSource() == Food5) {
        foodlist.insert(new food("Water", 20));
        showAllFoodInScreen();
    } else if (e.getSource() == Food6) {
        foodlist.insert(new food("Coke", 20));
        showAllFoodInScreen();
    } else if (e.getSource() == Food7) {
        foodlist.insert(new food("Brade", 60));
        showAllFoodInScreen();
    } else if (e.getSource() == Food8) {
        foodlist.insert(new food("Cake", 50));
        showAllFoodInScreen();
    } else if (e.getSource() == Food9) {
        foodlist.insert(new food("Biryani", 300));
        showAllFoodInScreen();
    } else if (e.getSource() == Food10) {
        foodlist.insert(new food("French-Fries", 100));
        showAllFoodInScreen();
    } else if (e.getSource()==PlaceOrder) {
        foodlist.DeleteAll();
        JOptionPane.showMessageDialog(this,"Order Placed","Thank You",JOptionPane.PLAIN_MESSAGE);
        showAllFoodInScreen();
    } else if (e.getSource()==DelOrder) {
        String name=deletefoodText.getText();
        foodlist.DeleteByName(name);
        showAllFoodInScreen();
    } else if (e.getSource()==Back) {
        this.setVisible(false);
        //your frame add here

    }
}


}
