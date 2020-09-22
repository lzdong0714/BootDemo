package com.unicorn.unicornmultitest.netty;

import com.unicorn.unicornmultitest.netty.WSServerInitializer;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.bootstrap.ServerBootstrap;


public class WSServer{
	public static void main(String[] args) throws Exception{
		EventLoopGroup mainGroup = new NioEventLoopGroup();
		EventLoopGroup subGroup = new NioEventLoopGroup();
		try{
			ServerBootstrap server = new ServerBootstrap();
			server.group(mainGroup, subGroup)
			.channel(NioServerSocketChannel.class)
			.childHandler(new WSServerInitializer());

			ChannelFuture future = server.bind(8089).sync();

			future.channel().closeFuture().sync();
		}finally{
			mainGroup.shutdownGracefully();
			subGroup.shutdownGracefully();
		}
	}

	public void start() throws InterruptedException {
		EventLoopGroup mainGroup = new NioEventLoopGroup();
		EventLoopGroup subGroup = new NioEventLoopGroup();
		try{
			ServerBootstrap server = new ServerBootstrap();
			server.group(mainGroup, subGroup)
					.channel(NioServerSocketChannel.class)
					.childHandler(new WSServerInitializer());

			ChannelFuture future = server.bind(8088).sync();
			future.channel().closeFuture().sync();
		}finally{
			mainGroup.shutdownGracefully();
			subGroup.shutdownGracefully();
		}

	}

}