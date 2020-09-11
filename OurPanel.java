import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import java.util.Locale;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import javafx.scene.layout.Border;

public class OurPanel extends javax.swing.JPanel {

    // Initialising JComponents
    private static final long serialVersionUID = 1L;
    private JButton button = new JButton();
    private JLabel label = new JLabel();
    private StockItem item;

    public OurPanel(StockItem item) {
        this.item = item;

        this.setLayout(new GridBagLayout());
        this.addButton(item);
        this.addLabel();
    }

    // Initilise and position the label for our panel
    private void addLabel() {
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.ipady = 20;
        c.weightx = 0.0;
        c.gridwidth = 1;
        c.gridx = 0;
        c.gridy = 42;
        setLabel();
        this.add(label, c);
    }

    // Initilise and position the button for our panel
    private void addButton(StockItem item) {
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.ipady = 30;
        c.weightx = 0.0;
        c.gridwidth = 1;
        c.gridx = 0;
        c.gridy = 1;

        button.setSize(80, 30);
        button.addActionListener(new ActionListener() {

            // Action listener checks the stock (quantity) of an item before 'dispensing' an sweet
            @Override
            public void actionPerformed(ActionEvent e) {
                if (item.getQuantity() == 0) {
                    JOptionPane.showMessageDialog(null, "Oops there are none left");
                } else {
                    item.decrement();
                    setLabel();
                }
            }
        });

        setButton();
        this.add(button, c);
    }

    // Set the label showing remaining stock
    public void setLabel() {
        label.setText(item.getQuantity() + " Left");
    }

    public void setButton() {
        NumberFormat n = NumberFormat.getCurrencyInstance(Locale.UK);
        String s = n.format(item.getPrice());

        button.setText(item.getName() + " (" + s + ")");
    }
}