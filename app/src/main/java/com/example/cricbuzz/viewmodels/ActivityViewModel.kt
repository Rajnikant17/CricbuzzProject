package com.example.cricbuzz.viewmodels
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.cricbuzz.utils.DataState
import com.example.localdatabase.models.Menu
import com.example.localdatabase.models.MenuJsonbaseModel
import com.example.localdatabase.models.Restaurant
import com.example.localdatabase.models.RestaurantJsonBaseModel
import com.google.gson.Gson
import kotlin.collections.ArrayList

class ActivityViewModel : ViewModel() {
    var moreThanThreeLetterTyped=false
    var listOfRestaurant = ArrayList<Restaurant>()
    var listOfRestaurantFilter = ArrayList<Restaurant>()
var listOfRestaurantLiveData = MutableLiveData<DataState<ArrayList<Restaurant>>>()
    val Filterlist: ArrayList<Restaurant> = ArrayList()
    val gson = Gson()
    val menuJsonString = """{
"menus":[
{
"restaurantId":1,
"categories":[

{
"id":"26576",
"name":"Appeteasers",
"menuItems":[
{
"id":"94298",
"name":"3 Chicken Wings",
"description":"Tender, Spicy and Juicy. Original or Peri-Crusted",

"price":"250.00",
"images":[
]
},
{
"id":"94301",
"name":"Chicken Livers and Portuguese Roll",
"description":"Chicken Livers Topped with PERi-PERi",

"price":"250.00",
"images":[
]
}
]
},
{
"id":"26588",
"name":"Peri-peri chicken",
"menuItems":[
{
"id":"94349",
"name":"1/4 Chicken",
"description":"Quarter Chicken Marinated with PERi-PERi Sauce and Grilled",

"price":"385.00",
"images":[
]
},
{
"id":"94352",
"name":"1/2 Chicken",
"description":"Half Chicken Marinated with PERi-PERi Sauce and Grilled",

"price":"685.00",
"images":[
]
}
]
}

]

}
,{
"restaurantId":2,
"categories":[

{
"id":"26576",
"name":"Kabab",
"menuItems":[
{
"id":"94298",
"name":"3 Chicken Wings",
"description":"Tender, Spicy and Juicy. Original or Peri-Crusted",

"price":"250.00",
"images":[
]
},
{
"id":"94301",
"name":"Chicken Livers and Portuguese Roll",
"description":"Chicken Livers Topped with PERi-PERi",

"price":"250.00",
"images":[
]
}
]
},
{
"id":"26588",
"name":"Biryani",
"menuItems":[
{
"id":"94349",
"name":"1/4 Chicken",
"description":"Quarter Chicken Marinated with PERi-PERi Sauce and Grilled",

"price":"385.00",
"images":[
]
},
{
"id":"94352",
"name":"1/2 Chicken",
"description":"Half Chicken Marinated with PERi-PERi Sauce and Grilled",

"price":"685.00",
"images":[
]
}
]
}

]

}

,{
"restaurantId":3,
"categories":[

{
"id":"26576",
"name":"Appeteasers",
"menuItems":[
{
"id":"94298",
"name":"3 Chicken Wings",
"description":"Tender, Spicy and Juicy. Original or Peri-Crusted",

"price":"250.00",
"images":[
]
},
{
"id":"94301",
"name":"Chicken Livers and Portuguese Roll",
"description":"Chicken Livers Topped with PERi-PERi",

"price":"250.00",
"images":[
]
}
]
},
{
"id":"26588",
"name":"Dal",
"menuItems":[
{
"id":"94349",
"name":"1/4 Chicken",
"description":"Quarter Chicken Marinated with PERi-PERi Sauce and Grilled",

"price":"385.00",
"images":[
]
},
{
"id":"94352",
"name":"1/2 Chicken",
"description":"Half Chicken Marinated with PERi-PERi Sauce and Grilled",

"price":"685.00",
"images":[
]
}
]
}

]

}

,{
"restaurantId":4,
"categories":[

{
"id":"26576",
"name":"Paratha",
"menuItems":[
{
"id":"94298",
"name":"3 Chicken Wings",
"description":"Tender, Spicy and Juicy. Original or Peri-Crusted",

"price":"250.00",
"images":[
]
},
{
"id":"94301",
"name":"Chicken Livers and Portuguese Roll",
"description":"Chicken Livers Topped with PERi-PERi",

"price":"250.00",
"images":[
]
}
]
},
{
"id":"26588",
"name":"Biryani",
"menuItems":[
{
"id":"94349",
"name":"1/4 Chicken",
"description":"Quarter Chicken Marinated with PERi-PERi Sauce and Grilled",

"price":"385.00",
"images":[
]
},
{
"id":"94352",
"name":"1/2 Chicken",
"description":"Half Chicken Marinated with PERi-PERi Sauce and Grilled",

"price":"685.00",
"images":[
]
}
]
}

]

}

,{
"restaurantId":5,
"categories":[

{
"id":"26576",
"name":"Appeteasers",
"menuItems":[
{
"id":"94298",
"name":"3 Chicken Wings",
"description":"Tender, Spicy and Juicy. Original or Peri-Crusted",

"price":"250.00",
"images":[
]
},
{
"id":"94301",
"name":"Chicken Livers and Portuguese Roll",
"description":"Chicken Livers Topped with PERi-PERi",

"price":"250.00",
"images":[
]
}
]
},
{
"id":"26588",
"name":"Soup",
"menuItems":[
{
"id":"94349",
"name":"1/4 Chicken",
"description":"Quarter Chicken Marinated with PERi-PERi Sauce and Grilled",

"price":"385.00",
"images":[
]
},
{
"id":"94352",
"name":"1/2 Chicken",
"description":"Half Chicken Marinated with PERi-PERi Sauce and Grilled",

"price":"685.00",
"images":[
]
}
]
}

]

}
]
}"""
    val restaurantJsonString: String = """{
"restaurants":
  [{"id":1,"name":"Mission Chinese Food",
    "neighborhood":"Manhattan","photograph":"1.jpg",
    "address":"171 E Broadway, New York, NY10002",
"cuisine_type":"Asian, Chinese"
} ,{"id":2,"name":"Nasssion  Food",
    "neighborhood":"Manhattan","photograph":"1.jpg",
    "address":"171 E Broadway, New York, NY10002",
"cuisine_type":"Indian"
} ,{"id":3,"name":"KKR Fast Food",
            "neighborhood":"Manhattan","photograph":"1.jpg",
            "address":"171 E Broadway, New York, NY10002",
            "cuisine_type":"Zessian, Chinese"
} ,{"id":4,"name":"Healthy Lunch Food",
            "neighborhood":"Manhattan","photograph":"1.jpg",
            "address":"171 E Broadway, New York, NY10002",
"cuisine_type":"Thai , Chinese"
}   ,{"id":5,"name":"Abcdef Hotel",
            "neighborhood":"Manhattan","photograph":"1.jpg",
            "address":"171 E Broadway, New York, NY10002",
"cuisine_type":"Indian , Chinese , SouthIndian , Punjabi"
}
]
}"""
    fun getRestaurantList() {
            val restaurantJsonBaseModel: RestaurantJsonBaseModel =
                gson.fromJson(restaurantJsonString, RestaurantJsonBaseModel::class.java)
            listOfRestaurant = restaurantJsonBaseModel.restaurants
            restaurantJsonBaseModel.restaurants.forEach {
                val result: List<String> = it.cuisineType.split(",").map { it.trim() }
                it.cuisineTypeListSepratedByComma = result
            }
            getRetaurantsMenuList()
    }

