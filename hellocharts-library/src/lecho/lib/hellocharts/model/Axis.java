package lecho.lib.hellocharts.model;

import java.util.ArrayList;
import java.util.List;

import lecho.lib.hellocharts.util.Utils;

/**
 * Single axis model. By default axis is auto-generated. Use {@link #setAutoGenerated(boolean)} to disable axis values
 * generation and set values manually using {@link #setValues(List)}. If Axis is auto-generated {@link #setValues(List)}
 * will be ignored. Change how axis labels are displayed by changing formatter {@link #setFormatter(ValueFormatter)}.
 * Axis can have a name that should be displayed next to labels(that depends on renderer implementation), you can change
 * name using {@link #setName(String)}, by default axis name is empty and therefore not displayed.
 * 
 * @author Leszek Wach
 * 
 */
public class Axis {
	public static final int DEFAULT_TEXT_SIZE_SP = 12;
	public static final int DEFAULT_MAX_AXIS_LABEL_CHARS = 4;
	private List<AxisValue> values = new ArrayList<AxisValue>();
	private String name;
	private boolean isAutoGenerated = true;
	private boolean hasLines = true;
	private int textColor = Utils.DEFAULT_DARKEN_COLOR;
	private int lineColor = Utils.DEFAULT_COLOR;
	private int textSize = DEFAULT_TEXT_SIZE_SP;
	private int maxLabelChars = DEFAULT_MAX_AXIS_LABEL_CHARS;
	private ValueFormatter formatter = new NumberValueFormatter();

	/**
	 * Creates auto-generated axis without name and with default formatter.
	 * 
	 * @see NumberValueFormatter
	 */
	public Axis() {
	}

	/**
	 * Creates axis with given values(not auto-generated) without name and with default formatter.
	 */
	public Axis(List<AxisValue> values) {
		this.values = values;
		this.isAutoGenerated = false;
	}

	public Axis(Axis axis) {
		this.name = axis.name;
		this.isAutoGenerated = axis.isAutoGenerated;
		this.formatter = axis.formatter;

		for (AxisValue axisValue : values) {
			this.values.add(new AxisValue(axisValue));
		}
	}

	public List<AxisValue> getValues() {
		return values;
	}

	public Axis setValues(List<AxisValue> values) {
		this.values = values;
		return this;
	}

	public String getName() {
		return name;
	}

	public Axis setName(String name) {
		this.name = name;
		return this;
	}

	public boolean isAutoGenerated() {
		return isAutoGenerated;
	}

	public Axis setAutoGenerated(boolean isAutoGenerated) {
		this.isAutoGenerated = isAutoGenerated;
		return this;
	}

	public boolean hasLines() {
		return hasLines;
	}

	public void setHasLines(boolean hasLines) {
		this.hasLines = hasLines;
	}

	public int getTextColor() {
		return textColor;
	}

	public void setTextColor(int color) {
		this.textColor = color;
	}

	public int getLineColor() {
		return lineColor;
	}

	public void setLineColor(int lineColor) {
		this.lineColor = lineColor;
	}

	public int getTextSize() {
		return textSize;
	}

	public void setTextSize(int textSize) {
		this.textSize = textSize;
	}

	public int getMaxLabelChars() {
		return maxLabelChars;
	}

	public void setMaxLabelChars(int maxLabelChars) {
		this.maxLabelChars = maxLabelChars;
	}

	public ValueFormatter getFormatter() {
		return formatter;
	}

	public Axis setFormatter(ValueFormatter formatter) {
		if (null == formatter) {
			this.formatter = new NumberValueFormatter();
		} else {
			this.formatter = formatter;
		}
		return this;
	}
}
