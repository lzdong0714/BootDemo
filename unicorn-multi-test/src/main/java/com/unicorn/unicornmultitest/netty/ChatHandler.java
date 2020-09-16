package com.unicorn.unicornmultitest.netty;

import io.netty.channel.group.DefaultChannelGroup;
import io.netty.channel.group.ChannelGroup;
import io.netty.util.concurrent.GlobalEventExecutor;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.Channel;
import io.netty.channel.SimpleChannelInboundHandler;
import java.time.LocalDateTime;


public class ChatHandler extends  SimpleChannelInboundHandler<TextWebSocketFrame>{
	private static ChannelGroup clients =
			new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);



	@Override
	protected void channelRead0(ChannelHandlerContext ctx, TextWebSocketFrame msg) throws
	Exception{
		String context = msg.text();

		System.out.println("context of recived message is :" + context);
		for(Channel channel : clients){
			channel.writeAndFlush(new TextWebSocketFrame("[server recevied msg in time ]:" + 
				LocalDateTime.now() + "content is " +  context));

		}
	}


	@Override
	public void handlerAdded(ChannelHandlerContext ctx)throws Exception{
			clients.add(ctx.channel());
	}

	@Override
	public void handlerRemoved(ChannelHandlerContext ctx )throws Exception{
			// 会自动触发
			// clients.remove(ctx.channel());
			// 
			System.out.println("client link is lost, "+ 
				"the long id of channel is : " + ctx.channel().id().asLongText());

			System.out.println("client link is lost, " + 
				"the short id of channel is : " + ctx.channel().id().asShortText());
	}

}