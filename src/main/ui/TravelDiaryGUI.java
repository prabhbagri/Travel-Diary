package ui;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import model.Flight;
import model.TravelDiary;
import persistence.JsonReader;
import persistence.JsonWriter;

// Represents a GUI with a table and splash screen
public class TravelDiaryGUI extends javax.swing.JFrame {

    private TravelDiary td;
    private JsonWriter jsonWriter;
    private JsonReader jsonReader;

    // constructs a GUI with saving and loading
    public TravelDiaryGUI() {
        this.td = new TravelDiary("My Travel Diary");
        this.jsonWriter = new JsonWriter("./data/MyTravelDiary.json");
        this.jsonReader = new JsonReader("./data/MyTravelDiary.json");
        loadFlights();
        initComponents();
    }

    @SuppressWarnings({"checkstyle:MethodLength", "checkstyle:SuppressWarnings"})
    private void init0() {
        panelFLights = new javax.swing.JPanel();
        jscrollpane1 = new javax.swing.JScrollPane();
        tblFlights = new javax.swing.JTable();
        btnAddFlight = new javax.swing.JButton();
        btnLoadFlight = new javax.swing.JButton();
        btnSaveFlight = new javax.swing.JButton();
        btnRemove = new javax.swing.JButton();
        btnClose = new javax.swing.JButton();
        panelFlight = new javax.swing.JPanel();
        jlabel1 = new javax.swing.JLabel();
        jlabel2 = new javax.swing.JLabel();
        jlabel3 = new javax.swing.JLabel();
        jlabel4 = new javax.swing.JLabel();
        jlabel5 = new javax.swing.JLabel();
        jlabel6 = new javax.swing.JLabel();
        txtFlightNum = new javax.swing.JTextField();
        txtAirline = new javax.swing.JTextField();
        txtDestination = new javax.swing.JTextField();
        txtDuration = new javax.swing.JTextField();
        txtDepartureDate = new javax.swing.JTextField();
        txtDepartureTime = new javax.swing.JTextField();
        btnAdd = new javax.swing.JButton();
        lblMsg = new javax.swing.JLabel();
        jscrollpane2 = new javax.swing.JScrollPane();
        panelFlightLayout = new javax.swing.GroupLayout(panelFlight);
        panelFlight.setLayout(panelFlightLayout);
        tblModel = new DefaultTableModel();
    }

