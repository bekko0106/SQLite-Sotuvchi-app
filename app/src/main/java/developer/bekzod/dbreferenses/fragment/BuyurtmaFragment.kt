package developer.bekzod.dbreferenses.fragment

import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.fragment.app.Fragment
import developer.bekzod.dbreferenses.Db.MyDbHelper
import developer.bekzod.dbreferenses.Models.Buyurtma
import developer.bekzod.dbreferenses.adapter.BuyurtmaAdapter
import developer.bekzod.dbreferenses.databinding.FragmentBuyurtmaBinding
import developer.bekzod.dbreferenses.databinding.ItemDialogOrdersBinding
import android.view.View as View1


class BuyurtmaFragment : Fragment() {
    private lateinit var binding: FragmentBuyurtmaBinding
    private lateinit var myDbHelper: MyDbHelper
    private lateinit var list: ArrayList<Buyurtma>
    private lateinit var buyurtmaAdapter: BuyurtmaAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View1 {
        binding = FragmentBuyurtmaBinding.inflate(layoutInflater)

        myDbHelper = MyDbHelper(context)
        list = ArrayList()
        list.addAll(myDbHelper.getAllOrder())
        buyurtmaAdapter = BuyurtmaAdapter(list)
        binding.rvBuyurtma.adapter = buyurtmaAdapter
        addBuyurtma()

        return binding.root
    }

    private fun addBuyurtma() {
        binding.btnAdd.setOnClickListener{
            val dialog = androidx.appcompat.app.AlertDialog.Builder(binding.root.context).create()
            val itemDialogOrdersBinding = ItemDialogOrdersBinding.inflate(layoutInflater)
            dialog.setView(itemDialogOrdersBinding.root)
            dialog.show()

            val listSotuvchi = myDbHelper.getAllSalesmen()
            val listSotuvchiName = ArrayList<String>()
            listSotuvchi.forEach{
                listSotuvchiName.add(it.name)
            }
            val sAdapter =ArrayAdapter<String>(binding.root.context, android.R.layout.simple_list_item_1, listSotuvchiName)
            itemDialogOrdersBinding.spinnerSotuvchi.adapter = sAdapter

            val listXaridor = myDbHelper.getAllCustomer()
            val listXaridorName = ArrayList<String>()
            listXaridor.forEach{
                listXaridorName.add(it.name)
            }
            val xAdapter =ArrayAdapter<String>(binding.root.context, android.R.layout.simple_list_item_1, listXaridorName)
            itemDialogOrdersBinding.spinnerXaridor.adapter = xAdapter

            itemDialogOrdersBinding.btnSave.setOnClickListener{

                val nomi = itemDialogOrdersBinding.edtName.text.toString()
                val narxi = itemDialogOrdersBinding.edtPrice.text.toString()
                val spinner_sotuvchi = itemDialogOrdersBinding.spinnerSotuvchi.toString()
                val spinner_xaridor = itemDialogOrdersBinding.spinnerXaridor.toString()

                if (nomi!= "" && narxi!= "" && spinner_sotuvchi!="" && spinner_xaridor!=""){

                    val buyurtma = Buyurtma(

                        itemDialogOrdersBinding.edtName.text.toString(),
                        itemDialogOrdersBinding.edtPrice.text.toString().toInt(),
                        listSotuvchi[itemDialogOrdersBinding.spinnerSotuvchi.selectedItemPosition],
                        listXaridor[itemDialogOrdersBinding.spinnerXaridor.selectedItemPosition]

                    )
                    myDbHelper.addOrder(buyurtma)
                    list.add(buyurtma)
                    buyurtmaAdapter.notifyItemInserted(list.size-1)
                    Toast.makeText(context, "Save", Toast.LENGTH_SHORT ).show()
                    dialog.cancel()

                }else{
                    Toast.makeText(requireContext(), "Malumotlarni to'ldiring", Toast.LENGTH_SHORT)
                        .show()
                }
            }
        }
    }

}