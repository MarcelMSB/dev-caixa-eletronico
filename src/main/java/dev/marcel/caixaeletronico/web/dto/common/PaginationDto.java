package dev.marcel.caixaeletronico.web.dto.common;

import java.util.ArrayList;
import java.util.List;

public class PaginationDto<E> {

    private int limit;
    private int offset;
    private int total;
    private boolean next;
    private List<E> content = new ArrayList<>();

    public PaginationDto(int limit, int offset, int total, boolean next, List<E> content) {
        this.limit = limit;
        this.offset = offset;
        this.total = total;
        this.next = next;
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

    public boolean hasNext() {
        return next;
    }

    public List<E> getContent() {
        return content;
    }
}
