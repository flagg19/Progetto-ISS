package it.unibo.iss.group2.implementations;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import it.unibo.iss.group2.implementations.gauges.Fuelometer;
import it.unibo.iss.group2.implementations.gauges.LocTracker;
import it.unibo.iss.group2.implementations.gauges.Odometer;
import it.unibo.iss.group2.implementations.gauges.Speedometer;
import it.unibo.iss.group2.interfaces.measures.IState;

import java.awt.*;

/**
 * Classe utilizzata per gestire la componente SWING relativa al gaugeDisplay.
 * Il gaugeDisplay si compone principalmente di tre parti:
 * 1) Una parte iniziale rappresentata dal LokTracker che permette la visualizzazione
 * su di una porzione di mappa estratta da GoogleMaps della posizione del drone
 * 2) Una parte centrale contenente le restanti informazioni sullo stato del drone quali:
 * 		a) Un Speedometer della velocita attuale del drone
 * 		b) Un Fuelometer del carburante residuo del drone
 * 		c) Un Odometer dei Km percorsi dal drone
 * 3) Un Label contenente il log corrente sullo stato di aggiornamento del gaugeDisplay
 * @author Alessandro
 *
 */
public class GaugeDisplayView {

	private final String		name;

	private final Fuelometer  	fuelometer;
	private final Speedometer 	speedometer;
	private final Odometer    	odometer;
	private LocTracker  		locTracker;

	// Rappresenta il contenitore ROOT della gerarchia
	private final JPanel		pnlMain;
	// Contiene il componente LocTracker
	private final JPanel		pnlGaugeOver;
	// Contiene i componenti Odometer, Speedometer e Fuelometer
	private final JPanel		pnlGaugeUnder;
	
	private final JLabel		lblTitle;
	private final JLabel		lblStatus;  

	/**
	 * Carica sulla GUI i componenti e imposta la grafica di visualizzazione relativa 
	 * ad ogni componente
	 * @param name
	 * @param fuelometer
	 * @param speedometer
	 * @param odometer
	 * @param locTracker
	 */
	protected GaugeDisplayView(final String name, final Fuelometer fuelometer,
			final Speedometer speedometer, final Odometer odometer, final LocTracker locTracker) {

		this.name = name;
		this.fuelometer = fuelometer;
		this.speedometer = speedometer;
		this.odometer = odometer;
		this.locTracker = locTracker;

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
		
	}
	
	/**
	 * Metodo utilizzato per generare una nuova istanza della classe
	 * @param name
	 * @param fuelometerView
	 * @param speedometerView
	 * @param odometerView
	 * @param locTrackerView
	 * @return
	 */
	public static GaugeDisplayView istantiate(final String name, final Fuelometer fuelometerView, 
			final Speedometer speedometerView, final Odometer odometerView, final LocTracker locTrackerView) {
		return new GaugeDisplayView(name, fuelometerView, speedometerView,
				odometerView, locTrackerView);
	}
	
	
	/**
	 * Metodo utilizzato per impostare il contenitore ROOT
	 */
	public JPanel getPanelMain() {
		return this.pnlMain;
	}
	
	/**
	 * Parte relativa al setting grafico del panel contenente il LokTracker
	 */
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
	/*
	protected void setPnlGaugeOver() {
		javax.swing.GroupLayout pnlGaugeOverLayout = new javax.swing.GroupLayout(this.pnlGaugeOver);
		
		this.pnlGaugeOver.setLayout(pnlGaugeOverLayout);
        
		pnlGaugeOverLayout.setHorizontalGroup(
				pnlGaugeOverLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(this.locTracker.getPanel(), javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            );
		pnlGaugeOverLayout.setVerticalGroup(
				pnlGaugeOverLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(this.locTracker.getPanel(), javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 211, Short.MAX_VALUE)
            );
	}
	*/
	
	/**
	 * Parte relativa al setting grafico del panel contenente i vari strumenti di visualizzazione
	 * delle misure di stato del Drone quali Odometer, Fuelometer e Speedometer
	 */
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
	
	/**
	 * Panel globale contenente l'intera GUI di visualizzazione delle informazioni del Drone
	 */
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
	
	/**
	 * Metodo utilizzato per aggiornare le informazioni relative ai componenti presenti sulla GUI
	 */
	public void updateDisplay(IState value) {
		this.lblStatus.setText("Gauge Display updated. Position: (" 
				+ value.getPosition().getPositionAsGeoPosition().getLatitude() + "°, "
				+ value.getPosition().getPositionAsGeoPosition().getLongitude() + "°)");
		
		speedometer.setValue(value.getSpeed().getSpeedAsDouble());
		fuelometer.setValue(value.getFuel().getFuelAsDouble());
		locTracker.setValue(value.getPosition().getPositionAsGeoPosition());
		odometer.setValue(value.getDistance().getDistanceAsDouble());
	}
}
