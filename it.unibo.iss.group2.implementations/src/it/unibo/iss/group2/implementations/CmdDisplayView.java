package it.unibo.iss.group2.implementations;

import it.unibo.iss.group2.implementations.measures.Speed;
import it.unibo.iss.group2.interfaces.cmd.ButtonLabels;
import it.unibo.iss.group2.interfaces.measures.ISpeed;
import it.unibo.iss.group2.interfaces.monitor.ISyncMonitor;

import javax.swing.*;
import javax.swing.border.TitledBorder;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Classe utilizzata per gestire la componente SWING relativa al commandDisplay.
 * Il commandDisplay si compone principalmente di due parti:
 * 1) Un header contenente i bottoni necessari per l'interazione con l'utente. Questi comandi sono:
 * 		a) Incrementa velocita del drone
 * 		b) Decrementa velocita del drone
 * 		c) Avvia la missione del drone
 * 		d) Interrompi la missione del drone
 * 		e) Imposta una velocita di crociera al drone ( utilizzando una textArea per l'inserimento 
 * 			manuale della velocita all'utente)
 * 2) Una label contenente il log corrente del comando eseguito.
 * @author Alessandro
 *
 */
public class CmdDisplayView {
	
	private ISyncMonitor syncMonitor;
	
	private final String      name;
	private final JPanel      pnlMain;
	private final JPanel      pnlCommand;
	
	private final JTextField  txfSpeed;
	private final JLabel      lblTitle;
	private final JLabel      lblStatus;
	
	private final JButton     btnDecSpeed;
	private final JButton     btnIncSpeed;
	private final JButton     btnSetSpeed;
	private final JButton     btnStartMission;
	private final JButton     btnStopMission;	
	
