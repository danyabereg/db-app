package ru.danyabereg.service;

import lombok.NoArgsConstructor;
import ru.danyabereg.dao.TableListDao;
import ru.danyabereg.dto.TableListDto;
import ru.danyabereg.mapper.TableListMapper;

import java.util.List;
import java.util.stream.Collectors;

import static lombok.AccessLevel.PRIVATE;

@NoArgsConstructor(access = PRIVATE)
public class TableListService {
    private static final TableListService INSTANCE = new TableListService();
    private final TableListDao tableListDao = TableListDao.getInstance();
    private final TableListMapper tableListMapper = TableListMapper.getInstance();

    public static TableListService getInstance() {
        return INSTANCE;
    }

    public List<TableListDto> findAll() {
        return tableListDao.findAll().stream()
                .map(tableListMapper::mapFrom).collect(Collectors.toList());
    }
}