    fun getRetaurantsMenuList() {
            val menuJsonBaseModel: MenuJsonbaseModel =
                gson.fromJson(menuJsonString, MenuJsonbaseModel::class.java)
            setCorrespondingMenuInEachRestaurant(menuJsonBaseModel.menus)
    }

    // Inserting the Menu json inside the Corresponding Restaurant Json using the Restaurant id
    fun setCorrespondingMenuInEachRestaurant(menuList: List<Menu>) {
        for (restaurant: Restaurant in listOfRestaurant) {
            menuList.forEach {
                if (restaurant.id == it.restaurantId) {
                    restaurant.menu = it

                    // creating a string of Restaurant Menu items seprated by comma to display in UI.
                    it.categories.forEach {
                        if (restaurant.menuItemSepratedByComma != null && restaurant.menuItemSepratedByComma.isNotEmpty())
                            restaurant.menuItemSepratedByComma =
                                restaurant.menuItemSepratedByComma + " , " + it.name
                        else
                            restaurant.menuItemSepratedByComma = it.name
                    }
                    return@forEach
                }
            }
        }
        if(listOfRestaurant.isNotEmpty())
        listOfRestaurantLiveData.value = DataState.Success(listOfRestaurant)
        else
            listOfRestaurantLiveData.value = DataState.Error
    }

    fun filterResult(chartString: String) {
        listOfRestaurantLiveData.value=DataState.Loading
        Filterlist.clear()
        if (chartString.isEmpty()) {
            Filterlist.addAll(listOfRestaurant)
        } else {
            var searchedStringFound = false
            for (row in listOfRestaurant) {
                searchedStringFound = false

                // Checking searched string in Restaurant name
                if (row.name.toLowerCase().contains(chartString.toLowerCase())) {
                    Filterlist.add(row)
                    // if we will get the restaurant name matching with searchView string then we donn't need to procced that's why we are not going down and starting next loop and we have used "continue"
                    continue
                }

                // Checking searched string in Cuisine
                for (cuisineTypeRow in row.cuisineTypeListSepratedByComma) {
                    if (cuisineTypeRow.toLowerCase().contains(chartString.toLowerCase())) {
                        Filterlist.add(row)
                        searchedStringFound = true
                        break
                    }
                }
                // if we will get the cuisine name matching with searchView string then we donn't need to procced that's why we are not going down and starting next loop that's why we have used "continue"
                if (searchedStringFound)
                    continue

                // Checking searchView string in Menu items
                if (row.menu != null) {
                    for (itemRowrow in row.menu.categories) {
                        if (itemRowrow.name.toLowerCase().contains(chartString.toLowerCase())) {
                            Filterlist.add(row)
                            break
                        }
                    }
                }
            }
        }
        if(Filterlist.isNotEmpty())
        listOfRestaurantLiveData.value=DataState.Success(Filterlist)
        else
            listOfRestaurantLiveData.value=DataState.Error
    }
}