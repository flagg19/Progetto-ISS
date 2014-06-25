package it.unibo.iss.group2.implementations;

import it.unibo.iss.group2.implementations.measures.Speed;
import it.unibo.iss.group2.interfaces.measures.ISpeed;
import it.unibo.iss.group2.interfaces.messages.MessageLabels;
import it.unibo.iss.group2.interfaces.monitor.ISyncMonitor;

import javax.swing.*;
import javax.swing.border.TitledBorder;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CmdDisplayView extends JFrame {
	
	private ISyncMonitor syncMonitor;
	
	private final String      name;
	private final JPanel      pnlMain;
	private final JPanel      pnlCommand;
	
	private final JTextField  txtSpeed;
	private final JLabel      lblTitle;
	private final JLabel      lblStatus;
	
	private JButton     btnDecSpeed;
	private JButton     btnIncSpeed;
	private JButton     btnSetSpeed;
	private JButton     btnStartMission;
	private JButton     btnStopMission;	
	
	
	public CmdDisplayView(final String name, ISyncMonitor syncMonitor) {
		
		this.syncMonitor = syncMonitor;
		
		this.name = name;
	    this.pnlMain = new JPanel();
	    this.pnlCommand = new JPanel();
	    TitledBorder titled = new TitledBorder("Command Display");
	    this.pnlMain.setBorder(titled);
	    
	    this.txtSpeed = new JFormattedTextField();
	    this.lblTitle = new JLabel();
	    this.lblStatus = new JLabel();
	    
	    this.btnIncSpeed = new JButton();
	    this.btnDecSpeed = new JButton();
	    this.btnSetSpeed = new JButton();
	    this.btnStartMission = new JButton();
	    this.btnStopMission = new JButton();
	 	
	    this.lblTitle.setFont(new Font("Arial", Font.BOLD, 16));
	    this.lblTitle.setText(this.name);
		this.lblStatus.setToolTipText("Commands status");
		this.lblStatus.setFont(new Font("Arial", Font.ITALIC, 12));
		this.lblStatus.setForeground(Color.lightGray);
		this.lblStatus.setText("Command display initialization done.");
	    
	    // BUTTON decSpeed
		this.btnDecSpeed = addButton("Dec speed", "Decrease drone speed", MessageLabels.DEC_SPEED, true);
		
		// BUTTON incSpeed
		this.btnIncSpeed = addButton("Inc speed", "Increase drone speed", MessageLabels.INC_SPEED, true);
	    
	    // BUTTON setSpeed
		this.btnSetSpeed = addButton("Set speed", "Set drone speed", MessageLabels.SET_SPEED, true);
	    
	    // BUTTON startMission
		this.btnStartMission = addButton("Start mission", "Start drone mission", MessageLabels.START, true);
	    
	    // BUTTON stopMission
		this.btnStopMission = addButton("Stop mission", "Stop drone mission", MessageLabels.STOP, true);
	    
	    this.setPnlCommand();
	    this.setPnlMain();
	  
	    setVisible(true);
	      
	    GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
            .addComponent(this.getPanelMain(), javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(this.getPanelMain(), javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
	}
	
	public JPanel getPanelMain() {
		return this.pnlMain;
	}

	public void stopDisplay() {
		this.btnSetSpeed.setEnabled(false);
		this.btnStartMission.setEnabled(false);
		this.btnStopMission.setEnabled(false);
		this.btnIncSpeed.setEnabled(false);
		this.btnDecSpeed.setEnabled(false);
		this.lblStatus.setText(String.format("Automatic Stopped"));
	}
	
	public static CmdDisplayView instantiate(final String name, ISyncMonitor syncMonitor) {
		return new CmdDisplayView(name, syncMonitor);
	}
    
	protected void setPnlCommand() {
		javax.swing.GroupLayout pnlCommandLayout = new javax.swing.GroupLayout(pnlCommand);
	    pnlCommand.setLayout(pnlCommandLayout);
	    pnlCommandLayout.setHorizontalGroup(
	        pnlCommandLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	        .addGroup(pnlCommandLayout.createSequentialGroup()
	            .addContainerGap()
	            .addGroup(pnlCommandLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                .addComponent(btnIncSpeed, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	                .addComponent(btnDecSpeed, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	                .addComponent(btnStartMission, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	                .addComponent(txtSpeed, javax.swing.GroupLayout.Alignment.TRAILING)
	                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlCommandLayout.createSequentialGroup()
	                    .addGap(0, 0, Short.MAX_VALUE)
	                    .addComponent(btnStopMission, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)))
	            .addContainerGap())
	        .addGroup(pnlCommandLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addGroup(pnlCommandLayout.createSequentialGroup()
	                .addContainerGap()
	                .addComponent(btnSetSpeed, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	                .addContainerGap()))
	    );
	    pnlCommandLayout.setVerticalGroup(
	        pnlCommandLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	        .addGroup(pnlCommandLayout.createSequentialGroup()
	            .addGap(104, 104, 104)
	            .addComponent(txtSpeed, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
	            .addGap(57, 57, 57)
	            .addComponent(btnStartMission, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
	            .addGap(18, 18, 18)
	            .addComponent(btnDecSpeed, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
	            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
	            .addComponent(btnIncSpeed, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
	            .addGap(18, 18, 18)
	            .addComponent(btnStopMission, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
	            .addContainerGap(143, Short.MAX_VALUE))
	        .addGroup(pnlCommandLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addGroup(pnlCommandLayout.createSequentialGroup()
	                .addGap(150, 150, 150)
	                .addComponent(btnSetSpeed, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
	                .addContainerGap(270, Short.MAX_VALUE)))
	    );
	}
	
	protected void setPnlMain() {
		this.getPanelMain().setLayout(new BorderLayout());
	    this.getPanelMain().add(this.pnlCommand, BorderLayout.CENTER);
	    this.getPanelMain().add(this.lblStatus, BorderLayout.PAGE_END);
	}
	
	private JButton addButton(String label, String tooltip, final MessageLabels buttonLabel, boolean enabled) {
		JButton temp = new JButton();
		temp.setToolTipText(tooltip);
		temp.setText(label);
		temp.setEnabled(enabled);
		temp.addActionListener(new ActionListener() {
	    	@Override
	    	public void actionPerformed(final ActionEvent e) {
	    		syncMonitor.release(buttonLabel);
	    	}
	    });
		return temp;
	}
	
	public Speed getSpeed() {
		return new Speed(Double.parseDouble(txtSpeed.getText()));
	}
}
