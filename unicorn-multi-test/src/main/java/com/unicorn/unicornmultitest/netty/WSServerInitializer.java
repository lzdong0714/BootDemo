package com.unicorn.unicornmultitest.netty;

import com.unicorn.unicornmultitest.netty.ChatHandler;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.HttpServerCodec;
import io.netty.handler.stream.ChunkedWriteHandler;
import io.netty.handler.codec.http.websocketx.WebSocketServerProtocolHandler;
import io.netty.handler.codec.http.HttpObjectAggregator;

public class WSServerInitializer extends ChannelInitializer<SocketChannel>{

	@Override
	public void initChannel(SocketChannel channel) throws Exception{
		ChannelPipeline pipeline = channel.pipeline();
		// http 编解码
		pipeline.addLast(new HttpServerCodec());
		// 大文件写
		pipeline.addLast(new ChunkedWriteHandler());

		// 对http message进行聚合，聚合成FullHttpRequest或FullHttpResponse
		pipeline.addLast(new HttpObjectAggregator(1024 * 64));

		// ================= 以上是用于支持合同谈判协议 ==================
		// 
		
		// websoceket 协议，添加路由
		pipeline.addLast(new WebSocketServerProtocolHandler("/ws"));

		pipeline.addLast(new ChatHandler());
	}

}