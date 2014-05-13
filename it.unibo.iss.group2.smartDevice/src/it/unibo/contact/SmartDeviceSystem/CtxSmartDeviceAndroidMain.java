package it.unibo.contact.SmartDeviceSystem;

import android.os.SystemClock;
import it.unibo.android.SmartDeviceSystem.BaseActivity;

public class CtxSmartDeviceAndroidMain extends CtxSmartDeviceMain {

	protected BaseActivity baseAct = null;
	protected String contextName = "";
	
	public CtxSmartDeviceAndroidMain(BaseActivity baseAct)
	{
		super();
		this.baseAct = baseAct;
	}
	
	protected void configureSubjects() {
		try 
		{
			//Different devices with (possibly) different name 
			smartGaugeDisplay = new SmartGaugeDisplay("SmartDevice" + SystemClock.uptimeMillis(), baseAct);
			smartGaugeDisplay.setEnv(env);
			smartGaugeDisplay.initInputSupports();			
			registerObservers();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}	

}
