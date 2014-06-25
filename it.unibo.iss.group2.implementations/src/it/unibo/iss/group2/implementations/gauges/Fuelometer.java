package it.unibo.iss.group2.implementations.gauges;

import eu.hansolo.steelseries.gauges.LinearBargraph;
import eu.hansolo.steelseries.tools.BackgroundColor;
import eu.hansolo.steelseries.tools.FrameDesign;
import eu.hansolo.steelseries.tools.FrameEffect;
import eu.hansolo.steelseries.tools.LcdColor;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.math.BigInteger;

public class Fuelometer extends Gauge<Double> {
	public static int fuelometerWidth = 480;
	public static int fuelometerHeight = 100;
	
	protected String               	unitName;
	private final LinearBargraph 	linearBargraph;
	private final BigInteger       	minWidth;
	private final BigInteger       	minHeight;
	private final double            minValue;
	private final double            maxValue;

	protected Fuelometer(final String name, final String unitName,
			final double minValueShown, final double maxValueShown) {
		super(name);

		this.unitName = unitName;

		this.minWidth = BigInteger.valueOf(fuelometerWidth);
		this.minHeight = BigInteger.valueOf(fuelometerHeight);

		this.minValue = minValueShown;
		this.maxValue = maxValueShown;

		this.linearBargraph = new LinearBargraph();
		this.init();
	}

	public static Fuelometer istantiate(final String name,
			final String unitName, final double minValueShown,
			final double maxValueShown) {

		return new Fuelometer(name, unitName, minValueShown, maxValueShown);
	}

	@Override
	public void setValue(final Double value) {
		EventQueue.invokeLater(new Runnable() {

			@Override
			public void run() {
				Fuelometer.this.linearBargraph.setValueAnimated(value);
			}
		});
	}
	
	protected void init() {
		this.linearBargraph.init(this.minWidth.intValue(),
				this.minHeight.intValue());

		this.linearBargraph.setMinValue(this.minValue);
		this.linearBargraph.setMaxValue(this.maxValue);

		this.linearBargraph.setTitle(this.getName());
		this.linearBargraph.setUnitString(this.unitName);

		this.linearBargraph.setLcdDecimals(2);
		this.linearBargraph.setDigitalFont(true);
		this.linearBargraph.setLcdColor(LcdColor.SECTIONS_LCD);
		this.linearBargraph.setFrameEffect(FrameEffect.EFFECT_INNER_FRAME);
		this.linearBargraph.setFrameDesign(FrameDesign.GLOSSY_METAL);
		this.linearBargraph.setBackgroundColor(BackgroundColor.PUNCHED_SHEET);

		FlowLayout mainPanelLayout = new FlowLayout();
		mainPanelLayout.setAlignment(FlowLayout.CENTER);
		this.getPanel().setLayout(mainPanelLayout);
		this.getPanel().add(this.linearBargraph);

		this.linearBargraph.setPreferredSize(new Dimension(this.minWidth
				.intValue(), this.minHeight.intValue()));
	}

}
