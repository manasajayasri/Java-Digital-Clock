import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;
public class DigitalClock extends JFrame implements ActionListener {
    JFrame frame;
    JLabel label, istLabel, pstLabel;
    JPanel panel;

    DigitalClock() {

        frame = new JFrame();

        label = new JLabel();
        label.setFont(new Font("Helvetica", Font.BOLD, 24));
        label.setForeground(Color.pink);
        label.setOpaque(true);
        label.setBackground(Color.BLACK);

        istLabel = new JLabel();
        istLabel.setFont(new Font("Helvetica", Font.BOLD, 18));
        istLabel.setForeground(Color.pink);
        istLabel.setOpaque(true);
        istLabel.setBackground(Color.BLACK);

        pstLabel = new JLabel();
        pstLabel.setFont(new Font("Helvetica", Font.BOLD, 18));
        pstLabel.setForeground(Color.pink);
        pstLabel.setOpaque(true);
        pstLabel.setBackground(Color.BLACK);

        panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(10, 10, 10, 10);

        panel.add(label, gbc);

        gbc.gridy = 1;
        panel.add(istLabel, gbc);

        gbc.gridy = 2;
        panel.add(pstLabel, gbc);
        panel.setBackground(Color.BLACK);

        frame.setLayout(new BorderLayout());
        frame.add(panel, BorderLayout.CENTER);

        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setSize(900, 1000);
        frame.setTitle("Digital Clock");

        Timer timer = new Timer(1000, this);
        timer.start();

        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() instanceof Timer) {
            updateTime();
        }
    }

    private void updateTime() {
        Date now = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
        String localTime = dateFormat.format(now);

        label.setText("<html>Local Time: " + localTime + "<br><br></html>");

        SimpleDateFormat istFormat = new SimpleDateFormat("HH:mm:ss");
        istFormat.setTimeZone(TimeZone.getTimeZone("Asia/Kolkata"));
        String istTime = istFormat.format(now);
        istLabel.setText("Time in Asia/Kolkata(IST): " + istTime);

        SimpleDateFormat pstFormat = new SimpleDateFormat("HH:mm:ss");
        pstFormat.setTimeZone(TimeZone.getTimeZone("America/Los_Angeles"));
        String pstTime = pstFormat.format(now);
        pstLabel.setText("Time in America/Los_Angeles(PST): " + pstTime);
    }
}
