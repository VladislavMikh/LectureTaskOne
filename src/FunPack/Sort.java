package FunPack;

public class Sort {

    int[] input;

    public int MaxSubArrSearch(int start, int stop) {
        if (start > stop) throw new IllegalArgumentException("Начальный индекс массива должен быть меньше конечного");
        if (start == stop) return input[start]; // если в массиве только 1 эл-т то это и есть max подмассив
        int center = (start + stop) / 2;
        int tmpSum = 0;
        int leftSum = 0;
        int rightSum = 0;
        // Поиск наибольшей суммы слева
        for (int i = center; i >= start; i--){
            tmpSum += input[i];
            if (tmpSum > leftSum) leftSum = tmpSum;
        }

        tmpSum = 0; // tmpSum используется в обоих циклах, поэтому обнулил

        // Поиск наибольшей суммы справа
        for (int i = center + 1; i <= stop; i++){
            tmpSum += input[i];
            if (tmpSum > rightSum) rightSum = tmpSum;
        }
        //Рекурсивно разбиваем данную нам часть массива примерно пополам и повтояем все действия над каждой в отдельности
        int centerSum = leftSum + rightSum;
        int leftSubSum = MaxSubArrSearch(start, center);
        int rightSubSum = MaxSubArrSearch(center + 1, stop);
        return Math.max(leftSubSum, Math.max(centerSum,rightSubSum));
    }
}
