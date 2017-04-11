import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import java.text.DecimalFormat;
import java.util.Random;
import java.util.Vector;


public class Gui {
    private Hotel hotel = new Hotel();
    private int random_cancel;
    private int roomind;

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
        hotel.addRoom(room1);

    }

    //Block for second room
    {
        Room room2 = new Room();
        room2.setPricePerPerson(15);
        room2.setMaxCapacity(2);
        hotel.addRoom(room2);
    }

    //Block for third room
    {
        RoomTypeA room3 = new RoomTypeA();
        room3.setPricePerDay(10);
        room3.setPricePerPerson(5);
        room3.setMaxCapacity(2);
        hotel.addRoom(room3);
    }

    //Block for forth room
    {
        RoomTypeB room4 = new RoomTypeB();
        room4.setDiscountPerDay(5);
        room4.setPricePerDay(15);
        room4.setPricePerPerson(25);
        room4.setMaxCapacity(4);
        hotel.addRoom(room4);
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


    public Gui() {
        hotel.setHotelName("Hotel");
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
        hotel.setReservations(reservation);
        random_cancel = random.nextInt(4);//Gives a random number between 0 and 3
        JOptionPane.showMessageDialog(null, hotel.getGUIString(), "RESULTS", JOptionPane.INFORMATION_MESSAGE);

        random_cancel = random.nextInt(3);//Gives a random number between 0 and 3
        /**
         * The try-catch block and the two if statements in the next while loop is a workaround
         * Because of static method atomic integer in reservation class each reservation gets a unique id
         * Even if eventually that reservation object is not saved not other Reservation object get same ID
         * If by luck the while loop tried to delete a Reservation with that id(essentially a non existent reservation)
         *a crash will occur.So we prevent that by ordering to delete the reservation with next ID
         */
        if (random_cancel == 2) {
            int resget = random.nextInt(hotel.getReservations().size());
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
        Container frame1ContentPane = frame.getContentPane();
        frame1ContentPane.setLayout(new GridLayout(8, 1));
        {
            JButton randomaction = new JButton();

            randomaction.setText("Next repeat(Program continues)");
            randomaction.addActionListener(new B1EventHandle());
            frame1ContentPane.add(randomaction);
        }
        {
            JButton addAReservation = new JButton();
            addAReservation.setText("Add a reservation");
            addAReservation.addActionListener(new B2EventHandle());
            frame1ContentPane.add(addAReservation);
        }
        {
            JButton cancelAReservation = new JButton();
            cancelAReservation.setText("Cancel a reservation");
            cancelAReservation.addActionListener(new B3EventHandle());
            frame1ContentPane.add(cancelAReservation);
        }
        {
            JButton viewReservations = new JButton();
            viewReservations.setText("View reservations");
            viewReservations.addActionListener(new B4EventHandle());
            frame1ContentPane.add(viewReservations);
        }
        {
            JButton viewRooms = new JButton();
            viewRooms.setText("View rooms");
            viewRooms.addActionListener(new B5EventHandle());
            frame1ContentPane.add(viewRooms);
        }
        {
            JButton viewReservationPlan = new JButton();
            viewReservationPlan.setText("View reservation plan");
            viewReservationPlan.addActionListener(new B6EventHandle());
            frame1ContentPane.add(viewReservationPlan);
        }
        {
            JButton viewIncome = new JButton();
            viewIncome.setText("View income");
            viewIncome.addActionListener(new B7EventHandle());
            frame1ContentPane.add(viewIncome);
        }
        {
            JButton exit = new JButton();
            exit.setText("Exit");
            exit.addActionListener(new B8EventHandle());
            frame1ContentPane.add(exit);
        }
        frame.setSize(540, 430);
        frame.setVisible(true);
        System.out.flush();
    }


    private class B1EventHandle implements ActionListener {
        public void actionPerformed(ActionEvent e) {

            Random random =new Random();
            String fullName = firstNames[random.nextInt(firstNames.length)] + " " + lastNames[random.nextInt(lastNames.length)];
            Reservation res = new Reservation();
            res.setClient(fullName);
            res.setArrival(random.nextInt(30));//Sets random values
            res.setDaysOfStay(random.nextInt((30 - res.getArrival())));
            //App supports only one month so if if DaysofStay+Arrival>30 a crash will occur
            res.setNumberOfPeople(random.nextInt(6));
            hotel.addReservationToFirstRoom(res);
            hotel.setReservations(res);
            JOptionPane.showMessageDialog(null, hotel.getGUIString(), "RESULTS", JOptionPane.INFORMATION_MESSAGE);

            random_cancel = random.nextInt(4);//Gives a random number between 0 and 3
            if (random_cancel == 2) {
                int resget = random.nextInt(hotel.getReservations().size());
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
                reserv.setArrival(arrivDay-1);
                int daysOfStay = Integer.parseInt((JOptionPane.showInputDialog(null, "Insert days of stay", "DAYS OF STAY", JOptionPane.QUESTION_MESSAGE)));
                reserv.setDaysOfStay(daysOfStay);
                int numbPeople = Integer.parseInt((JOptionPane.showInputDialog(null, "Insert number of people", "NUMBER OF PEOPLE", JOptionPane.QUESTION_MESSAGE)));
                reserv.setNumberOfPeople(numbPeople);
                int answer = JOptionPane.showConfirmDialog(null, "Do you want to enter specific room id?", "SPECIFIC ROOM ID", JOptionPane.YES_NO_CANCEL_OPTION);
                if (answer == JOptionPane.YES_OPTION) {
                    int rid = Integer.parseInt((JOptionPane.showInputDialog(null, "Room id", "ROOM ID", JOptionPane.QUESTION_MESSAGE)));
                    hotel.addReservationToRoom(reserv, rid);
                    JOptionPane.showMessageDialog(null, hotel.getGUIString(), "RESULT", JOptionPane.INFORMATION_MESSAGE);


                } else {
                    hotel.addReservationToFirstRoom(reserv);
                    JOptionPane.showMessageDialog(null, hotel.getGUIString(), "RESULT", JOptionPane.INFORMATION_MESSAGE);
                    hotel.setReservations(reserv);
                }
            }catch(NumberFormatException nf){JOptionPane.showMessageDialog(null, "Incorrect input.Please try again ", "ERROR", JOptionPane.ERROR_MESSAGE);}
        }


    }
    private class B3EventHandle implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent cr) {
           try {
                int idToCancel = Integer.parseInt((JOptionPane.showInputDialog(null, "Insert ID of reservation you want to cancel", "ID TO CANCEL", JOptionPane.QUESTION_MESSAGE)));
                hotel.cancelReservation(idToCancel);
           } catch (NumberFormatException nf) {
               JOptionPane.showMessageDialog(null, "Incorrect input.Please try again ", "ERROR", JOptionPane.ERROR_MESSAGE);
            }
            JOptionPane.showMessageDialog(null, hotel.getGUIString(), "RESULT", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private class B4EventHandle implements ActionListener {



        @Override
        public void actionPerformed(ActionEvent b) {

            DefaultTableModel tableModel = new DefaultTableModel(0,3);

            for(Reservation r:hotel.getReservations())
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
    private class B5EventHandle implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent rp) {
            DefaultTableModel model = new DefaultTableModel(0,3);
            DecimalFormat df = new DecimalFormat();
            df.setMaximumFractionDigits(2);
            for(Room r:hotel.getRoom())
            {
                Vector roomVector=new Vector();
                try {
                    roomVector.add(r.getRoomNumber());
                    roomVector.add(df.format(r.occupiedPercentage()));
                    roomVector.add(hotel.incomeCalculate(r.getRoomNumber()));
                    model.addRow(roomVector);
                }catch(NullPointerException e){continue;}

            }
            JFrame frame = new JFrame("ROOMS");
            JPanel panel = new JPanel();
            panel.setLayout(new BorderLayout());

            JTable table = new JTable(model);
            table.getColumnModel().getColumn(0).setHeaderValue("ID");
            table.getColumnModel().getColumn(1).setHeaderValue("FULLNESS");
            table.getColumnModel().getColumn(2).setHeaderValue("INCOME");
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
    private class B6EventHandle implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent rp) {

            DefaultTableModel model = new DefaultTableModel(0,31);
            for(Room ravail:hotel.getRoom()){
                Vector rows=new Vector();

                rows.add(ravail.getRoomNumber());
                for (int k = 0; k < 30; k++) {
                    if (ravail.Availability[k] == null) {
                        rows.add("-");
                    } else {
                        rows.add("*");
                    }

                }

                model.addRow(rows);
            }
            JFrame frames = new JFrame("RESERVATION PLAN");
            frames.setExtendedState(Frame.MAXIMIZED_BOTH);//Sets it to full screen by default
            JPanel panel = new JPanel();
            panel.setLayout(new BorderLayout());
            JTable table = new JTable(model);
            table.getColumnModel().getColumn(0).setHeaderValue("ROOMS");
            for(int i=1;i<31;i++)
            {
                table.getColumnModel().getColumn(i).setHeaderValue(+i);
            }
            table.getTableHeader().repaint();
            JScrollPane scrollPane = new JScrollPane(table);

            panel.add(scrollPane);
            frames.getContentPane().add(panel);

            frames.pack();
            frames.setVisible(true);
            table.setVisible(true);
            scrollPane.setVisible(true);
        }
    }
    private class B7EventHandle implements ActionListener {
        public void actionPerformed(ActionEvent inc) {

            int answer = JOptionPane.showConfirmDialog(null, "Do you want to show income of specific room?", "SPECIFIC ROOM ID", JOptionPane.YES_NO_CANCEL_OPTION);
            if (answer == JOptionPane.YES_OPTION) {
                try {
                    roomind = Integer.parseInt((JOptionPane.showInputDialog(null, "Insert room ID", "ID TO SHOW INCOME", JOptionPane.QUESTION_MESSAGE)));
                } catch (NumberFormatException nf) {
                    JOptionPane.showMessageDialog(null, "Incorrect input.Please try again ", "ERROR", JOptionPane.ERROR_MESSAGE);
                }
                try {
                    JOptionPane.showMessageDialog(null, "Income is " + hotel.incomeCalculate(roomind) + " euros", "INCOME", JOptionPane.INFORMATION_MESSAGE);
                }catch(NullPointerException exc){JOptionPane.showMessageDialog(null, "Room not found.Please try again ", "ERROR", JOptionPane.ERROR_MESSAGE);}
            }
            else{
                JOptionPane.showMessageDialog(null,"Income is " +hotel.incomeCalculate()+ " euros", "INCOME", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }
    private class B8EventHandle implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
                        System.exit(0);
        }
    }
}





