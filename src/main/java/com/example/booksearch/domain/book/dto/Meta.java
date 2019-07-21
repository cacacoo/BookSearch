package com.example.booksearch.domain.book.dto;

import com.google.gson.annotations.SerializedName;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Meta {
    @SerializedName("is_end")
    private boolean isEnd;
    @SerializedName("pageable_count")
    private int pageableCount;
    @SerializedName("total_count")
    private int totalCount;
}
