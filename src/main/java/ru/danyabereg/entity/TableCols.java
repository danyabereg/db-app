package ru.danyabereg.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@AllArgsConstructor
@Getter
@EqualsAndHashCode
@Builder
public class TableCols {
    private String tableName;
    private String columnName;
    private String columnType;
}
