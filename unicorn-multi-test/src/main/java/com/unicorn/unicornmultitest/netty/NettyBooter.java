package com.unicorn.unicornmultitest.netty;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
//import org.springframework.context.evnet.ContextRegfreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class NettyBooter implements ApplicationListener<ContextRefreshedEvent>{

//	@Override
//	public void onApplicationEvent(ContextResfreshedEvent event){
//		if(event.getApplicationContext().getParent == null){
//			try{
//				WSServerBoot.getInstance().start();
//			}catch(Exception e){
//				e.printStackTrace();
//			}
//		}
//	}

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		if(event.getApplicationContext().getParent() == null){
			try{
				WSServerBoot.getInstance().start();
			}catch(Exception e){
				e.printStackTrace();
			}
		}

	}
}