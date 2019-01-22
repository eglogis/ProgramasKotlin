package com.example.retrofitjobqueue

class MapeadoItem {

    fun transform(items: List<ItemDto>): List<ModeloItem>{

        return items.map { transform(it) }
    }

    private fun transform(item: ItemDto): ModeloItem{

        return ModeloItem(item.item, item.business, item.farmer_id, item.category, item.phone1)
    }
}