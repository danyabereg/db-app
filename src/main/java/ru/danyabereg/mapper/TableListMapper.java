package ru.danyabereg.mapper;

import lombok.NoArgsConstructor;
import ru.danyabereg.dto.TableListDto;
import ru.danyabereg.entity.TableList;

import static lombok.AccessLevel.PRIVATE;

@NoArgsConstructor(access = PRIVATE)
public class TableListMapper implements Mapper<TableListDto, TableList> {
    private static final TableListMapper INSTANCE = new TableListMapper();

    public static TableListMapper getInstance() {
        return INSTANCE;
    }

    @Override
    public TableListDto mapFrom(TableList tableList) {
        return new TableListDto(tableList.getTableName(), tableList.getPk());
    }
}
