package ru.danyabereg.mapper;

import ru.danyabereg.dto.TableColsDto;
import ru.danyabereg.entity.TableCols;

public class TableColsMapper implements Mapper<TableColsDto, TableCols> {
    private static final TableColsMapper INSTANCE = new TableColsMapper();

    public static TableColsMapper getInstance() {
        return INSTANCE;
    }

    @Override
    public TableColsDto mapFrom(TableCols tableCols) {
        return new TableColsDto(tableCols.getTableName(),
                tableCols.getColumnName(),
                tableCols.getColumnType());
    }
}
