package it.unibo.iss.group2.implementations.gauges;

import org.jdesktop.swingx.JXMapKit;
import org.jdesktop.swingx.JXMapKit.DefaultProviders;
import org.jdesktop.swingx.mapviewer.GeoPosition;

import it.unibo.iss.group2.interfaces.globals.Globals;

import java.awt.EventQueue;


public class LocTracker extends Gauge<GeoPosition> {

	// GUI JComponent related to the locTracker
	private final JXMapKit       jxmMap;	
	
	public static int locTrackerZoom = 1;
	public static int locTrackerWidth = 720;
	public static int locTrackerHeight = 194;
	
	protected LocTracker(final String name) {
		super(name);
		
		this.jxmMap = new JXMapKit();

		this.setJxmMap();
		this.setPnlMain();
	}

	public static LocTracker istantiate(final String name) {
		return new LocTracker(name);
	}

	protected void setJxmMap() {
	    this.jxmMap.setDefaultProvider(DefaultProviders.OpenStreetMaps);
	    
	    // Setting the initial location and zoom of the map component
	    this.jxmMap.setAddressLocation(new GeoPosition(Globals.INITIAL_LATITUDE, Globals.INITIAL_LONGITUDE));
	    this.jxmMap.setZoom(locTrackerZoom);
	    
	    this.jxmMap.setZoomSliderVisible(true);
	    this.jxmMap.setZoomButtonsVisible(true);
	    this.jxmMap.setMiniMapVisible(false);
	    this.jxmMap.setAddressLocationShown(true);
	}

	protected void setPnlMain() {
		javax.swing.GroupLayout pnlLocTracker = new javax.swing.GroupLayout(this.getPanel());
		this.getPanel().setLayout(pnlLocTracker);
		
		pnlLocTracker.setHorizontalGroup(
				pnlLocTracker.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlLocTracker.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnlLocTracker.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(this.jxmMap, javax.swing.GroupLayout.PREFERRED_SIZE, locTrackerWidth, javax.swing.GroupLayout.PREFERRED_SIZE)
        )));
		pnlLocTracker.setVerticalGroup(
				pnlLocTracker.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlLocTracker.createSequentialGroup()
                .addComponent(this.jxmMap, javax.swing.GroupLayout.DEFAULT_SIZE, locTrackerHeight, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        ));
	}

	@Override
	public void setValue(final GeoPosition value) {
		// Updating the map according to the last observed position
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				LocTracker.this.jxmMap.setAddressLocation(value);
			}
		});
	}
}
