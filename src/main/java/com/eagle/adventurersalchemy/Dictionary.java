package com.eagle.adventurersalchemy;

/**
 * This class was created by GustoniaEagle.
 * It is distributed under a part of the Adventurer's Alchemy mod.
 * https://github.com/GustoniaEagle/
 * <p/>
 * Adventurer's Alchemy is open source, and available under the
 * GNU General Public License Version 2.
 * <p/>
 * File created @ 06/06/2015, 16:18 GMT.
 */
public class Dictionary
{
    public static final String MOD_ID = "adventurersalchemy";
    public static final String NAME = "Adventurer's Alchemy";
    public static final String VERSION = "1.0.0";
    public static final String COMMON_PROXY = "com.eagle.adventurersalchemy.proxy.CommonProxy";
    public static final String CLIENT_PROXY = "com.eagle.adventurersalchemy.proxy.ClientProxy";

    public static final String UNLOCALIZED_ALCHEMICAL_DUST = "alchemicalDust";
    public static final String[] UNLOCALIZED_ALCHEMICAL_DUST_TYPES =
            new String[]{"Ash", "Ignis", "Terra", "Aeris", "Aqua", "Sol", "Luna", "Inferna", "Metallum", "Calor",
                    "Vapor", "Flamma", "Nocte", "Petram", "Harenosa", "Luto", "Invio", "Meteoron", "Ventus", "Nube",
                    "Caelum", "Stella", "Oceanus", "Spiritus", "Unda", "Exitium", "Concordia", "Pacem"};
    public static final String[] COLOURS =
            new String[]{"293338", "db2424", "3fbd2c", "ffdb00", "00abff", "ff8100", "4b5474", "ff3300", "dbd3d0",
                    "fd8432", "93a9a9", "ff4d00", "4900ff", "5a2f17", "b8883f", "6b3d0f", "c19f7c", "ae6c50", "caeac3",
                    "c3ddea", "6ccfff", "f8aaf9", "0004ff", "8d1062", "364cba", "ff4d00", "ff009a", "ffffff"};
    public static final String UNLOCALIZED_MORTAR = "mortar";
    public static final String UNLOCALIZED_ALCHEMICAL_FIRE = "alchemicalFire";
    public static final String TEXTURE_ALCHEMICAL_FIRE =
            Dictionary.MOD_ID + ":" + "textures/blocks/model/alchemicalFire.png";

	public enum NetworkIdentifiers {

		ALCHEMICAL_FIRE;

	}
}
