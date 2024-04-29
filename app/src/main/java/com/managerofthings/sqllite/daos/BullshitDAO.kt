package com.managerofthings.sqllite.daos

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import com.managerofthings.sqllite.tables.Bullshit
import com.managerofthings.sqllite.tables.BullshitWithCategories

@Dao
interface BullshitDAO {

    @Query("SELECT * FROM bullshit")
    fun getAll(): List<Bullshit>

    @Query("SELECT * FROM bullshit WHERE id IN (:idBullshit)")
    fun getBullshitId(idBullshit: Int): Bullshit

    @Query("SELECT * FROM bullshit WHERE name IN (:nameBullshit)")
    fun getBullshitName(nameBullshit: String): List<Bullshit>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertBullshit(bullshit: Bullshit)

    @Transaction
    @Query("SELECT * FROM bullshit WHERE id = :bullshitId")
    suspend fun getSchoolWithStudents(bullshitId: Int): List<BullshitWithCategories>

    @Delete
    fun delete(bullshit: Bullshit)
}