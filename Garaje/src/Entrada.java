public class Entrada {
    public static void main(String[] args) {
        Object[][] garaje = new Object[5][6];
        garaje[0] = new Object[]{"1234A", "Ford", "Fiesta", 90, 10.0, "motor"};
        garaje[1] = new Object[]{"1234B", "Seat", "Ibiza", 150, 50.0, "aceite"};
        garaje[2] = new Object[]{"1234C", "Seat", "Leon", 90, 00.0, "aceite"};
        garaje[3] = new Object[]{"1234D", "VW", "Tiguan", 150, 00.0, "motor"};
        garaje[4] = new Object[]{"1234E", "Opel", "Astra", 75, 00.0, "motor"};

        double acumlado = 0.0;
        for (Object[] coche : garaje) {
            if (coche[0] != null) {
                acumlado += (double) coche[4];
                for (Object item : coche) {
                    System.out.print(item + " ");
                }
                System.out.println();
            }
        }
        System.out.println(acumlado);

        for (Object[] coche : garaje) {
            if (((String) coche[5]).equalsIgnoreCase("motor")) {
                for (Object item : coche) {
                    System.out.print(item + " ");
                }
                System.out.println();
            }

        }

        for (int i = 0; i < garaje.length; i++) {
            if (garaje[i][5].equals("aceite")) {
                if ((Integer) garaje[i][3] > 100) {
                    garaje[i][4] = (double) garaje[i][4] + 100;
                } else {
                    garaje[i][4] = (double) garaje[i][4] + 50;
                }

            }


        }
        for (Object[] coche : garaje) {
            for (Object item : coche) {
                System.out.print(item + " ");
            }
            System.out.println();
        }

    }
}