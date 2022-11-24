package developer.bekzod.dbreferenses.Db

import developer.bekzod.dbreferenses.Models.Buyurtma
import developer.bekzod.dbreferenses.Models.Sotuvchi
import developer.bekzod.dbreferenses.Models.Xaridor


interface MyDbInterface {

    fun addSalesmen(sotuvchi: Sotuvchi)
    fun addCustomer(xaridor: Xaridor)
    fun addOrder(buyurtma: Buyurtma)

    fun getAllSalesmen(): List<Sotuvchi>
    fun getAllCustomer(): List<Xaridor>
    fun getAllOrder(): List<Buyurtma>

    fun getSalesmanByid(id: Int): Sotuvchi
    fun getCustomerByid(id: Int): Xaridor

}