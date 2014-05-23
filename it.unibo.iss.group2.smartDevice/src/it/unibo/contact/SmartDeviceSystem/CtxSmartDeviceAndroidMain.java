package it.unibo.contact.SmartDeviceSystem;

import android.os.SystemClock;
import it.unibo.android.SmartDeviceSystem.BaseActivity;
import it.unibo.contact.platformuv.AcquireOneReply;
import it.unibo.contact.platformuv.CommLogic;
import it.unibo.contact.platformuv.LindaLike;
import it.unibo.contact.platformuv.Message;
import it.unibo.contact.platformuv.MsgUtil;
import it.unibo.contact.platformuv.PlatformExpert;
import it.unibo.contact.platformuv.RunTimeKb;
import it.unibo.is.interfaces.IMessage;
import it.unibo.is.interfaces.platforms.IAcquireOneReply;
import it.unibo.is.interfaces.platforms.ILindaLike;

public class CtxSmartDeviceAndroidMain extends CtxSmartDeviceMain {

	protected BaseActivity baseAct = null;
	protected String contextName = "";
	
	public CtxSmartDeviceAndroidMain(BaseActivity baseAct)
	{
		super();
		String uniqueID = String.valueOf(SystemClock.uptimeMillis());
		contextName = "ctxSmartDevice" + uniqueID;  
		this.baseAct = baseAct;
	}
	
	@Override
	protected void initSupport(){
		MsgUtil.init(view);
		core = ((LindaLike)LindaLike.initSpace(view,contextName));
	}
	
	@Override
	protected void ask_setConnChannel_space()  {
		try{
	  		ILindaLike support = PlatformExpert.findOutSupport("space","setConnChannel",contextName,view);
		 	RunTimeKb.addSubjectConnectionSupport(contextName, support, view );
		 	String msgOut = "space_setConnChannel("+contextName+", setConnChannel, connect, 0) "  ;
			support.out( msgOut );
	
			IAcquireOneReply answer = new AcquireOneReply(contextName, "space","setConnChannel",core, 
					contextName+"_space_setConnChannel(space,setConnChannel,M,0)",view);
			
			IMessage reply = answer.acquireReply();
			if( reply.msgContent().contains("exception")) throw new Exception("connection not possible");
			System.out.println(" ask_setConnChannel_space: reply= " + reply.msgContent() + " from " + reply.msgEmitter() );
	 	}catch( Exception e){
			System.out.println(" ask_setConnChannel_space: ERROR " + e.getMessage() );	
		}
	 }
	  
	@Override
	 protected void serveUpdateDispatchThread() throws Exception {
			new Thread(){
				protected boolean goon = true;
				protected CommLogic comSup = new CommLogic(view);
				
				protected IMessage hl_node_serve_update(   ) throws Exception {
					IMessage m = new Message(contextName+"_update"+"(ANY,update,M,N)");
					IMessage inMsg = comSup.inOnly( contextName ,"update", m );				
					return inMsg;				
				}		
		
				public void run(){
					System.out.println(contextName + " serveUpdateDispatchThread started");
					while(goon)
					try {
						IMessage m =  hl_node_serve_update();
	 					System.out.println(contextName + " storing content of: " + m   );
						LindaLike.getSpace().out( m.msgContent() );					 
					} catch (Exception e) {
						goon=false;
	 					e.printStackTrace();
					}
					
				}
			}.start();
	 }
	 
	@Override
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
