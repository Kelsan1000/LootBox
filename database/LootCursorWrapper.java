package com.mcs270.lootbox.database;

import android.database.Cursor;
import android.database.CursorWrapper;

import com.mcs270.lootbox.Box;

import java.util.UUID;

public class LootCursorWrapper extends CursorWrapper{

        public LootCursorWrapper(Cursor cursor) {
            super(cursor);
        }

        public Box getBox() {
            String uuidString = getString(getColumnIndex(LootDbSchema.LootTable.Cols.UUID));
            int num = getInt(getColumnIndex(LootDbSchema.LootTable.Cols.NUM));
            String tier = getString(getColumnIndex(LootDbSchema.LootTable.Cols.TIER));
            String rarity = getString(getColumnIndex(LootDbSchema.LootTable.Cols.RARITY));
            int isKept = getInt(getColumnIndex(LootDbSchema.LootTable.Cols.KEPT));
            String price = getString(getColumnIndex(LootDbSchema.LootTable.Cols.PRICE));

            Box box = new Box(UUID.fromString(uuidString));
            box.setNum(num);
            box.setTier(tier);
            box.setRarity(rarity);
            box.setKept(isKept != 0);
            box.setPrice(price);

            return box;
        }

}
