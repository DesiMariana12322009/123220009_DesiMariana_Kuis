import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RentalKendaraan extends JFrame {
    private String selectedVehicleType;
    private String customerName;
    private String phoneNumber;
    private String selectedVehicle;
    private double rentalPrice;
    private int rentalDays;
    private double totalPrice;

    public RentalKendaraan() {
        setTitle("Aplikasi Rental Kendaraan");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null);

        // Frame 1: Pilihan Kendaraan
        JPanel panel1 = new JPanel();
        JButton motorButton = new JButton("Motor");
        JButton mobilButton = new JButton("Mobil");

        motorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                selectedVehicleType = "Motor";
                showDetailFrame();
            }
        });

        mobilButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                selectedVehicleType = "Mobil";
                showDetailFrame();
            }
        });

        panel1.add(motorButton);
        panel1.add(mobilButton);

        add(panel1);
        setVisible(true);
    }

    private void showDetailFrame() {
        // Frame 2/3: Detail Penyewaan
        JFrame detailFrame = new JFrame("Detail Penyewaan");
        detailFrame.setSize(400, 400);
        detailFrame.setLocationRelativeTo(null);

        JPanel panel2 = new JPanel();
        panel2.setLayout(new GridLayout(6, 2));

        JLabel nameLabel = new JLabel("Nama Penyewa:");
        JTextField nameField = new JTextField(20);
        JLabel phoneLabel = new JLabel("Nomor Telepon:");
        JTextField phoneField = new JTextField(20);
        JLabel vehicleLabel = new JLabel("Pilih Jenis Kendaraan:");
        JRadioButton motorRadio = new JRadioButton("Motor (Rp. 60.000/hari)");
        JRadioButton mobilRadio = new JRadioButton("Mobil (Rp. 150.000/hari)");
        JRadioButton busRadio = new JRadioButton("Bus (Rp. 500.000/hari)");
        ButtonGroup vehicleGroup = new ButtonGroup();
        vehicleGroup.add(motorRadio);
        vehicleGroup.add(mobilRadio);
        vehicleGroup.add(busRadio);
        JLabel daysLabel = new JLabel("Jumlah Hari:");
        JTextField daysField = new JTextField(20);
        JButton saveButton = new JButton("Simpan");

        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                customerName = nameField.getText();
                phoneNumber = phoneField.getText();
                if (motorRadio.isSelected()) {
                    selectedVehicle = "Motor";
                    rentalPrice = 60000;
                } else if (mobilRadio.isSelected()) {
                    selectedVehicle = "Mobil";
                    rentalPrice = 150000;
                } else if (busRadio.isSelected()) {
                    selectedVehicle = "Bus";
                    rentalPrice = 500000;
                }
                rentalDays = Integer.parseInt(daysField.getText());
                totalPrice = rentalPrice * rentalDays;
                detailFrame.dispose();
                showTotalFrame();
            }
        });

        panel2.add(nameLabel);
        panel2.add(nameField);
        panel2.add(phoneLabel);
        panel2.add(phoneField);
        panel2.add(vehicleLabel);
        panel2.add(motorRadio);
        panel2.add(new JLabel());
        panel2.add(mobilRadio);
        panel2.add(new JLabel());
        panel2.add(busRadio);
        panel2.add(daysLabel);
        panel2.add(daysField);
        panel2.add(saveButton);

        detailFrame.add(panel2);
        detailFrame.setVisible(true);
    }

    private void showTotalFrame() {
        // Frame 4: Detail dan Total Harga
        JFrame totalFrame = new JFrame("Detail dan Total Harga");
        totalFrame.setSize(500, 400);
        totalFrame.setLocationRelativeTo(null);

        JPanel panel3 = new JPanel();
        panel3.setLayout(new GridLayout(6, 1));

        JLabel nameLabel = new JLabel("Nama Penyewa: " + customerName);
        JLabel phoneLabel = new JLabel("Nomor Telepon: " + phoneNumber);
        JLabel vehicleLabel = new JLabel("Jenis Kendaraan: " + selectedVehicle);
        JLabel daysLabel = new JLabel("Jumlah Hari: " + rentalDays);
        JLabel priceLabel = new JLabel("Harga Sewa per Hari: Rp. " + rentalPrice);
        JLabel totalLabel = new JLabel("Total Harga: Rp. " + totalPrice);
        JButton finishButton = new JButton("Selesai");

        finishButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                totalFrame.dispose();
                System.exit(0);
            }
        });

        panel3.add(nameLabel);
        panel3.add(phoneLabel);
        panel3.add(vehicleLabel);
        panel3.add(daysLabel);
        panel3.add(priceLabel);
        panel3.add(totalLabel);
        panel3.add(finishButton);

        totalFrame.add(panel3);
        totalFrame.setVisible(true);
    }

    public static void main(String[] args) {
        new RentalKendaraan();
    }
}