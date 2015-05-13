package com.maximegens.chticharivari.utils;

import java.text.DecimalFormat;

public class Conversion {

        /**
         * Convertie la distance de métre en kilométre.
         * @param metre La distance en métre
         * @return float La distance en kilométre.
         */
        public static float metreToKm(float metre){
            String result;
            DecimalFormat df = new DecimalFormat("#####.##");
            result = df.format(metre * 0.001);
            return Float.parseFloat(result.replace(',', '.'));
        }
}
