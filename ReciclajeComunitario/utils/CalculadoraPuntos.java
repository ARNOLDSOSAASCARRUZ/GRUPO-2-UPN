package utils;

import model.Material;

public class CalculadoraPuntos {

    public int calcular(Material material) {
        String tipo = material.getTipo();
        double peso = material.getPeso();

        switch (tipo) {
            case "Plástico":
                return (int) (peso * 2); // 2 puntos por kg
            case "Papel":
                return (int) (peso * 1); // 1 punto por kg
            case "Metal":
                return (int) (peso * 3); // 3 puntos por kg
            default:
                return 0;
        }
    }
}