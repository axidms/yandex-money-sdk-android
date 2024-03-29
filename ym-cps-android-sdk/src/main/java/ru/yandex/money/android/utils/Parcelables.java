package ru.yandex.money.android.utils;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

import java.math.BigDecimal;
import java.util.Map;

/**
 * @author vyasevich
 */
public class Parcelables {

    public static void writeBoolean(Parcel parcel, boolean value) {
        parcel.writeByte(Booleans.toByte(value));
    }

    public static void writeNullableLong(Parcel parcel, Long value) {
        boolean hasValue = writeNullableValue(parcel, value);
        if (hasValue) {
            parcel.writeLong(value);
        }
    }

    public static void writeNullableParcelable(Parcel parcel, Parcelable value, int flags) {
        boolean hasValue = writeNullableValue(parcel, value);
        if (hasValue) {
            parcel.writeParcelable(value, flags);
        }
    }

    public static void writeBigDecimal(Parcel parcel, BigDecimal value) {
        boolean hasValue = writeNullableValue(parcel, value);
        if (hasValue) {
            parcel.writeDouble(value.doubleValue());
        }
    }

    public static void writeStringMap(Parcel parcel, Map<String, String> map) {
        if (parcel == null) {
            throw new NullPointerException("parcel is null");
        }
        if (map == null) {
            throw new NullPointerException("map is null");
        }
        Bundle bundle = new Bundle();
        Bundles.writeStringMapToBundle(bundle, map);
        parcel.writeBundle(bundle);
    }

    public static boolean readBoolean(Parcel parcel) {
        return Booleans.toBoolean(parcel.readByte());
    }

    public static Long readNullableLong(Parcel parcel) {
        return hasNullableValue(parcel) ? parcel.readLong() : null;
    }

    public static Parcelable readNullableParcelable(Parcel parcel, ClassLoader classLoader) {
        return hasNullableValue(parcel) ? parcel.readParcelable(classLoader) : null;
    }

    public static BigDecimal readBigDecimal(Parcel parcel) {
        return hasNullableValue(parcel) ? new BigDecimal(parcel.readDouble()) : null;
    }

    public static Map<String, String> readStringMap(Parcel parcel) {
        if (parcel == null) {
            throw new NullPointerException("parcel is null");
        }
        Bundle bundle = parcel.readBundle();
        return Bundles.readStringMapFromBundle(bundle);
    }

    private static boolean writeNullableValue(Parcel parcel, Object value) {
        boolean hasValue = value != null;
        writeBoolean(parcel, hasValue);
        return hasValue;
    }

    private static boolean hasNullableValue(Parcel parcel) {
        return readBoolean(parcel);
    }
}
