package com.aor.numbers;

import com.aor.numbers.GenericListFilter;
import com.aor.numbers.ListFilterer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;

public class ListFiltererTest {

    @Test
    public void filter_positiveFilter_shouldFilterPositiveNumbers() {
        List<Integer> list = Arrays.asList(-2, 0, 5, -8, 10);

        GenericListFilter positiveFilter = new PositiveFilter();
        ListFilterer filterer = new ListFilterer(positiveFilter);
        List<Integer> filteredList = filterer.filter(list);

        Assertions.assertEquals(Arrays.asList(5, 10), filteredList);
    }

    @Test
    public void filter_divisibleByFilter_shouldFilterDivisibleNumbers() {
        List<Integer> list = Arrays.asList(3, 8, 15, 7, 20);

        GenericListFilter divisibleByFilter = new DivisibleByFilter(5);
        ListFilterer filterer = new ListFilterer(divisibleByFilter);
        List<Integer> filteredList = filterer.filter(list);

        Assertions.assertEquals(Arrays.asList(15, 20), filteredList);
    }

    @Test
    public void filter_withEmptyList_shouldReturnEmptyList() {
        List<Integer> list = Arrays.asList();

        GenericListFilter filterStub = Mockito.mock(GenericListFilter.class);
        ListFilterer filterer = new ListFilterer(filterStub);
        List<Integer> filteredList = filterer.filter(list);

        Assertions.assertEquals(0, filteredList.size());
    }

    @Test
    public void filter_withStub_shouldFilterAccordingToStub() {
        List<Integer> list = Arrays.asList(2, 5, 8, 10, 15);

        // Using Mockito to create a stub for GenericListFilter
        GenericListFilter filterStub = Mockito.mock(GenericListFilter.class);
        Mockito.when(filterStub.accept(Mockito.anyInt())).thenReturn(true); // Stubbing to accept all numbers

        ListFilterer filterer = new ListFilterer(filterStub);
        List<Integer> filteredList = filterer.filter(list);

        Assertions.assertEquals(list, filteredList);
    }
}