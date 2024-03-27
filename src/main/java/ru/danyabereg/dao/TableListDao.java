package ru.danyabereg.dao;

import lombok.NoArgsConstructor;
import ru.danyabereg.entity.TableList;
import ru.danyabereg.utils.ConnectionManager;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static lombok.AccessLevel.PRIVATE;

@NoArgsConstructor(access = PRIVATE)
public class TableListDao {
    private static final TableListDao INSTANCE = new TableListDao();
    private static final String SQL_FIND_ALL = "SELECT * FROM TABLE_LIST";

    public static TableListDao getInstance() {
        return INSTANCE;
    }

    private TableList buildTableList(ResultSet resultSet) throws SQLException {
        return TableList.builder()
                .tableName(resultSet.getObject("TABLE_NAME", String.class))
                .pk(Arrays.asList(resultSet.getObject("PK", String.class).split(", ")))
                .build();
    }

    public List<TableList> findAll() {
        try (var connection = ConnectionManager.get();
             var statement = connection.prepareStatement(SQL_FIND_ALL)) {
            List<TableList> tables = new ArrayList<>();
            var result = statement.executeQuery();
            while (result.next())
                tables.add(
                        buildTableList(result)
                );
            return tables;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
