package com.aor.numbers;

import com.aor.numbers.GenericListFilter;

public class PositiveFilter implements GenericListFilter {
    @Override
    public boolean accept(Integer number) {
        return number > 0;
    }
}