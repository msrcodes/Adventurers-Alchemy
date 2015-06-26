package com.eagle.adventurersalchemy.networking;

import io.netty.buffer.ByteBuf;

/**
 * Created by AEnterprise
 */
public interface ISyncable {

	void writeToByteBuff(ByteBuf buf);

	void readFromByteBuff(ByteBuf buf);
}
