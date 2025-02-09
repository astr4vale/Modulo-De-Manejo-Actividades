
package com.codideep.app.dataaccess;

import com.codideep.app.datatransfer.DtoActivity;
import com.codideep.app.repository.RepoActivity;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class QActivity extends QGeneric<DtoActivity> implements RepoActivity {

    @Override
    public int insert(DtoActivity dto) throws SQLException {
        DataBaseContext.generateConnection();

        script = "insert into tactivity(idActivity, name, beginDate, endDate, status, createdAt, updatedAt) values(?, ?, ?, ?, ?, ?, ?)";

        prepareStatement = DataBaseContext.getConnection().prepareStatement(script);

        prepareStatement.setString(1, dto.getIdActivity());
        prepareStatement.setString(2, dto.getName());
        prepareStatement.setTimestamp(3, new java.sql.Timestamp(dto.getBeginDate().getTime()));
        prepareStatement.setTimestamp(4, new java.sql.Timestamp(dto.getEndDate().getTime()));
        prepareStatement.setBoolean(5, dto.isStatus());
        prepareStatement.setTimestamp(6, new java.sql.Timestamp(dto.getCreatedAt().getTime()));
        prepareStatement.setTimestamp(7, new java.sql.Timestamp(dto.getUpdatedAt().getTime()));

        rowsQuantity = prepareStatement.executeUpdate();

        DataBaseContext.closeConnection();

        return rowsQuantity;
    }

    @Override
    public int update(DtoActivity dto) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public DtoActivity getById(String id) throws SQLException {
        DataBaseContext.generateConnection();

        script = "select * from tactivity where id = ?";

        prepareStatement = DataBaseContext.getConnection().prepareStatement(script);

        prepareStatement.setString(1, id);

        resultSet = prepareStatement.executeQuery();

        if (resultSet.next()) {
            dto = new DtoActivity();

            dto.setIdActivity(resultSet.getString("idActivity"));
            dto.setName(resultSet.getString("name"));
            dto.setBeginDate(resultSet.getTimestamp("beginDate"));
            dto.setEndDate(resultSet.getTimestamp("endDate"));
            dto.setStatus(resultSet.getBoolean("status"));
            dto.setCreatedAt(resultSet.getTimestamp("createdAt"));
            dto.setUpdatedAt(resultSet.getTimestamp("updatedAt"));
        }

        DataBaseContext.closeConnection();

        return dto;
    }

    @Override
    public List<DtoActivity> getDataPage(String searchData, int page, int rowsPerPage) throws SQLException {
        DataBaseContext.generateConnection();

        script = "SELECT * FROM tactivity WHERE name LIKE ? LIMIT ? OFFSET ?";
        prepareStatement = DataBaseContext.getConnection().prepareStatement(script);

        prepareStatement.setString(1, "%" + searchData + "%");
        prepareStatement.setInt(2, rowsPerPage);
        prepareStatement.setInt(3, (page - 1) * rowsPerPage);

        resultSet = prepareStatement.executeQuery();
        List<DtoActivity> activities = new ArrayList<>();

        while (resultSet.next()) {
            DtoActivity activity = new DtoActivity();
            activity.setIdActivity(resultSet.getString("idActivity"));
            activity.setName(resultSet.getString("name"));
            activity.setBeginDate(resultSet.getTimestamp("beginDate"));
            activity.setEndDate(resultSet.getTimestamp("endDate"));
            activity.setStatus(resultSet.getBoolean("status"));
            activities.add(activity);
        }

        DataBaseContext.closeConnection();
        return activities;
    }

    @Override
    public int getDataPageQuantity(String searchData) throws SQLException {
        DataBaseContext.generateConnection();

        script = "SELECT COUNT(*) FROM tactivity WHERE name LIKE ?";
        prepareStatement = DataBaseContext.getConnection().prepareStatement(script);
        prepareStatement.setString(1, "%" + searchData + "%");

        resultSet = prepareStatement.executeQuery();
        int total = 0;

        if (resultSet.next()) {
            total = resultSet.getInt(1);
        }

        DataBaseContext.closeConnection();
        return total;
    }

}
