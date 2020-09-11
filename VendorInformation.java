import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.concurrent.Callable;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class VendorInformation extends javax.swing.JFrame {
    private static final long serialVersionUID = 1L;
    private JButton button = new JButton();
    private JLabel label = new JLabel();
    private Callable resetCallback;

	public VendorInformation(Double total, Callable funcReset) {
        super("Vendor Information");

        this.resetCallback = funcReset;

        this.setLayout(new FlowLayout());
        this.setSize(200, 100);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        addLabel(total);
        addButton();
    }

	private void addLabel(Double total) {
        GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;
        c.ipady = 20;
        c.weightx = 0.0;
        c.gridwidth = 1;
        c.gridx = 0;
        c.gridy = 42;
        
        setTotal(total);
        this.add(label, c);
    }

	private void setTotal(Double total) {
        NumberFormat n = NumberFormat.getCurrencyInstance(Locale.UK);
        //String s = n.format(total);
		label.setText("Total Sales = " + n.format(total));
	}
    
    private void addButton() {
        GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;
        c.ipady = 30;
        c.weightx = 0.0;
        c.gridwidth = 1;
        c.gridx = 0;
        c.gridy = 1;

        button.setSize(80, 30);
        button.addActionListener(new ActionListener(){
        
            @Override
            public void actionPerformed(ActionEvent e) {
                try
                {
                    if (resetCallback != null )
                        resetCallback.call();
                }
                catch(Exception ex)
                {}
            }
        });

        button.setText("Reset Stock");
        this.add(button, c);
	}
}