package umg.edu.progra.arboles;

/**
 * Clase principal que demuestra el uso del Arbol Binario de Busqueda (BST)
 * implementado manualmente, sin usar librerias como java.util.
 *
 * Ejecucion sugerida:
 *   1. mvn compile
 *   2. mvn exec:java -Dexec.mainClass="umg.edu.progra.arboles.Principal"
 *
 * @author Walter Cordova
 */
public class Principal {

    public static void main(String[] args) {

        ArbolBinarioBusqueda arbol = new ArbolBinarioBusqueda();

        /*
         * Insertamos estos valores para formar el siguiente BST:
         *
         *               50
         *              /  \
         *            30    70
         *           /  \   / \
         *          20  40 60  80
         *         /
         *        10
         */
        int[] valores = { 50, 30, 70, 20, 40, 60, 80, 10 };
        for (int v : valores) {
            arbol.insertar(v);
        }

        System.out.println("===== Arbol Binario de Busqueda =====");
        System.out.println("Tamanio: " + arbol.tamanio());
        System.out.println("Altura:  " + arbol.altura());
        System.out.println("Minimo:  " + arbol.minimo());
        System.out.println("Maximo:  " + arbol.maximo());
        System.out.println("Hojas:   " + arbol.contarHojas());

        System.out.println("\n--- Representacion visual (rotada 90 grados) ---");
        arbol.imprimirArbol();

        System.out.println("\n--- Recorridos ---");
        System.out.print("InOrden    (ascendente): ");
        arbol.inOrden();

        System.out.print("PreOrden   (raiz primero): ");
        arbol.preOrden();

        System.out.print("PostOrden  (raiz al final): ");
        arbol.postOrden();

        System.out.print("Por niveles (BFS):         ");
        arbol.recorridoPorNiveles();

        System.out.println("\n--- Busquedas ---");
        System.out.println("Contiene 40? " + arbol.contiene(40));
        System.out.println("Contiene 99? " + arbol.contiene(99));

        System.out.println("\n--- Eliminacion ---");
        System.out.println("Eliminando 20 (nodo con 1 hijo)...");
        arbol.eliminar(20);
        System.out.print("InOrden tras eliminar 20: ");
        arbol.inOrden();

        System.out.println("Eliminando 30 (nodo con 2 hijos)...");
        arbol.eliminar(30);
        System.out.print("InOrden tras eliminar 30: ");
        arbol.inOrden();

        System.out.println("Eliminando 50 (raiz)...");
        arbol.eliminar(50);
        System.out.print("InOrden tras eliminar la raiz: ");
        arbol.inOrden();

        System.out.println("\n--- Estado final ---");
        arbol.imprimirArbol();
        System.out.println("Tamanio final: " + arbol.tamanio());
        System.out.println("Altura final:  " + arbol.altura());

        // --- Pruebas adicionales solicitadas en la tarea ---
        System.out.println("\n--- Ejercicios: contarNodos() y esBalanceado() ---");
        System.out.println("contarNodos() (recursivo): " + arbol.contarNodos());
        System.out.println("esBalanceado() (debe ser true para este arbol): " + arbol.esBalanceado());

        // Arbol claramente desbalanceado: insertar 1,2,3,4,5 en orden
        ArbolBinarioBusqueda desbalanceado = new ArbolBinarioBusqueda();
        int[] seq = {1,2,3,4,5};
        for (int v : seq) {
            desbalanceado.insertar(v);
        }
        System.out.println("\nArbol desbalanceado (insert 1..5):");
        desbalanceado.imprimirArbol();
        System.out.println("esBalanceado() (debe ser false): " + desbalanceado.esBalanceado());

        // --- Problema 3: validar BST ---
        System.out.println("\n--- Prueba esBSTValido() ---");
        System.out.println("esBSTValido() (debe ser true): " + arbol.esBSTValido());

        // Rompemos la propiedad del BST manualmente: colocamos un valor grande en el subarbol izquierdo
        System.out.println("\nRompemos la propiedad del BST (modificando un nodo)...");
        Nodo raiz = arbol.getRaiz();
        if (raiz != null && raiz.izquierdo != null) {
            raiz.izquierdo.dato = 1000; // viola la propiedad (debe ser < 50)
        }
        arbol.imprimirArbol();
        System.out.println("esBSTValido() (debe ser false): " + arbol.esBSTValido());

        /*
         * Ejercicios
         *
         *  1. Implementar un metodo que devuelva la cantidad TOTAL de nodos
         *     usando recursividad (sin usar el campo 'tamanio').
         *  2. Implementar un metodo 'esBalanceado()' que indique si el arbol
         *     esta balanceado (diferencia de alturas <= 1 en cada nodo).
         *  3. Implementar 'esBSTValido()' que verifique que el arbol cumple
         *     la propiedad de BST recorriendo los nodos.
         *  4. Implementar un metodo para encontrar el ancestro comun mas
         *     bajo (LCA) entre dos valores.
         *  5. Implementar la inversion del arbol (espejo).
         */
    }
}
