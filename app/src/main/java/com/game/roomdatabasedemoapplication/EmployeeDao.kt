package com.game.roomdatabasedemoapplication

import androidx.room.*

@Dao
interface EmployeeDao {

    @Insert
    suspend fun insert(employeeEntity: EmployeeEntity)

    @Update
    suspend fun update(employeeEntity: EmployeeEntity)

    @Delete
    suspend fun delete(employeeEntity: EmployeeEntity)

    @Query("SELECT * FROM `employee-table`")
    fun fetchAllEmployees():kotlinx.coroutines.flow.Flow<List<EmployeeEntity>>

    @Query("SELECT * FROM `employee-table` where id = :id")
    fun fetchAllEmployeeById(id : Int):kotlinx.coroutines.flow.Flow<EmployeeEntity>
}