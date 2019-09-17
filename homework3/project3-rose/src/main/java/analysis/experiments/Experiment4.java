package analysis.experiments;

import analysis.utils.AnalysisUtils;
import analysis.utils.PlotWindow;
import analysis.utils.SortingAlgorithms;
import datastructures.lists.IList;
import misc.Sorter;

import java.util.function.LongUnaryOperator;

public class Experiment4 {
    public static final long MAX_LIST_SIZE = 200000;
    public static final long STEP = 2000;
    public static final int K = 50;

    public static void main(String[] args) {
        IList<Long> listSizes = AnalysisUtils.makeDoubleLinkedList(0L, MAX_LIST_SIZE, STEP);

        PlotWindow.launch("Experiment 4", "n", "Elapsed Time (ms)",
                new LongUnaryOperator[]{Experiment4::testHeap, Experiment4::testQuick, Experiment4::testMerge},
                new String[]{"heap sort", "quick sort", "merge sort"}, listSizes, 2, .01);
    }

    public static long testHeap(long listSize) {
        IList<Long> list = AnalysisUtils.makeRandomDoubleLinkedList(listSize);

        long start = System.currentTimeMillis();
        Sorter.topKSort(K, list);
        return System.currentTimeMillis() - start;
    }

    public static long testQuick(long listSize) {
        IList<Long> list = AnalysisUtils.makeRandomDoubleLinkedList(listSize);

        long start = System.currentTimeMillis();
        SortingAlgorithms.quickTopKSort(K, list);
        return System.currentTimeMillis() - start;
    }

    public static long testMerge(long listSize) {
        IList<Long> list = AnalysisUtils.makeRandomDoubleLinkedList(listSize);

        long start = System.currentTimeMillis();
        SortingAlgorithms.mergeTopKSort(K, list);
        return System.currentTimeMillis() - start;
    }
}
