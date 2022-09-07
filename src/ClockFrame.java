import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class ClockFrame extends JFrame {

    Calendar calendar;
    SimpleDateFormat timeFormat;
    SimpleDateFormat dayFormat;
    JLabel timeLabel;
    JLabel dayLabel;
    String time;
    String day;
    ClockFrame(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Time");
        this.setLayout(new FlowLayout());
        this.setSize(600,200);
        this.setResizable(false);


        timeFormat = new SimpleDateFormat("HH:mm:ss");
        dayFormat = new SimpleDateFormat("EEEE, dd-MM-yyyy", Locale.ENGLISH);

        timeLabel = new JLabel();
        timeLabel.setFont(new Font("Georgia", Font.PLAIN, 50));
        timeLabel.setBackground(Color.LIGHT_GRAY);

        dayLabel = new JLabel();
        dayLabel.setFont(new Font("Georgia", Font.PLAIN, 50));

        this.add(timeLabel);
        this.add(dayLabel);

        this.setVisible(true);

        setTime();
    }

    public void setTime(){
        while(true){
            time = timeFormat.format(Calendar.getInstance().getTime());
            timeLabel.setText(time);


            day = dayFormat.format(Calendar.getInstance().getTime());
            dayLabel.setText(day);

            try{
                Thread.sleep(1000);
            } catch(InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}
