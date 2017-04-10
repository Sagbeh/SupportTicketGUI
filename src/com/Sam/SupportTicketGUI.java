package com.Sam;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by samagbeh on 3/29/17.
 */
public class SupportTicketGUI extends JFrame{

    private JMenuBar menuBar;
    private JPanel menuPanel;
    private JPanel rootPanel;

    protected SupportTicketGUI() {

        super("Support Ticket System");
        setContentPane(rootPanel);
        pack();
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);

        menuBar = new JMenuBar();
        JMenu menu = new JMenu("Options");
        JMenuItem enterTicket = new JMenuItem("Enter Ticket");
        JMenuItem deleteTicketID = new JMenuItem("Delete Ticket by ID");
        JMenuItem deleteTicketIssue = new JMenuItem("Delete Ticket by Issue");
        JMenuItem searchIssue = new JMenuItem("Search by Issue");
        JMenuItem displayAllTickets = new JMenuItem("Display All Tickets");
        JMenuItem quit = new JMenuItem("Quit");
        menu.add(enterTicket);
        menu.add(deleteTicketID);
        menu.add(deleteTicketIssue);
        menu.add(searchIssue);
        menu.add(displayAllTickets);
        menu.add(quit);
        menuBar.add(menu);

        menuPanel.add(menuBar, BorderLayout.WEST);

        enterTicket.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }




}
