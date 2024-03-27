package ru.danyabereg.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class TableColsDto {
    private final String TableName;
    private final String ColumnName;
    private final String ColumnType;
}
