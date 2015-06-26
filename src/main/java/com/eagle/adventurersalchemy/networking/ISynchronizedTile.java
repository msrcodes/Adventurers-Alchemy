package com.eagle.adventurersalchemy.networking;

/**
 * Created by AEnterprise
 */
public interface ISynchronizedTile extends ISyncable {

	int getX();

	int getY();

	int getZ();

	int getIdentifier();
}
