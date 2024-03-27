package ru.danyabereg.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
@Getter
@EqualsAndHashCode
@Builder
public class TableList {
    private String tableName;
    private List<String> pk;
}
