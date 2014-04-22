package it.unibo.iss.group2.implementations;

import it.unibo.iss.group2.implementations.gauges.Fuelometer;
import it.unibo.iss.group2.implementations.gauges.LocTracker;
import it.unibo.iss.group2.implementations.gauges.Odometer;
import it.unibo.iss.group2.implementations.gauges.Speedometer;
import it.unibo.iss.group2.interfaces.globals.Globals;
import it.unibo.iss.group2.interfaces.monitor.ISyncMonitor;

import javax.swing.GroupLayout;
import javax.swing.JFrame;

public class DroneControlDashboardView extends JFrame {
		
	private DroneControlDashboardView(ISyncMonitor syncMonitor) {
		CmdDisplayView cdv = CmdDisplayView.istantiate("Command Display", syncMonitor); 
		
		GaugeDisplayView gdv = GaugeDisplayView.istantiate("Gauge Display", 
						Fuelometer.istantiate("Fuelometer", "l", Globals.MIN_FUEL, Globals.MAX_FUEL),
						Speedometer.istantiate("Speedometer", "km/h", Globals.MIN_SPEED, Globals.MAX_SPEED),
						Odometer.istantiate("Odometer", "km", Globals.MIN_DISTANCE, Globals.MAX_DISTANCE), 
						LocTracker.istantiate("Loctracker"));
				
		try {
		    setTitle("Drone Control Dashboard");
		    setVisible(true);
		    
		    setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
	        
	        // Menu Item
	        /*jmnFile.setText("File");
	        jmnBar.add(jmnFile);
	        j.setJMenuBar(jmnBar);

	        jmnItem.setText("Archivio missioni");
	        
	        jmnFile.add(jmnItem);
		    */
	        GroupLayout layout = new GroupLayout(getContentPane());
	        getContentPane().setLayout(layout);
	        layout.setHorizontalGroup(
	            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addGroup(layout.createSequentialGroup()
	                .addComponent(cdv.getPanelMain(), javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
	                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
	                .addComponent(gdv.getPanelMain(), javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
	        );
	        layout.setVerticalGroup(
	            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addComponent(cdv.getPanelMain(), javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	            .addComponent(gdv.getPanelMain(), javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	        );

	        pack();
	        
	        /*
	        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
			setLocation(dim.width/2-getSize().width/2, dim.height/2-getSize().height/2);
			*/
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	public static DroneControlDashboardView istantiate(ISyncMonitor syncMonitor) {
		return new DroneControlDashboardView(syncMonitor);
	}
	
}
