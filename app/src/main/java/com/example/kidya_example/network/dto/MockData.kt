package com.example.kidya_example.network.dto

import com.example.kidya_example.R
import java.util.*
import kotlin.collections.ArrayList

class MockData {

    companion object {
        fun getCatList(): List<Category> {

            val list = ArrayList<Category>()

            list.add(Category(R.drawable.ic_shape))
            list.add(Category(R.drawable.ic_shape))
            list.add(Category(R.drawable.ic_shape))
            list.add(Category(R.drawable.ic_shape))
            list.add(Category(R.drawable.ic_shape))
            list.add(Category(R.drawable.ic_shape))
            list.add(Category(R.drawable.ic_shape))
            return list
        }

        fun getNovostiList(): List<NovostiModel> {
            val list = ArrayList<NovostiModel>()
            list.add(
                NovostiModel(
                    R.drawable.box,
                    "Распродажа во всех маназиназ Zara Kids",
                    "5 december"
                )
            )
            list.add(NovostiModel(R.drawable.box2, "Новая коллексия в B...", "5 december"))
            list.add(NovostiModel(R.drawable.box, "Розовое платье c к..", "5 december"))
            list.add(NovostiModel(R.drawable.box2, "Малиновый сарафан", "5 december"))
            list.add(
                NovostiModel(
                    R.drawable.box,
                    "Распродажа во всех маназиназ Zara Kids",
                    "5 december"
                )
            )
            list.add(NovostiModel(R.drawable.box2, "Новая коллексия в Bershka", "5 december"))
            list.add(NovostiModel(R.drawable.box, "Розовое платье c кружевами", "5 december"))
            list.add(NovostiModel(R.drawable.box2, "Малиновый сарафан", "5 december"))

            return list

        }

//        list.add(NovostiModel(R.drawable.image_2, "Распродажа во всех маназиназ Zara Kids", "5 december"))
//        list.add(NovostiModel(R.drawable.image_2, "Новая коллексия в Bershka", "5 december"))
//        list.add(NovostiModel(R.drawable.image_2, "Розовое платье c кружевами", "5 december"))
//        list.add(NovostiModel(R.drawable.image_2, "Малиновый сарафан", "5 december"))

        fun getSkitkaList(): List<SkitkaModel> {

            val list = ArrayList<SkitkaModel>()

            list.add(
                SkitkaModel(
                    R.drawable.image_2,
                    "320 000 сум",
                    "Распродажа во всех маназиназ Zara Kids",
                    "Vep brand"
                )
            )
            list.add(
                SkitkaModel(
                    R.drawable.image_2,
                    "320 000 сум",
                    "Новая коллексия в Bershka",
                    "Vep brand"
                )
            )
            list.add(
                SkitkaModel(
                    R.drawable.image_2,
                    "320 000 сум",
                    "Розовое платье c кружевами",
                    "Vep brand"
                )
            )
            list.add(
                SkitkaModel(
                    R.drawable.image_2,
                    "320 000 сум",
                    "Малиновый сарафан",
                    "Vep brand"
                )
            )
            list.add(SkitkaModel(R.drawable.image_2, "320 000 сум", "Dress5", "Vep brand"))
            list.add(SkitkaModel(R.drawable.image_2, "320 000 сум", "Dress6", "Vep brand"))
            list.add(SkitkaModel(R.drawable.image_2, "320 000 сум", "Dress7", "Vep brand"))

            return list
        }

        fun getGridList(): List<Grid> {

            val list = ArrayList<Grid>()

            list.add(Grid(R.drawable.ic_shape, "Кофточки"))
            list.add(Grid(R.drawable.ic_shape, "Носки"))
            list.add(Grid(R.drawable.ic_shape, "Футболки"))
            list.add(Grid(R.drawable.ic_shape, "Юбки"))

            list.add(Grid(R.drawable.ic_shape, "Dress5"))
            list.add(Grid(R.drawable.ic_shape, "Dress6"))
            list.add(Grid(R.drawable.ic_shape, "Dress7"))
            list.add(Grid(R.drawable.ic_shape, "Dress8"))
            list.add(Grid(R.drawable.ic_shape, "Dress9"))
            list.add(Grid(R.drawable.ic_shape, "Dress10"))
            list.add(Grid(R.drawable.ic_shape, "Dress11"))

            return list
        }


        fun getColorList(): List<ItemDialog> {

            val list = ArrayList<ItemDialog>()

            list.add(ItemDialog("#458565"))
            list.add(ItemDialog("#658545"))
            list.add(ItemDialog("#238523"))
            list.add(ItemDialog("#658534"))
            list.add(ItemDialog("#458565"))
            list.add(ItemDialog("#658545"))
            list.add(ItemDialog("#238523"))
            list.add(ItemDialog("#658534"))
            list.add(ItemDialog("#458565"))
            list.add(ItemDialog("#658545"))
            list.add(ItemDialog("#238523"))
            list.add(ItemDialog("#658534"))
            list.add(ItemDialog("#458565"))
            list.add(ItemDialog("#658545"))
            list.add(ItemDialog("#238523"))
            list.add(ItemDialog("#658534"))
            list.add(ItemDialog("#458565"))
            list.add(ItemDialog("#658545"))
            list.add(ItemDialog("#238523"))
            list.add(ItemDialog("#658534"))
            list.add(ItemDialog("#458565"))
            list.add(ItemDialog("#658545"))
            list.add(ItemDialog("#238523"))
            list.add(ItemDialog("#658534"))

            return list

        }

        fun getSizeList(): List<ItemDialog> {

            val list = ArrayList<ItemDialog>()

            list.add(ItemDialog("10"))
            list.add(ItemDialog("11"))
            list.add(ItemDialog("12"))
            list.add(ItemDialog("13"))
            list.add(ItemDialog("14"))
            list.add(ItemDialog("15"))
            list.add(ItemDialog("16"))
            list.add(ItemDialog("17"))
            list.add(ItemDialog("18"))
            list.add(ItemDialog("19"))
            list.add(ItemDialog("20"))
            list.add(ItemDialog("21"))
            list.add(ItemDialog("22"))
            list.add(ItemDialog("23"))
            list.add(ItemDialog("24"))
            list.add(ItemDialog("25"))
            list.add(ItemDialog("26"))
            list.add(ItemDialog("27"))
            list.add(ItemDialog("28"))
            list.add(ItemDialog("29"))
            list.add(ItemDialog("30"))


            return list
        }

        fun getItemMaterialList(): List<ItemDialog> {

            val list = ArrayList<ItemDialog>()

            list.add(ItemDialog("Шерсть"))
            list.add(ItemDialog("Вельвет"))
            list.add(ItemDialog("Лайкра"))
            list.add(ItemDialog("Ситец"))
            list.add(ItemDialog("ХБ"))
            list.add(ItemDialog("Синтетика"))

            return list
        }

        fun getItemOplateList(): List<ItemDialog> {
            val list = ArrayList<ItemDialog>()

            list.add(ItemDialog("PayMe"))
            list.add(ItemDialog("Apelsin"))
            list.add(ItemDialog("Xumo"))
            list.add(ItemDialog("Oson"))
            list.add(ItemDialog("Click.uz"))
            list.add(ItemDialog("Наличные"))

            return list
        }

        fun getMessageDrawerList(): List<MessageDrawer> {

            val list = ArrayList<MessageDrawer>()

            list.add(
                MessageDrawer(
                    "No Brand shop",
                    "27 сентября",
                    "Добрый день, Татьяна! Чем могу помочь..."
                )
            )
            list.add(
                MessageDrawer(
                    "Kids World Shop",
                    "25 сентября",
                    "Скидка -20% только до конца сентя..."
                )
            )
            list.add(
                MessageDrawer(
                    "No Brand shop",
                    "27 сентября",
                    "Добрый день, Татьяна! Чем могу помочь..."
                )
            )
            list.add(
                MessageDrawer(
                    "Kids World Shop",
                    "25 сентября",
                    "Скидка -20% только до конца сентя..."
                )
            )
            list.add(
                MessageDrawer(
                    "No Brand shop",
                    "27 сентября",
                    "Добрый день, Татьяна! Чем могу помочь..."
                )
            )
            list.add(
                MessageDrawer(
                    "Kids World Shop",
                    "25 сентября",
                    "Скидка -20% только до конца сентя..."
                )
            )
            list.add(
                MessageDrawer(
                    "No Brand shop",
                    "27 сентября",
                    "Добрый день, Татьяна! Чем могу помочь..."
                )
            )
            list.add(
                MessageDrawer(
                    "Kids World Shop",
                    "25 сентября",
                    "Скидка -20% только до конца сентя..."
                )
            )
            list.add(
                MessageDrawer(
                    "No Brand shop",
                    "27 сентября",
                    "Добрый день, Татьяна! Чем могу помочь..."
                )
            )
            list.add(
                MessageDrawer(
                    "Kids World Shop",
                    "25 сентября",
                    "Скидка -20% только до конца сентя..."
                )
            )
            list.add(
                MessageDrawer(
                    "No Brand shop",
                    "27 сентября",
                    "Добрый день, Татьяна! Чем могу помочь..."
                )
            )
            list.add(
                MessageDrawer(
                    "Kids World Shop",
                    "25 сентября",
                    "Скидка -20% только до конца сентя..."
                )
            )

            return list
        }

        fun getMessageDrawerBack(): List<MessageDrawerBack> {

            val list = ArrayList<MessageDrawerBack>()
            list.add(MessageDrawerBack("Добрый день, Томара", "22:30"))
            list.add(
                MessageDrawerBack(
                    "Здравствуйте, Суннат. Как ваши дела?\n" +
                            "Чем могу помочь?", "22:32"
                )
            )

            list.add(
                MessageDrawerBack(
                    "У меня вопрос по добавлению\n" +
                            "продукции", "22:32"
                )
            )
            list.add(MessageDrawerBack("Добрый день, Томара", "22:30"))
            list.add(
                MessageDrawerBack(
                    "Здравствуйте, Суннат. Как ваши дела?\n" +
                            "Чем могу помочь?", "22:32"
                )
            )

            list.add(
                MessageDrawerBack(
                    "У меня вопрос по добавлению\n" +
                            "продукции", "22:32"
                )
            )
            list.add(MessageDrawerBack("Добрый день, Томара", "22:30"))
            list.add(
                MessageDrawerBack(
                    "Здравствуйте, Суннат. Как ваши дела?\n" +
                            "Чем могу помочь?", "22:32"
                )
            )

            list.add(
                MessageDrawerBack(
                    "У меня вопрос по добавлению\n" +
                            "продукции", "22:32"
                )
            )

            return list

        }

        fun getBellList(): List<BellData> {
            val list = ArrayList<BellData>()

            list.add(
                BellData(
                    "Акция «Счастливые часы»",
                    "29 сентября",
                    "Исправлению подверглись лишь явные\n" +
                            "орфографические пунктуационные погрешности\n" +
                            "например, аффилиация начинает лирический\n" +
                            "реципиент. "
                )
            )

            list.add(
                BellData(
                    "Доставка заказа", "27 сентября", "Ваш заказ  №4829753 передан курьеру.\n" +
                            "Доставка произойдет в течении 1 часа." +
                            "Исправлению подверглись лишь явные " +
                            "                            \"орфографические пунктуационные погрешности " +
                            "                            \"например, аффилиация начинает лирический " +
                            "                            \"реципиент."
                )
            )
            list.add(
                BellData(
                    "Акция «Счастливые часы»",
                    "29 сентября",
                    "Исправлению подверглись лишь явные\n" +
                            "орфографические пунктуационные погрешности\n" +
                            "например, аффилиация начинает лирический\n" +
                            "реципиент. "
                )
            )

            list.add(
                BellData(
                    "Доставка заказа", "27 сентября", "Ваш заказ  №4829753 передан курьеру.\n" +
                            "Доставка произойдет в течении 1 часа." +
                            "Исправлению подверглись лишь явные " +
                            "                            \"орфографические пунктуационные погрешности " +
                            "                            \"например, аффилиация начинает лирический " +
                            "                            \"реципиент."
                )
            )
            list.add(
                BellData(
                    "Акция «Счастливые часы»",
                    "29 сентября",
                    "Исправлению подверглись лишь явные\n" +
                            "орфографические пунктуационные погрешности\n" +
                            "например, аффилиация начинает лирический\n" +
                            "реципиент. "
                )
            )

            list.add(
                BellData(
                    "Доставка заказа", "27 сентября", "Ваш заказ  №4829753 передан курьеру.\n" +
                            "Доставка произойдет в течении 1 часа." +
                            "Исправлению подверглись лишь явные " +
                            "                            \"орфографические пунктуационные погрешности " +
                            "                            \"например, аффилиация начинает лирический " +
                            "                            \"реципиент."
                )
            )
            list.add(
                BellData(
                    "Акция «Счастливые часы»",
                    "29 сентября",
                    "Исправлению подверглись лишь явные\n" +
                            "орфографические пунктуационные погрешности\n" +
                            "например, аффилиация начинает лирический\n" +
                            "реципиент. "
                )
            )

            list.add(
                BellData(
                    "Доставка заказа", "27 сентября", "Ваш заказ  №4829753 передан курьеру.\n" +
                            "Доставка произойдет в течении 1 часа." +
                            "Исправлению подверглись лишь явные " +
                            "                            \"орфографические пунктуационные погрешности " +
                            "                            \"например, аффилиация начинает лирический " +
                            "                            \"реципиент."
                )
            )


            return list
        }


        fun getMessageChatList(): List<BaseData> {
            val data = ArrayList<BaseData>()

            data.add(SellerData("Добрый день, Томара", "22:30"))
            data.add(
                ClientData(
                    "Здравствуйте, Суннат. Как ваши дела?\n" +
                            "Чем могу помочь?", "22:32"
                )
            )
            data.add(
                SellerData(
                    "У меня вопрос по добавлению\n" +
                            "продукции", "22:30"
                )
            )
            data.add(SellerData("Добрый день, Томара", "22:30"))
            data.add(
                ClientData(
                    "Здравствуйте, Суннат. Как ваши дела?\n" +
                            "Чем могу помочь?", "22:32"
                )
            )
            data.add(
                SellerData(
                    "У меня вопрос по добавлению\n" +
                            "продукции", "22:30"
                )
            )
            data.add(SellerData("Добрый день, Томара", "22:30"))
            data.add(
                ClientData(
                    "Здравствуйте, Суннат. Как ваши дела?\n" +
                            "Чем могу помочь?", "22:32"
                )
            )
            data.add(
                SellerData(
                    "У меня вопрос по добавлению\n" +
                            "продукции", "22:30"
                )
            )
//            Collections.shuffle(data)

            return data
        }
    }

    data class Category(
        val image: Int
    )

    data class Grid(
        val image: Int,
        val text: String
    )

    data class NovostiModel(val image: Int, val aboutDress: String, val date: String)

    data class SkitkaModel(
        val image: Int,
        val money: String,
        val dressName: String,
        val shopName: String
    )

    data class ItemDialog(val item2: String)

    data class MessageDrawer(val shopName: String, val time: String, val message: String)

    data class MessageDrawerBack(val message: String, val time: String)

    data class BellData(val aksiya: String, val date: String, val text: String)


    data class SellerData(
        val name: String,
        val number: String
    ) : BaseData()


    data class ClientData(
        val name: String,
        val number: String
    ) : BaseData()


    open class BaseData {
    }
}
