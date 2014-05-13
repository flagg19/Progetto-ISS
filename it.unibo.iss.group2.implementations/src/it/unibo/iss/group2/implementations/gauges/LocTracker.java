package it.unibo.iss.group2.implementations.gauges;

import org.jdesktop.swingx.JXMapKit;					// From swingx-ws-1.0.jar
import org.jdesktop.swingx.JXMapKit.DefaultProviders;
import org.jdesktop.swingx.JXMapViewer;
import org.jdesktop.swingx.mapviewer.GeoPosition;

import it.unibo.iss.group2.interfaces.globals.Globals;

import java.awt.EventQueue;


/**
 * Classe utilizzata per visualizzare sulla GUI il componente JXMapKit.
 * Visualizza tramite immagini ricavate da GoogleMaps la posizione del drone attuale
 * e il percorso realizzato.
 * @author Alessandro
 *
 */
public class LocTracker extends Gauge<GeoPosition> {

	// JComponent della GUI relativa al locTracker
	private final JXMapKit       jxmMap;	
	
	public static int locTrackerZoom = 1;
	public static int locTrackerWidth = 720;
	public static int locTrackerHeight = 194;
	
	/**
	 * Inizializza i componenti relativi all GUI
	 * @param name
	 */
	protected LocTracker(final String name) {
		super(name);
		
		this.jxmMap = new JXMapKit();

		this.setJxmMap();
		this.setPnlMain();
	}

	/**
	 * Metodo utilizzato da contact per ricevere una istanza dell'oggetto LocTracker
	 * @param name
	 * @return
	 */
	public static LocTracker istantiate(final String name) {
		return new LocTracker(name);
	}

	/**
	 * Metodo relativo all'inizializzazione del componente JXMapKit.
	 * Viene impostato il provider di default da cui ricevere l'immagine e settata una
	 * posizione iniziale di partenza del drone a partire dalle configurazioni presente nel file Data
	 */
	protected void setJxmMap() {
	    this.jxmMap.setDefaultProvider(DefaultProviders.OpenStreetMaps);
	    
	    // Imposto la posizione di partenza e lo Zoom del componente grafico di visualizzazione della mappa
	    this.jxmMap.setAddressLocation(new GeoPosition(Globals.INITIAL_LATITUDE, Globals.INITIAL_LONGITUDE));
	    this.jxmMap.setZoom(locTrackerZoom);
	    
	    this.jxmMap.setZoomSliderVisible(true);
	    this.jxmMap.setZoomButtonsVisible(true);
	    this.jxmMap.setMiniMapVisible(false);
	    this.jxmMap.setAddressLocationShown(true);
	}


	/**
	 * Metodo utilizzato per organizzare il Layout dei componenti grafici
	 */
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

	/**
	 * Metodo utilizzato per ricevere la posizione attuale del drone.
	 */
	@Override
	public void setValue(final GeoPosition value) {
		//double latitude = value.getLatitude();
		//double longitude = value.getLongitude();
		
		// Aggiorno il cursore grafico all'ultima posizione rilevata
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				LocTracker.this.jxmMap.setAddressLocation(value);
			}
		});
	}

	
	/**
	 * Metodo utilizzato per l'inserimento all'interno della lista della posizione.
	 * Richiama il painter per disegnare la nuova posizione sulla GUI
	 * @param latitude
	 * @param longitude
	 */
	/*
	protected void addWaypoint(final double latitude, final double longitude) {

		@SuppressWarnings("rawtypes")
		WaypointPainter painter = new WaypointPainter();
		extracted(painter);
		
		painter.setRenderer(new WaypointRenderer() {

			@Override
			public boolean paintWaypoint(final Graphics2D g, final JXMapViewer map,
					final Waypoint waypoint) {
				g.setColor(Color.BLUE);
				g.drawLine(-5, -5, +5, +5);
				g.drawLine(-5, +5, +5, -5);
				return true;
			}
    	});

		this.jxmMap.getMainMap().setOverlayPainter(painter);
	}*/
}
