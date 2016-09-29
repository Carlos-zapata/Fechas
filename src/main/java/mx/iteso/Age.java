package mx.iteso;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JOptionPane;
/**
 * Created by Carlos Flores on 29/09/2016.
 */
public class Age {


        public static String requestBirthDate (){
            String inputString;
            return inputString = JOptionPane.showInputDialog(null, "Introducir fecha (dd/MM/YYYY):");


        }
        public static String Validate(String input){

            try{
                if(input.length() == 10)
                    if(input.charAt(2) == '/' && input.charAt(5) == '/'){
                        if(Integer.parseInt(input.substring(0, 2)) < 0 || Integer.parseInt(input.substring(0, 2)) > 31 ){
                            JOptionPane.showMessageDialog(null,"Fecha inválida, día fuera de rango.", "Fecha inválida", JOptionPane.ERROR_MESSAGE);
                            return "Día inválido";}

                        if(Integer.parseInt(input.substring(3, 5)) < 0 || Integer.parseInt(input.substring(3, 5)) > 12 ){
                            JOptionPane.showMessageDialog(null,"Fecha inválida, mes fuera de rango.", "Fecha inválida", JOptionPane.ERROR_MESSAGE);
                            return "Mes inválido";}
                        if(Integer.parseInt(input.substring(6, 10)) < 0 || Integer.parseInt(input.substring(6, 10)) > 2016 ){
                            JOptionPane.showMessageDialog(null,"Fecha inválida, año fuera de rango.", "Fecha inválida", JOptionPane.ERROR_MESSAGE);
                            return "Año inválido";}
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null,"Formato inválido", "Formato inválido", JOptionPane.ERROR_MESSAGE);
                        return "Formato inválido";
                    }
                else{
                    JOptionPane.showMessageDialog(null,"Formato inválido", "Formato inválido", JOptionPane.ERROR_MESSAGE);
                    return "Formato inválido";
                }
            }catch(Exception e){
                JOptionPane.showMessageDialog(null,"Formato inválido", "Formato inválido", JOptionPane.ERROR_MESSAGE);
                return "Formato inválido";
            }
            return input;
        }

        public static String getAge(String date){

            int cday = Calendar.getInstance().get(Calendar.DAY_OF_MONTH);
            int cmonth = Calendar.getInstance().get(Calendar.MONTH) + 1;
            int cyear = Calendar.getInstance().get(Calendar.YEAR);
            int myDay = 0, myMonth = 0, myYear = 0;
            int resultYear = 0, resultDay = 0, resultMonth = 0;


            myDay = Integer.parseInt(date.substring(0, 2));
            myMonth = Integer.parseInt(date.substring(3, 5));
            myYear = Integer.parseInt(date.substring(6, 10));

            if (myYear <= cyear){
                if (myMonth < cmonth){
                    resultYear = cyear - myYear;
                    if(cday <= myDay){
                        resultMonth = cmonth - myMonth;
                        resultDay = cday - myDay;
                    }
                    else {
                        resultMonth = cmonth - myMonth - 1;
                        switch (myMonth){
                            case 1: resultDay = cday + (31 - myDay);
                            case 2: resultDay = cday + (28 - myDay);
                            case 3: resultDay = cday + (31 - myDay);
                            case 4: resultDay = cday + (30 - myDay);
                            case 5: resultDay = cday + (31 - myDay);
                            case 6: resultDay = cday + (30 - myDay);
                            case 7: resultDay = cday + (31 - myDay);
                            case 8: resultDay = cday + (31 - myDay);
                            case 9: resultDay = cday + (30 - myDay);
                            case 10: resultDay = cday + (31 - myDay);
                            case 11: resultDay = cday + (30 - myDay);
                            case 12: resultDay = cday + (31 - myDay);
                        }
                    }

                }

                else if (myMonth == cmonth){
                    if(myDay < cday){
                        resultYear = cyear - myYear - 1;
                        resultMonth = 11;
                        resultDay = cday - myDay;}
                    else{
                        resultYear = cyear - myYear;
                        resultMonth = 0;
                        switch (myMonth){
                            case 1: resultDay = cday + (31 - myDay);
                            case 2: resultDay = cday + (28 - myDay);
                            case 3: resultDay = cday + (31 - myDay);
                            case 4: resultDay = cday + (30 - myDay);
                            case 5: resultDay = cday + (31 - myDay);
                            case 6: resultDay = cday + (30 - myDay);
                            case 7: resultDay = cday + (31 - myDay);
                            case 8: resultDay = cday + (31 - myDay);
                            case 9: resultDay = cday + (30 - myDay);
                            case 10: resultDay = cday + (31 - myDay);
                            case 11: resultDay = cday + (30 - myDay);
                            case 12: resultDay = cday + (31 - myDay);}
                    }
                }
                else
                    resultYear = cyear - myYear - 1;
                if (myDay >= cday){
                    resultMonth = 12 - (myMonth - cmonth) - 1;
                    switch (myMonth){
                        case 1: resultDay = cday + (31 - myDay);
                        case 2: resultDay = cday + (28 - myDay);
                        case 3: resultDay = cday + (31 - myDay);
                        case 4: resultDay = cday + (30 - myDay);
                        case 5: resultDay = cday + (31 - myDay);
                        case 6: resultDay = cday + (30 - myDay);
                        case 7: resultDay = cday + (31 - myDay);
                        case 8: resultDay = cday + (31 - myDay);
                        case 9: resultDay = cday + (30 - myDay);
                        case 10: resultDay = cday + (31 - myDay);
                        case 11: resultDay = cday + (30 - myDay);
                        case 12: resultDay = cday + (31 - myDay);
                    }}
                else if (myDay < cday){
                    resultMonth = 12 - (myMonth - cmonth);
                    resultDay = cday - myDay;}

            }

            JOptionPane.showMessageDialog(null, "Tienes " + resultDay + " días, " + resultMonth + " meses y " + resultYear + " años.", "Tu edad", JOptionPane.INFORMATION_MESSAGE);
            return resultYear + " años " + resultMonth + " meses y " + resultDay + " días";
        }

        public static void main (String[] args){
            String myBirthDate = requestBirthDate();
            String Valid=Validate (myBirthDate);

            if (Valid.length() == 10){
                getAge(Valid);}
        }


    }

