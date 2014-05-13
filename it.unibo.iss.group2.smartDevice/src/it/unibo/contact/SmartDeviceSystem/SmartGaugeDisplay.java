package it.unibo.contact.SmartDeviceSystem;

import android.widget.TextView;
import it.unibo.android.SmartDeviceSystem.BaseActivity;
import it.unibo.android.SmartDeviceSystem.OutView;
import it.unibo.android.SmartDeviceSystem.R;

public class SmartGaugeDisplay extends SmartGaugeDisplaySupport {

	BaseActivity ba = null;
	
	public SmartGaugeDisplay(String name, BaseActivity ba) throws Exception {
		super(name);
		this.ba = ba;
	}
	
	public SmartGaugeDisplay(String name) throws Exception {
		super(name);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected String cleanString(String jsonString) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public void showMsg( String msg){
 		ba.showMsg(msg);
	}
}
