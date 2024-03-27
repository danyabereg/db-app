package ru.danyabereg.service;

import lombok.NoArgsConstructor;
import ru.danyabereg.dao.TableColsDao;
import ru.danyabereg.dto.TableColsDto;
import ru.danyabereg.mapper.TableColsMapper;

import java.util.List;
import java.util.stream.Collectors;

import static lombok.AccessLevel.PRIVATE;

@NoArgsConstructor(access = PRIVATE)
public class TableColsService {
    private static final TableColsService INSTANCE = new TableColsService();
    private final TableColsDao tableColsDao = TableColsDao.getInstance();
    private final TableColsMapper tableColsMapper = TableColsMapper.getInstance();

    public static TableColsService getInstance() {
        return INSTANCE;
    }

    public List<TableColsDto> findAll() {
        return tableColsDao.findAll().stream()
                .map(tableColsMapper::mapFrom).collect(Collectors.toList());
    }

    public List<TableColsDto> findByTableName(String tableName) {
        return tableColsDao.findAllByTableName(tableName).stream()
                .map(tableColsMapper::mapFrom).collect(Collectors.toList());
    }
}
