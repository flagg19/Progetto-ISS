package it.unibo.iss.group2.implementations.gauges;

import javax.swing.JPanel;

import it.unibo.iss.group2.interfaces.gauges.IGauge;

import java.awt.*;

public abstract class Gauge<ValueType> implements IGauge<ValueType> {
	
	private final String name;
	private JPanel mainPanel;

	protected Gauge(final String name) {
		this.name = name;
	}

	@Override
	public JPanel getPanel() {
		if (this.mainPanel == null)
		{
			this.mainPanel = new JPanel();
			this.mainPanel.setLayout(new GridBagLayout());
		}
		return this.mainPanel;
	}
	
	protected String getName() {
		return this.name;
	}
}