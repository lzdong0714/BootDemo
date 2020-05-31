package com.unicorn.unicornmultitest.netty;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import org.springframework.stereotype.Component;

@Component
public class WSServerBoot{

	private static class SingletionWSServer{
		static final WSServerBoot  instance = new WSServerBoot();
	}

	public static WSServerBoot getInstance(){
		return SingletionWSServer.instance;
	}

	private EventLoopGroup mainGroup ;
	private EventLoopGroup subGroup ;
	private ServerBootstrap server;
	private ChannelFuture future;


	public WSServerBoot(){
		mainGroup = new NioEventLoopGroup();
		subGroup = new NioEventLoopGroup();
		server = new ServerBootstrap();
			server.group(mainGroup, subGroup)
			.channel(NioServerSocketChannel.class)
			.childHandler(new WSServerInitializer());
	}
 
	public void start(){
		this.future = server.bind(8088);
		System.err.println("netty websocket server ");

	}
}