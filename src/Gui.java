import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import java.util.Random;
import java.util.Vector;


public class Gui {
    private Hotel hotel = new Hotel();
    /**
     * ByteArrayOutputStream baos = new ByteArrayOutputStream();
     * PrintStream ps = new PrintStream(baos);
     * <p>
     * PrintStream old = System.out;
     */
    String clientName;
    int number;
    int arrivalDay;
    int daysToStay;
    int roomiddecider;
    int roomid;
    private int random_cancel;

   // private Random random = new Random();
    int userinput;//Will be used for scanner
    //First names taken from wikipedia's list of most common names in Greece
    private String firstNames[] = {"George", "Giannis", "Konstantinos", "Kostas", "Dimitris", "Nikos", "Panagiotis", "Vasilis",
            "Christos", "Thanasis", "Michalis", "Maria", "Eleni", "Vasiliki", "Sofia", "Aggeliki", "Dimitra", "Kwstantina"};
    //Last names taken from wikipedia's list of most common last names in Greece
    private String lastNames[] = {"Papadopoulos", "Vlachos", "Angelopoulos", "Nikolaidis", "Georgiou", "Athanasiadis",
            "Dimitriadis", "Papadakis", "Panagiotopoulos", "Antoniou", "Papantoniou", "Petridis"};


    //Block for first room
    {
        Room room1 = new Room();
        room1.setPricePerPerson(20);
        room1.setMaxCapacity(4);
        //room1.RoomNumber=2;
        hotel.rooms.add(room1);

    }

    //Block for second room
    {
        Room room2 = new Room();
        room2.setPricePerPerson(15);
        room2.setMaxCapacity(2);
        hotel.rooms.add(room2);
    }

    //Block for third room
    {
        RoomTypeA room3 = new RoomTypeA();
        room3.setPricePerDay(10);
        room3.setPricePerPerson(5);
        room3.setMaxCapacity(2);
        hotel.rooms.add(room3);
    }

    //Block for forth room
    {
        RoomTypeB room4 = new RoomTypeB();
        room4.setDiscountPerDay(5);
        room4.setPricePerDay(15);
        room4.setPricePerPerson(25);
        room4.setMaxCapacity(4);
        hotel.rooms.add(room4);
    }

    //Block for fifth room
    {
        RoomTypeC room5 = new RoomTypeC();
        room5.setMinimumDays(4);
        room5.setMinimumPeople(5);
        room5.setMaxCapacity(6);
        room5.setPricePerPerson(20);
        hotel.addRoom(room5);
    }

    //Block for sixth room
    {
        RoomTypeD room6 = new RoomTypeD();
        room6.setNumberOfChildrenBeds(2);
        room6.setPricePerPerson(14);
        room6.setMaxCapacity(5);
        hotel.addRoom(room6);
    }

    //Block for seventh room
    {
        RoomTypeE room7 = new RoomTypeE();
        room7.setPricePerPerson(19);
        room7.setMaxCapacity(4);
        room7.setCancellationPermittedThreshold(3);
        room7.setCurrentDate(5);
        hotel.addRoom(room7);
    }

    //Block for eighth room
    {
        Room room8 = new Room();
        room8.setPricePerPerson(8);
        room8.setMaxCapacity(2);
        hotel.addRoom(room8);
    }

    //Block for ninth room
    {
        RoomTypeA room9 = new RoomTypeA();
        room9.setPricePerDay(30);
        room9.setPricePerPerson(15);
        room9.setMaxCapacity(2);
        hotel.addRoom(room9);
    }

    //Block for tenth room
    {
        RoomTypeB room10 = new RoomTypeB();
        room10.setDiscountPerDay(3);
        room10.setPricePerPerson(10);
        room10.setPricePerDay(30);
        room10.setMaxCapacity(3);
        hotel.addRoom(room10);
    }

    //private String fullName = firstNames[random.nextInt(firstNames.length)] + " " + lastNames[random.nextInt(lastNames.length)];
    //private Reservation reservation = new Reservation();