	/**
	 * Carica sulla GUI i componenti e imposta la grafica di visualizzazione relativa 
	 * ad ogni componente
	 * @param name
	 */
	public CmdDisplayView(final String name, ISyncMonitor syncMonitor) {
		
		this.syncMonitor = syncMonitor;
		
		this.name = name;
	    this.pnlMain = new JPanel();
	    this.pnlCommand = new JPanel();
	    TitledBorder titled = new TitledBorder("Command Display");
	    this.pnlMain.setBorder(titled);
	    
	    this.txfSpeed = new JFormattedTextField();
	    this.lblTitle = new JLabel();
	    this.lblStatus = new JLabel();
	    
	    this.btnIncSpeed = new JButton();
	    this.btnDecSpeed = new JButton();
	    this.btnSetSpeed = new JButton();
	    this.btnStartMission = new JButton();
	    this.btnStopMission = new JButton();
	    
	    // Imposto la velocita al valore di crociera fornito da specifiche
	 	this.txfSpeed.setText("15");
	 	
	    this.lblTitle.setFont(new Font("Arial", Font.BOLD, 16));
	    this.lblTitle.setText(this.name);
		this.lblStatus.setToolTipText("Commands status");
		this.lblStatus.setFont(new Font("Arial", Font.ITALIC, 12));
		this.lblStatus.setForeground(Color.lightGray);
		this.lblStatus.setText("Command display initialization done.");
	    
	    // BUTTON decSpeed
		this.btnDecSpeed.setToolTipText("Press to decrement the speed of Drone by an amount equal to 21 km/h.");
		this.btnDecSpeed.setText("Dec Speed");
		this.btnDecSpeed.setEnabled(false);
		this.btnDecSpeed.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(final ActionEvent e) {
				onDecSpeed();
			}
		});
		
		// BUTTON incSpeed
		this.btnIncSpeed.setToolTipText("Press to increment the speed of Drone by an amount equal to 21 km/h.");
	    this.btnIncSpeed.setText("Inc Speed");
	    this.btnIncSpeed.setEnabled(false);
	    this.btnIncSpeed.addActionListener(new ActionListener() {
	    	@Override
	    	public void actionPerformed(final ActionEvent e) {
	    		onIncSpeed();
	    	}
    	});
	    
	    // BUTTON setSpeed
		this.btnSetSpeed.setToolTipText("Press to set the initial speed of the drone.");
	    this.btnSetSpeed.setText("Set Speed");
	    this.btnSetSpeed.addActionListener(new ActionListener() {
	    	@Override
	    	public void actionPerformed(final ActionEvent e) {
	    		onSetSpeed(txfSpeed.getText());
	    	}
	    });
	    
	    // BUTTON startMission
		this.btnStartMission.setToolTipText("Press to start the mission.");
	    this.btnStartMission.setText("Start mission");
	    this.btnStartMission.setEnabled(false); 
	    this.btnStartMission.addActionListener(new ActionListener() {
	    	@Override
	    	public void actionPerformed(final ActionEvent e) {
	    		onStartMission();
	    	}
	    });
	    
	    // BUTTON stopMission
		this.btnStopMission.setToolTipText("Press to stop the mission");
		this.btnStopMission.setText("Stop mission");
		
		// Abilito il pulsante solo a seguito di SetSpeed
		this.btnStopMission.setEnabled(false);
		
		this.btnStopMission.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(final ActionEvent e) {
				onStop();
			}
		});
	    
	    this.setPnlCommand();
	    this.setPnlMain();
	   
	}
	
	/**
	 * Metodo utilizzato per impostare il contenitore ROOT
	 */
	public JPanel getPanelMain() {
		return this.pnlMain;
	}

	/**
	 * Metodo utilizzato per interrompere la GUI
	 */
	public void stopDisplay() {
		this.btnSetSpeed.setEnabled(false);
		this.btnStartMission.setEnabled(false);
		this.btnStopMission.setEnabled(false);
		this.btnIncSpeed.setEnabled(false);
		this.btnDecSpeed.setEnabled(false);
		this.lblStatus.setText(String.format("Automatic Stopped"));
	}
	
	/**
	 * Metodo utilizzato per generare una nuova istanza della classe
	 * @param name
	 * @return
	 */
	public static CmdDisplayView istantiate(final String name, ISyncMonitor syncMonitor) {
		return new CmdDisplayView(name, syncMonitor);
	}
    
	/**
	 * Metodo utilizzato per effettuare il set del layout del pannello dei comandi
	 */
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
	                .addComponent(txfSpeed, javax.swing.GroupLayout.Alignment.TRAILING)
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
	            .addComponent(txfSpeed, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
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
	
	/**
	 * Metodo utilizzato per effettuare il set del layout del pannello ROOT
	 */
	protected void setPnlMain() {
		this.getPanelMain().setLayout(new BorderLayout());
	    this.getPanelMain().add(this.pnlCommand, BorderLayout.CENTER);
	    this.getPanelMain().add(this.lblStatus, BorderLayout.PAGE_END);
	}
	
	/**
	 * Metodo invocato alla pressione del pulsante SetSpeed
	 * @param value Il valore di velocita da associare al metodo
	 */
	protected void onSetSpeed(final String value) {
		try {
			double speedValue = Double.parseDouble(value);
			ISpeed speed = new Speed(speedValue);
			
			this.btnStartMission.setEnabled(true);
			
			this.lblStatus.setText(String.format("Command correctly sent."));
			
		} catch (Exception e){
			this.btnStartMission.setEnabled(false);
			
			this.lblStatus.setText("Invalid input speed.");
			this.txfSpeed.setText("15");
		}
	}

	/**
	 *  Metodo invocato alla pressione del pulsante IncSpeed
	 */
	protected void onIncSpeed() {
		this.lblStatus.setText(String.format("Command correctly sent."));
	}

	/**
	 *  Metodo invocato alla pressione del pulsante DecSpeed
	 */
	protected void onDecSpeed() {
		this.lblStatus.setText(String.format("Command correctly sent."));
	}

	/**
	 * Metodo invocato alla pressione del pulsante Start
	 */
	protected void onStartMission() {
		// Abilita i pulsanti di incremento e decremento della velocita
		this.btnStartMission.setEnabled(false);
		this.btnSetSpeed.setEnabled(false);
		
		this.btnStopMission.setEnabled(true);
		this.btnIncSpeed.setEnabled(true);
		this.btnDecSpeed.setEnabled(true);
		
		this.lblStatus.setText(String.format("Mission correctly started."));
	}

	/**
	 * Metodo invocato alla pressione del pulsante Stop
	 */
	protected void onStop() {
		stopDisplay();
	}
}
