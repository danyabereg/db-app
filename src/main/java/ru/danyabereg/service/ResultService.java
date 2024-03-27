package ru.danyabereg.service;

import lombok.NoArgsConstructor;
import ru.danyabereg.dto.TableListDto;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static lombok.AccessLevel.PRIVATE;

@NoArgsConstructor(access = PRIVATE)
public class ResultService {
    private static final ResultService INSTANCE = new ResultService();
    private static final String FILE = "C:\\Users\\danya_pnuruns\\IdeaProjects\\db-app\\src\\main\\output.txt";
    private final TableColsService tableColsService = TableColsService.getInstance();
    private final TableListService tableListService = TableListService.getInstance();

    public static ResultService getInstance() {
        return INSTANCE;
    }

    public void getResultOutput() {
        List<String> rows = buildResultTable();
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE))) {
            for (String row : rows) {
                writer.write(row);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private List<String> buildResultTable() {
        List<String> resultTable = new ArrayList<>();
        List<TableListDto> listDtos = tableListService.findAll();
        for (var table : listDtos) {
            var cols = tableColsService.findByTableName(table.getTableName());
            for (var pk : table.getPk()) {
                for (var col : cols) {
                    if (col.getColumnName().equalsIgnoreCase(pk)) {
                        resultTable.add(String.format("%s, %s, %s\n", table.getTableName(), pk, col.getColumnType()));
                    }
                }
            }
        }
        return resultTable;
    }
}