    // EFFECTS: initializes control components
    private void init1() {
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("My Travel Diary");
        setResizable(false);
        panelFLights.setBorder(javax.swing.BorderFactory.createTitledBorder("Current Flights"));

        tblFlights.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{}, new String[]{"Flight Num", "Airline", "Destination"}
        ) {
            boolean[] canEdit = new boolean[]{false, false, false,};

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        });
        jscrollpane1.setViewportView(tblFlights);

    }

    // EFFECTS: initializes control components
    private void init11() {
        btnAddFlight.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnAddFlight.setText("Add Flight");
        btnAddFlight.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddFlightActionPerformed(evt);
            }
        });

        btnLoadFlight.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnLoadFlight.setText("Load");
        btnLoadFlight.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoadFlightsActionPerformed(evt);
            }
        });

        btnSaveFlight.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnSaveFlight.setText("Save");
        btnSaveFlight.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveFlightsActionPerformed(evt);
            }
        });
    }

    // EFFECTS: initializes control components
    private void init12() {

        btnClose.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnClose.setText("Close");
        btnClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCloseActionPerformed(evt);
            }
        });

        btnRemove.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnRemove.setText("Remove");
        btnRemove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoveActionPerformed(evt);
            }
        });
    }


    // EFFECTS: initializes control components
    private void init2() {
        panelFlightsLayout = new javax.swing.GroupLayout(panelFLights);
        panelFLights.setLayout(panelFlightsLayout);
        panelFlightsLayout.setHorizontalGroup(
                panelFlightsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(panelFlightsLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(panelFlightsLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(panelFlightsLayout.createSequentialGroup()
                                                .addComponent(btnLoadFlight, -2, 101, -2)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(btnAddFlight, -2, 103, -2)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(btnSaveFlight, -2, 97, -2)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(btnClose, -2, 95, -2)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(btnRemove, -2, 95, -2)
                                                .addGap(0, 0, Short.MAX_VALUE))
                                        .addComponent(jscrollpane1, -1, 752, Short.MAX_VALUE))
                                .addContainerGap())
        );
    }

    // EFFECTS: initializes control components
    private void init3() {
        panelFlightsLayout.setVerticalGroup(
                panelFlightsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(panelFlightsLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jscrollpane1, -2, 118, -2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(panelFlightsLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(panelFlightsLayout.createSequentialGroup()
                                                .addGroup(panelFlightsLayout
                                                        .createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                                        .addComponent(btnLoadFlight, GroupLayout.Alignment.LEADING,
                                                                -1, 42, 32767)
                                                        .addComponent(btnSaveFlight, GroupLayout.Alignment.LEADING,
                                                                -2, 41, -2)
                                                        .addComponent(btnClose, GroupLayout.Alignment.LEADING,
                                                                -2, 40, -2)
                                                        .addComponent(btnRemove, GroupLayout.Alignment.LEADING,
                                                                -2, 40, -2))
                                                .addContainerGap(22, Short.MAX_VALUE))
                                        .addGroup(panelFlightsLayout.createSequentialGroup()
                                                .addComponent(btnAddFlight, -2, 41, -2)
                                                .addGap(0, 0, Short.MAX_VALUE))))
        );
    }

    // EFFECTS: initializes control components
    @SuppressWarnings({"checkstyle:MethodLength", "checkstyle:SuppressWarnings"})
    private void init4() {
        panelFlight.setBorder(javax.swing.BorderFactory.createTitledBorder("Add")); //change

        jlabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jlabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jlabel1.setText("Flight Num:");

        jlabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jlabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jlabel2.setText("Airline:");

        jlabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jlabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jlabel3.setText("Destination:");

        txtFlightNum.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtFlightNum.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTitleActionPerformed(evt);
            }
        });

    }

    // EFFECTS: initializes control components
    private void init41() {
        txtAirline.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
//        txtAirline.addKeyListener(new java.awt.event.KeyAdapter() {
//            public void keyPressed(java.awt.event.KeyEvent evt) {
//                txtRatingKeyPressed(evt);
//            }
//        });

        btnAdd.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnAdd.setText("Add");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        //  lblMsg.setText("Message");

        txtDestination.setColumns(20);
        jscrollpane2.setViewportView(txtDestination);
    }

    // EFFECTS: initializes control components
    private void init5() {
        panelFlightLayout.setHorizontalGroup(panelFlightLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(panelFlightLayout.createSequentialGroup()
                        .addGroup(panelFlightLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addGroup(panelFlightLayout.createSequentialGroup()
                                        .addGap(28, 28, 28).addGroup(panelFlightLayout
                                                .createParallelGroup(GroupLayout.Alignment.TRAILING)
                                                .addComponent(jlabel2, -2, 83, -2)
                                                .addComponent(jlabel1, -2, 101, -2))
                                        .addGap(18, 18, 18).addGroup(panelFlightLayout
                                                .createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                .addComponent(txtFlightNum)
                                                .addComponent(jscrollpane2, -1, 333, 32767)))
                                .addGroup(panelFlightLayout.createSequentialGroup()
                                        .addGap(82, 82, 82).addComponent(jlabel3)
                                        .addGap(18, 18, 18)
                                        .addGroup(panelFlightLayout
                                                .createParallelGroup(GroupLayout.Alignment.LEADING)
                                                .addGroup(panelFlightLayout.createSequentialGroup()
                                                        .addComponent(txtAirline, -2, 59, -2)
                                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(lblMsg))
                                                .addComponent(btnAdd, -2, 87, -2))))
                        .addContainerGap(-1, 32767)));
    }

    // EFFECTS: initializes control components
    private void init6() {
        panelFlightLayout.setVerticalGroup(
                panelFlightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(panelFlightLayout.createSequentialGroup().addContainerGap()
                                .addGroup(panelFlightLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jlabel1, -2, 33, -2)
                                        .addGroup(panelFlightLayout.createSequentialGroup().addGap(7, 7, 7)
                                                .addComponent(txtFlightNum, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                        31, Short.MAX_VALUE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(panelFlightLayout.createParallelGroup(javax.swing.GroupLayout
                                                .Alignment.LEADING)
                                        .addComponent(jlabel2, -2, 22, -2)
                                        .addComponent(jscrollpane2, -2, -1, -2))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, Short.MAX_VALUE)
                                .addGroup(panelFlightLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jlabel3).addComponent(txtAirline, -2, 32, -2)
                                        .addComponent(lblMsg))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnAdd, -2, 36, -2).addContainerGap()));
    }

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());

    // EFFECTS: initializes control components
    private void init7() {
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(panelFLights, -1, -1, Short.MAX_VALUE)
                                        .addComponent(panelFlight, -1, -1, Short.MAX_VALUE)))
        );
    }

    // EFFECTS: initializes control components
    private void init8() {
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(panelFLights, -2, javax.swing.GroupLayout.DEFAULT_SIZE, -2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(panelFlight, javax.swing.GroupLayout.DEFAULT_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(17, 17, 17))
        );
    }

    // EFFECTS: initializes control components
    private void initComponents() {
        init0();
        init1();
        init11();
        init12();
        init2();
        init3();
        init4();
        init41();
        init5();
        init6();
        init7();
        init8();
        pack();
        tblModel = (DefaultTableModel) tblFlights.getModel();
    }

    // EFFECTS: click event for "add show" button
    private void btnAddFlightActionPerformed(java.awt.event.ActionEvent evt) {
        panelFlight.setVisible(true);
    }

    // EFFECTS: action event for text title
    private void txtTitleActionPerformed(java.awt.event.ActionEvent evt) {
    }

