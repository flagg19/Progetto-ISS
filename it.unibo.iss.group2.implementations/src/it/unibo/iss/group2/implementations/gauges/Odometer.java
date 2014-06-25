package it.unibo.iss.group2.implementations.gauges;

import eu.hansolo.steelseries.gauges.Linear;
import eu.hansolo.steelseries.tools.BackgroundColor;
import eu.hansolo.steelseries.tools.FrameDesign;
import eu.hansolo.steelseries.tools.FrameEffect;
import eu.hansolo.steelseries.tools.LcdColor;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.math.BigInteger;

public class Odometer extends Gauge<Double> {
	
	private final String     unitName;
	private final Linear     linearValue;
	private final BigInteger minWidth;
	private final BigInteger minHeight;

	public static int odometerWidth = 480;
	public static int odometerHeight = 100;
	
	protected Odometer(final String name, final String unitName, final double minValue, final double maxValue) {
		super(name);

		this.unitName = unitName;

		this.minWidth = BigInteger.valueOf(odometerWidth);
		this.minHeight = BigInteger.valueOf(odometerHeight);

		this.linearValue = new Linear();
		this.init(minValue, maxValue);
	}

	public static Odometer istantiate(final String name, final String unitName, final double minValue, final double maxValue) {
		return new Odometer(name, unitName, minValue, maxValue);
	}
	
	@Override
	public void setValue(final Double value) {
		EventQueue.invokeLater(new Runnable() {

			@Override
			public void run() {
				Odometer.this.linearValue.setValueAnimated(value);
			}
		});
	}

	protected void init(final double minValue, final double maxValue) {
		this.linearValue.init(this.minWidth.intValue(), this.minHeight.intValue());

		this.linearValue.setTitle(this.getName());
		this.linearValue.setUnitString(this.unitName);

		this.linearValue.setMinValue(minValue);
		this.linearValue.setMaxValue(maxValue);

		this.linearValue.setLcdDecimals(3);
		this.linearValue.setDigitalFont(true);
		this.linearValue.setLcdColor(LcdColor.SECTIONS_LCD);
		this.linearValue.setFrameEffect(FrameEffect.EFFECT_INNER_FRAME);
		this.linearValue.setFrameDesign(FrameDesign.GLOSSY_METAL);
		this.linearValue.setBackgroundColor(BackgroundColor.PUNCHED_SHEET);

		FlowLayout mainPanelLayout = new FlowLayout();
		mainPanelLayout.setAlignment(FlowLayout.CENTER);
		this.getPanel().setLayout(mainPanelLayout);
		this.getPanel().add(this.linearValue);

		this.linearValue.setPreferredSize(new Dimension(this.minWidth
				.intValue(), this.minHeight.intValue()));
	}
}
