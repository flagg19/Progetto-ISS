package it.unibo.android.SmartDeviceSystem;
import android.os.Bundle;
import it.unibo.android.SmartDeviceSystem.GaugeActivitySupport;
import it.unibo.contact.SmartDeviceSystem.CtxSmartDeviceAndroidMain;
import it.unibo.contact.SmartDeviceSystem.CtxSmartDeviceMain;

public class GaugeActivity extends GaugeActivitySupport {

	protected CtxSmartDeviceMain context = null;

	
	@Override
	protected void startListening(String inputValue, Bundle b) throws Exception {
		//Create extended context
		context = new CtxSmartDeviceAndroidMain(this);
		context.doJob();
	}

	@Override
	protected void doJob() {
	}

}
