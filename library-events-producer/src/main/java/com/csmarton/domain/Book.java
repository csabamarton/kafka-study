package com.csmarton.domain;

import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Book {
    private Integer bookId;
    @NotBlank
    private String bookName;
    @NotBlank
    private String bookAuthor;
}
