public class Search {

    public static void main(String[] args) {
        int[] numbers = new int[]{45, 1, 1, 1, 0, 0, -3, -5, -48};         //Posortowana tablica w porządku rosnącym
        int x = 0;                                                         //Numer

        System.out.println(new Search().search(numbers, x));               //Wdrażanie metody search
    }

    private boolean search(int[] numbers, int x) {                        //Metoda search
        int firstIndex = 0;
        int lastIndex = numbers.length - 1;
        int midleIndex = (firstIndex + lastIndex) / 2;

        /*Jeżeli wartość liczby nie jest większa lub mniejsza niż
         maksymalne i minimalne wartości tablicy, to liczba nie może
         tam być i nie jest wykonywane dalsze wyszukiwanie.
         Złożoność obliczeniową algorytmy O(1), pamięciową O(1)*/

        if ((x > numbers[firstIndex]) && (x < numbers[lastIndex])) {
            return false;
        }

        /* Algorytm wyszukiwania binarnego dla podanej liczby.
         Z każdą iteracją liczba wyszukiwań zmniejsza się o połowę.
         Złożoność obliczeniową algorytmy O(log n), pamięciową O(1)*/


        while (firstIndex <= lastIndex) {
            if (x == numbers[midleIndex]) {
                return true;
            } else if (x < numbers[midleIndex]) {
                firstIndex = midleIndex + 1;
            } else {
                lastIndex = midleIndex - 1;
            }
            midleIndex = (firstIndex + lastIndex) / 2;

        }
        return false;
    }
}