    public Gui() {
         Random random = new Random();

        /**
         * Sets UI look to system
         */
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());//Sets ui to system
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }


        String fullName = firstNames[random.nextInt(firstNames.length)] + " " + lastNames[random.nextInt(lastNames.length)];
        Reservation reservation = new Reservation();
        reservation.setClient(fullName);
        reservation.setArrival(random.nextInt(30));//Sets random values
        reservation.setDaysOfStay(random.nextInt((30 - reservation.getArrival())));
        //App supports only one month so if if DaysofStay+Arrival>30 a crash will occur
        reservation.setNumberOfPeople(random.nextInt(6));
        hotel.addReservationToFirstRoom(reservation);
        //hotel.addReservationToRoom(reservation,2);
        hotel.reservations.add(reservation);
        random_cancel = random.nextInt(4);//Gives a random number between 0 and 3
        JOptionPane.showMessageDialog(null, hotel.getGUIString(), "RESULTS", JOptionPane.INFORMATION_MESSAGE);

        random_cancel = random.nextInt(4);//Gives a random number between 0 and 3
        /**
         * The try-catch block and the two if statements in the next while loop is a workaround
         * Because of static method atomic integer in reservation class each reservation gets a unique id
         * Even if eventually that reservation object is not saved not other Reservation object get same ID
         * If by luck the while loop tried to delete a Reservation with that id(essentially a non existent reservation)
         *a crash will occur.So we prevent that by ordering to delete the reservation with next ID
         */
        if (random_cancel == 2) {
            int resget = random.nextInt(hotel.reservations.size());
            try {
                if (hotel.retrieveReservationFromNumber(resget).getRoom() == null) {
                    resget += 1;
                }
            } catch (NullPointerException e) {
                resget += 1;
            }
            hotel.cancelReservation(resget);
            JOptionPane.showMessageDialog(null, hotel.getGUIString(), "RESULTS", JOptionPane.INFORMATION_MESSAGE);

        }


        JFrame frame = new JFrame();

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("HOTEL MANAGEMENT");
        //frame.setSize(500,250);
        //frame.setResizable(true);
        //frame.setLayout(new BoxLayout(frame,BoxLayout.PAGE_AXIS));
        //frame.setLocationRelativeTo(null);//Set location to center
        Container frame1ContentPane = frame.getContentPane();
        frame1ContentPane.setLayout(new GridLayout(8, 1));
        //mainPanel=new JPanel();
        //mainPanel.setSize(500,250);
        // mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.PAGE_AXIS));

        //mainPanel.setVisible(true);
        {
            JButton randomaction = new JButton();

            randomaction.setText("Next repeat(Program continues)");
            //mainPanel.add(randomaction);
            randomaction.addActionListener(new B1EventHandle());
            frame1ContentPane.add(randomaction);
            //randomaction.setVisible(true);
        }
        {
            JButton addAReservation = new JButton();
            addAReservation.setText("Add a reservation");
            addAReservation.addActionListener(new B2EventHandle());
            // mainPanel.add(addAReservation);
            frame1ContentPane.add(addAReservation);
            //double test=Double.parseDouble((JOptionPane.showInputDialog("Test")));
            //addAReservation.addActionListener(b);
        }
        {
            JButton cancelAReservation = new JButton();
            cancelAReservation.setText("Cancel a reservation");
            //mainPanel.add(cancelAReservation);
            frame1ContentPane.add(cancelAReservation);
        }
        {
            JButton viewReservations = new JButton();
            viewReservations.setText("View reservations");
            //mainPanel.add(viewReservations);
            viewReservations.addActionListener(new B4EventHandle());
            frame1ContentPane.add(viewReservations);
        }
        {
            JButton viewRooms = new JButton();
            viewRooms.setText("View rooms");
            //mainPanel.add(viewRooms);
            frame1ContentPane.add(viewRooms);
        }
        {
            JButton viewReservationPlan = new JButton();
            viewReservationPlan.setText("View reservation plan");
            //mainPanel.add(viewReservations);
            frame1ContentPane.add(viewReservationPlan);
        }
        {
            JButton viewIncome = new JButton();
            viewIncome.setText("View income");
            //mainPanel.add(viewIncome);
            frame1ContentPane.add(viewIncome);
        }
        {
            JButton exit = new JButton();
            exit.setText("Exit");
            exit.addActionListener(new B8EventHandle());
            //mainPanel.add(exit);
            frame1ContentPane.add(exit);
        }
        //frame.pack();
        frame.setSize(540, 430);

        //SwingUtilities.updateComponentTreeUI(frame);
        //frame.getContentPane().add(mainPanel);

        //frame1ContentPane.setLayout(new GridLayout(7, 1));
        //frame.pack();
        frame.setVisible(true);
        System.out.flush();
        //System.setOut(old);

    }


    private class B1EventHandle implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            ;
            Random random =new Random();
            String fullName = firstNames[random.nextInt(firstNames.length)] + " " + lastNames[random.nextInt(lastNames.length)];
            Reservation res = new Reservation();
            res.setClient(fullName);
            res.setArrival(random.nextInt(30));//Sets random values
            res.setDaysOfStay(random.nextInt((30 - res.getArrival())));
            //App supports only one month so if if DaysofStay+Arrival>30 a crash will occur
            res.setNumberOfPeople(random.nextInt(6));
            hotel.addReservationToFirstRoom(res);
            //hotel.addReservationToRoom(reservation,2);
            hotel.reservations.add(res);
            JOptionPane.showMessageDialog(null, hotel.getGUIString(), "RESULTS", JOptionPane.INFORMATION_MESSAGE);

            random_cancel = random.nextInt(4);//Gives a random number between 0 and 3
            if (random_cancel == 2) {
                int resget = random.nextInt(hotel.reservations.size());
                try {
                    if (hotel.retrieveReservationFromNumber(resget).getRoom() == null) {
                        resget += 1;
                    }
                } catch (NullPointerException a) {
                    resget += 1;
                }
                hotel.cancelReservation(resget);
                JOptionPane.showMessageDialog(null, hotel.getGUIString(), "RESULTS", JOptionPane.INFORMATION_MESSAGE);

            }
        }
    }

    private class B2EventHandle implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                Reservation reserv = new Reservation();
                String name = JOptionPane.showInputDialog(null, "Insert name", "NAME", JOptionPane.QUESTION_MESSAGE);
                reserv.setClient(name);
                int arrivDay = Integer.parseInt((JOptionPane.showInputDialog(null, "Insert arrival day", "ARRIVAL DAY", JOptionPane.QUESTION_MESSAGE)));
                reserv.setArrival(arrivDay);
                int daysOfStay = Integer.parseInt((JOptionPane.showInputDialog(null, "Insert days of stay", "DAYS OF STAY", JOptionPane.QUESTION_MESSAGE)));
                reserv.setDaysOfStay(daysOfStay);
                int numbPeople = Integer.parseInt((JOptionPane.showInputDialog(null, "Insert number of people", "NUMBER OF PEOPLE", JOptionPane.QUESTION_MESSAGE)));
                reserv.setNumberOfPeople(numbPeople);
                int answer = JOptionPane.showConfirmDialog(null, "Do you want to enter specific room id?", "SPECIFIC ROOM ID", JOptionPane.YES_NO_CANCEL_OPTION);
                if (answer == JOptionPane.YES_OPTION) {
                    int rid = Integer.parseInt((JOptionPane.showInputDialog(null, "Arrival Day", "ARRIVAL DAY", JOptionPane.QUESTION_MESSAGE)));
                    hotel.addReservationToRoom(reserv, rid);
                    JOptionPane.showMessageDialog(null, hotel.getGUIString(), "RESULT", JOptionPane.INFORMATION_MESSAGE);


                } else {
                    hotel.addReservationToFirstRoom(reserv);
                    JOptionPane.showMessageDialog(null, hotel.getGUIString(), "RESULT", JOptionPane.INFORMATION_MESSAGE);
                    hotel.reservations.add(reserv);
                }
            }catch(NumberFormatException nf){JOptionPane.showMessageDialog(null, "Incorrect input.Please try again ", "ERROR", JOptionPane.ERROR_MESSAGE);}
        }


    }

    private class B4EventHandle implements ActionListener {
        int d1;
        String d2;
        int d3;
        Object[] row = {d1, d2, d3};


        @Override
        public void actionPerformed(ActionEvent b) {

            DefaultTableModel tableModel = new DefaultTableModel(0,3);

            for(Reservation r:hotel.reservations)
            {
               Vector row=new Vector();


                        try{
                        row.add(r.getReservationNumber());
                        row.add(r.getClient());
                        row.add(r.getRoom().getRoomNumber());
                        tableModel.addRow(row);
                        }catch(NullPointerException e){continue;}

            }
            JFrame frame = new JFrame("RESERVATIONS");

            JPanel panel = new JPanel();
            panel.setLayout(new BorderLayout());

            JTable table = new JTable(tableModel);
            table.getColumnModel().getColumn(0).setHeaderValue("ID");
            table.getColumnModel().getColumn(1).setHeaderValue("CLIENT");
            table.getColumnModel().getColumn(2).setHeaderValue("ROOM NUMBER");
            table.getTableHeader().repaint();
            JScrollPane scrollPane = new JScrollPane(table);

            panel.add(scrollPane);
            frame.getContentPane().add(panel);

            frame.pack();
            frame.setVisible(true);
            table.setVisible(true);
            scrollPane.setVisible(true);
    }
    }
    private class B8EventHandle implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
                        System.exit(0);
        }
    }
}





