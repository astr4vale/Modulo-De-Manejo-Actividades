
package com.codideep.app.business;

import com.codideep.app.dataaccess.QActivity;
import com.codideep.app.datatransfer.DtoActivity;
import com.codideep.app.datatransfer.DtoMessageObject;
import com.codideep.app.repository.RepoActivity;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.UUID;


public class BusinessActivity extends BusinessGeneric {

    private RepoActivity repoActivity = null;
    private DtoActivity dtoActivity = null;

    public BusinessActivity() {
        this.repoActivity = new QActivity();
        dtoActivity = new DtoActivity();
    }

    public DtoMessageObject insert(
            String name,
            int beginDay,
            int beginMonth,
            int beginYear,
            int beginHour,
            int beginMinute,
            int endDay,
            int endMonth,
            int endYear,
            int endHour,
            int endMinute
    ) throws SQLException {
        dtoActivity.setIdActivity(UUID.randomUUID().toString());
        dtoActivity.setStatus(true);
        dtoActivity.setCreatedAt(new Date());
        dtoActivity.setUpdatedAt(dtoActivity.getCreatedAt());
        
        dtoActivity.setName(name);
        
        Calendar beginDate = Calendar.getInstance();
        
        beginDate.set(Calendar.DAY_OF_MONTH, beginDay);
        beginDate.set(Calendar.MONTH, beginMonth - 1);
        beginDate.set(Calendar.YEAR, beginYear);
        beginDate.set(Calendar.HOUR, beginHour);
        beginDate.set(Calendar.MINUTE, beginMinute);
        
        dtoActivity.setBeginDate(beginDate.getTime());
        
        Calendar endDate = Calendar.getInstance();
        
        endDate.set(Calendar.DAY_OF_MONTH, endDay);
        endDate.set(Calendar.MONTH, endMonth - 1);
        endDate.set(Calendar.YEAR, endYear);
        endDate.set(Calendar.HOUR, endHour);
        endDate.set(Calendar.MINUTE, endMinute);
        
        dtoActivity.setEndDate(endDate.getTime());

        repoActivity.insert(dtoActivity);

        dtoMessageObject.addMessage("Registro realizado correctamente.");
        dtoMessageObject.setSuccess();

        return dtoMessageObject;
    }

    public int getDataPageQuantity(String searchData) throws SQLException {
        return repoActivity.getDataPageQuantity(searchData);
    }

    public List<DtoActivity> getDataPage(String searchData, int page, int rowsPerPage) throws SQLException {
        return repoActivity.getDataPage(searchData, page, rowsPerPage);
    }

}
