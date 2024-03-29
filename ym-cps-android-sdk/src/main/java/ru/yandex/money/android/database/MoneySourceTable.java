package ru.yandex.money.android.database;

/**
* @author vyasevich
*/
public class MoneySourceTable {
    public static final String NAME = "MoneySources";

    public static final String TYPE = "type";
    public static final String PAYMENT_CARD_TYPE = "payment_card_type";
    public static final String PAN_FRAGMENT = "pan_fragment";
    public static final String TOKEN = "token";

    public static final String COMMAND_CREATE =
            "CREATE TABLE " + NAME + " (\n" +
                    TOKEN + " TEXT PRIMARY KEY,\n" +
                    TYPE + " TEXT NOT NULL,\n" +
                    PAYMENT_CARD_TYPE + " TEXT NOT NULL,\n" +
                    PAN_FRAGMENT + " TEXT NOT NULL);";

    MoneySourceTable() {
        // forbid instance creation
    }
}
