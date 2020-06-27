package pe.kr.kth.test.data;

import android.os.Parcel;
import android.os.Parcelable;

public class Item implements Parcelable {
    public int id;
    public String title;
    public String content;

    public Item(int id, String title, String content) {
        this.id = id;
        this.title = title;
        this.content = content;
    }

    protected Item(Parcel in) {
        id = in.readInt();
        title = in.readString();
        content = in.readString();
    }

    public static final Creator<Item> CREATOR = new Creator<Item>() {
        @Override
        public Item createFromParcel(Parcel in) {
            return new Item(in);
        }

        @Override
        public Item[] newArray(int size) {
            return new Item[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(title);
        dest.writeString(content);
    }
}
