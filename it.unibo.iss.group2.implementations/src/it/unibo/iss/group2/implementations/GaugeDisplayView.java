package it.unibo.iss.group2.implementations;

import javax.swing.GroupLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import it.unibo.iss.group2.implementations.gauges.Fuelometer;
import it.unibo.iss.group2.implementations.gauges.LocTracker;
import it.unibo.iss.group2.implementations.gauges.Odometer;
import it.unibo.iss.group2.implementations.gauges.Speedometer;
import it.unibo.iss.group2.interfaces.globals.Globals;
import it.unibo.iss.group2.interfaces.measures.IStatus;

import java.awt.*;


public class GaugeDisplayView extends JFrame {

	private final String		name;

	private final Fuelometer  	fuelometer;
	private final Speedometer 	speedometer;
	private final Odometer    	odometer;
	private LocTracker  		locTracker;

	// Root container
	private final JPanel		pnlMain;
	// Panel containing LocTracker
	private final JPanel		pnlGaugeOver;
	// Panel containing Odometer, Speedometer and Fuelometer
	private final JPanel		pnlGaugeUnder;
	
	private final JLabel		lblTitle;
	private final JLabel		lblStatus;  

	
	protected GaugeDisplayView(final String name) {
		this.name = name;
		this.fuelometer = Fuelometer.istantiate("Fuelometer", "l", Globals.MIN_FUEL, Globals.MAX_FUEL);
		this.speedometer = Speedometer.istantiate("Speedometer", "km/h", Globals.MIN_SPEED, Globals.MAX_SPEED);
		this.odometer = Odometer.istantiate("Odometer", "km", 0, Globals.MAX_DISTANCE);
		this.locTracker = LocTracker.istantiate("Loctracker");

		this.pnlMain = new JPanel();
		this.lblTitle = new JLabel();
		this.pnlGaugeOver = new JPanel();
		this.pnlGaugeUnder = new JPanel();
		
		TitledBorder titled = new TitledBorder("Gauge Display");
	    this.pnlMain.setBorder(titled);
	    
	    
		this.lblStatus = new JLabel();
		this.lblTitle.setFont(new Font("Arial", Font.BOLD, 16));
		this.lblTitle.setText(this.name);
		this.lblStatus.setFont(new Font("Arial", Font.ITALIC, 12));
		this.lblStatus.setForeground(Color.lightGray);
		this.lblStatus.setText("Gauge Display initialized.");
		
		this.setPnlGaugeUnder();
		this.setPnlGaugeOver();
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
	
	public static GaugeDisplayView instantiate(final String name) {
		return new GaugeDisplayView(name);
	}
	
	public JPanel getPanelMain() {
		return this.pnlMain;
	}
	
	protected void setPnlGaugeOver() {
		javax.swing.GroupLayout pnlGaugeOverLayout = new javax.swing.GroupLayout(this.pnlGaugeOver);
		this.pnlGaugeOver.setLayout(pnlGaugeOverLayout);
		pnlGaugeOverLayout.setHorizontalGroup(
				pnlGaugeOverLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addComponent(this.locTracker.getPanel(), javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	        );
		pnlGaugeOverLayout.setVerticalGroup(
				pnlGaugeOverLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addComponent(this.locTracker.getPanel(), javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
	        );
	}

	protected void setPnlGaugeUnder() {
		javax.swing.GroupLayout pnlgaugeUnderLayout = new javax.swing.GroupLayout(this.pnlGaugeUnder);
		this.pnlGaugeUnder.setLayout(pnlgaugeUnderLayout);
        pnlgaugeUnderLayout.setHorizontalGroup(
            pnlgaugeUnderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlgaugeUnderLayout.createSequentialGroup()
                .addComponent(this.speedometer.getPanel(), javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlgaugeUnderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(this.fuelometer.getPanel(), javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(this.odometer.getPanel(), javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        pnlgaugeUnderLayout.setVerticalGroup(
            pnlgaugeUnderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlgaugeUnderLayout.createSequentialGroup()
                .addComponent(this.fuelometer.getPanel(), javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(this.odometer.getPanel(), javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(pnlgaugeUnderLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(this.speedometer.getPanel(), javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
	}
	
	protected void setPnlMain() {
    javax.swing.GroupLayout pnlgaugeDisplayLayout = new javax.swing.GroupLayout(this.getPanelMain());
    this.getPanelMain().setLayout(pnlgaugeDisplayLayout);
    pnlgaugeDisplayLayout.setHorizontalGroup(
        pnlgaugeDisplayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(this.pnlGaugeUnder, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlgaugeDisplayLayout.createSequentialGroup()
            .addComponent(this.pnlGaugeOver, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addContainerGap())
        .addComponent(this.lblStatus, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
    );
    pnlgaugeDisplayLayout.setVerticalGroup(
        pnlgaugeDisplayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(pnlgaugeDisplayLayout.createSequentialGroup()
	        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(this.pnlGaugeOver, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(this.pnlGaugeUnder, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(this.lblStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
    );
	}

	public void updateDisplay(IStatus value) {
		this.lblStatus.setText("Gauge Display updated. Position: (" 
				+ value.getPosition().getPositionAsGeoPosition().getLatitude() + ", "
				+ value.getPosition().getPositionAsGeoPosition().getLongitude() + ")");
		
		speedometer.setValue(value.getSpeed().getSpeedAsDouble());
		fuelometer.setValue(value.getFuel().getFuelAsDouble());
		locTracker.setValue(value.getPosition().getPositionAsGeoPosition());
		odometer.setValue(value.getDistance().getDistanceAsDouble());
	}
}
