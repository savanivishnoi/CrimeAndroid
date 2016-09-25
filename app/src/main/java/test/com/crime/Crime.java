package test.com.crime;

import java.text.DateFormat;
import java.text.FieldPosition;
import java.text.ParsePosition;
import java.util.Date;
import java.util.UUID;

/**
 * Created by savani on 9/13/16.
 */
public class Crime {
private UUID uid;
    private String title;
    private Date date;

    public boolean isSolved() {
        return solved;
    }

    public void setSolved(boolean solved) {
        this.solved = solved;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    private boolean solved;
    public Crime(){
        uid = UUID.randomUUID();
        Long lDate = System.currentTimeMillis();
        //DateFormat dateFormat= DateFormat.getDateInstance().format(lDate);
    }

    public UUID getUid() {
        return uid;
    }



    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
