package com.ibrahim.spring.lesson02.task03_rest_resource_design;

import java.time.format.DateTimeFormatter;
import java.util.List;

public class PagedResponse<T> extends ApiResponse<List<T>> {
    private final int page;
    private final int size;
    private final long totalElements;
    private final long totalPages;


    private PagedResponse(List<T> content, int page, int size, long totalElements) {
        super(200, "OK", content);
        this.page = page;
        this.size = size;
        this.totalElements = totalElements;
        this.totalPages = size == 0 ? 0 : (int) Math.ceil((double) totalElements / size);
    }

    public static <T> PagedResponse<T> of(List<T> content, int page, int size, long totalElements) {
        return new PagedResponse<>(content, page, size, totalElements);
    }

    public static <T> PagedResponse<T> of(List<T> allItems, int page, int size) {
        int from = Math.min(page * size, allItems.size());
        int to = Math.min(from + size, allItems.size());
        List<T> slice = allItems.subList(from, to);
        return new PagedResponse<>(slice, page, size, allItems.size());
    }

    public int getPage() {
        return page;
    }

    public long getTotalElements() {
        return totalElements;
    }

    public int getSize() {
        return size;
    }

    public long getTotalPages() {
        return totalPages;
    }

    @Override
    public String toString() {
        String ts = getTimestamp().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);
        return String.format("""
                        {
                          "status"        : %d,
                          "message"       : "%s",
                          "timestamp"     : "%s",
                          "page"          : %d,
                          "size"          : %d,
                          "totalElements" : %d,
                          "totalPages"    : %d,
                          "data"          : %s
                        }""",
                getStatus(), getMessage(), ts,
                page, size, totalElements, totalPages,
                formatData(getData()));
    }
}
