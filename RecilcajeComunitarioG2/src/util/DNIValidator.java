package util;

public class DNIValidator {

    // Valida que el DNI tenga exactamente 8 dígitos numéricos
    public static boolean esValido(String dni) {
        if (dni == null || dni.length() != 8) {
            return false;
        }

        for (char c : dni.toCharArray()) {
            if (!Character.isDigit(c)) {
                return false;
            }
        }

        return true;
    }
}