package com.unicorn.unicornmultitest.netty;

import com.unicorn.unicornmultitest.netty.CustomHandler;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.HttpServerCodec;


public class HelloServerInitializer extends ChannelInitializer<SocketChannel>{

	@Override
	protected void initChannel(SocketChannel channel) throws Exception{
		ChannelPipeline pipeline = channel.pipeline();
		pipeline.addLast("HttpSeverCodec", new HttpServerCodec());
		pipeline.addLast("customHandler", new CustomHandler());
	}

}