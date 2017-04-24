package com.Sam;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.LinkedList;

/**
 * Created by samagbeh on 3/29/17.
 */
public class SupportTicketGUI extends JFrame {

    LinkedList<Ticket> ticketQueue = new LinkedList<Ticket>();
    LinkedList<Ticket> resolvedTickets = new LinkedList<Ticket>();

    private JMenuBar menuBar;
    private JPanel menuPanel;
    private JPanel rootPanel;
    private JList<Ticket> TicketJList;
    private JTextField topTextField;
    private JTextField middleTextField;
    private JTextField bottomTextField;
    private JLabel topLabel;
    private JLabel middleLabel;
    private JLabel bottomLabel;
    private JButton optionButton;
    private JButton allTickets;
    private JButton searchButton;
    private JButton showAllResolvedTicketsButton;

    DefaultListModel<Ticket> TicketListModel;

    static Boolean addOrDelete = false;

    public SupportTicketGUI() {



        super("Support Ticket System");
        setContentPane(rootPanel);
        configureMenus();
        pack();
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        optionButton.setVisible(false);
        topTextField.setVisible(false);
        middleTextField.setVisible(false);
        bottomTextField.setVisible(false);
        topLabel.setVisible(false);
        middleLabel.setVisible(false);
        bottomLabel.setVisible(false);
        searchButton.setVisible(false);

    }

    private void configureMenus() {


        menuBar = new JMenuBar();
        JMenu menu = new JMenu("Options");
        JMenuItem enterTicket = new JMenuItem("Enter Ticket");
        JMenuItem deleteTicket = new JMenuItem("Delete a Ticket");
        JMenuItem searchTicket = new JMenuItem("Search Open Tickets");
        JMenuItem quit = new JMenuItem("Quit");


        TicketListModel = new DefaultListModel<>();
        TicketJList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        TicketJList.setModel(TicketListModel);


        menuPanel.add(menuBar, BorderLayout.WEST);

        enterTicket.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                addOrDelete = true;

                optionButton.setVisible(true);
                topTextField.setVisible(true);
                middleTextField.setVisible(true);
                bottomTextField.setVisible(true);
                topLabel.setVisible(true);
                middleLabel.setVisible(true);
                bottomLabel.setVisible(true);
                searchButton.setVisible(false);


                topLabel.setText("Enter a description of the issue:");
                middleLabel.setText("Who reported the issue?");
                bottomLabel.setText("What is the priority of this ticket?");
                optionButton.setText("Add ticket");


            }
        });

        deleteTicket.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                addOrDelete = false;

                optionButton.setVisible(true);
                topTextField.setVisible(false);
                middleTextField.setVisible(true);
                bottomTextField.setVisible(true);
                topLabel.setVisible(false);
                middleLabel.setVisible(true);
                bottomLabel.setVisible(true);
                searchButton.setVisible(true);


                middleLabel.setText("Search open tickets by issue: ");
                bottomLabel.setText("How was the issue resolved? ");
                optionButton.setText("Delete ticket");

            }
        });


        searchTicket.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                optionButton.setVisible(false);
                topTextField.setVisible(false);
                middleTextField.setVisible(true);
                bottomTextField.setVisible(false);
                topLabel.setVisible(false);
                middleLabel.setVisible(true);
                bottomLabel.setVisible(false);
                searchButton.setVisible(true);

                middleLabel.setText("Search open tickets by issue: ");

            }
        });


        quit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        optionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (addOrDelete == true) {

                    Date dateReported = new Date(); //Default constructor creates Date with current date/time
                    Date resDate = null;
                    String fix = null;

                    String problem = topTextField.getText();
                    String reporter = middleTextField.getText();
                    int priority = Integer.parseInt(bottomTextField.getText());


                    Ticket t = new Ticket(problem, priority, reporter, dateReported, resDate, fix);
                    //ticketQueue.add(t);
                    TicketListModel.addElement(t);

                    ticketQueue.add(t);

                } else {


                    Ticket toDelete = TicketJList.getSelectedValue();
                    String resolution;


                        resolution = bottomTextField.getText();
                        if (resolution.equals("")) {
                            JOptionPane.showMessageDialog(SupportTicketGUI.this, "Enter a resolution for the issue");
                            return;
                        }


                    TicketListModel.removeElement(toDelete);
                    ticketQueue.remove(toDelete);
                    Date resDate = new Date();
                    toDelete.setResDate(resDate);
                    toDelete.setFix(resolution);
                    resolvedTickets.add(toDelete);

                }

            }
        });

        allTickets.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TicketListModel.clear();

                for (Ticket ticket : ticketQueue) {
                    TicketListModel.addElement(ticket);
                }

            }
        });

        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ticketSearch();

            }
        });

        showAllResolvedTicketsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TicketListModel.clear();

                for (Ticket ticket : resolvedTickets) {
                    TicketListModel.addElement(ticket);
                }

            }
        });

        menu.add(enterTicket);
        menu.add(deleteTicket);
        menu.add(searchTicket);
        menu.add(quit);
        menuBar.add(menu);

    }

    public void ticketSearch() {

        String ticketDescrip = middleTextField.getText();


        LinkedList<Ticket> searchTicketList = new LinkedList<Ticket>();


        TicketListModel.clear();

        for (Ticket ticket : ticketQueue) {
            if (ticket.getDescription().contains(ticketDescrip)) {
                searchTicketList.add(ticket);

            }

        }

        for (Ticket t : searchTicketList) {
            TicketListModel.addElement(t);

        }

    }

}