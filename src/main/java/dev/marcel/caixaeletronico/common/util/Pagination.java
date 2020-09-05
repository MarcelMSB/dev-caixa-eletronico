package dev.marcel.caixaeletronico.common.util;

import java.util.ArrayList;
import java.util.List;

public class Pagination<E> {

    private final int limit;
    private final int offset;
    private final int total;
    private List<E> content = new ArrayList<>();

    public Pagination(int limit, int offset, int total, List<E> content) {
        this.limit = limit;
        this.offset = offset;
        this.total = total;
        this.content = content;
    }

    public int getLimit() {
        return limit;
    }

    public int getOffset() {
        return offset;
    }

    public int getTotal() {
        return total;
    }

    public List<E> getContent() {
        return content;
    }

    public boolean hasNext() {
        return (offset + limit) < total;
    }
}