//    // EFFECTS: adds show to user's list table
//    private void addFlight(String flightNum, String airline, String destination) {
//        //int size = this.td.getSize();
//        //BroadwayShow show = this.td.getIndex(--size);
//        //lastId = show.getId();
//        this.td.addFlight(new Flight(flightNum, airline, destination));
//    }

    // EFFECTS: action event for button "add", prompting row added to table
    @SuppressWarnings({"checkstyle:MethodLength", "checkstyle:SuppressWarnings"})
    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {
        String flightNum = txtFlightNum.getText();
        String destination = txtAirline.getText();
        String airline = txtDestination.getText();
        if (flightNum.equals("") || airline.equals("") || destination.equals("")) {
            JOptionPane.showMessageDialog(this, "Please enter all data");
        } else {
            if (alreadyExist(flightNum)) {
                JOptionPane.showMessageDialog(this,
                        "Duplicate flight num, please enter a unique one");
            } else {
                String dd = "August 31";
                String dt = "1:00 PM";

                td.addFlight(new Flight(flightNum, airline, destination, 1, dd, dt));
                String[] data = {flightNum, airline, destination};
                DefaultTableModel tblModel = (DefaultTableModel) tblFlights.getModel();
                tblModel.addRow(data);
                JOptionPane.showMessageDialog(this, "Flight added successfully");
                txtFlightNum.setText("");
                txtAirline.setText("");
                txtDestination.setText("");
                txtDuration.setText("");
                txtDepartureDate.setText("");
                txtDepartureTime.setText("");
            }
        }

    }

    // EFFECTS: load flights from file
    private void loadFlights() {
        try {
            td = jsonReader.read();
            //System.out.println(this.bsl.getSize());
            if (this.td.getSize() <= 0) {

                System.out.println("No flights in list! Please add a Flight");

            } else {
                this.jsonReader = new JsonReader("./data/MyTravelDiary.json");
                this.td = this.jsonReader.read();
                System.out.println("Loaded " + this.td.getName() + " from " + "./data/MyTravelDiary.json");
            }
        } catch (IOException e) {
            System.out.println("Unable to read from file: ./data/MyTravelDiary.json");
        }
    }

    // EFFECTS: prints all the flights in list
    private void printFlights() {
        List<Flight> lst = td.getFlights();

        for (Flight t : lst) {
            System.out.println(t.getFlightNum() + "\t" + t.getAirline() + "\t\t\t\t" + t.getDestination());


            String[] data = {t.getFlightNum(), t.getAirline(), t.getDestination()};
            DefaultTableModel tblModel = (DefaultTableModel) tblFlights.getModel();

            tblModel.addRow(data);
        }
    }

    // EFFECTS: action event for "Load" button
    private void btnLoadFlightsActionPerformed(java.awt.event.ActionEvent evt) {
        int size = td.getSize();
        loadFlights();
        printFlights();
        btnLoadFlight.setVisible(false);
        btnAddFlight.setVisible(true);
        btnSaveFlight.setVisible(true);
        btnClose.setVisible(true);
        btnRemove.setVisible(true);
    }

    // MODIFIES: this
    // EFFECTS: saves flights to file
    private void saveFlights() {
        try {
            this.jsonWriter.open();
            this.jsonWriter.write(this.td);
            this.jsonWriter.close();
            JOptionPane.showMessageDialog(this,
                    "Saved " + this.td.getName() + " to " + "./data/MyTravelDiary.json");

        } catch (FileNotFoundException e) {
            System.out.println("Unable to write to file: ./data/MyTravelDiary.json");
        }

    }

    // EFFECTS: action event for "Save" button
    private void btnSaveFlightsActionPerformed(java.awt.event.ActionEvent evt) {
        saveFlights();
    }

    // EFFECTS: action event for "Close" button
    private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {
        td.closeAction();
        System.exit(0);
    }

    private boolean alreadyExist(String flightNum) {
        for (Flight flight : td.getFlights()) {
            if (flight.getFlightNum().toUpperCase().equals(flightNum.toUpperCase())) {
                return true;
            }
        }
        return false;
    }

    // EFFECTS: action event for "Remove" button
    private void btnRemoveActionPerformed(java.awt.event.ActionEvent evt) {
        if (tblFlights.getSelectedRow() != -1) {
            int row = tblFlights.getSelectedRow();
            // remove selected row from the model
            tblModel.removeRow(tblFlights.getSelectedRow());
            td.removeFlightTravelDiary(row);
            JOptionPane.showMessageDialog(null, "Selected row removed successfully");
        }
    }

    // EFFECTS: main function to run and execute ui
    public static void main(String[] args) {
        try {
            new SplashScreen();
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TravelDiaryGUI().setVisible(true);
                panelFlight.setVisible(false);
                btnAddFlight.setVisible(false);
                btnSaveFlight.setVisible(false);
                btnClose.setVisible(false);
                btnRemove.setVisible(false);
            }
        });
    }

    // EFFECTS: declare variables
    private javax.swing.GroupLayout panelFlightsLayout;
    private javax.swing.GroupLayout panelFlightLayout;
    private javax.swing.JButton btnAdd;
    private static javax.swing.JButton btnAddFlight;
    private javax.swing.JButton btnLoadFlight;
    private static javax.swing.JButton btnSaveFlight;
    private static javax.swing.JButton btnClose;
    private static javax.swing.JButton btnRemove;
    private javax.swing.JLabel jlabel1;
    private javax.swing.JLabel jlabel2;
    private javax.swing.JLabel jlabel3;
    private javax.swing.JLabel jlabel4;
    private javax.swing.JLabel jlabel5;
    private javax.swing.JLabel jlabel6;
    private javax.swing.JScrollPane jscrollpane1;
    private javax.swing.JScrollPane jscrollpane2;
    private javax.swing.JLabel lblMsg;
    private static javax.swing.JPanel panelFlight;
    private javax.swing.JPanel panelFLights;
    private javax.swing.JTable tblFlights;
    private javax.swing.JTextField txtFlightNum;
    private javax.swing.JTextField txtAirline;
    private javax.swing.JTextField txtDestination;
    private javax.swing.JTextField txtDuration;
    private javax.swing.JTextField txtDepartureDate;
    private javax.swing.JTextField txtDepartureTime;
    private DefaultTableModel tblModel;
}

