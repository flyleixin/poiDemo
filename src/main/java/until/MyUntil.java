package until;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MyUntil {


    public static Integer findNum(String nickname){
        String result = "";
        int cnt = 0;
        int flag = 0;
        for(int i = 0;i<nickname.length();i++){
            if('0'<=nickname.charAt(i)&&nickname.charAt(i)<='9'){
                cnt++;
                result+=nickname.charAt(i);
                if(cnt==8){
                    flag = 1;
                    break;
                }
            }
            else{
                cnt = 0;
                result ="";
            }


        }
        if(flag == 1){
            return Integer.parseInt(result);
        }
        else{
            return -1;
        }
    }

    public static double StrToDate(String string) throws ParseException {

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        string  = "2022-04-10 "+string;
        Date date = format.parse(string);
        Date dateOrigin = format.parse("2022-04-10 00:00:00");
        double minute = 1.0*(date.getTime()-dateOrigin.getTime())/(60000);
        return minute;
    }
}
