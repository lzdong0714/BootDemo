package com.unicorn.unicornmultitest.netty;

import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.EventLoopGroup;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.channel.ChannelFuture;
import lombok.extern.slf4j.Slf4j;

import java.net.InetSocketAddress;
@Slf4j
public class HelloServer{

//	public static void main(String[] args) throws Exception {
//
//		EventLoopGroup bossGroup = new NioEventLoopGroup();
//		EventLoopGroup workerGroup = new NioEventLoopGroup();
//		try{
//			ServerBootstrap serverBootstrap = new ServerBootstrap();
//
//			serverBootstrap.group(bossGroup, workerGroup)
//						.channel(NioServerSocketChannel.class)
//						.childHandler(new HelloServerInitializer());
//
//			ChannelFuture channelFuture = serverBootstrap.bind(8088).sync();
//
//			channelFuture.channel().closeFuture().sync();
//		}finally{
//			bossGroup.shutdownGracefully();
//			workerGroup.shutdownGracefully();
//		}
//
//	}

	public void start(InetSocketAddress socketAddress){
		EventLoopGroup bossGroup = new NioEventLoopGroup();
		EventLoopGroup workerGroup = new NioEventLoopGroup();
		try{
			ServerBootstrap serverBootstrap = new ServerBootstrap();

			serverBootstrap.group(bossGroup, workerGroup)
					.channel(NioServerSocketChannel.class)
					.childHandler(new HelloServerInitializer())
					.localAddress(socketAddress);

			ChannelFuture channelFuture = serverBootstrap.bind(socketAddress).sync();
			log.info("服务器启动开始监听端口: {}", socketAddress.getPort());
			channelFuture.channel().closeFuture().sync();

		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally{
			bossGroup.shutdownGracefully();
			workerGroup.shutdownGracefully();
		}
	}
}