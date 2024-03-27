package ru.danyabereg.dao;

import lombok.NoArgsConstructor;
import ru.danyabereg.entity.TableCols;
import ru.danyabereg.utils.ConnectionManager;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static lombok.AccessLevel.PRIVATE;

@NoArgsConstructor(access = PRIVATE)
public class TableColsDao {
    private static final TableColsDao INSTANCE = new TableColsDao();
    private static final String SQL_FIND_ALL = "SELECT * FROM TABLE_COLS";
    private static final String SQL_FIND_ALL_BY_TABLE_NAME = "SELECT * FROM TABLE_COLS WHERE TABLE_NAME = ?";

    public static TableColsDao getInstance() {
        return INSTANCE;
    }

    private TableCols buildTableCols(ResultSet resultSet) throws SQLException {
        return TableCols.builder()
                .tableName(resultSet.getObject("TABLE_NAME", String.class))
                .columnName(resultSet.getObject("COLUMN_NAME", String.class))
                .columnType(resultSet.getObject("COLUMN_TYPE", String.class))
                .build();
    }

    public List<TableCols> findAll() {
        try (var connection = ConnectionManager.get();
             var statement = connection.prepareStatement(SQL_FIND_ALL)) {
            List<TableCols> tableCols = new ArrayList<>();
            var result = statement.executeQuery();
            while (result.next())
                tableCols.add(
                        buildTableCols(result)
                );
            return tableCols;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<TableCols> findAllByTableName(String tableName) {
        try (var connection = ConnectionManager.get();
             var statement = connection.prepareStatement(SQL_FIND_ALL_BY_TABLE_NAME)) {
            statement.setString(1, tableName);
            List<TableCols> tableCols = new ArrayList<>();
            var result = statement.executeQuery();
            while (result.next())
                tableCols.add(
                        buildTableCols(result)
                );
            return tableCols;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
