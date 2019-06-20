package greymerk.roguelike.util;

/*
 * Roguelike Dungeons Reborn
 * Modified Source
 */

import java.util.Map;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import net.minecraft.nbt.ByteArrayNBT;
import net.minecraft.nbt.ByteNBT;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.nbt.DoubleNBT;
import net.minecraft.nbt.FloatNBT;
import net.minecraft.nbt.IntArrayNBT;
import net.minecraft.nbt.IntNBT;
import net.minecraft.nbt.ListNBT;
import net.minecraft.nbt.LongNBT;
import net.minecraft.nbt.ShortNBT;
import net.minecraft.nbt.StringNBT;

public enum JsonNBT {

	END, BYTE, SHORT, INT, LONG, FLOAT, DOUBLE, BYTEARRAY, STRING, LIST, COMPOUND, INTARRAY;

	public static CompoundNBT jsonToCompound(JsonObject data) {

		CompoundNBT toReturn = new CompoundNBT();

		for (Map.Entry<String, JsonElement> entry : data.entrySet()) {
			JsonObject obj = entry.getValue().getAsJsonObject();
			JsonNBT type = getType(obj.get("type").getAsString());
			setCompoundEntry(toReturn, entry.getKey(), type, obj.get("value"));
		}

		return toReturn;
	}

	public static ListNBT jsonToList(JsonObject data) {
		ListNBT toReturn = new ListNBT();
		JsonNBT type = JsonNBT.valueOf(data.get("type").getAsString());
		for (JsonElement e : data.get("value").getAsJsonArray()) {
			append(toReturn, type, e);
		}

		return toReturn;
	}

	public static JsonNBT getType(String type) {
		return JsonNBT.valueOf(type);
	}

	public static void setCompoundEntry(CompoundNBT nbt, String name, JsonNBT type, JsonElement data) {
		switch (type) {
		case END:
			return;
		case BYTE:
			nbt.putByte(name, data.getAsByte());
			return;
		case SHORT:
			nbt.putShort(name, data.getAsShort());
			return;
		case INT:
			nbt.putInt(name, data.getAsInt());
			return;
		case LONG:
			nbt.putLong(name, data.getAsLong());
			return;
		case FLOAT:
			nbt.putFloat(name, data.getAsFloat());
			return;
		case DOUBLE:
			nbt.putDouble(name, data.getAsDouble());
			return;
		case BYTEARRAY:
			nbt.putByteArray(name, jsonToByteArray(data.getAsJsonObject()));
			return;
		case STRING:
			nbt.putString(name, data.getAsString());
			return;
		case LIST:
			nbt.put(name, jsonToList(data.getAsJsonObject()));
			return;
		case COMPOUND:
			nbt.put(name, jsonToCompound(data.getAsJsonObject()));
			return;
		case INTARRAY:
			nbt.put(name, new IntArrayNBT(jsonToIntArray(data.getAsJsonObject())));
			return;
		}
	}

	public static void append(ListNBT nbt, JsonNBT type, JsonElement data) {
		switch (type) {
		case END:
			return;
		case BYTE:
			nbt.add(new ByteNBT(data.getAsByte()));
			return;
		case SHORT:
			nbt.add(new ShortNBT(data.getAsShort()));
			return;
		case INT:
			nbt.add(new IntNBT(data.getAsInt()));
			return;
		case LONG:
			nbt.add(new LongNBT(data.getAsLong()));
			return;
		case FLOAT:
			nbt.add(new FloatNBT(data.getAsFloat()));
			return;
		case DOUBLE:
			nbt.add(new DoubleNBT(data.getAsDouble()));
			return;
		case BYTEARRAY:
			nbt.add(new ByteArrayNBT(jsonToByteArray(data.getAsJsonObject())));
			return;
		case STRING:
			nbt.add(new StringNBT(data.getAsString()));
			return;
		case LIST:
			nbt.add(jsonToList(data.getAsJsonObject()));
			return;
		case COMPOUND:
			nbt.add(jsonToCompound(data.getAsJsonObject()));
			return;
		case INTARRAY:
			nbt.add(new IntArrayNBT(jsonToIntArray(data.getAsJsonObject())));
			return;
		}
	}

	public static byte[] jsonToByteArray(JsonObject data) {
		JsonArray arr = data.getAsJsonArray();

		byte[] bytes = new byte[arr.size()];

		int i = 0;
		for (JsonElement e : arr) {
			bytes[i] = e.getAsByte();
			i++;
		}

		return bytes;
	}

	public static int[] jsonToIntArray(JsonObject data) {
		JsonArray arr = data.getAsJsonArray();

		int[] ints = new int[arr.size()];

		int i = 0;
		for (JsonElement e : arr) {
			ints[i] = e.getAsInt();
			i++;
		}

		return ints;
	}
}
