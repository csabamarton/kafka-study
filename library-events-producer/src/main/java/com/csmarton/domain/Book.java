package com.csmarton.domain;

import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Book {
    @NotNull
    private Integer boolId;
    @NotBlank
    private String bookName;
    @NotBlank
    private String bookAuthor;
}
