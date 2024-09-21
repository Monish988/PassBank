package com.example.passbank.Data

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.ViewModelFactoryDsl
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.Date

class PassBankViewModel(private val passrepository: Passrepository):ViewModel(){

    val alldata:LiveData<List<Pass>> = passrepository.alldata.asLiveData()
    val alllogs:LiveData<List<logs>> = passrepository.alllogs.asLiveData()
    fun crtdate():String{
        val dt = SimpleDateFormat("'on 'dd-MM-yyyy ,HH:mm ")
        return dt.format(Date())
    }


    fun addlog(created:String,message:String){
        val log = logs(created = created,message = message)
        viewModelScope.launch {
            passrepository.insertlogs(logs = log)
        }

    }
    fun deletelog(logs: logs){
        viewModelScope.launch {
            passrepository.deletelogs(logs)
        }
    }
    fun clearlogs(){
        viewModelScope.launch {
            passrepository.clearlogs()
        }
    }



    fun addpassword(password:String,email:String,platform:String){
        val pass = Pass(password = password, email =  email, platform =  platform)
        viewModelScope.launch {
            passrepository.insert(pass)
        }
    }
    fun updatepassword(pass: Pass){
        viewModelScope.launch {
            passrepository.update(pass)
        }
    }
    fun deletepassword(pass: Pass){
        viewModelScope.launch {
            passrepository.delete(pass)
        }
    }

}
class passviewmodelfactory(private val passrepository: Passrepository):ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(PassBankViewModel::class.java)){
            @Suppress("UNCHECKED_CAST")
            return PassBankViewModel(passrepository) as T
        }
        else{
            throw IllegalArgumentException("Unknown Viewmodel Class")
        }
    }
}