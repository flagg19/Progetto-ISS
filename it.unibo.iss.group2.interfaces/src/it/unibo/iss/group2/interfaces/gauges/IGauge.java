package it.unibo.iss.group2.interfaces.gauges;

import javax.swing.JPanel;

public interface IGauge<ValueType> {
	public JPanel getPanel(); 
	public abstract void setValue(final ValueType value);
}