import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SchedulingApp {
    private DefaultListModel<String> appointmentListModel = new DefaultListModel<>();
    private JList<String> appointmentList = new JList<>(appointmentListModel);
    private JTextField appointmentField = new JTextField(20);

    public SchedulingApp() {
        JFrame frame = new JFrame("Scheduling Application");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        JButton addButton = new JButton("Add Appointment");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String newAppointment = appointmentField.getText();
                if (!newAppointment.isEmpty()) {
                    appointmentListModel.addElement(newAppointment);
                    appointmentField.setText("");
                }
            }
        });

        JButton removeButton = new JButton("Remove Selected");
        removeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedIndex = appointmentList.getSelectedIndex();
                if (selectedIndex >= 0) {
                    appointmentListModel.remove(selectedIndex);
                }
            }
        });

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(addButton);
        buttonPanel.add(removeButton);

        panel.add(appointmentField, BorderLayout.NORTH);
        panel.add(new JScrollPane(appointmentList), BorderLayout.CENTER);
        panel.add(buttonPanel, BorderLayout.SOUTH);

        frame.add(panel);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new SchedulingApp();
            }
        });
    }
}
