package com.example.passbank.Data

import kotlinx.coroutines.flow.Flow

class Passrepository(private val db:PassDao,private val ld:LogsDAO) {


    val alldata:Flow<List<Pass>> =db.getalldata()
    suspend fun insert(pass: Pass){
        db.insert(pass)
    }
    suspend fun update(pass: Pass){
        db.update(pass)
    }
    suspend fun delete(pass: Pass){
        db.delete(pass)
    }


    val alllogs:Flow<List<logs>> = ld.getalllogs()
    suspend fun insertlogs(logs: logs){
        ld.insertlog(logs)
    }
    suspend fun deletelogs(logs: logs){
        ld.deletelog(logs)
    }
    suspend fun clearlogs(){
        ld.deletealllogs()
    }

}