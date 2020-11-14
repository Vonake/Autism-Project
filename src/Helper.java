
import java.util.Date;
import javax.swing.JLabel;

public class Helper {

    public Helper() {

    }

    public String getTime() {
        String n = new java.util.Date().toString();
        int hours = Integer.parseInt(n.substring(11, 13));
        String time = "";
        if (hours > 12) {
            hours = hours - 12;
            time = hours + n.substring(13, 16) + " PM";
        } else if (hours == 12) {
            time = hours + n.substring(13, 16) + " PM";
        } else {
            time = n.substring(11, 16) + " AM";
        }

        return time;

    }

    public String getDate() {
        String n = new java.util.Date().toString();
        return n.substring(8, 10) + " / " + n.substring(4, 7) + " / " + n.substring(24);
    }

    public Date requestDate() {
        return new java.util.Date();
    }

    public String timeTaken(Date d1, Date d2) {
        long time = (d2.getTime() - d1.getTime()) / 1000;
        return time + "";
    }

    public String getMonth() {
        String n = new java.util.Date().toString().substring(4, 7);
        switch (n) {
            case "Jan":
                n = "01";
                break;
            case "Feb":
                n = "02";
                break;
            case "Mar":
                n = "03";
                break;
            case "Apr":
                n = "04";
                break;
            case "May":
                n = "05";
                break;
            case "Jun":
                n = "06";
                break;
            case "Jul":
                n = "07";
                break;
            case "Aug":
                n = "08";
                break;
            case "Sep":
                n = "09";
                break;
            case "Oct":
                n = "10";
                break;
            case "Nov":
                n = "11";
                break;
            case "Dec":
                n = "12";
                break;
        }
        return n;
    }

    public String getYear() {
        String n = new java.util.Date().toString();
        return n.substring(24);
    }

    public int getTimeStamp() {
        String n = new java.util.Date().toString();
        return Integer.parseInt(n.substring(24) + getMonth() + n.substring(8, 10));
    }

    public String getDay() {
        int n = new java.util.Date().getDay();
        String d = "";
        switch (n) {
            case 0:
                d = "Sunday";
                break;
            case 1:
                d = "Monday";
                break;
            case 2:
                d = "Tuesday";
                break;
            case 3:
                d = "Wednesday";
                break;
            case 4:
                d = "Thursday";
                break;
            case 5:
                d = "Friday";
                break;
            case 6:
                d = "Saturday";

        }
        return d;

    }

//    public String getTimerTime() {
//        return new java.util.Date().toString().substring(11, 19);
//    }
    public Thread Timer(JLabel obj) {

        Runnable r = new Runnable() {
            int hours = 0;
            int min = 0;
            int sec = 0;
//            JLabel lbl = obj;

            @Override
            public void run() {
                try {
                    while (true) {
                        sec++;
                        if (sec == 60) {
                            sec = 0;
                            min++;
                        }

                        if (min == 60) {
                            min = 0;
                            hours++;
                        }

                        String hr = hours + "";
                        String mn = min + "";
                        String sc = sec + "";

                        if (hr.length() == 1) {
                            hr = "0" + hr;
                        }
                        if (mn.length() == 1) {
                            mn = "0" + mn;

                        }
                        if (sc.length() == 1) {
                            sc = "0" + sc;
                        }
                        obj.setText(hr + "." + mn + "." + sc);
                        Thread.sleep(1000);

                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };

        Thread t = new Thread(r);
        return t;

    }

}
