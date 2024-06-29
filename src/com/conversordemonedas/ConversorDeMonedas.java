package com.conversordemonedas;

import javax.swing.*;

public class ConversorDeMonedas {

    public static void main(String[] args) {
        boolean continueProgram = true;

        while (continueProgram) {
            String[] options = {
                    "Convertir de Pesos Chilenos a Dólar",
                    "Convertir de Pesos Chilenos a Euros",
                    "Convertir de Pesos Chilenos a Libras Esterlinas",
                    "Convertir de Pesos Chilenos a Yen Japonés",
                    "Convertir de Pesos Chilenos a Won sur-coreano"
            };

            String input = (String) JOptionPane.showInputDialog(
                    null,
                    "Seleccione una opción:",
                    "Menú Principal",
                    JOptionPane.PLAIN_MESSAGE,
                    null,
                    options,
                    options[0]
            );

            if (input != null && input.length() > 0) {
                double amount = getAmountFromUser();
                if (amount != -1) {
                    double rate = getExchangeRate(input);
                    double result = amount * rate;
                    JOptionPane.showMessageDialog(null, "El resultado de la conversión es: " + result);
                    continueProgram = deseaContinuar();
                    if (continueProgram) {
                        calcularCostoAlojamiento();
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
            String amountStr = JOptionPane.showInputDialog(
                    null,
                    "Ingrese la cantidad de dinero que desea convertir:"
            );

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

    private static double getExchangeRate(String option) {
        switch (option) {
            case "Convertir de Pesos Chilenos a Dólar":
                return 0.0012;
            case "Convertir de Pesos Chilenos a Euros":
                return 0.0010;
            case "Convertir de Pesos Chilenos a Libras Esterlinas":
                return 0.00085;
            case "Convertir de Pesos Chilenos a Yen Japonés":
                return 0.16;
            case "Convertir de Pesos Chilenos a Won sur-coreano":
                return 1.42;
            default:
                throw new IllegalArgumentException("Opción de conversión no válida");
        }
    }

    private static void calcularCostoAlojamiento() {
        String[] hotelOptions = {
                "Hotel 3 Estrellas (USD 80 por noche)",
                "Hotel 4 Estrellas (USD 120 por noche)",
                "Hotel 5 Estrellas (USD 200 por noche)"
        };

        String hotelSelection = (String) JOptionPane.showInputDialog(
                null,
                "Seleccione el tipo de hotel:",
                "Selección de Hotel",
                JOptionPane.PLAIN_MESSAGE,
                null,
                hotelOptions,
                hotelOptions[0]
        );

        if (hotelSelection != null && hotelSelection.length() > 0) {
            double costoPorNoche = obtenerTarifaHotel(hotelSelection);
            if (costoPorNoche != -1) {
                int numeroNoches = getNumeroNoches();
                if (numeroNoches != -1) {
                    double costoTotal = costoPorNoche * numeroNoches;
                    JOptionPane.showMessageDialog(null, "El costo total por " + numeroNoches + " noches es: USD " + costoTotal);
                    boolean continueHotelCalculation = deseaContinuar();
                    if (continueHotelCalculation) {
                        calcularCostoAlojamiento();
                    }
                }
            }
        }
    }

    private static double obtenerTarifaHotel(String hotelSelection) {
        switch (hotelSelection) {
            case "Hotel 3 Estrellas (USD 80 por noche)":
                return 80.0;
            case "Hotel 4 Estrellas (USD 120 por noche)":
                return 120.0;
            case "Hotel 5 Estrellas (USD 200 por noche)":
                return 200.0;
            default:
                return -1;
        }
    }

    private static int getNumeroNoches() {
        while (true) {
            String nochesStr = JOptionPane.showInputDialog(
                    null,
                    "Ingrese el número de noches:",
                    "Número de Noches",
                    JOptionPane.PLAIN_MESSAGE
            );

            if (nochesStr == null) {
                return -1;
            }

            try {
                return Integer.parseInt(nochesStr);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Valor no válido. Por favor ingrese un número.");
            }
        }
    }

    private static boolean deseaContinuar() {
        String[] options = {"Sí", "No", "Cancelar"};

        int option = JOptionPane.showOptionDialog(
                null,
                "¿Desea continuar usando el programa?",
                "Continuar",
                JOptionPane.YES_NO_CANCEL_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                options,
                options[0]
        );

        switch (option) {
            case JOptionPane.YES_OPTION:
                return true;
            case JOptionPane.NO_OPTION:
                return false;
            case JOptionPane.CANCEL_OPTION:
            case JOptionPane.CLOSED_OPTION:
                JOptionPane.showMessageDialog(null, "Programa Terminado");
                System.exit(0);
                return false;
            default:
                return false;
        }
    }
}