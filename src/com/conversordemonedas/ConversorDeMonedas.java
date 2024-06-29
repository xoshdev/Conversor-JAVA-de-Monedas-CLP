package com.conversordemonedas;

import javax.swing.*;

public class ConversorDeMonedas {
    public static void main(String[] args) {
        boolean continueProgram = true;

        while (continueProgram) {
            String[] options = {"Convertir de Pesos Chilenos a Dólar",
                    "Convertir de Pesos Chilenos a Euros",
                    "Convertir de Pesos Chilenos a Libras Esterlinas",
                    "Convertir de Pesos Chilenos a Yen Japonés",
                    "Convertir de Pesos Chilenos a Won sur-coreano",
                    "Convertir de Dólar a Pesos Chilenos",
                    "Convertir de Euros a Pesos Chilenos",
                    "Convertir de Libras Esterlinas a Pesos Chilenos",
                    "Convertir de Yen Japonés a Pesos Chilenos",
                    "Convertir de Won sur-coreano a Pesos Chilenos"};

            String input = (String) JOptionPane.showInputDialog(null,
                    "Seleccione una opción de conversión:",
                    "Menú Principal",
                    JOptionPane.PLAIN_MESSAGE,
                    null,
                    options,
                    options[0]);

            if (input != null && input.length() > 0) {
                double amount = getAmountFromUser();
                if (amount != -1) {
                    double result = performConversion(input, amount);
                    JOptionPane.showMessageDialog(null,
                            "El resultado de la conversión es: " + result);
                    int response = JOptionPane.showConfirmDialog(null,
                            "¿Desea realizar otra conversión?",
                            "Continuar",
                            JOptionPane.YES_NO_CANCEL_OPTION);

                    if (response == JOptionPane.NO_OPTION || response == JOptionPane.CANCEL_OPTION) {
                        JOptionPane.showMessageDialog(null, "Programa Terminado");
                        continueProgram = false;
                    }
                }
            } else {
                JOptionPane.showMessageDialog(null, "Programa Terminado");
                continueProgram = false;
            }
        }
    }

    private static double getAmountFromUser() {
        while (true) {
            String amountStr = JOptionPane.showInputDialog(null,
                    "Ingrese la cantidad de dinero que desea convertir:");

            if (amountStr == null) {
                return -1;
            }

            try {
                return Double.parseDouble(amountStr);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Valor no válido. Por favor ingrese un número.");
            }
        }
    }

    private static double performConversion(String option, double amount) {
        final double USD_TO_CLP = 0.0013; // Tasa de cambio USD.
        final double EUR_TO_CLP = 0.0011; // Tasa de cambio EUR.
        final double GBP_TO_CLP = 0.0009; // Tasa de cambio GBP.
        final double JPY_TO_CLP = 0.18; // Tasa de cambio JPY.
        final double KRW_TO_CLP = 1.45; // Tasa de cambio KRW.

        switch (option) {
            case "Convertir de Pesos Chilenos a Dólar":
                return amount * USD_TO_CLP;
            case "Convertir de Pesos Chilenos a Euros":
                return amount * EUR_TO_CLP;
            case "Convertir de Pesos Chilenos a Libras Esterlinas":
                return amount * GBP_TO_CLP;
            case "Convertir de Pesos Chilenos a Yen Japonés":
                return amount * JPY_TO_CLP;
            case "Convertir de Pesos Chilenos a Won sur-coreano":
                return amount * KRW_TO_CLP;
            case "Convertir de Dólar a Pesos Chilenos":
                return amount / USD_TO_CLP;
            case "Convertir de Euros a Pesos Chilenos":
                return amount / EUR_TO_CLP;
            case "Convertir de Libras Esterlinas a Pesos Chilenos":
                return amount / GBP_TO_CLP;
            case "Convertir de Yen Japonés a Pesos Chilenos":
                return amount / JPY_TO_CLP;
            case "Convertir de Won sur-coreano a Pesos Chilenos":
                return amount / KRW_TO_CLP;
            default:
                throw new IllegalArgumentException("Opción de conversión no válida");
        }
    }
}

