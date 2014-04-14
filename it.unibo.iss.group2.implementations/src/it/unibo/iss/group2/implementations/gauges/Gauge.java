package it.unibo.iss.group2.implementations.gauges;

import javax.swing.JPanel;

import it.unibo.iss.group2.interfaces.gauges.IGauge;

import java.awt.*;

/**
 * Classe di interfaccia comune a tutti i componenti della GUI.
 * I componenti sono: Odometer, Speedometer, LocTracker e Fuelometer
 * @author Alessandro
 *
 */
public abstract class Gauge<ValueType> implements IGauge<ValueType> {
	
	private final String name;
	private JPanel mainPanel;

	/**
	 * Metodo costruttore utilizzare per settare i parametri di base della GUI gaugeDisplay
	 * @param name
	 */
	protected Gauge(final String name) {
		this.name = name;
	}

	/**
	 * Ritorna il panel principale della GUI
	 */
	@Override
	public JPanel getPanel() {
		if (this.mainPanel == null)
		{
			this.mainPanel = new JPanel();
			this.mainPanel.setLayout(new GridBagLayout());
		}
		return this.mainPanel;
	}
	
	/**
	 * Ritorna il nome del componente selezionato
	 * @return
	 */
	protected String getName() {
		return this.name;
	}
}