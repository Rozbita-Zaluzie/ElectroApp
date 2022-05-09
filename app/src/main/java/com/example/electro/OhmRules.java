package com.example.electro;

import android.app.ListActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;

public class OhmRules {

   String[] ohms = {"pΩ","nΩ","µΩ","mΩ", "Ω","kΩ","MΩ"};

   private int compareUnits(String type, String unit) {
       int toReturn = 0;
       switch (type) {
           case "R":
               for (int i = 0; i < ohms.length; i++) {
                   if (ohms[i] == unit) {
                       if (i < 3) {
                           toReturn = (4 - i) * 3;
                       } else {
                           toReturn = (i - 4) * 3;
                       }
                   }
               }
       }
       return toReturn;
   }

    public double toBasicUnits(double num, String type, String unit) {
       double unitBack = 0;
        System.out.println();
        switch (type) {
            case "R":
                unitBack = num * Math.pow(10, compareUnits(type, unit));
                System.out.println(num);
                System.out.println(compareUnits(type, unit));
                break;
        }
        return unitBack;
    }

    public boolean isBasicUnit(String unit) {
       if (unit == "V" || unit == "A" || unit == "Ω") {
        return true;
       } else {
           return false;
       }
    }


    public double Calc (String mode, double num1, String num1unit ,double num2, String num2unit) {

       double num1basic = 0.0;
       double num2basic = 0.0;

       // to basic units
       if (!isBasicUnit(num1unit))
        return toBasicUnits(num1, type, num1unit);
    }





}
