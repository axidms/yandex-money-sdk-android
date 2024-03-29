package ru.yandex.money.android.parcelables;

import android.os.Parcel;
import android.os.Parcelable;

import com.yandex.money.model.cps.misc.MoneySource;

/**
 * @author vyasevich
 */
public class MoneySourceParcelable implements Parcelable {

    private final MoneySource moneySource;

    public MoneySourceParcelable(MoneySource moneySource) {
        this.moneySource = moneySource;
    }

    private MoneySourceParcelable(Parcel parcel) {
        moneySource = new MoneySource(parcel.readString(), parcel.readString(), parcel.readString(),
                parcel.readString());
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(moneySource.getType());
        dest.writeString(moneySource.getPaymentCardType());
        dest.writeString(moneySource.getPanFragment());
        dest.writeString(moneySource.getMoneySourceToken());
    }

    public MoneySource getMoneySource() {
        return moneySource;
    }

    public static final Creator<MoneySourceParcelable> CREATOR =
            new Creator<MoneySourceParcelable>() {
                @Override
                public MoneySourceParcelable createFromParcel(Parcel source) {
                    return new MoneySourceParcelable(source);
                }

                @Override
                public MoneySourceParcelable[] newArray(int size) {
                    return new MoneySourceParcelable[size];
                }
            };
}
