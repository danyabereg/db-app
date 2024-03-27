package ru.danyabereg.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
@Getter
public class TableListDto {
    private final String TableName;
    private final List<String> Pk;
}
